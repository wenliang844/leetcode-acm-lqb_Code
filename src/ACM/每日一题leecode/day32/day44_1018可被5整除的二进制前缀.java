package ACM.每日一题leecode.day32;

import java.util.ArrayList;
import java.util.List;

/***
 给定由若干 0 和 1 组成的数组 A。我们定义 N_i：从 A[0] 到 A[i] 的第 i 个子数组被解释为一个二进制数（从最高有效位到最低有效位）。

 返回布尔值列表 answer，只有当 N_i 可以被 5 整除时，答案 answer[i] 为 true，否则为 false。

  

 示例 1：

 输入：[0,1,1]
 输出：[true,false,false]
 解释：
 输入数字为 0, 01, 011；也就是十进制中的 0, 1, 3 。只有第一个数可以被 5 整除，因此 answer[0] 为真。
 示例 2：

 输入：[1,1,1]
 输出：[false,false,false]
 示例 3：

 输入：[0,1,1,1,1,1]
 输出：[true,false,false,false,true,false]
 示例 4：

 输入：[1,1,1,0,1]
 输出：[false,false,false,false,false]
*/
public class day44_1018可被5整除的二进制前缀 {
    public static void main(String[] args) {
        //System.out.println("这是答案=="+prefixesDivBy5(new int[]{0, 1, 1}));
        //System.out.println("这是答案=="+prefixesDivBy5(new int[]{1,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,1,0,0,0,0,1,1,0,1,0,0,0,1}));
        //System.out.println("这是答案=="+prefixesDivBy5(new int[]{1,0,0,1,0,1,0,0,1,0,1,1}));
        System.out.println("这是结果"+prefixesDivBy5_2(new int[]{0,1,1}));


    }

    //暴力解法
    public static List<Boolean> prefixesDivBy5(int[] A) {

        //乘以2对5取余
        List<Boolean> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < A.length; i++) {
            sb.append(A[i]);
            //int tempNum = Integer.parseUnsignedInt(sb.toString(), 2);
            //System.out.println(tempNum);
//            System.out.println(sb.toString().equals("0"));
            if (sb.toString().equals("0") || sb.toString().equals("101")){
                list.add(true);
            }else if (sb.length()>=4 && (sb.substring(sb.length()-3,sb.length()).equals("101") || sb.substring(sb.length()-4,sb.length()).equals("101"))){
                list.add(true);
            }else {
                list.add(false);
            }

            /*if (sb.length()>=4){
                System.out.println(sb.substring(sb.length()-3,sb.length()));
                System.out.println(sb.substring(sb.length()-4,sb.length()));
            }*/


           /* if (tempNum%5==0){
                list.add(true);
            }else {
                list.add(false);
            }*/
        }

        return list;
    }

    //力扣移位解法
    public static List<Boolean> prefixesDivBy5_2(int[] A) {
        List<Boolean> list = new ArrayList<>();
        int num=0;
        for (int i = 0; i < A.length; i++) {
            num = num<<1;
            num+=A[i];
            num = num%10;
            if (num%5==0 || num%10==0){
                list.add(true);
            }else {
                list.add(false);
            }
        }

        return list;
    }
}
