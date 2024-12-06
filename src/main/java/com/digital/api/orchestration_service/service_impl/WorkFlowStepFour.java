package com.digital.api.orchestration_service.service_impl;

import com.digital.api.orchestration_service.service.WorkflowStep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Component
public class WorkFlowStepFour implements WorkflowStep {
    @Override
    public void execute(Map<String, Object> context) {
        CompletableFuture<Void> futureWorkFlowStepOne = (CompletableFuture<Void>) context.get("futureWorkFlowStepOne");
        CompletableFuture<Void> futureWorkFlowStepThree = (CompletableFuture<Void>) context.get("futureWorkFlowStepThree");
        CompletableFuture.allOf(futureWorkFlowStepOne,futureWorkFlowStepThree).join();
        log.info("WorkFlowStepFour executed !!");
        context.put("WorkFlowStepFour","SUCCESS");
    }
}
