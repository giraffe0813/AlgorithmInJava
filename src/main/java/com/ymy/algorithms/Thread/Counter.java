package com.ymy.algorithms.Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by yemengying on 16/4/19.
 */
public class Counter {

    private int i = 0;
    private AtomicInteger atomicInteger = new AtomicInteger();

    private void counter(){
        i++;
    }
    private void safeCounter(){
        for(;;) {
            int old = atomicInteger.get();
            boolean a = atomicInteger.compareAndSet(old, old + 1);
            if (a) {
                break;
            }
        }
    }

    public static void main(String[] args){

        Counter cas = new Counter();
        List<Thread> ts = new ArrayList<>();
        long start = System.currentTimeMillis();
        for(int j=0;j<1000;j++){
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    cas.counter();
                    cas.safeCounter();
                }
            });
            ts.add(t);
        }
        for(Thread t:ts){
            t.start();
        }

        //等待所有线程完成
        for(Thread t:ts){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();

        System.out.println(end-start);
        System.out.println(cas.i);
        System.out.println(cas.atomicInteger.get());




    }

}
