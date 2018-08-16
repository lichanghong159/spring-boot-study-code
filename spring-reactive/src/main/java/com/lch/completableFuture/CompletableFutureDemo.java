package com.lch.completableFuture;

import java.util.concurrent.CompletableFuture;

/**
 *
 * @author: lichanghong on 2018-07-25
 **/
public class CompletableFutureDemo {
    public static void main(String[] args) {
        println("当前线程");
        //流式编程
        //异步非阻塞
        CompletableFuture.supplyAsync(()->{
            println("第一步");
            return "hello";
        }).thenApplyAsync(result->{
            println("第2步");
            return result+" Word";
        }).thenAccept(CompletableFutureDemo::println)
                .whenComplete((v,error)->{
                    println("当前线程");
                })
                .join();
    }
    private static void println(String message){
        System.out.printf("[线程:%s]->%s\n",Thread.currentThread().getName(),message);
    }
}
