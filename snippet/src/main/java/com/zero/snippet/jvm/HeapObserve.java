package com.zero.snippet.jvm;

/**
 * 堆内存观察
 * 工具： VisualVM 中的插件 Visual GC
 * VisualVM 下载地址：http://visualvm.github.io/download.html
 * 指定如下 JVM 参数运行此程序，并使用 VisualVM 监控
 * -Xms100m -Xmx100m
 *
 * @author lishaofei
 * @date 2022/9/12 22:39
 */
public class HeapObserve {

    public static void main(String[] args) {
        System.out.println("------start------");
        try {
            Thread.sleep(1000 * 60 * 60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("-------end-------");
    }

}


