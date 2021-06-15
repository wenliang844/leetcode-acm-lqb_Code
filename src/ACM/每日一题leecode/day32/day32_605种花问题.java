package ACM.每日一题leecode.day32;

import java.util.Arrays;

public class day32_605种花问题 {

    /*
    假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。

    给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。

    示例 1:

    输入: flowerbed = [1,0,0,0,1], n = 1
    输出: True
    示例 2:

    输入: flowerbed = [1,0,0,0,1], n = 2
    输出: False
     */
    public static void main(String[] args) {
        /*int[] arr = new int[]{1, 0, 0, 0, 1};
        System.out.println("炸是结果=" + canPlaceFlowers(arr, 1));
        System.out.println("这是后面的花=" + Arrays.toString(arr));

        int[] arr1 = new int[]{1, 0, 0, 0, 1};
        System.out.println("炸是结果=" + canPlaceFlowers(arr1, 2));
        System.out.println("这是后面的花=" + Arrays.toString(arr1));

        int[] arr2 = new int[]{0, 0, 1, 0, 1};
        System.out.println("炸是结果=" + canPlaceFlowers(arr2, 1));
        System.out.println("这是后面的花=" + Arrays.toString(arr2));

        int[] arr3 = new int[]{1, 0, 0, 0, 1, 0, 0};
        System.out.println("炸是结果=" + canPlaceFlowers(arr3, 1));
        System.out.println("这是后面的花=" + Arrays.toString(arr3));*/

        int[] arr4 = new int[]{0};
        System.out.println("===" + canPlaceFlowers(arr4, 1));
        System.out.println("---" + Arrays.toString(arr4));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        /***
         思路：1*2+1 1颗树
         2*2+1 2颗树

         从左向右扫描.
         从i=1 到i=len-2
         如果i-1 i i+1都是0   就i=1种一棵树  然后n--
         if(n<=0) return true
         else return false
         */
        if (n==0){
            return true;
        }
        /*if (flowerbed.length < 2) {
            return false;
        }*/
        if (flowerbed.length==1 && flowerbed[0]==0){
            n--;
            flowerbed[0]=1;
        }
        if (flowerbed[0] == 0 && flowerbed[1] == 0) {
            flowerbed[0] = 1;
            n--;
        }

        if (flowerbed[flowerbed.length - 1] == 0 && flowerbed[flowerbed.length - 2] == 0) {
            flowerbed[flowerbed.length - 1] = 1;
            n--;
        }

        for (int i = 1; i <= flowerbed.length - 2; i++) {
            if (flowerbed[i - 1] == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                n--;
            }
        }
        if (n <= 0) {
            return true;
        } else {

            return false;
        }
    }

}
