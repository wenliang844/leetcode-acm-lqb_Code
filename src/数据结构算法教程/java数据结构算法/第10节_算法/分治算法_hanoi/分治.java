package 数据结构算法教程.java数据结构算法.第10节_算法.分治算法_hanoi;

/***程序只是tool 只是翻译我们的思想 思想是最重要的
 * ***没有数学的东西,avl 数学,模型{代码}=算法
 归并排序
 傅里叶变换{{快速傅里叶变换}}
 二分
 大整数乘法
 棋盘覆盖 ->分治构造特殊序列
 快速排序
 线性时间选择
 最街景点对问题
 循环赛日程表
 汉诺塔

 如何把复杂的大问题 分解成小问题 小问题在合成得到答案
 1.分解: 将原问题分解为若干个较小的相互独立的,与原问题形式相同的子问题
 2.解决: 若子问题规模较小而容易被解决则直接解,否则递归解决各个子问题
 3.合并: 将各个子问题的解合并成原问题的解

 if p<n0
    then return ADHOC(p)
 //将问题分解为较小的子问题p1,p2,p3,pk
 for i<-1 to k
 do yi<- Divice-and-Comquer(pi) 递归解决子问题pi
 T<-Merge(y1,y2,y3,y4,y5,...yk) 合并子问题
 return(T)

 一个盘直接一次
 A B C
 第一步:把所有的盘移动到B盘A->B  依赖C
 第二部:最后一个盘移动到C盘A->C打印
 第三部:B->C 依靠A

 先把A上面的依赖C移动到B
 把A移动到C
 把B上面的依赖A移动到C

 n>=2 作为两个部分
 1.先把最下面的盘移动到B   A->B{借助C}
 2.把下边的A->C
 3.把B塔的所有盘移动到C   B->C{借助A}
 */
public class 分治 {
    public static void main(String[] args) {
        System.out.println("一个汉诺塔");
        hanoi(1,'A','B','C');
        System.out.println("两个汉诺塔");
        hanoi(2,'A','B','C');
        System.out.println("仨个汉诺塔");
        hanoi(3,'A','B','C');
        System.out.println("四个汉诺塔");
        hanoi(4,'A','B','C');
        System.out.println("四个汉诺塔");
        hanoi(5, 'A', 'B', 'C');
    }

    //分治:汉诺塔
    public static void hanoi(int n,char a,char b,char c){
        if (n==1){//如果只有一个盘
            System.out.println(a+"->"+c);
            return;
        }else {
            hanoi(n-1,a,c,b);//a上面的n-1个盘借助c传递给b
            System.out.println("第"+n+"个盘"+a+"->"+c);
            hanoi(n-1,b,a,c);//b上面的盘在借助a移动到c
        }

    }
}
