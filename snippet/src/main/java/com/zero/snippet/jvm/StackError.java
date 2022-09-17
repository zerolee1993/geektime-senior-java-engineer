package com.zero.snippet.jvm;

/**
 * 栈异常模拟
 * Xss 默认为 1M
 * 可调整 Xss 观察异常时打印的栈深度
 *
 * @author lishaofei
 * @date 2022/9/12 23:21
 */
public class StackError {

    private static int index = 1;

    public static void main(String[] args) {
        StackError mock = new StackError();
        try {
            mock.call();
        } catch (Throwable e) {
            System.out.println("Stack Deep: " + index);
            e.printStackTrace();
        }
    }

    public void call() {
        index++;
        call();
    }

}
