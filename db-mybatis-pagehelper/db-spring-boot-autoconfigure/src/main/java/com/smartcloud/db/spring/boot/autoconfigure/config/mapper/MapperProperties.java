package com.smartcloud.db.spring.boot.autoconfigure.config.mapper;

import org.springframework.boot.context.properties.ConfigurationProperties;
import tk.mybatis.mapper.entity.Config;

@ConfigurationProperties(prefix = "mapper")
public class MapperProperties extends Config{
}
