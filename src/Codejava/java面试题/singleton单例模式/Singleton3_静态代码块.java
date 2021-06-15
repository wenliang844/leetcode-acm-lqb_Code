package Codejava.java面试题.singleton单例模式;

public class Singleton3_静态代码块 {
    public static final Singleton3_静态代码块 INSTANCE;
    private String info;

    static {
        //加载文件Properties 类加载器
        INSTANCE = new Singleton3_静态代码块("你好,陈文亮");
    }

    private Singleton3_静态代码块(String info) {
        this.info = info;
    }
}
