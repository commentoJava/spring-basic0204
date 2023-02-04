package com.example.lecture.chapter01.singleton;

/**
 * double checked locking
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
