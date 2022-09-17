package com.zero.snippet.jvm;

/**
 * 大对象创建直接进入老年代案例
 * -Xmx60m -Xms60m -XX:NewRatio=2 -XX:SurvivorRatio=8 -XX:+PrintGCDetails
 *
 * @author lishaofei
 * @date 2022/9/17 14:28
 */
public class BigObjectCreate {

    public static void main(String[] args)
            throws InterruptedException {
        byte[] buffer = new byte[1024 * 1024 * 20];
        Thread.sleep(1000 * 60 * 60);
    }
}
