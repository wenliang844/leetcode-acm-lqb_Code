package ACM.每日一题leecode.day100;

public class day111_633平方数之和 {
    /***
     给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
     */

    public static void main(String[] args) {
        System.out.println(judgeSquareSum2(5));
        System.out.println(judgeSquareSum2(3));
        System.out.println(judgeSquareSum2(4));
        System.out.println(judgeSquareSum2(2));
    }

    //方法一:暴力破解
    public static boolean judgeSquareSum(int c) {
        int limit= (int) Math.sqrt(c);
        for (int i = 0; i <=limit ; i++) {
            for (int j = 0; j <=limit; j++) {
                if (i*i+j*j==c){
                    return true;
                }
            }
        }
        return false;
    }
    //方法二:双指针
    public static boolean judgeSquareSum2(int c) {
        int right= (int) Math.sqrt(c);
        int left = 0;
        while (left<=right){
            int ans = right*right+left*left;
            if (ans==c){
                return true;
            }else if (ans>c){
                right--;
            }else {
                left++;
            }
        }
        return false;
    }


}
