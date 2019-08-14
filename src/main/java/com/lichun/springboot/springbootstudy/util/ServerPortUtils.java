package com.lichun.springboot.springbootstudy.util;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class ServerPortUtils {
    public static int getAvailablePort() {
        int max = 65535;
        int min = 2000;
        Random random = new Random();
        int port = random.nextInt(max) % (max - min + 1) + min;
        boolean using = NetUtils.isLoclePortUsing(port);
        if (using) {
            return getAvailablePort();
        } else {
            return port;
        }

    }
}
