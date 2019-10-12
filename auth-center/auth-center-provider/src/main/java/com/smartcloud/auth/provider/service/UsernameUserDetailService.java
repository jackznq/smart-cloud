package com.smartcloud.auth.provider.service;

import com.smartcloud.common.pojo.ResponseData;
import com.smartcloud.main.api.mapper.model.BaseUser;
import com.smartcloud.main.api.pojo.ResponseCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsernameUserDetailService extends BaseUserDetailService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    protected BaseUser getUser(String username) {
        // 账号密码登陆调用FeignClient根据用户名查询用户
        ResponseData<BaseUser> baseUserResponseData = baseUserService.getUserByUserName(username);
        if(baseUserResponseData.getData() == null || !ResponseCode.SUCCESS.getCode().equals(baseUserResponseData.getCode())){
            logger.error("找不到该用户，用户名：" + username);
            throw new UsernameNotFoundException("找不到该用户，用户名：" + username);
        }
        return baseUserResponseData.getData();
    }
}
