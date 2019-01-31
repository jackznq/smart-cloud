package com.smartcloud.main.provider.service;

import com.smartcloud.db.spring.boot.autoconfigure.service.BaseService;
import com.smartcloud.main.api.mapper.model.BaseModuleResources;
import com.smartcloud.main.provider.mapper.mapper.BaseModuleResourcesMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseModuleResourceService extends BaseService<BaseModuleResources>{


    /**
     * 根据用户查询菜单
     * @param userId
     * @return
     */
    public List<BaseModuleResources> getMenusByUserId(Long userId) {
        return ((BaseModuleResourcesMapper)mapper).getMenusByUserId(userId);
    }

    public List<BaseModuleResources> getModuleTree(Long id, Long systemId) {
        return ((BaseModuleResourcesMapper)mapper).selectModuleTree(id, systemId);
    }
}
