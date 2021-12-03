package ACM.每日一题leecode.day185;

public class day200_600不含连续1的非负整数 {
    //参考网络的判定: deffoo2(n):return (n & n<<1) > 0
    public static void main(String[] args) {
        System.out.println(findIntegers(0));
        System.out.println(findIntegers(1));
        System.out.println(findIntegers(2));
        System.out.println("---");
        System.out.println(findIntegers(3));
        System.out.println(findIntegers(4));
        System.out.println(findIntegers(5));
        System.out.println("---");
        System.out.println(findIntegers(6));
        System.out.println("---");
        System.out.println(findIntegers(7));
        System.out.println(findIntegers(8));
        System.out.println(findIntegers(9));
        System.out.println(findIntegers(10));
        System.out.println("---");
        System.out.println(findIntegers(11));
        System.out.println(findIntegers(12));
        System.out.println(findIntegers(13));
        System.out.println(findIntegers(14));
        System.out.println(findIntegers(15));
        System.out.println(findIntegers(16));
        System.out.println("---");
        System.out.println(findIntegers(50));
        System.out.println(findIntegers(500));
        System.out.println(findIntegers(5000));
        System.out.println(findIntegers(50000));
        System.out.println(findIntegers(80982165));
    }

    public static int findIntegers(int n) {
        int count = 0;
        for (int i = 0; i <= n; i++) {
            if ((i & i << 1) > 0) {
                count++;
            }
        }

        return count;
    }


    //力扣官方
    public static int findIntegers2(int n) {
        int[] dp = new int[31];
        dp[0] = dp[1] = 1;
        for (int i = 2; i < 31; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int pre = 0, res = 0;
        for (int i = 29; i >= 0; --i) {
            int val = 1 << i;
            if ((n & val) != 0) {
                res += dp[i + 1];
                if (pre == 1) {
                    break;
                }
                pre = 1;
            } else {
                pre = 0;
            }

            if (i == 0) {
                ++res;
            }
        }

        return res;
    }


}
