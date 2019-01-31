package com.smartcloud.main.provider.mapper.mapper;


import com.smartcloud.main.api.mapper.model.BaseRoleModule;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface BaseRoleModuleMapper extends Mapper<BaseRoleModule> {
    List<BaseRoleModule> selectLeafRoleModule(String roleId);
}