package com.smartcloud.main.api.service;

import com.smartcloud.common.pojo.ResponseData;
import com.smartcloud.main.api.mapper.model.BaseRole;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface BaseRoleRemoteService {

    /**
     * 根据userId查询角色
     * @param userId
     * @return
     */
    @RequestMapping(value = "/role/user/{userId}", method = RequestMethod.GET)
    ResponseData<List<BaseRole>> getRoleByUserId(@PathVariable("userId") Long userId);
}
