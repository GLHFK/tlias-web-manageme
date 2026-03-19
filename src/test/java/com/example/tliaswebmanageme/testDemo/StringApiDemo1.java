package com.example.tliaswebmanageme.testDemo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


@Slf4j
public class StringApiDemo1 {
    static final String err = "nihao121314 12314313133441999 131314141333 3";

    @Test
    public void stringDemo1() {
        int index = err.indexOf("121");
        log.info("index: {}", index);
        log.info(err.substring(index));
        log.info(err.substring(0, 2));
        //输出err字符串以空格分割的结果
        String[] split = err.split(" ");
        log.info(Arrays.toString(split));
        int index1 = err.lastIndexOf("123");
        log.info(err.substring(index1));
        //拼接字符串
        String s = "123" + "456" + "789";
        log.info(s);
        //找到err中第二个12的位置
        int index2 = err.indexOf("12", err.indexOf("12") + 1);
        log.info("index2: {}", index2);
    }
}
