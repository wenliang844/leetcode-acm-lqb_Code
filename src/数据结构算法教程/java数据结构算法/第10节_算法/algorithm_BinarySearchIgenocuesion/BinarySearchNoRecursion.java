package 数据结构算法教程.java数据结构算法.第10节_算法.algorithm_BinarySearchIgenocuesion;

public class BinarySearchNoRecursion {

    public static void main(String[] args) {
        //测试升序数组的查找
        int[] arr = {1,3,4,5,9,99};
        System.out.println(binarySearch(arr,3));
        System.out.println(binarySearch(arr,99));
        System.out.println(binarySearch(arr,55));
        System.out.println(binarySearch(arr,4));
    }

    //二分查找的非递归实现
    public static int binarySearch(int[] arr,int target){
        /***
         * arr数组升序 target查找目标 return下标 or -1
         */
        int left = 0;
        int right = arr.length - 1;
        while (left <= right){//说明可以继续查找
            int mid = (left+right)/2;
            if (arr[mid] == target){
                return mid;
            }else if (arr[mid]>target){
                right = mid-1;//需要向左边查找
            }else {
                left = mid+1;
            }

        }

        return -1;//找不到
    }
}
