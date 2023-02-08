package com.example.lecture.chapter01.singleton;

/**
 * double checked locking
 * volatile : java 1.5 이상 버전에서 등장
 * solve1보다 좋은 이유 : cpu cache가 아닌 메모리에 저장
 * getInstance를 호출할때마다가 아니라 null 일 경우만 syncronized 가 걸린다.
 */
public class SingleTonClassSolve3 {

    private static volatile SingleTonClassSolve3 instance;

    public static SingleTonClassSolve3 getInstance() {
        if (instance == null) {
            synchronized (SingleTonClassSolve3.class) {
                if (instance == null) {
                    instance = new SingleTonClassSolve3();
                }
            }
        }
        return instance;
    }

    private SingleTonClassSolve3() {
    }
}
