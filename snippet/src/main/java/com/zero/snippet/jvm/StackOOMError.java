package com.zero.snippet.jvm;

import java.util.concurrent.TimeUnit;

/**
 *  栈异常补充案例
 *  演示大量创建线程撑爆内存
 *  但仅仅出现了 StackOverFlowError 没有出现 OOM
 *
 * @author lishaofei
 * @date 2022/9/12 23:32
 */
public class StackOOMError {
    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            new Thread("Thread-" + i) {
                @Override
                public void run() {
                    try {
                        String name = Thread.currentThread().getName();
                        System.out.println(name);
                        recurive(30000);
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println();
                }
            }.start();
        }
    }

    public static void recurive(double d) {
        if (d == 0)
            return;
        recurive(d - 1);
    }
}
