package 数据结构算法教程.java数据结构算法.第1节_算法基本;

import java.util.ArrayList;
import java.util.List;

public class 引例_实现稀疏数组 {
    public static void main(String[] args) {
/*
如果是利用数组存储稀疏数组的话  就是先计数count   再进行创建一个count * 3的稀疏数组
 */

        int[][] nums = new int[11][11];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                nums[i][j] = 0;
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
        nums[2][3] = 1;
        nums[3][4] = 2;

        List<List<Integer>> lists = new ArrayList<List<Integer>>();

        System.out.println("---===压缩后===---");
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i][j]!=0){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(i);
                    list.add(j);
                    list.add(nums[i][j]);
                    lists.add(list);
                }
            }
        }

        System.out.println(lists);


        System.out.println("---稀疏数组的恢复算法---");
        System.out.println("---===恢复后的二维数组===---");
        int[][] newNums = new int[11][11];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                nums[i][j]=0;
            }
        }
        for (List<Integer> list : lists) {
            nums[list.get(0)][list.get(1)]=list.get(2);
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                System.out.print(nums[i][j]+" ");
            }
            System.out.println();
        }

    }
}
