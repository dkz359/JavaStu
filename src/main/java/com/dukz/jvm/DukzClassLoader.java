package com.dukz.jvm;

import java.io.*;

/**
 * @ClassName DukzClassLoader
 * @Description 自定义类加载器
 * @Author dukz
 * @Date 12/29/20
 * @Version 1.0
 */
public class DukzClassLoader extends ClassLoader {

    private String classPath;

    public DukzClassLoader(String classPath) {
        this.classPath = classPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] result = loadClassBytes(name);
            if(result == null){
                throw new FileNotFoundException(name);
            }else{
                return defineClass(name, result, 0, result.length);
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new ClassNotFoundException(name);
        }
    }

    /**
     * @Author dukz
     * @Description 根据字节码文件获取字节码数组
     * @Date 12/29/20
     * @Param [file]
     * @return
     **/
    public byte[] loadClassBytes(String name){
        String path = classPath+name.replace('.', '/')+".class";
        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            int len = fileInputStream.available();
            byte[] data = new byte[len];
            fileInputStream.read(data);
            return data;
        }catch (Exception e){
            return null;
        }
    }

    public static void main(String[] args) {
        String classPath = "/Users/dukz/workspace/jvmtest/";
        DukzClassLoader dukzClassLoader = new DukzClassLoader(classPath);

        try {
            /**
             * 注意：此处Class.forName和loadClass由于双亲委派模型，如果能被AppClassLoader加载则会被加载，最终结果是AppClassLoader；
             *      而findClass由于方法重写所以始终会由DukzClassLoader加载；
             *      或者重写loadclass也行，但是加载class时就要用loadClass方法；双亲委派的逻辑就是在loadClass方法中
             */
            //Class<?> clazz = Class.forName("com.dukz.jvm.TestWhoLoad", true, dukzClassLoader);
            //Class<?> clazz = dukzClassLoader.loadClass("com.dukz.jvm.TestWhoLoad");
            Class<?> clazz = dukzClassLoader.findClass("com.dukz.jvm.TestWhoLoad");
            Object obj = clazz.newInstance();
            System.out.println(obj.getClass().getClassLoader());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
