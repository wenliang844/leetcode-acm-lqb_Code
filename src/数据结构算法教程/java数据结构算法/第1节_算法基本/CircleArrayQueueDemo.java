package 数据结构算法教程.java数据结构算法.第1节_算法基本;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleArrayQueue queue = new CircleArrayQueue(10);
        System.out.println(queue.isEmpty());
        System.out.println(queue.pop());

        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println("有效数据数" + queue.getNum());

        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());

        System.out.println("有效数据数" + queue.getNum());
    }


}


class CircleArrayQueue {
    private int rear;
    private int front;
    private int maxSize;
    private int[] arr;

    public CircleArrayQueue(int newMaxSize) {
        maxSize = newMaxSize;
        arr = new int[maxSize];
        //rear=0;//可以不写，默认是0
        //front=0;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public int getNum() {
        //rear=1;
        //front=0'
        //maxSize=3
        return ((rear + maxSize - front) % maxSize);
    }

    public void push(int a) {
        if ((rear + 1) % maxSize == front) {
            System.out.println("插入失败,队列满了");
            return;
        }

        /*
        还有一个逻辑
        当rear到达maxSize-1的时候
        rear=0
         */
        /*if (rear == maxSize - 1) {
            rear = 0;
        }*/
        //可以在后面直接+1取模 这是更聪明的做法

        //if ((rear+maxSize-front)%maxSize > 0){
        arr[rear] = a;
        rear = (rear + 1) % maxSize;
        //}
    }

    public int pop() {
        if (this.isEmpty()) {
            System.out.println("队列为空,不可以pop");
            return -1;
        }

        //这里需要分析出front是指向度列的第一个元素
        //1.先把front的对应值保存在一个临时变量temp
        //2.将front后移  要考虑取模
        //3.将临时保存的变量返回
        int temp = arr[front];//front和rear在一个指针上,
        front = (front + 1) % maxSize;//需要考虑取模  不然会越界
        return temp;
    }

    //显示队列数据:一直取 直到为空
    public void showQueue() {
        //遍历
        if (isEmpty()) {
            System.out.println("队列是空的,没有数据了~~~");
            return;
        }
        //思路从front开始遍历,遍历多少个元素就可以了
        //动脑子思考一下  是不是front开始  到front+(rear+maxSize-front)%maxSize
        for (int i = front; i < front + getNum(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i]); //format 格式化输出
        }
    }

    //显示头元素
    public int getHeader() {
        if (isEmpty()) {
            throw new RuntimeException("空队列!!");
        }
        return arr[front];
    }


}
