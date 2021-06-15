package ACM.每日一题leecode.day141;

public class day155_852山脉数组的峰顶索引 {

    public static void main(String[] args) {
        System.out.println(peakIndexInMountainArray2(new int[]{0, 10, 5, 2}));//1
        System.out.println(peakIndexInMountainArray2(new int[]{24,69,100,99,79,78,67,36,26,19}));//2
        System.out.println(peakIndexInMountainArray2(new int[]{3,5,3,2,0}));//2
    }

    //方法一:暴力法 直接找最大
    public static int peakIndexInMountainArray(int[] arr) {
        int max = 0;
        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    //方法一:暴力法 直接一个数满足左右都小即可 16/91
    public static int peakIndexInMountainArray1(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                return i;
            }
        }
        return 0;
    }

    //方法二:二分法 logn  分情况,这个数左小右小则找到了 100/44
    public static int peakIndexInMountainArray2(int[] arr) {

        int left = 0;
        int right = arr.length-1;
        while (left<right){
            int mid = left + (right-left)/2;
            if (arr[mid] > arr[mid+1] && arr[mid]>arr[mid-1]){
                return mid;
            }else if (arr[mid] > arr[mid-1] && arr[mid]<arr[mid+1]){
                left = mid+1;
            }else {
                right = mid;//因为有可能会越界
            }
        }
        return right;
    }
}
