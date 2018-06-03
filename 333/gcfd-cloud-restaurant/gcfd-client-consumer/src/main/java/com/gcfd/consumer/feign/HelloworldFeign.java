package com.gcfd.consumer.feign;

import com.gcfd.common.DataCenter;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="GCFD-HT")
public interface HelloworldFeign {

    @RequestMapping(value = "/pservice/service/hello/sayhello",method = RequestMethod.GET)
    DataCenter<Object> sayhello();
}
