package com.arobs.sbw.controllers;

import com.arobs.sbw.model.DemoEntity;
import com.arobs.sbw.services.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author vasile.mihali
 * @since 8/6/2020
 */

@Slf4j
@RestController
public class DemoController {

    private DemoService demoService;

    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @RequestMapping(value = "/demo", produces = {"application/json"})
    public String createBaseDemoEntity() {
        log.info("createBaseDemoEntity - called");
        DemoEntity dm = new DemoEntity();
        dm.setDescription("Nice test");
        final int entityId = demoService.createEntity(dm);

        return "{\"id\":" + entityId + "\"}";
    }

}
