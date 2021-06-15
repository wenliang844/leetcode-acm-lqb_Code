package ACM.leecode周赛.lee42;

/****
 5623. 修改后的最大二进制字符串 显示英文描述
 通过的用户数334
 尝试过的用户数545
 用户总通过次数337
 用户总提交次数1231
 题目难度Medium
 给你一个二进制字符串 binary ，它仅有 0 或者 1 组成。你可以使用下面的操作任意次对它进行修改：

 操作 1 ：如果二进制串包含子字符串 "00" ，你可以用 "10" 将其替换。
 比方说， "00010" -> "10010"
 操作 2 ：如果二进制串包含子字符串 "10" ，你可以用 "01" 将其替换。
 比方说， "00010" -> "00001"
 请你返回执行上述操作任意次以后能得到的 最大二进制字符串 。如果二进制字符串 x 对应的十进制数字大于二进制字符串 y 对应的十进制数字，那么我们称二进制字符串 x 大于二进制字符串 y 。



 示例 1：

 输入：binary = "000110"
 输出："111011"
 解释：一个可行的转换为：
 "000110" -> "000101"
 "000101" -> "100101"
 "100101" -> "110101"
 "110101" -> "110011"
 "110011" -> "111011"
 示例 2：

 输入：binary = "01"
 输出："01"
 解释："01" 没办法进行任何转换。
 */
public class lee_5623修改后的最大二进制字符串 {

    public static void main(String[] args) {
        System.out.println(maximumBinaryString("000110"));
    }

    //超时
    public static String maximumBinaryString(String binary) {

        /***遍历 贪心
         思路:分两种情况:
         1.00   直接变10
         2.0110  00中间加了1的   直接变成10111
         */

        int pro;
        int rear;
        char[] chars = binary.toCharArray();
        for (int i = 0; i < binary.length() - 1; i++) {
            if (chars[i] == '0' && chars[i + 1] == '0') {
                chars[i] = '1';
                chars[i + 1] = '0';
            }

            //2.0110  00中间加了1的   直接变成10111
            if (chars[i] == '0' && chars[i + 1] == '1') {
                for (int j = i + 2; j < chars.length; j++) {
                    if (chars[j] == '0') {
                        chars[i] = '1';
                        chars[i + 1] = '0';
                        chars[j] = '1';
                        break;
                    }
                }
            }
        }

        //System.out.println(chars.toString());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    public static String maximumBinaryString2(String binary) {

        /***遍历 贪心
         思路:分两种情况:
         1.00   直接变10   连续的0直接变成0000 1110
         2.0110  00中间加了1的   直接变成10111
         */

        int pro;
        int rear;
        char[] chars = binary.toCharArray();
        for (int i = 0; i < binary.length() - 1; i++) {
            //1.00   直接变10   连续的0直接变成0000 1110
            if (chars[i] == '0' && chars[i + 1] == '0') {
                chars[i] = '1';
                chars[i + 1] = '1';
                for (int j = i + 2; j < chars.length; j++) {
                    if (chars[j] == '0') {
                        chars[j] = '1';
                    } else {
                        chars[j - 1] = '0';
                        break;
                    }


                }
            }


            //2.0110  00中间加了1的   直接变成10111
            if (chars[i] == '0' && chars[i + 1] == '1') {
                for (int j = i + 2; j < chars.length; j++) {
                    if (chars[j] == '0') {
                        chars[i] = '1';
                        chars[i + 1] = '0';
                        chars[j] = '1';
                        break;
                    }
                }
            }
        }

        //System.out.println(chars.toString());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}


