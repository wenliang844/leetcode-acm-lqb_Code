package Codejava.java面试题.singleton单例模式;

public class Singleton懒汉式3 {
    /**
     1.在内部类被加载时才创建对象
     2.静态内部类不会自动随着外部类的加载而初始化,是独立的类,需要单独初始化的{延时加载}
     因为是在内部类加载和初始化时,创建的,因此是线程安全的
     */

    private Singleton懒汉式3(){

    }
    private static class Inner{//内部类
        private static final Singleton懒汉式3 instance = new Singleton懒汉式3();

    }
    public static Singleton懒汉式3 getInstance(){//推荐
        return Inner.instance;
    }
}
