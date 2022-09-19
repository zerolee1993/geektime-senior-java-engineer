package com.zero.snippet.jvm;

import java.util.HashMap;

/**
 * 字符传 hash 案例
 *
 * @author lishaofei
 * @date 2022/9/17 11:17
 */
public class StringHashCode {

    public static void main(String[] args) {
        System.out.println("hello".hashCode());// 99162322
        System.out.println("world".hashCode());// 113318802
        System.out.println("java".hashCode());// 3254818
        System.out.println("通话".hashCode());// 1179395
        System.out.println("重地".hashCode());// 1179395

        HashMap<String, Integer> map = new HashMap<>();
        // 99162322 哈希碰撞，数值不存在，则计算哈希，存入数据，若哈希所在位置已有元素，则存入同位置的链表
        map.put("hello", 53);
        // 113318802 哈希碰撞，数值不存在，则计算哈希，存入数据，若哈希所在位置已有元素，则存入同位置的链表
        map.put("world", 35);
        // 3254818 哈希碰撞，数值不存在，则计算哈希，存入数据，若哈希所在位置已有元素，则存入同位置的链表
        map.put("java", 55);
        // 113318802 哈希碰撞，数值存在，则比较字符传的值，字符串值相同，则覆盖元数据
        map.put("world", 52);
        // 1179395 哈希碰撞，数值不存在，则计算哈希，存入数据，若哈希所在位置已有元素，则存入同位置的链表
        map.put("通话", 51);
        // 1179395 哈希碰撞，数值存在，则比较字符传的值，字符串值不相同，则计算哈希，存入数据，若哈希所在位置已有元素，则存入同位置的链表
        map.put("重地", 55);
        System.out.println(map);

    }

}
