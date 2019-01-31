package com.smartcloud.main.client;

import com.smartcloud.common.pojo.ResponseData;
import com.smartcloud.main.api.InterfaceService;
import com.smartcloud.main.api.mapper.model.BaseRole;
import com.smartcloud.main.api.pojo.ResponseCode;
import com.smartcloud.main.api.service.BaseRoleRemoteService;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = InterfaceService.SERVICE_NAME, fallback = BaseRoleService.HystrixClientFallback.class)
public interface BaseRoleService extends BaseRoleRemoteService{

    class HystrixClientFallback implements BaseRoleService{

        @Override
        public ResponseData<List<BaseRole>> getRoleByUserId(@PathVariable("userId") Long userId) {
            return new ResponseData<>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getMessage());
        }
    }
}
