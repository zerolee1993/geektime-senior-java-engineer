package com.zero.snippet.jvm;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * 引用类型案例
 *
 * @author lishaofei
 * @date 2022/9/17 13:40
 */
public class TestReference {
    public static void main(String[] args) {
        //强引用
        Object obj = new Object();
        System.out.println("强引用->" + obj);

        //软引用
        Object obj1 = new Object();
        SoftReference<Object> sf = new SoftReference<>(obj1);
        obj1 = null;
        Object o1 = sf.get();//有时候会返回null
        System.out.println("软引用->" + o1 + ",是否被垃圾回收器标记为即将回收的垃圾 = " + sf.isEnqueued());

        //弱引用
        Object obj2 = new Object();
        WeakReference<Object> wf = new WeakReference<>(obj2);
        obj2 = null;
        System.gc();
        Object o2 = wf.get();//有时候会返回null
        System.out.println("弱引用->" + o2 + ",是否被垃圾回收器标记为即将回收的垃圾 = " + wf.isEnqueued());

        // 虚引用
        Object obj3 = new Object();
        PhantomReference<Object> pf = new PhantomReference<>(obj3, new ReferenceQueue<>());
        obj3 = null;
        Object o3 = pf.get();//永远返回null
        System.out.println("虚引用->" + o3 + ",是否被垃圾回收器标记为即将回收的垃圾 = " + pf.isEnqueued());
    }
}
