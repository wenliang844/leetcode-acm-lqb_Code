package ACM.每日一题leecode.自刷;
/*
给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。

 

示例:

输入: 13
输出: 6
解释: 数字 1 出现在以下数字中: 1, 10, 11, 12, 13 。
 */

/**
 * 思路:遍历判断个位数是否等于1
 */
public class L233数字1的个数 {

    public static void main(String[] args) {
        System.out.println(countDigitOne4(13));
        //System.out.println(countDigitOne3(11111));
        //System.out.println(countDigitOne3(824883294));
        //System.out.println(countDigitOne3(3184191));
        //System.out.println(countDigitOne3(824883294));
    }

    public static int countDigitOne(int n) {//超出时间限制
        int count = 0;
        for (int j = 1; j <= n; j++) {
            int i=j;
            while (i >=1){
                if (i%10==1){
                    count++;
                }
                i=i/10;
            }
        }
            return count;
    }

    public static int countDigitOne2(int n) {//优化:22 - 30  他们的1出现的次数count的一样的
        int count = 0;
        int c = 0;
        for (int j = 1; j <= n; j++) {
            int i=j;
            while (i >=1){
                if (i%10==1){
                    c++;
                }
                i=i/10;
            }

            count += c;
            c=0;
        }
        return count;
    }

    public static int countDigitOne3(int n) {//优化:字符串法  直接数1的个数
        int count = 0;
        for (int j = 1; j <= n; j++) {
            String s = String.valueOf(j);
            //System.out.println(sb);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    count++;
                }
            }

        }
        return count;
    }

    public static int countDigitOne4(int n) {//优化:字符串法  直接数1的个数
        int num = n;
        long i = 1;
        int s = 0;
        while(num > 0)
        {
            if(num % 10 == 0) // 不包含1 -9
                s += (num / 10) * i; // 修正值是 0

            if(num % 10 == 1) // 包含 1 - 9的一部分
                s += (num / 10) * i + (n % i) + 1; // 修正值是(n % i) + 1

            if(num % 10 > 1) // 包含1 - 9
                s += (num / 10) * i + i; // i

            num = num / 10; // 比如109/10 = 10， 可以按10位的处理，因为i增量了10倍
            i = i * 10; // 每次1的个数是增加10倍
        }

        return s;
    }
}
