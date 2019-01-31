package com.smartcloud.db.spring.boot.samples.service;

import com.smartcloud.db.spring.boot.autoconfigure.service.BaseService;
import com.smartcloud.db.spring.boot.samples.mapper.model.BaseUser;
import org.springframework.stereotype.Service;

@Service
public class BaseUserService extends BaseService<BaseUser> {}
