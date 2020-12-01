package com.dukz.java8newfeature.interfacenewfeature;

import java.util.function.Supplier;

/**
 * @author dukezheng
 * @ClassName Defaulable
 * @Description TODO
 * @date 2020/12/1 10:01
 * @Version 1.0
 */
public class InterfaceDefaultStaticMethod {

    private interface Defaultable{
        /**
         * @Author dukezheng
         * @Description //TODO 默认方法，实现类可以选择实现还是不实现
         * @Date 10:03 2020/12/1
         * @Param []
         * @return java.lang.String
         **/
        default String notRequired(){
            return "Default implementation";
        }
    }

    private static class DefaultableImpl implements Defaultable{
    }
    private static class OverrideableImpl implements Defaultable{
        @Override
        public String notRequired(){
            return "Overridden implementation";
        }
    }
    
    private interface DefaultFactory {
        /**
         * @Author dukezheng
         * @Description //TODO 接口支持静态方法
         * @Date 10:09 2020/12/1
         * @Param [supplier]
         * @return com.dukz.java8newfeature.interfacenewfeature.InterfaceDefaultStaticMethod.Defaultable
         **/
        static Defaultable create(Supplier<Defaultable> supplier){
            return supplier.get();
        }
    }

    public static void main(String[] args) {
        Defaultable defaultable = DefaultFactory.create(DefaultableImpl::new);
        System.out.println(defaultable.notRequired());

        defaultable = DefaultFactory.create(OverrideableImpl::new);
        System.out.println(defaultable.notRequired());
    }
}

