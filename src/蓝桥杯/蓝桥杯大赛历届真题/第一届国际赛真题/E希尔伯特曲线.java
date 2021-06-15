package 蓝桥杯.蓝桥杯大赛历届真题.第一届国际赛真题;

public class E希尔伯特曲线 {
    /**
     * 给定n p,问第阶个p个希尔伯特曲线是哪个坐标
     * 发现规律:每一个阶层都是由上一个阶层*4个构成
     * 第一部分1-4是上一个阶层的反转
     * 第二部分5-8是上一个阶层的y+n
     * 第三个部分是上一个阶层的x+n y+n
     * 第四个部分是上一个阶层的前后两部分反转再x+n
     * <p>
     * 采用递归调用的形式,自顶向下,再用最下面的结果反推到上面
     */
    public static String dfs(int n, int p) {
        if (n == 1) {
            switch (p) {
                case 1:
                    return "00";
                case 2:
                    return "01";
                case 3:
                    return "11";
                case 4:
                    return "10";
            }
        }

        //n>1的情况,计算出p%n  p/n 进行分类讨论
        int pow = (int) (Math.pow(4, n - 1));//pow是上个部分的个数,也就是这个部分的1/4
        int num1 = (p + pow - 1) / pow;//num1代表是第几部分,对应上一个阶段对应哪些操作
        int num2 = p % pow;//num2对应是上一个阶段的第几个坐标操作

        System.out.println("这是num1-num2=" + num1 + "--" + num2);
        switch (num1) {
            case 1:
                //对应上一个阶段n-1的反转
                String s1 = dfs(n - 1, num2 == 0 ? pow : num2);
                return s1.charAt(1) + s1.charAt(0) + "";
            case 2:
                //对应上一个阶段的y+n
                String s2 = dfs(n - 1, num2 == 0 ? pow : num2);
                char ch = (char) (s2.charAt(1) + n);
                return s2.charAt(0) + "" + ch;
            case 3:
                //对应上一个阶层的x+n y+n
                String s3 = dfs(n - 1, num2 == 0 ? pow : num2);
                char ch1 = (char) (s3.charAt(0) + n);
                char ch2 = (char) (s3.charAt(1) + n);
                return ch1 + "" + ch2;
            case 4:
                String s4 = "";
                //分类讨论:p是1 2 3 0分别对应1 2 3 4
                if (num2 == 3) {//p==1||p==2||p==0
                    //需要p-2  ----------1
                    s4 = dfs(n - 1, num2 - 2);
                } else/* if (p == 3)*/ {
                    //对应上一个阶段的1 2,需要对p+2------3 4
                    s4 = dfs(n - 1, num2 + 2);
                }/*else {
                    //p==0,需要p+2 --------2

                }*/

                //统一处理:反转再x+2
                //相当于y+2  再反转
                char ch4 = (char) (s4.charAt(1) + n);
                return ch4 + "" + s4.charAt(0);
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println(dfs(2, 5));
        System.out.println(dfs(2, 6));
        System.out.println(dfs(2, 7));
        System.out.println(dfs(2, 8));
        System.out.println("---case2----");
        System.out.println(dfs(2, 9));
        System.out.println(dfs(2, 10));
        System.out.println(dfs(2, 11));
        System.out.println(dfs(2, 12));
        System.out.println(dfs(2, 13));
        System.out.println(dfs(2, 14));
        System.out.println(dfs(2, 15));
        System.out.println(dfs(2, 16));
    }

}