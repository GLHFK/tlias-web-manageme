package com.example.tliaswebmanageme.service;


import com.example.tliaswebmanageme.pojo.JobData;

import java.util.List;
import java.util.Map;

public interface ReportService {
    List<Map<String, Object>> empGenderData();

    JobData empJobData();
}
