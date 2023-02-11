package com.example.lecture.multithread;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootTest
@Slf4j
public class MultiThreadTest {

    @Autowired
    TestMapBean testMapBean;


    @Test
    void multiThreadTest() throws InterruptedException {
        int numberOfThreads = 100000;
        ExecutorService service = Executors.newFixedThreadPool(10);

        // numberOfThreads 개의 쓰레드가 완료된 후 메인쓰레드가 실행됨
        CountDownLatch latch = new CountDownLatch(numberOfThreads);

        for (int i = 0; i < numberOfThreads; i++) {
            service.submit(() -> {
                testMapBean.retrieveKey("saechim");

                // 스레드가 끝날때 마다 카운트를 감소
                latch.countDown();
            });
        }

        // 카운트가 0 이되면 대기가 풀리고 이후 스레드가 실행
        latch.await();

//        for(int i=0; i<numberOfThreads; i++){
//            testMapBean.retrieveKey("saechim");
//        }

        log.info("\n 최종 value {}",testMapBean.retrieveKey("saechim"));

    }

}
