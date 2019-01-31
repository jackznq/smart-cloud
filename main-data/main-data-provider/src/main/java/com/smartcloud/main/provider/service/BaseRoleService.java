package com.smartcloud.main.provider.service;

import com.smartcloud.db.spring.boot.autoconfigure.service.BaseService;
import com.smartcloud.main.api.mapper.model.BaseRole;
import com.smartcloud.main.provider.mapper.mapper.BaseRoleMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseRoleService extends BaseService<BaseRole>{

    /**
     * 根据用户查询角色
     * @param userId
     * @return
     */
    public List<BaseRole> getRoleByUserId(Long userId) {
        return ((BaseRoleMapper)mapper).getRoleByUserId(userId);
    }
}
