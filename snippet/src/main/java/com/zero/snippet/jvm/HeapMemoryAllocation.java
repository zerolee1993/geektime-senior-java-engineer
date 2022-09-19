package com.zero.snippet.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 内存分配过程可视化案例
 * 工具： VisualVM 中的插件 Visual GC
 *
 * @author lishaofei
 * @date 2022/9/17 14:39
 */
public class HeapMemoryAllocation {

    public static void main(String[] args) throws InterruptedException {
        List<Object> list = new ArrayList<>();
        while (true) {
            list.add(new byte[1024 * 1024]);
            Thread.sleep(20);
        }
    }

}
