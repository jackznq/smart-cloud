package com.smartcloud.main.provider.mapper.mapper;


import com.smartcloud.main.api.mapper.model.BaseModuleResources;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface BaseModuleResourcesMapper extends Mapper<BaseModuleResources> {
    List<BaseModuleResources> getMenusByUserId(@Param("userId") Long userId);

    List<BaseModuleResources> selectModuleTree(@Param("id") Long id, @Param("systemId") Long systemId);
}