package ACM.ACM_20201116江西师大校选拔赛.ACM;


/**
 * 链接：https://ac.nowcoder.com/acm/contest/5697/B
 * 来源：牛客网
 * <p>
 * 题目描述
 * xby也学习算法与数据结构课程，老师讲了好多种排序算法，上课的时候老师提了一个小问题,给定一个长度为nn的序列a_{1},a_{2},a_{3},...,a_{n}a
 * 1
 * ​
 * ,a
 * 2
 * ​
 * ,a
 * 3
 * ​
 * ,...,a
 * n
 * ​
 * ,让大家用冒泡排序算法进行排序，这个简单的问题立马被解决了，老师见状又提了一个问题，问该序列利用冒泡排序，外层循环次数是多少？  ---冒泡排序算法 使用 题设伪代码
 * <p>
 * // 伪代码
 * flag= false
 * while ( !flag ):
 * flag= true
 * for i = 0 to N-2:
 * if A[i+1] < A[i]:
 * swap A[i], A[i+1]
 * flag= false
 * //
 * 输入描述:
 * 第一行一个整数nn，第二行nn个整数表示序列a_{1},a_{2},a_{3},...,a_{n}a
 * 1
 * ​
 * ,a
 * 2
 * ​
 * ,a
 * 3
 * ​
 * ,...,a
 * n
 * ​
 * 。
 * 输出描述:
 * 一行一个整数，表示答案。
 * 示例1
 * 输入
 * 复制
 * 5
 * 1 5 3 8 2
 * 输出
 * 复制
 * 4
 */


import java.util.Scanner;
public class Main2_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int counts = 0;
        int count = sc.nextInt();
        int a[] = new int[count];
        for (int i = 0; i < count; i++) {
            a[i] = sc.nextInt();
        }
        int temp;
        boolean flag = false;
        while (!flag) {
            flag = true;
            for (int i = 0; i <= count - 2; i++) {
                if (a[i + 1] < a[i]) {
                    temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                    flag = false;
                }
            }
            counts++;
        }
        System.out.println(counts);
    }
}
