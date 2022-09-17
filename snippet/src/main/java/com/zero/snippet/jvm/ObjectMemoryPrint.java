package com.zero.snippet.jvm;

import lombok.Builder;
import lombok.Data;
import org.openjdk.jol.info.ClassLayout;

/**
 * 对象内存信息打印
 * <dependency>
 * <groupId>org.openjdk.jol</groupId>
 * <artifactId>jol-core</artifactId>
 * <version>0.9</version>
 * </dependency>
 *
 * @author lishaofei
 * @date 2022/9/17 15:50
 */
public class ObjectMemoryPrint {

    public static void main(String[] args) {
//        Object o = new Object();
//        System.out.println("new Object:" +
//                ClassLayout.parseInstance(o).toPrintable());
        System.out.println(ClassLayout.parseInstance(People.builder().build()).toPrintable());
        System.out.println(ClassLayout.parseInstance(People.builder()
                .age(18)
                .name("Tom")
                .adult(true)
                .build()).toPrintable());
    }

    @Data
    @Builder
    static class People{
        private boolean adult;
        private int age;
        private String name;
    }

}
