package com.digital.api.orchestration_service.service;

import java.util.Map;

public interface WorkflowStep {
    void execute(Map<String, Object> context);
}
