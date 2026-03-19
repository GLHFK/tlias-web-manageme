package com.example.tliaswebmanageme.controller;

import com.example.tliaswebmanageme.pojo.JobData;
import com.example.tliaswebmanageme.pojo.Result;
import com.example.tliaswebmanageme.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @GetMapping("/empGenderData")
    public Result empGenderData() {
        List<Map<String, Object>> list = reportService.empGenderData();
        return Result.success(list);
    }

    @GetMapping("/empJobData")
    public Result empJobData() {
        JobData jobData = reportService.empJobData();
        log.info(jobData.toString());
        return Result.success(jobData);
    }
}
