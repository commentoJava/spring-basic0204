package com.example.lecture.chapter01.singleton;

/**
 * 멀티스레드 환경 세이프 한가?? NO
 */
public class SingleTonClass {

    private static SingleTonClass instance;

    private SingleTonClass(){}

    public static SingleTonClass getInstance(){
        if(instance==null){
            instance=new SingleTonClass();
        }
        return instance;
    }
}

