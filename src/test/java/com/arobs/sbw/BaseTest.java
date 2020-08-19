package com.arobs.sbw;

import com.arobs.sbw.config.BaseTestConfig;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author vasile.mihali
 * @since 8/19/2020
 */

@RunWith(SpringRunner.class)
@EnableTransactionManagement
@TestPropertySource("/test.properties")
@ComponentScan(basePackages = "com.arobs.sbw", basePackageClasses = {BaseTestConfig.class})
public abstract class BaseTest {

}
