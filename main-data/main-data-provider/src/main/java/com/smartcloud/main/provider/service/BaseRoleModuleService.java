package com.smartcloud.main.provider.service;

import com.smartcloud.db.spring.boot.autoconfigure.service.BaseService;
import com.smartcloud.main.api.mapper.model.BaseRoleModule;
import com.smartcloud.main.provider.mapper.mapper.BaseRoleModuleMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BaseRoleModuleService extends BaseService<BaseRoleModule>{

    @Transactional
    public void saveRoleModule(List<BaseRoleModule> roleModule) {
        if (roleModule.size() > 0 && roleModule.get(0).getRoleId() != null) {
            BaseRoleModule module = new BaseRoleModule();
            module.setRoleId(roleModule.get(0).getRoleId());
            mapper.delete(module);
            roleModule.forEach(it -> {
                mapper.insertSelective(it);
            });
        }
    }

    // 查询关联角色的叶子模块
    public List<BaseRoleModule> selectLeafRoleModule(String roleId) {
        return ((BaseRoleModuleMapper)mapper).selectLeafRoleModule(roleId);
    }
}
