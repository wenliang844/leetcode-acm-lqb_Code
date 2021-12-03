package ACM.其他的算法比赛.笔试.爱奇艺;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class aqy3指定顺序打印 {
    public static void main(String[] args) throws InterruptedException {
        final Scanner reader = new Scanner(System.in);
        final String next = reader.next();
        String[] orders = next.substring(1, next.length() - 1).split(",");
        FooPrint foo = new FooPrint();
        Thread thread1 = new Thread(() -> {
            try {
                foo.first(() -> System.out.print("first"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                foo.second(() -> System.out.print("second"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread3 = new Thread(() -> {
            try {
                foo.third(() -> System.out.print("third"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        List<Thread> threads = Arrays.asList(thread1, thread2, thread3);
        for (int i = 0; i < orders.length; i++) {
            threads.get(Integer.parseInt(orders[i]) - 1).start();
        }
        reader.close();
    }
}
//66
class FooPrint2 {

    public FooPrint2() {
    }

    boolean fRun = false;
    boolean sRun = false;
    public void first(Runnable printFirst) throws InterruptedException {
        //待实现
        //System.out.println("first");

        printFirst.run();
        fRun=true;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        //待实现
        //System.out.println("second");
        while (true){
            if (fRun){
                printSecond.run();
                sRun=true;
                break;
            }
        }

    }

    public void third(Runnable printThird) throws InterruptedException {
        //待实现
        //System.out.println("third");
        while (true){
            if(sRun){
                printThird.run();
                break;
            }
        }

    }
}

//100
class FooPrint {

    public FooPrint() {
    }

    //boolean fRun = false;
    //boolean sRun = false;
    public void first(Runnable printFirst) throws InterruptedException {
        //待实现
        //System.out.println("first");

        printFirst.run();
        //fRun=true;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        //待实现
        //System.out.println("second");
        //while (true){
        //    if (fRun){
        //        printSecond.run();
        //        sRun=true;
        //        break;
        //    }
        //}
        Thread.sleep(1);
        printSecond.run();

    }

    public void third(Runnable printThird) throws InterruptedException {
        //待实现
        //System.out.println("third");
        //while (true){
        //    if(sRun){
        //        printThird.run();
        //        break;
        //    }
        //}
        Thread.sleep(2);
        printThird.run();

    }
}