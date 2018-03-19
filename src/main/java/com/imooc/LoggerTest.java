package com.imooc;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {
    private final static Logger logger = LoggerFactory.getLogger(LoggerTest.class);
    @Test
    public void test(){
        String name = "imooc";
        String password = "123456";
        log.debug("debug...");
        log.info("info:  name:{},password:{}",name,password);
        log.warn("warn:  name:{},password:{}",name,password);
        log.error("error:    name:{},password:{}",name,password);
    }
}
