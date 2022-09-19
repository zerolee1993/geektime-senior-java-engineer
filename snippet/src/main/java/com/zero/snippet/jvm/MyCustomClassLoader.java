package com.zero.snippet.jvm;

import java.io.*;
import java.lang.reflect.Method;

/**
 * 自定义类加载器案例
 *
 * @author lishaofei
 * @date 2022/9/12 11:31
 */
public class MyCustomClassLoader extends ClassLoader {

    private final String classpath;

    public MyCustomClassLoader(String classpath) {
        this.classpath = classpath;
    }

    public static void main(String[] args) throws Exception {
        //自定义类加载器的加载路径(事先在该目录使用同版本 jdk 编译一个 class 类，参考 model.User)
        MyCustomClassLoader myCustomClassLoader = new MyCustomClassLoader("/Users/lishaofei/Downloads");
        // 类全限定名称
        Class<?> c = myCustomClassLoader.loadClass("User");

        if (c != null) {
            // 创建对象
            Object obj = c.newInstance();
            // 获取对象的指定方法
            Method method = c.getMethod("print", (Class<?>[]) null);
            // 执行方法
            method.invoke(obj);
            // 打印该类的类加载器
            System.out.println(c.getClassLoader().toString());
            // 打印内容：com.zero.snippet.jvm.MyCustomClassLoader@2f2c9b19
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            // 输入流，通过类的全限定名称加载文件到字节数组
            // 将文件目录中的 class 文件，以字节码流输入内存
            byte[] classDate = getData(name);
            if (classDate != null) {
                //defineClass方法将字节数组数据 转为 字节码对象
                return defineClass(name, classDate, 0, classDate.length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return super.findClass(name);
    }

    //加载类的字节码数据
    private byte[] getData(String className) throws IOException {
        String path = classpath + File.separatorChar +
                className.replace('.', File.separatorChar) + ".class";
        try (InputStream in = new FileInputStream(path);
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[2048];
            int len;
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            return out.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
