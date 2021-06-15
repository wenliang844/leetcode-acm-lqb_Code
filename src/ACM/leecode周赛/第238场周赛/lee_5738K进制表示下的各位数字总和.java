package ACM.leecode周赛.第238场周赛;

public class lee_5738K进制表示下的各位数字总和 {
    /***
     给你一个整数 n（10 进制）和一个基数 k ，请你将 n 从 10 进制表示转换为 k 进制表示，计算并返回转换后各位数字的 总和 。
     转换后，各位数字应当视作是 10 进制数字，且它们的总和也应当按 10 进制表示返回。
     示例 1：
     输入：n = 34, k = 6
     输出：9
     解释：34 (10 进制) 在 6 进制下表示为 54 。5 + 4 = 9 。
     */
    public static void main(String[] args) {
        System.out.println(sumBase(34, 6));
        System.out.println(sumBase(10, 10));
    }

    //方法一;辗转相除法 100/100
    public static int sumBase(int n, int k) {

        if (n==10){

        }
        int sum = 0;
        while (n / k != 0) {
            sum += n % k;
            n = n / k;
        }
        System.out.println("sum="+sum);
        System.out.println("n="+n);

        return sum + n;
    }
}
