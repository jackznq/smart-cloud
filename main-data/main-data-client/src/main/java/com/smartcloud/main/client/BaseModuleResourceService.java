package com.smartcloud.main.client;

import com.smartcloud.common.pojo.ResponseData;
import com.smartcloud.main.api.InterfaceService;
import com.smartcloud.main.api.mapper.model.BaseModuleResources;
import com.smartcloud.main.api.pojo.ResponseCode;
import com.smartcloud.main.api.service.BaseModuleResourcesRemoteService;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = InterfaceService.SERVICE_NAME, fallback = BaseModuleResourceService.HystrixClientFallback.class)
public interface BaseModuleResourceService extends BaseModuleResourcesRemoteService {

    class HystrixClientFallback implements BaseModuleResourceService{

        @Override
        public ResponseData<List<BaseModuleResources>> getMenusByUserId(@PathVariable("userId") Long userId) {
            return new ResponseData<>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getMessage());
        }
    }
}
