package ACM.其他的算法比赛.笔试.北森;

import java.util.LinkedList;
import java.util.Queue;

public class 生产者消费者Main {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        int maxSize = 5;

        /*Producer p1 = new Producer(queue,maxSize);
        Consumer c1 = new Consumer(queue,maxSize);
        p1.start();
        c1.start();*/

        int i = Integer.parseInt("-1");
        System.out.println(i);


    }

    public static class Producer extends Thread{
        Queue<Integer> queue;
        int maxSize;
        int stuff = 0;
        public Producer(Queue<Integer> queue,int maxSize){
            this.queue = queue;
            this.maxSize = maxSize;
        }

        @Override
        public void run() {
            synchronized (queue){
                while (true){
                    if (queue.size()==maxSize){
                        System.out.println("队列满,需要消费~~~");
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    //没满,我就生产
                    queue.offer(stuff++);
                    queue.notifyAll();//唤醒所有的消费者前来消费
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static class Consumer extends Thread{
        Queue<Integer> queue;
        int maxSize;
        public Consumer(Queue<Integer> queue,int maxSize){
            this.queue = queue;
            this.maxSize = maxSize;
        }

        @Override
        public void run() {
            synchronized (queue){
                while (true){
                    if (queue.size()==0){
                        System.out.println("队空,需要生产~~~");
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    //没满,我就生产
                    //queue.offer(stuff++);
                    System.out.println("消费~~"+queue.poll());
                    queue.notifyAll();//唤醒所有的消费者前来消费
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
