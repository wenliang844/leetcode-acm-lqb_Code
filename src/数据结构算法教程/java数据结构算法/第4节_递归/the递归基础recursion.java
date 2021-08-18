package 数据结构算法教程.java数据结构算法.第4节_递归;

public class the递归基础recursion {

    public static void main(String[] args) {
        //通过打印问题回顾递归的调用机制
        /***
         栈空间: main开启一个空间,调用test(4)-->立即开辟一个独立的空间test(3)->test(2){往下执行代码到return再退出}
         堆空间:
         代码/常量区
         每个空间的局部变量是独立的,java空间图要理解 重要

         迷宫问题
         八皇后问题

         球和篮子问题{google编程大赛}:
         有几个球,希望能放到几个篮子里,每个篮子有相同的容量,
         给出int的baskets[]篮子的数量
         capacity[]篮子的最大容量
         balls[]表示归类到篮子的数量
         返回值是把球归类到篮子里的方式的数量
         如果不能完全存放,返回0
         篮子互不相同 球相同
         2个球到2个篮子
         3种 (0,2)(1,1)(2,0)

         */
        /*****
         **递归能解决的问题
         1.各种数学问题
         8皇后
         汉诺塔
         阶层问题
         迷宫问题
         球和篮子问题{google编程大赛}
         **算法:
         快速排序
         归并排序
         二分查找
         分治算法_hanoi
         递归->代码简介 容易想到和理解
            ->时间复杂度高

         引用类型有可能共享数据空间 在堆里
         */
        //test(9);
        System.out.println(factorial(4));
    }

    //打印问题
    public static void test(int n){
        if (n>2){
            test(n-1);
        }
        System.out.println("n=="+n);
    }

    //阶层问题
    public static int factorial(int n){
        if (n==1){
            return 1;
        }else {
            return factorial(n-1)*n;
        }
    }
}
