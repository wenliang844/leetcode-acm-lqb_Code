package ACM.每日一题leecode.day185;

public class day220_剑指OfferII069山峰数组的顶部 {
    public static void main(String[] args) {
        System.out.println(peakIndexInMountainArray(new int[]{0, 1, 0}));
        System.out.println(peakIndexInMountainArray(new int[]{1, 3, 5, 4, 2}));
        System.out.println(peakIndexInMountainArray(new int[]{1, 2, 3, 4, 5}));
        System.out.println(peakIndexInMountainArray(new int[]{5, 4, 3, 2, 1}));
    }

    //方法一:枚举:一趟遍历  100|92
    public static int peakIndexInMountainArray(int[] arr) {

        if (arr[0]>arr[1]){
            return 0;
        }
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                return i;
            }

        }
        return arr.length - 1;
    }

    //方法二:二分法
}
