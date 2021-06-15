package ACM.leecode周赛.第243场周赛;

public class lee2_5773插入后的最大值 {
    /****
     给你一个非常大的整数 n 和一个整数数字 x ，大整数 n 用一个字符串表示。n 中每一位数字和数字 x 都处于闭区间 [1, 9] 中，且 n 可能表示一个 负数 。
     你打算通过在 n 的十进制表示的任意位置插入 x 来 最大化 n 的 数值 ​​​​​​。但 不能 在负号的左边插入 x 。
     例如，如果 n = 73 且 x = 6 ，那么最佳方案是将 6 插入 7 和 3 之间，使 n = 763 。
     如果 n = -55 且 x = 2 ，那么最佳方案是将 2 插在第一个 5 之前，使 n = -255 。
     返回插入操作后，用字符串表示的 n 的最大值。
     示例 1：
     输入：n = "99", x = 9
     输出："999"
     解释：不管在哪里插入 9 ，结果都是相同的。
     */
    public static void main(String[] args) {
        System.out.println(maxValue("99", 9));//999
        System.out.println(maxValue("-13", 2));//-123
        System.out.println(maxValue("-13", 5));//-135
        System.out.println("--->"+maxValue("-132",3));//-1323

        System.out.println(maxValue("131", 2));//2131
        System.out.println(maxValue("535", 1));//2131
    }

    //正数:从头开始,找到第一个大于等于的 放在前面;负数相反
    public static String maxValue(String n, int x) {
        if (n.charAt(0)=='-'){
            for (int i = 0; i < n.length(); i++) {
                int tempnum = n.charAt(i)-'0';
                if (x<tempnum){
                    return n.substring(0,i)+x+n.substring(i,n.length());
                }
            }

        }else {

            for (int i = 0; i < n.length(); i++) {
                int tempnum = n.charAt(i)-'0';
                if (x>tempnum){
                    return n.substring(0,i)+x+n.substring(i,n.length());
                }
            }
        }
        return n+x;
    }
}
