package ACM.其他的算法比赛.笔试.腾讯音乐;

import java.util.Arrays;
import java.util.Scanner;

public class code1狡猾的雇主 {

    public static void main(String[] args) {
        //求数组中最小无重复的数字
        /***
         7
         1 1 4 5 1 4 5
         */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int array[] = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        //处理

        //升序排序
        Arrays.sort(array);
       //System.out.println(Arrays.toString(array));

        //无重复则返回
        //双指针:相等则一直跳,不相等则判断是否相邻
        int i=0;
        int j=1;
        while (j<array.length){
            if (array[i]==array[j]){
                j++;
            }else {
                if (j-i==1){
                    break;
                }else {
                    i=j;
                    j=i+1;
                }
            }
        }
        System.out.println("i=="+i);
        System.out.println("j=="+j);

        if (i+1>=array.length || array[i]!=array[i+1]){
            System.out.println(array[i]);
        }else {
            System.out.println(-1);
        }

    }
}
