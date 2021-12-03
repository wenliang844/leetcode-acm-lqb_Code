package ACM.每日一题leecode.day185;

import java.util.Arrays;

public class day194_面试题1714最小K个数 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(smallestK(new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 4)));
    }

    //方法一:直接sort方法 70/46
    public static int[] smallestK(int[] arr, int k) {
        //System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        //System.out.println(Arrays.toString(arr));
        int[] res = new int[k];
        System.arraycopy(arr,0,res,0,k);
        return res;
    }

    //方法二,使用快排, 当左右直接小于等于k的时候就可以直接返回了
}
