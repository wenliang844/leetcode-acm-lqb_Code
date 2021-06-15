package 算法algo.马士兵左程云_排序算法.牛客第三期进阶.NK01_算法;

import java.util.Map;

public class code5_lee564寻找最近的回文数 {

    /***
     给定一个整数 n ，你需要找到与它最近的回文数（不包括自身）。
     “最近的”定义为两个整数差的绝对值最小。
     */

    /***
     1.找比他小的数是回文数  199 191  202
     2.找比他大的数是回文数
     假设
     */
    //判断回文
    public static boolean isPalindrome(long n) {
        if (n < 0) {
            return false;
        }
        int help = 1;
        while (n / help >= 10) { //n=12321
            help *= 10; //将help调整到10000
        }
        while (n != 0) {
            //System.out.println(n/help +"//"+help+"/////"+ n% 10);
            //System.out.println("这是N="+n);
            if (n / help != n % 10) {
                return false;
            }
            n = (n % help) / 10;//n变成2321 --> 232         32->3
            help /= 100;//从10000到 100
        }
        return true;
    }

    //方法一:暴力解法 找一个小的 一个比n大的回文数
    //超时163 / 212 个通过测试用例  "807045053224792883"
    public static String nearestPalindromic1(String n) {
        long l = Long.parseLong(n);
        long i;
        for (i = l + 1; ; i++) {
            //System.out.println(i);
            if (isPalindrome(i)) {
                break;
            }
        }

        long j;
        for (j = l - 1; ; j--) {
            //System.out.println(j);
            if (isPalindrome(j)) {
                break;
            }
        }

        long res;
        if ((i - l) >= (l - j)) {
            res = j;
        } else {
            res = i;
        }
        return String.valueOf(res);
    }

    /***
     java 18ms。 算投机取巧吗？

     可以证明以下结论： 如果n 的前半部分是整数N，那么它的解一定是 以下三者之一：

     N-1 和 N-1的回文组成的数字。
     N 和 N的回文组成的数字
     N+1 和 N+1 的回文组成的数字
     利用这个结论生成3个解，取最近 且不为n就行。
     例 1230XXX的解 是 1230321, 1229221, 1231321 中的一个。
     过程中处理下奇偶数长度，N是9999 N是10000等等特殊值， 自由发挥就好了。


     */

    //方法二:前半部分进行不操作 和加1操作; 两个数进行比较 19999 -> 199 200 -> 19991 20002
    public static String nearestPalindromic2(String n) {

        if (n.equals("10") || n.equals("11")) {
            return "9";//
        }

        //是10 100 1000的情况直接输出-1
       /* if (n.replaceAll("","0").equals("1")){
            System.out.println("这是一个10 100 1000的数");
        }*/

        int len = n.length();
        /*if (len<=1){
            return String.valueOf(Long.parseLong(n)-1);
        }*/
        Long nn = Long.parseLong(n);
        if (nn <= 10) {
            return String.valueOf(Long.parseLong(n) - 1);
        }
        if (nn.equals("11")) {
            return String.valueOf("9");
        }
        String a = "";
        for (int i = 1; i < len; i++) {
            a += "0";
        }
        if (n.substring(1, len).equals(a)) {//10的幂 -1
            return String.valueOf(Long.parseLong(n) - 1);
        }
        String b = "";
        for (int i = 0; i < len; i++) {
            b += "9";
        }
        if (n.equals(b)) {//多个9  +2
            return String.valueOf(Long.parseLong(n) + 2);
        }

        String sMin = len % 2 == 0 ? n.substring(0, n.length() / 2) : n.substring(0, (n.length() / 2) + 1);
        String other = n.substring(n.length() / 2, len);
        System.out.println(sMin);
        String sMax = String.valueOf(Long.parseLong(sMin) + 1);
        System.out.println(sMax);
        //如果sMin 和另一半相等,那么sMin也需要-1
        other = String.valueOf(new StringBuilder(other).reverse());
        System.out.println(other);
        if (sMin.equals(other)) {
            sMin = String.valueOf(Long.parseLong(sMin) - 1);
        }
        System.out.println("--" + sMin);

        StringBuilder min = null;
        StringBuilder max = null;
        if (sMin.length() % 2 == 0) {
            min = new StringBuilder(sMin).reverse();
            // max = new StringBuilder(sMax).reverse();
        } else {
            min = new StringBuilder(sMin.substring(0, sMin.length() - 1)).reverse();
            //max = new StringBuilder(sMax.substring(0, sMax.length() - 1)).reverse();
        }
        if (sMax.length() % 2 == 0) {
            //min = new StringBuilder(sMin).reverse();
            max = new StringBuilder(sMax).reverse();
        } else {
            //min = new StringBuilder(sMin.substring(0, sMin.length() - 1)).reverse();
            max = new StringBuilder(sMax.substring(0, sMax.length() - 1)).reverse();
        }
        System.out.println(min.toString() + "-" + max.toString());
        Long trueMin = Long.parseLong(sMin + min);
        Long trueMax = Long.parseLong(sMax + max);
        System.out.println(trueMin + "---" + trueMax);

        String result;
        if (trueMax - nn >= nn - trueMin) {
            return String.valueOf(trueMin);
        } else {
            return String.valueOf(trueMax);
        }

        //向下搜索10次


    }

    public static String nearestPalindromic3(String n) {

        if (n.equals("10") || n.equals("11")) {
            return "9";//
        }

        int len = n.length();

        Long nn = Long.parseLong(n);
        if (nn <= 10) {
            return String.valueOf(Long.parseLong(n) - 1);
        }
        if (nn.equals("11")) {
            return String.valueOf("9");
        }

        String a = "";
        for (int i = 1; i < len; i++) {
            a += "0";
        }
        if (n.substring(1, len).equals(a)) {//10的幂 -1
            return String.valueOf(Long.parseLong(n) - 1);
        }
        String b = "";
        for (int i = 0; i < len; i++) {
            b += "9";
        }
        if (n.equals(b)) {//多个9  +2
            return String.valueOf(Long.parseLong(n) + 2);
        }


        //取a a+1 a-1 构建三个解 长度奇数给a多分点
        String sMed;
        String sMax;
        String sMin;
        if (len % 2 == 0) {
            sMed = n.substring(0, len / 2);
        } else {
            sMed = n.substring(0, len / 2 + 1);
        }
        sMax = String.valueOf(Long.parseLong(sMed) + 1);
        sMin = String.valueOf(Long.parseLong(sMed) - 1);
        //System.out.println(sMin + "-" + sMed + "-" + sMax);

        //构建回文数;注意n长度为奇数的时候左边的最后一个字符不能复制过去。  0-len/2 个数过去
        /*if (sMin.length() % 2 == 0) {
            sMin = sMin + String.valueOf(new StringBuilder(sMin).reverse());
        } else {
            sMin = sMin + String.valueOf(new StringBuilder(sMin.substring(0, sMin.length() - 1)).reverse());
        }
        if (sMed.length() % 2 == 0) {
            sMed = sMed + String.valueOf(new StringBuilder(sMed).reverse());
        } else {
            sMed = sMed + String.valueOf(new StringBuilder(sMed.substring(0, sMed.length() - 1)).reverse());
        }
        if (sMax.length() % 2 == 0) {
            sMax = sMax + String.valueOf(new StringBuilder(sMax).reverse());
        } else {
            sMax = sMax + String.valueOf(new StringBuilder(sMax.substring(0, sMax.length() - 1)).reverse());
        }*/

            sMin = sMin + String.valueOf(new StringBuilder(sMin.substring(0, len/2)).reverse());
            sMed = sMed + String.valueOf(new StringBuilder(sMed.substring(0, len/2)).reverse());
            sMax = sMax + String.valueOf(new StringBuilder(sMax.substring(0, len/2)).reverse());

        //System.out.println(sMin + "-" + sMed + "-" + sMax);

        //找出最近,且不等于n的那个
        Long res1,res2;
        Long min = Long.parseLong(sMin);
        Long med = Long.parseLong(sMed);
        Long max = Long.parseLong(sMax);
        //System.out.println(min + "-" + med + "-" + max);
        if (nn - min <= max -nn){
            res1 = min;
        }else {
            res1 = max;
        }
        //System.out.println(res1);

        //System.out.println(Math.abs(med - nn));
        //System.out.println(Math.abs(res1-nn));

        /*if ((!sMed.equals(n)) && ((Math.abs(med - nn) < Math.abs(res1-nn)))){
            //System.out.println("执行了med"+med);
            res2 = med;
        }else if ((!sMed.equals(n)) && ((Math.abs(med - nn) > Math.abs(res1-nn)))){
            //System.out.println("");
            res2 = res1;
        }else {
            res2 = Math.min(med,res1);
        }*/

        if (sMed.equals(n)){
            res2 = res1;
        }else {
            System.out.println("执行了");

            if (((Math.abs(med - nn) < Math.abs(res1-nn)))){
                //System.out.println("执行了med"+med);
                res2 = med;
            }else if (((Math.abs(med - nn) > Math.abs(res1-nn)))){
                //System.out.println("");
                res2 = res1;
            }else {
                res2 = Math.min(med,res1);
            }
        }
        //System.out.println(res1+"-"+res2+"==nn=="+nn);



        return String.valueOf(res2);


       /* String sMin = len % 2 == 0 ? n.substring(0, n.length() / 2) : n.substring(0, (n.length() / 2) + 1);
        String other = n.substring(n.length() / 2, len);
        System.out.println(sMin);
        String sMax = String.valueOf(Long.parseLong(sMin) + 1);
        System.out.println(sMax);
        //如果sMin 和另一半相等,那么sMin也需要-1
        other = String.valueOf(new StringBuilder(other).reverse());
        System.out.println(other);
        if (sMin.equals(other)) {
            sMin = String.valueOf(Long.parseLong(sMin) - 1);
        }
        System.out.println("--" + sMin);

        StringBuilder min = null;
        StringBuilder max = null;
        if (sMin.length() % 2 == 0) {
            min = new StringBuilder(sMin).reverse();
           // max = new StringBuilder(sMax).reverse();
        } else {
            min = new StringBuilder(sMin.substring(0, sMin.length() - 1)).reverse();
            //max = new StringBuilder(sMax.substring(0, sMax.length() - 1)).reverse();
        }
        if (sMax.length() % 2 == 0) {
            //min = new StringBuilder(sMin).reverse();
            max = new StringBuilder(sMax).reverse();
        } else {
            //min = new StringBuilder(sMin.substring(0, sMin.length() - 1)).reverse();
            max = new StringBuilder(sMax.substring(0, sMax.length() - 1)).reverse();
        }
        System.out.println(min.toString() + "-" + max.toString());
        Long trueMin = Long.parseLong(sMin + min);
        Long trueMax = Long.parseLong(sMax + max);
        System.out.println(trueMin + "---" + trueMax);

        String result;
        if (trueMax - nn >= nn - trueMin) {
            return String.valueOf(trueMin);
        } else {
            return String.valueOf(trueMax);
        }*/

        //向下搜索10次


        //return null;
    }


    public static void main(String[] args) {
        /*System.out.println(nearestPalindromic2("199"));
        System.out.println(nearestPalindromic2("19999"));
        System.out.println(nearestPalindromic2("12354"));*/
        /*System.out.println(nearestPalindromic2("88"));//0
        System.out.println(nearestPalindromic2("888"));//0
        System.out.println(nearestPalindromic2("12345"));//0
        System.out.println(nearestPalindromic2("1234"));//0*/


        //System.out.println(nearestPalindromic3("10001"));//0
        //System.out.println(nearestPalindromic3("807045053224792883"));
        //System.out.println(nearestPalindromic3("1837722381"));
        System.out.println(nearestPalindromic3("1805170081"));
        System.out.println(nearestPalindromic3("11011"));
        //System.out.println(nearestPalindromic2("11911"));//0
        /*System.out.println(nearestPalindromic2("99"));//0
        System.out.println(nearestPalindromic2("999"));//0
        System.out.println(nearestPalindromic2("9999"));//0
        System.out.println(nearestPalindromic2("10"));//0
        System.out.println(nearestPalindromic2("100"));//0
        System.out.println(nearestPalindromic2("1000"));//0
        System.out.println(nearestPalindromic2("10000"));//0
        System.out.println(nearestPalindromic2("11000"));//0
        System.out.println(nearestPalindromic2("11100"));//0
        System.out.println(nearestPalindromic2("1"));//0
        System.out.println(nearestPalindromic2("11"));//0
        System.out.println(nearestPalindromic2("111"));//0
        System.out.println(nearestPalindromic2("1111"));//0
        System.out.println(nearestPalindromic2("11111"));//0
        System.out.println(nearestPalindromic2("12"));//0
        System.out.println(nearestPalindromic2("19"));//0
        System.out.println(nearestPalindromic2("17"));//0*/
      /*  System.out.println(nearestPalindromic2("1341"));
        System.out.println(nearestPalindromic2("807045053224792883"));
        System.out.println(nearestPalindromic2("1357"));//1331  1441
        System.out.println(nearestPalindromic2("1987"));//1331  1441
        System.out.println(nearestPalindromic2("9997"));//1331  1441*/
    }
}
