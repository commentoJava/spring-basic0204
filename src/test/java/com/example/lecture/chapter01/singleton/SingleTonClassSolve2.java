package com.example.lecture.chapter01.singleton;

/**
 * 멀티스레드 환경 세이프 한가?? YES
 * 해결법 : 이른 초기화
 */
public class SingleTonClassSolve2 {

    private static SingleTonClassSolve2 instance = new SingleTonClassSolve2();

    private SingleTonClassSolve2() {
    }

    public static SingleTonClassSolve2 getInstance() {
        return instance;
    }
}

