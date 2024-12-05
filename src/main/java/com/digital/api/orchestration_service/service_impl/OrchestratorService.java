package com.digital.api.orchestration_service.service_impl;

import com.digital.api.orchestration_service.service.WorkflowStep;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class OrchestratorService {
    private final Environment env;
    private final List<WorkflowStep> workflowSteps;

    @Autowired
    public OrchestratorService(Environment env, List<WorkflowStep> workflowSteps) {
        this.env = env;
        this.workflowSteps = workflowSteps;
    }


    public Map<String,Object> executeWorkflow(String productName, Map<String, Object> response) {
        String[] steps = env.getProperty("workflow.config.view.".concat(productName),"INVALID_PRODUCT").split(",");
        // Example: workflow.config.view.ProductA=GetCFDataFromDB,CallQueryOrder
        for (String step : steps) {
            for (WorkflowStep workflowStep : workflowSteps) {
                if (workflowStep.getClass().getSimpleName().equalsIgnoreCase(step.trim())) {
                    workflowStep.execute(response);
                    break;
                }
            }
        }
        return response;
    }

}
