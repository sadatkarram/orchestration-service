package com.digital.api.orchestration_service.service_impl;

import com.digital.api.orchestration_service.service.WorkflowStep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Component
public class WorkFlowStepThree implements WorkflowStep {
    @Override
    public void execute(Map<String, Object> context) {
        CompletableFuture<Void> futureWorkFlowStepThree = CompletableFuture.runAsync(() ->{
            try {
                Thread.sleep(3000);
                log.info("WorkFlowStepThree executed !!");
                context.put("WorkFlowStepThree","SUCCESS");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        context.put("futureWorkFlowStepThree",futureWorkFlowStepThree);
    }
}
