package com.smartcloud.main.provider.service;

import com.smartcloud.db.spring.boot.autoconfigure.service.BaseService;
import com.smartcloud.main.api.mapper.model.BaseSystem;
import com.smartcloud.main.api.pojo.response.ModuleAndSystemResponse;
import com.smartcloud.main.provider.mapper.mapper.BaseSystemMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseSystemService extends BaseService<BaseSystem>{
    public List<ModuleAndSystemResponse> selectModuleAndSystem() {
        return ((BaseSystemMapper)mapper).selectModuleAndSystem();
    }
}
