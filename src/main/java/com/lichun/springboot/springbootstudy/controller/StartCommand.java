package com.lichun.springboot.springbootstudy.controller;

import com.lichun.springboot.springbootstudy.util.ServerPortUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

@Slf4j
public class StartCommand {
    public StartCommand(String[] args) {
        Boolean isServerPort = false;
        String serverPort = "";
        if (args != null) {
            for (String arg : args) {
                if (StringUtils.hasText(arg) && arg.startsWith("--server.port")) {
                    isServerPort = true;
                    serverPort = arg;
                    break;
                }
            }
        }
        if(!isServerPort) {
            int port = ServerPortUtils.getAvailablePort();
            log.info("current server.port=" + port);
        } else {
            log.info("current server.port=" + serverPort.split("=")[1]);
            System.setProperty("server.port", serverPort.split("=")[1]);
        }
    }
}
