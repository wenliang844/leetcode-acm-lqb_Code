package ACM.tag刷题.算法.位运算;

//两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
//给出两个整数 x 和 y，计算它们之间的汉明距离。
public class binnary_461汉明距离 {

    //方法1:位运算  异或得出不同的位置为1, 再统计这个数字的1的个数
    public static int hammingDistance(int x, int y) {

       int a = x ^ y;
        //System.out.println(a);
        String s = Integer.toBinaryString(a);
        //System.out.println(s);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1'){
                count++;
            }
        }


        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1,4));//2

    }

}
