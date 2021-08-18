package 数据结构算法教程.java数据结构算法.第1节_算法基本;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(10);
        System.out.println(queue.rear);
        queue.push(3);
        System.out.println(queue.arr[0]);
    }


}

class ArrayQueue {
    private int maxSize;
     int rear;
     int front;
     int[] arr;

    public ArrayQueue(int arrMaxSize) {
        this.maxSize = arrMaxSize;
        arr = new int[maxSize];
        rear = -1;
        front = -1;//空的时候
    }

    public boolean isEmpty(ArrayQueue queue) {
        if (queue.rear == queue.front) {
            return true;
        }
        return false;
    }

    //push 加入元素
    public void push(int a){
        if (rear > maxSize-1){
            System.out.println("满了,不能在加了");
        }
        rear = rear+1;
        arr[rear] = a;
    }

}
