package com.smartcloud.main.provider.service;

import com.smartcloud.db.spring.boot.autoconfigure.service.BaseService;
import com.smartcloud.main.api.mapper.model.BaseUserRole;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BaseUserRoleService extends BaseService<BaseUserRole>{

    /**
     * 保存用户角色
     * @param baseUserRoleList
     */
    @Transactional
    public void saveUserRole(List<BaseUserRole> baseUserRoleList) {
        if (baseUserRoleList.size() > 0 && baseUserRoleList.get(0).getRoleId() != null) {
            BaseUserRole userRole = new BaseUserRole();
            userRole.setUserId(baseUserRoleList.get(0).getUserId());
            mapper.delete(userRole);
            baseUserRoleList.forEach(it -> {
                insertSelective(it);
            });
        }
    }
}
