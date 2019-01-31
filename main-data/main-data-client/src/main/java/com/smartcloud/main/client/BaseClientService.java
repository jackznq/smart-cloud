package com.smartcloud.main.client;

import com.smartcloud.common.pojo.ResponseData;
import com.smartcloud.main.api.InterfaceService;
import com.smartcloud.main.api.mapper.model.OauthClientDetails;
import com.smartcloud.main.api.pojo.ResponseCode;
import com.smartcloud.main.api.service.BaseClientRemoteService;
import org.springframework.cloud.netflix.feign.FeignClient;

import java.util.List;

@FeignClient(name = InterfaceService.SERVICE_NAME, fallback = BaseClientService.HystrixClientFallback.class)
public interface BaseClientService extends BaseClientRemoteService {

    class HystrixClientFallback implements BaseClientService {

        @Override
        public ResponseData<List<OauthClientDetails>> getAllClient() {
            return new ResponseData<>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getMessage());
        }
    }
}
