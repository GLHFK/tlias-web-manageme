package com.example.tliaswebmanageme.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobData {
    private List<String> jobList;
    private List<Integer> dataList;
}
