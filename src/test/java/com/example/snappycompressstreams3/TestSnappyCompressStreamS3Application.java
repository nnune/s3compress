package com.example.snappycompressstreams3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestSnappyCompressStreamS3Application {

    public static void main(String[] args) {
        SpringApplication.from(SnappyCompressStreamS3Application::main).with(TestSnappyCompressStreamS3Application.class).run(args);
    }

}
