package com.gugu.port_test.controller;

import com.gugu.port_test.mode.Result;
import com.gugu.port_test.service.ListenerServer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author minmin
 * @since 2021/05/07 22:13
 */
@RestController
public class PortController {
    @Resource
    private ListenerServer listenerServer;

    @PostMapping("/port")
    public Result test(Integer port) {
        listenerServer.startListener(port);
        return new Result(200, "ok");
    }
}
