package Codejava.java面试题.singleton单例模式;

public class singleton饿汉式 {
    /***
     直接创建对象:不管你是否需要这个对象,如果有静态方法
     1.构造器私有化
     2.自行创建,静态变量保存
     3.向外提供这个实例
     4.强调这是一个单例,可以final修饰
     */
    public static final singleton饿汉式 instance = new singleton饿汉式();
    private singleton饿汉式(){

    }

    public static void test(){

    }

}
