package com.smartcloud.mc.service;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

@SpringCloudApplication
public class McServiceApplication {
    public static void main (String[] args){
        SpringApplication.run(McServiceApplication.class, args);
    }
}
