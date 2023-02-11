package com.example.lecture.chapter01.singleton;

/**
 * 멀티스레드 환경 세이프 한가??
 */
public class SingleTonClassSolve4 {

    public static class SingleTonClassSolve4Holder {
        private static final SingleTonClassSolve4 instance = new SingleTonClassSolve4();
    }

    private SingleTonClassSolve4() {
    }

    /**
     * lazy loading이 가능해지는 장점.
     */
    public static SingleTonClassSolve4 getInstance() {
        return SingleTonClassSolve4Holder.instance;
    }
}

