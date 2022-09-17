package com.zero.snippet.jvm;

/**
 * 老年代内存担保案例
 * -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC
 *
 * @author lishaofei
 * @date 2022/9/17 15:05
 */
public class MemoryAllocationGuarantee {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws InterruptedException {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[1 * _1MB];//1M
        allocation2 = new byte[1 * _1MB];//1M
        allocation3 = new byte[1 * _1MB];//1M
        allocation4 = new byte[6 * _1MB];//6M
    }
}
