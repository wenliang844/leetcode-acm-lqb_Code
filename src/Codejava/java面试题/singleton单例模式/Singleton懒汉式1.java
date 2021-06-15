package Codejava.java面试题.singleton单例模式;

public class Singleton懒汉式1 {
    /***
     1.构造器私有化
     2.类中静态变量保存唯一的实例
     3.提供一个静态方法,获取这个实例
     */
    private static  Singleton懒汉式1 instance;
    private Singleton懒汉式1(){

    }

    public static Singleton懒汉式1 getInstance(){
        if (instance == null){//你没创建,get的时候,我就帮你创建,不然不创建
            try {
                Thread.sleep(1000);//为了达到效果,在getInstance加一个线程的休眠
            } catch (InterruptedException e) {//进行阻塞,先后进来了  概率问题
                e.printStackTrace();
            }
            instance = new Singleton懒汉式1();
        }
        return instance;
    }
}
