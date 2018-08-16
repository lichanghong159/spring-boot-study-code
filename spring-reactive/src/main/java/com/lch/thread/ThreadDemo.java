package com.lch.thread;

import java.util.concurrent.CompletableFuture;

/**
 * @author: lichanghong on 2018-07-25
 **/
public class ThreadDemo {
    public static void main(String[] args) {
    println("helloWord1");
    Thread thread = new Thread(()->{
        println("helloWord2018");
    },"sub-thread");
        thread.start();
        println("helloWord2");
    }
    private static void println(String message){
        System.out.printf("[线程:%s]->%s\n",Thread.currentThread().getName(),message);
    }
}
