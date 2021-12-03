package ACM.其他的算法比赛.笔试.阿里2;

import java.util.Scanner;

public class ali1_自然变化 {
    /**
     想法:
     1. 通过相加大于了目标值,然后相加的数和目标值的差需要从sum中减掉, 也就是将sub差值/2的值减掉 也就是这个值要是偶数除2后才是 整数
        如
        target=12
        1 2 3 4 5 =15    但是15-12=3 3/2=1.5 不合格
        1 2 3 4 5 6=21    21-12=9 不合格
        1 2 3 4 5 6 7=28   28-12=16 16/2=8 用2+6就可以凑到8 所以合格
     */
    //1 2 3 >凑到一个数
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Q = scanner.nextInt();
        while (Q-- >0){
            int sub = Math.abs(scanner.nextInt() - scanner.nextInt());
            int sum = 0;
            int count = 0;
            for (int i = 1;; i++) {
                sum+=i;
                count++;
                if (sum >= sub && ((sum-sub)%2==0)){ //通过了
                    System.out.println(count);
                    break;
                }
            }
        }

    }
}
