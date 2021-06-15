package 算法algo.马士兵左程云_排序算法.sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 8, 1, 7, 9, 4, 2};
//        BubbleSoetMethod(arr);
        bubblingSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    static void BubbleSoetMethod(int[] arr){

        for (int i = arr.length-1; i >=1;i--) {
            for (int j = 0; j < i;j++) {
                if (arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }

    }
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



    static  int[] bubblingSort(int[] nums){

        for (int i = nums.length-1; i >=1;i--) {
            for (int j = 0; j < i;j++) {
                if (nums[j]>nums[j+1]){
                    swap(nums,j,j+1);
                }
            }
        }

        return nums;
    }
}


/*
class Solution {
    public int[] bubblingSort( int[] nums) {
        for (int i = nums.length-1; i >=1;i--) {
            for (int j = 0; j < i;j++) {
                if (nums[j]>nums[j+1]){
                    swap(nums,j,j+1);
                }
            }
        }

        return nums;
    }
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

 */