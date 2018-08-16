package com.lch.springCloud.configClient.demo;

import java.util.*;

/**
 * 观察者模式在java中的应用
 * @author: lichanghong on 2018-07-31
 **/
public class ObserverDemo {
    public static void main(String[] args) {
        MyObservable observable = new MyObservable();
        //增加订阅者
        observable.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object value) {
                System.out.println(value);
            }
        });
        observable.setChanged();//发布者发生变化
        //发布者通知，订阅者是被动感知的(推模式)
        observable.notifyObservers("Hello,World");
        echoIterator();
    }
    private static void echoIterator(){
        List<Integer> values = Arrays.asList(1,2,3,4,5);
        Iterator<Integer> iterator = values.iterator();
        while(iterator.hasNext()){//通过循环，主动去获取（拉的模式）
            System.out.println(iterator.next());
        }
    }
    public static class MyObservable extends Observable{

        public  void setChanged() {
            super.setChanged();
        }
    }
}
