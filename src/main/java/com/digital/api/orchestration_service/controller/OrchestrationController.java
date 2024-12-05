package com.digital.api.orchestration_service.controller;


import com.digital.api.orchestration_service.service_impl.OrchestratorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/orchestrate")
public class OrchestrationController {

    private final OrchestratorService orchestratorService;
    public static final String PRODUCT_NAME="productName";
    public static final String INVALID_PRODUCT="INVALID_PRODUCT";

    @Autowired
    public OrchestrationController(OrchestratorService orchestratorService) {
        this.orchestratorService = orchestratorService;
    }

    @PostMapping("/viewCf")
    public  Map<String, Object> orchestrate(@RequestBody Map<String, Object> request) {
        Map<String, Object> response = new HashMap<>();
        String productName = request.get(PRODUCT_NAME) !=null? request.get(PRODUCT_NAME).toString():INVALID_PRODUCT;
        response=orchestratorService.executeWorkflow(request.get(PRODUCT_NAME).toString(), response);
        log.info("Workflow executed successfully for product: {}", productName);
        return response;
    }
}
