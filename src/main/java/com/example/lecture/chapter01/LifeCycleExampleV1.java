package com.example.lecture.chapter01;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LifeCycleExampleV1 implements InitializingBean, DisposableBean {
    @Override
    public void destroy() throws Exception {
        log.info("\n 소멸전 콜백");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("\n 초기화 콜백");
    }
}
