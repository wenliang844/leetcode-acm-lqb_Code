package 算法algo.马士兵左程云_排序算法.sort;

import java.util.Arrays;
import java.util.Random;

public class DataChecker {
    static int[] generateRandomArray(){
        Random r = new Random();
        int[] arr = new int[10000];

        for (int i = 0; i < arr.length; i++) {
            arr[i]=r.nextInt(10000);
        }
        return arr;
    }

    static boolean check(){
        int[] arr = generateRandomArray();
        int[] arr2=new int[arr.length];
        System.arraycopy(arr,0,arr2,0,arr.length);

        Arrays.sort(arr);
        SelectionSort.sort(arr2);

        boolean same = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arr2[i]){
                same=false;
                break;
            }
        }
        System.out.println(same == true ? "right" : "wrong");
        return same;
    }

    public static void main(String[] args) {
        int count = 0;
        for (int i = 0; i < 1000; i++) {
            if (check()){
                count++;
            }
        }
        System.out.println(count);
    }

    //5 3 5 2 1     如何证明不稳定?
}
