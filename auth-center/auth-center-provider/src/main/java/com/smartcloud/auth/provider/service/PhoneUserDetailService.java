package com.smartcloud.auth.provider.service;

import com.smartcloud.common.pojo.ResponseData;
import com.smartcloud.main.api.mapper.model.BaseUser;
import com.smartcloud.main.api.pojo.ResponseCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PhoneUserDetailService extends BaseUserDetailService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    protected BaseUser getUser(String phone) {
        // 手机验证码调用FeignClient根据电话号码查询用户
        ResponseData<BaseUser> baseUserResponseData = baseUserService.getUserByPhone(phone);
        if(baseUserResponseData.getData() == null || !ResponseCode.SUCCESS.getCode().equals(baseUserResponseData.getCode())){
            logger.error("找不到该用户，手机号码：" + phone);
            throw new UsernameNotFoundException("找不到该用户，手机号码：" + phone);
        }
        return baseUserResponseData.getData();
    }
}
