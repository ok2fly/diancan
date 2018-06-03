package com.gcfd.consumer.feign;

import com.gcfd.common.DataCenter;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="GCFD-HT")
public interface ScrScenceConsumeFeign {

    @RequestMapping(value = "/pservice/service/scr/scence/consume/branch/{branchId}",method = RequestMethod.GET)
    DataCenter<Object> getBranchInfo(@PathVariable("branchId") String branchId);
}
