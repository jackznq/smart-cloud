package com.smartcloud.zipkin.db;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;


/**
 * zipkin mysql 存储实现
 */
@SpringCloudApplication
@EnableZipkinStreamServer
public class ZipkinDbApplication {
    public static void main (String[] args){
        SpringApplication.run(ZipkinDbApplication.class, args);
    }
}
