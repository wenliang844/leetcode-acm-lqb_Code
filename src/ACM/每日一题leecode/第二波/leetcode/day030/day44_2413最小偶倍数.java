package ACM.每日一题leecode.第二波.leetcode.day030;

/**
 * @author 陈文亮
 * @date 2023/4/21 14:50
 */
public class day44_2413最小偶倍数 {
    public static void main(String[] args) {

        System.out.println(smallestEvenMultiple(5));//8 6   = 1--2    6/2=3--0

    }

    public static int smallestEvenMultiple(int n) {
        return n*2/maxCommomDivisor(n,2);
    }


    public static int maxCommomDivisor(int max,int min) {

        if (max % min ==0){
            return min;
        }else {
            return maxCommomDivisor(min,max%min);
        }
    }
}
