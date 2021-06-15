package 算法algo.马士兵左程云_排序算法.牛客第三期进阶.NK01_算法;

public class code11_与最小值的差值界限num下最大 {
    /***
     6. 给定arr num整数 返回右多少子数组满足:
     max(arr[i…j] - min(arr[i…j]))<=num   有子数组:用单调栈,滑动窗口  窗口中维护最小值,最大值
     max(arr[i……j])表示子数组中的最大值
     min(arr[i………j])表示子数组最小值
     如果数组长度N,实现复杂度为O(N)的算法

     [0 0] [0 1] [0 2] [0 3] [0 4]
     [1 1] [1 2] [1 3] [1 4]
     最大值最小值的窗口怎样用? 子数组是连续的
     范围缩小只能让最大值边小,最小值变大 子数组达标,内部子数组都达标;

     如果一个数不达标,子树组都不达标,R位置扩, 每次扩一下检查一下;
     窗口最大,最小 O(n)
     */

    //方法一:暴力破解:1,2,3,4,5,6,7  num=4中最小值是1 差值是0 1 2 3 4 5 6    差值<=num的是4 return4
    public static int getMaxNumOfSubNums(int[] arr, int num) {
        int min = 0;//找到最小值
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
        }

        int maxNum = 0;//找到一个小于等于num中的最大值
        for (int i = 0; i < arr.length; i++) {
            int sub = arr[i] - min;
            if (sub <=num){
                maxNum = Math.max(maxNum,sub);
            }
        }

        return maxNum;
    }

    //要求:O(N)的解法:

    public static void main(String[] args) {
        System.out.println(getMaxNumOfSubNums(new int[]{1, 2, 3, 4, 5, 6, 7}, 4));//4

    }
}
