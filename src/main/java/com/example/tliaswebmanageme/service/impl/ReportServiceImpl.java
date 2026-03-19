package com.example.tliaswebmanageme.service.impl;

import com.example.tliaswebmanageme.mapper.ReportMapper;
import com.example.tliaswebmanageme.pojo.JobData;
import com.example.tliaswebmanageme.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Slf4j
@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportMapper reportMapper;

    @Override
    public List<Map<String, Object>> empGenderData() {
        log.info("empGenderData");
        List<Map<String, Object>> list = reportMapper.empGenderData();
        log.info(list.toString());
        return list;
    }

    @Override
    public JobData empJobData() {
        List<Map<String, Object>> jobData = reportMapper.empJobData();
        log.info(jobData.toString());
        List<String> jobList = jobData.stream().map((map -> map.get("job").toString())).toList();
        List<Integer> dataList = jobData.stream()
                .map(map -> ((Number) map.get("value")).intValue())
                .toList();
        log.info(dataList.toString());
        return new JobData(jobList, dataList);
    }
}
