package Codejava.java面试题.singleton单例模式;

public class singleton饿汉式Test {

    public static void main(String[] args) {
        singleton饿汉式 s = singleton饿汉式.instance;//静态可以直接使用

        Singleton饿汉式enum s1 = Singleton饿汉式enum.INSTANCE;//一样的
    }

}
