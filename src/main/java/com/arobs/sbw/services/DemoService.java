package com.arobs.sbw.services;

import com.arobs.sbw.model.DemoEntity;
import com.arobs.sbw.repositories.DemoEntityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author vasile.mihali
 * @since 8/6/2020
 */
@Slf4j
@Service
public class DemoService {

    @Autowired
    private DemoEntityRepository demoRepository;

    public int createEntity(DemoEntity entity) {
        return demoRepository.saveAndFlush(entity).getId();
    }

}
