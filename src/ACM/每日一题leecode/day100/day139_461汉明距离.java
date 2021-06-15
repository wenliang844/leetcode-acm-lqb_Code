package ACM.每日一题leecode.day100;

public class day139_461汉明距离 {
    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
        // 001
        // 100
    }

    //1.暴力解法 8/43
    public static int hammingDistance(int x, int y) {
        //将两个数字的二进制表示出来,计算不同的个数,返回count
        int count = 0;
        String s1 = Integer.toBinaryString(x);
        String s2 = Integer.toBinaryString(y);

        //位数不足的补0
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 > len2) {
            //对2进行补o
            String temp = "";
            for (int i = 0; i < len1 - len2; i++) {
                temp += "0";
            }
            s2 = temp + s2;
        } else if (len1 < len2) {
            String temp = "";
            for (int i = 0; i < len2 - len1; i++) {
                temp += "0";
            }
            s1 = temp + s1;
        }

        System.out.println("s1==" + s1);
        System.out.println("s2==" + s2);

        for (int i = 0; i < s1.length(); i++) {

            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
        }

        return count;
    }

    //2.异或解法
    public static int hammingDistance2(int x, int y) {
        int s = x ^ y, ret = 0;
        while (s != 0) {
            ret += s & 1;
            s >>= 1;
        }
        return ret;
        //统计0的个数  或者统计%2==0的个数 或统计能不能^1==1

    }

    //3.内置工具法
    public static int hammingDistance3(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    //4
    public static int hammingDistance4(int x, int y) {
        int s = x ^ y, ret = 0;
        while (s != 0) {
            s &= s - 1;
            ret++;
        }
        return ret;
    }

}
