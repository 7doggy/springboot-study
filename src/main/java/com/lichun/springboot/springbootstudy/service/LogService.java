package com.lichun.springboot.springbootstudy.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LogService {

    @Async
    public void sayLog() {
      log.info(Thread.currentThread().getName());
    }
}
