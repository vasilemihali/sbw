package com.arobs.sbw.util;


import com.zaxxer.hikari.HikariDataSource;
import java.lang.reflect.Method;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import net.ttddyy.dsproxy.listener.ChainListener;
import net.ttddyy.dsproxy.listener.DataSourceQueryCountListener;
import net.ttddyy.dsproxy.listener.logging.DefaultQueryLogEntryCreator;
import net.ttddyy.dsproxy.listener.logging.SLF4JLogLevel;
import net.ttddyy.dsproxy.listener.logging.SLF4JQueryLoggingListener;
import net.ttddyy.dsproxy.support.ProxyDataSourceBuilder;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

/**
 * @author vasile.mihali
 * @since 5/21/2020
 */
@Component
@Slf4j
@ConditionalOnProperty(name = "use-datasource-proxy", havingValue = "true")
public class DataSourceProxyBeanPostProcessor implements BeanPostProcessor {

    @Autowired
    private Environment environment;

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        if (!useProxy()) {
            log.warn("Desired to NOT START DATA_SOURCE_PROXY to show queries");
            return bean;
        }
        if (bean instanceof DataSource) {
            //NECESSARY HACK : since there are 2 instance of HikariDataSource, skip enhancement of EnhancerBySpring to not have double proxy
            //enhancement's, that should cause logs appear twice (2)
            if (bean instanceof HikariDataSource && bean.getClass().getName().contains("EnhancerBySpring")) {
                log.info("HikariDataSource from DATA_SOURCE_PROXY desired to skip enhancement for: {}", bean.getClass().getName());
                return bean;
            }

            log.info("Activate DATA_SOURCE_PROXY to show queries for: {}", bean.getClass().getName());
            // Instead of directly returning a less specific datasource bean
            // (e.g.: HikariDataSource -> DataSource), return a proxy object.
            // See following links for why:
            //   https://stackoverflow.com/questions/44237787/how-to-use-user-defined-database-proxy-in-datajpatest
            //   https://gitter.im/spring-projects/spring-boot?at=5983602d2723db8d5e70a904
            //   http://blog.arnoldgalovics.com/2017/06/26/configuring-a-datasource-proxy-in-spring-boot/
            final ProxyFactory factory = new ProxyFactory(bean);
            factory.setProxyTargetClass(true);
            factory.addAdvice(new ProxyDataSourceInterceptor((DataSource) bean));

            return factory.getProxy();
        }

        return bean;
    }

    private boolean useProxy() {
        return environment.getProperty("use-datasource-proxy", Boolean.class, false);
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        return bean;
    }

    private static class ProxyDataSourceInterceptor implements MethodInterceptor {

        private final DataSource dataSource;

        public ProxyDataSourceInterceptor(final DataSource dataSource) {
            super();

            ChainListener chainListener = new ChainListener();
            DataSourceQueryCountListener dataSourceQueryCountListener = new DataSourceQueryCountListener();
            SLF4JQueryLoggingListener loggingListener = new SLF4JQueryLoggingListener();
            loggingListener.setQueryLogEntryCreator(new DefaultQueryLogEntryCreator());

            chainListener.addListener(loggingListener);
            chainListener.addListener(dataSourceQueryCountListener);

            this.dataSource = ProxyDataSourceBuilder
                .create(dataSource)
                .name("DSP") //data source proxy
                .listener(chainListener)
                .logQueryBySlf4j(SLF4JLogLevel.INFO)
                .build();
        }

        @Override
        public Object invoke(final MethodInvocation invocation) throws Throwable {
            final Method proxyMethod = ReflectionUtils.findMethod(this.dataSource.getClass(),
                invocation.getMethod().getName());
            if (proxyMethod != null) {
                return proxyMethod.invoke(this.dataSource, invocation.getArguments());
            }

            return invocation.proceed();
        }
    }
}
