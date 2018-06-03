package com.gcfd.consumer.controller;

import com.gcfd.common.DataCenter;
import com.gcfd.consumer.feign.ScrScenceConsumeFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer/scr/scence/consume")
public class ScrScenceConsumeController {

    @Autowired
    private ScrScenceConsumeFeign scrScenceConsumeFeign;

    @RequestMapping(value = "/branch/{branchId}",method = RequestMethod.GET)
    public DataCenter<Object> getBranchInfo(@PathVariable("branchId") String branchId) {
        return scrScenceConsumeFeign.getBranchInfo(branchId);
    }
}
