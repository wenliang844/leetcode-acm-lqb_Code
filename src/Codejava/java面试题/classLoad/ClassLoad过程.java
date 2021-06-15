package Codejava.java面试题.classLoad;

public class ClassLoad过程 {

    public static void main(String[] args) {
        /*Son s1 = new Son();
        System.out.println("-----");
        Son s2 = new Son();*/
    }
}

class Father {
    /***
     初始化<clinit></>
     子类的静态代码块

     初始化父类51
     初始化子类106

     子类的实例化方法:
        super()
        i=test() -->父类多态,执行的是子类的test
        非静态代码块
        构造器{最后}
     */
    private int i = test();


    private static int j = methed();

    static {
        System.out.print("{1}");
    }

    Father() {
        System.out.print("{2}");
    }

    {
        System.out.print("{3}");
    }

    private int test() {
        System.out.print("{4}");
        return 1;
    }

    private static int methed() {
        System.out.print("{5}");
        return 1;
    }
}

class Son extends Father {
    private int i = test();


    private static int j = methed();

    static {
        System.out.print("{6}");
    }

    Son() {
        super();//写不写都存在,一定会调用父类的构造器
        System.out.print("{7}");
    }

    {
        System.out.print("{8}");
    }

    private int test() {
        System.out.print("{9}");
        return 1;
    }

    private static int methed() {
        System.out.print("{10}");
        return 1;
    }

    public static void main(String[] args) {
        Son s1 = new Son();
        System.out.println("-----");
        Son s2 = new Son();
    }
}