package Codejava.java面试题.singleton单例模式;

import java.util.concurrent.*;

public class Singleton懒汉式1Test {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Singleton懒汉式1 s1 = Singleton懒汉式1.getInstance();
        Singleton懒汉式1 s2 = Singleton懒汉式1.getInstance();

        System.out.println(s1==s2);
        System.out.println(s1);
        System.out.println(s2);

        //线程安全问题
        Callable<Singleton懒汉式1> c = new Callable<Singleton懒汉式1>() {//调用服务
            @Override
            public Singleton懒汉式1 call() throws Exception {
                return Singleton懒汉式1.getInstance();
            }
        };

        ExecutorService es = Executors.newFixedThreadPool(2);//线程池
        Future<Singleton懒汉式1> f1 = es.submit(c);
        Future<Singleton懒汉式1> f2 = es.submit(c);

        Singleton懒汉式1 s3 = f1.get();//为了达到效果,在getInstance加一个线程的休眠
        Singleton懒汉式1 s4 = f2.get();

        System.out.println(s3==s4);
        System.out.println(s3);
        System.out.println(s4);

        es.shutdown();
    }
}
