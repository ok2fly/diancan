package com.gcfd.service.contorller;

import com.gcfd.common.DataCenter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/service/hello")

public class HelloWorldController {
    @RequestMapping(value = "/sayhello",method = RequestMethod.GET)
	public DataCenter<Object> helloworld() {
        DataCenter<Object> netData = new DataCenter<Object>();// 实例化统一网络包
        netData.setData("Hello World!");
        return netData;
    }
}

