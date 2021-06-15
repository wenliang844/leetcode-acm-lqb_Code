package ACM.每日一题leecode.day100;

public class day130_1442形成两个异或相等数组的三元组数目 {
    /******
     给你一个整数数组 arr 。
     现需要从数组中取三个下标 i、j 和 k ，其中 (0 <= i < j <= k < arr.length) 。
     a 和 b 定义如下：
     a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
     b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
     注意：^ 表示 按位异或 操作。
     请返回能够令 a == b 成立的三元组 (i, j , k) 的数目。

     示例 1：
     输入：arr = [2,3,1,6,7]
     输出：4
     解释：满足题意的三元组分别是 (0,1,2), (0,2,2), (2,3,4) 以及 (2,4,4)
     */
    public static void main(String[] args) {
        System.out.println(countTriplets(new int[]{2, 3, 1, 6, 7}));
    }

    //方法一:暴力破解 三从循环  18//62
    public static int countTriplets(int[] arr) {
        int len = arr.length;
        int count = 0;
        for (int i = 0; i < len-1; i++) {
            int sum1 = arr[i];

            for (int j = i+1; j < len; j++) {
                int sum2 = 0;
                for (int k = j; k < len; k++) {
                    sum2^=arr[k];
                    if (sum1==sum2){
                        System.out.println(i+"--"+j+"--"+k);
                        count++;
                    }
                }

                sum1^=arr[j];
            }
        }
        return count;
    }
}
