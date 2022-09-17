package com.zero.snippet.jvm;

/**
 * 自定义描述
 *
 * @author lishaofei
 * @date 2022/9/17 11:32
 */
public class StringCompare {

    public static void main(String[] args) {
        // str1 在字符传常量池，str2 在堆里 ==比较引用地址
        String str1 = "abc";
        String str2 = new String("abc");
        System.out.println("case1:" + (str1 == str2));//  false

        // str3 在堆里，但与 str2 是两个对象，==比较引用地址
        String str3 = new String("abc");
        System.out.println("case2:" + (str3 == str2));// false

        // str4 在编译器合并，并放入字符串常量池
        String str4 = "a" + "b";
        System.out.println("case3:" + (str4 == "ab"));// true

        // str5 编译器合并，并放入字符串常量池
        final String s = "a";
        String str5 = s + "b";
        System.out.println("case4:" + (str5 == "ab"));// true

        // str6 在运行时创建，在堆中
        String s1 = "a";
        String s2 = "b";
        String str6 = s1 + s2;
        System.out.println("case5:" + (str6 == "ab"));// false

        // str7 在运行时创建，在堆中
        String str7 = "abc".substring(0, 2);
        System.out.println("case6:" + (str7 == "ab"));// false

        // str8 在运行时创建，在堆中
        String str8 = "abc".toUpperCase();
        System.out.println("case7:" + (str8 == "ABC"));// false

        // 当调用 intern 方法时，如果常量池中已经该字符串，则返回池中的字符串
        // 否则将此字符串添加到常量池中，并返回字符串的引用
        String s5 = "a";
        String s6 = "abc";
        String s7 = s5 + "bc";
        System.out.println("case8:" + (s6 == s7.intern()));// true
    }

}
