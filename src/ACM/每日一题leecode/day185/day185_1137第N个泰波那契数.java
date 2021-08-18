package ACM.每日一题leecode.day185;

public class day185_1137第N个泰波那契数 {
    /***
     泰波那契序列 Tn 定义如下： 
     T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
     给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
     示例 1：
     输入：n = 4
     输出：4
     解释：
     T_3 = 0 + 1 + 1 = 2
     T_4 = 1 + 1 + 2 = 4
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(tribonacci2(3));
        System.out.println(tribonacci2(4));
    }

    //直接for循环 100/50
    public static int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        int n0 = 0;
        int n1 = 1;
        int n2 = 1;
        for (int i = 0; i <= n - 3; i++) {
            int temp = n2 + n1 + n0;
            n0 = n1;
            n1 = n2;
            n2 = temp;
        }

        return n2;
    }

    //直接for循环 100/50      ---100/92
    public static int tribonacci2(int n) {
        int[] res = new int[3];
        res[0] = 0;
        res[1] = 1;
        res[2] = 1;
        if(n < 3) {
            return res[n];
        }
        for (int i = 0; i <= n - 3; i++) {
            int temp = res[0] + res[1] + res[2];
            res[0] = res[1];
            res[1] = res[2];
            res[2] = temp;
        }

        return res[2];
    }
}
