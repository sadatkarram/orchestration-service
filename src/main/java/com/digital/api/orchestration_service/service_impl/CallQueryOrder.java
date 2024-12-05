package com.digital.api.orchestration_service.service_impl;

import com.digital.api.orchestration_service.service.WorkflowStep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class CallQueryOrder implements WorkflowStep {

    @Override
    public void execute(Map<String, Object> context) {
        log.info("CallQueryOrder executed !!");
        context.put("CallQueryOrder","SUCCESS");
    }
}
