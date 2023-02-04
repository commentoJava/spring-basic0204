package com.example.lecture.chapter01.singleton;

/**
 * 멀티스레드 환경 세이프 한가?? YES
 */
public class SingleTonClassSolve1 {

    private static SingleTonClassSolve1 instance;

    private SingleTonClassSolve1(){}

    public static synchronized SingleTonClassSolve1 getInstance(){
        if(instance==null){
            instance=new SingleTonClassSolve1();
        }
        return instance;
    }
}

