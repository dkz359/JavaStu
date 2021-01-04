package com.dukz.jvm;

import java.io.*;

/**
 * @ClassName CustomClassLoader
 * @Description 自定义类加载器
 * @Author dukz
 * @Date 12/29/20
 * @Version 1.0
 */
public class CustomClassLoader extends ClassLoader {


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] result = getClassFormFile(name);
            if(result == null){
                throw new FileNotFoundException();
            }else{
                return defineClass(name, result, 0, result.length);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        throw new ClassNotFoundException(name);
    }

    public static void main(String[] args) {
        CustomClassLoader customClassLoader = new CustomClassLoader();

        try {
            /**
             * 注意：此处Class.forName和loadClass由于双亲委派模型，如果能被AppClassLoader加载则会被加载，最终结果是AppClassLoader；
             *      而findClass由于方法重写所以始终会由customClassLoader加载；
             */
            Class<?> clazz = Class.forName("com.dukz.jvm.TestWhoLoad", true, customClassLoader);
            //Class<?> clazz = customClassLoader.loadClass("com.dukz.jvm.TestWhoLoad");
            //Class<?> clazz = customClassLoader.findClass("com.dukz.jvm.TestWhoLoad");
            Object obj = clazz.newInstance();
            System.out.println(obj.getClass().getClassLoader());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @Author dukz
     * @Description 根据字节码文件获取字节码数组
     * @Date 12/29/20
     * @Param [file]
     * @return
     **/
    public byte[] getClassFormFile(String name){

        String path = "/Users/dukz/"+name.replace('.', '/')+".class";
        File file = new File(path);
        if (file.exists()){
            FileInputStream in = null;
            ByteArrayOutputStream out= null;

            try{
                in = new FileInputStream(file);
                out = new ByteArrayOutputStream();

                byte[] buffer = new byte[1024];
                int size = 0;
                while ((size = in.read(buffer))!=-1){
                    out.write(buffer, 0, size);
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return out.toByteArray();
        }else {
            return null;
        }
    }
}
