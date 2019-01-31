package com.smartcloud.main.provider.mapper.mapper;


import com.smartcloud.main.api.mapper.model.BaseSystem;
import com.smartcloud.main.api.pojo.response.ModuleAndSystemResponse;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface BaseSystemMapper extends Mapper<BaseSystem> {
    List<ModuleAndSystemResponse> selectModuleAndSystem();
}