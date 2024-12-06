package com.digital.api.orchestration_service.service_impl;

import com.digital.api.orchestration_service.service.WorkflowStep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Component
public class WorkFlowStepOne implements WorkflowStep {
    @Override
    public void execute(Map<String, Object> context) {
        CompletableFuture<Void> futureWorkFlowStepOne = CompletableFuture.runAsync(() ->{
            try {
                Thread.sleep(5000);
                log.info("WorkFlowStepOne executed !!");
                context.put("WorkFlowStepOne","SUCCESS");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        context.put("futureWorkFlowStepOne",futureWorkFlowStepOne);
    }
}
