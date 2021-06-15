package ACM.每日一题leecode.day01;

import java.util.ArrayList;
import java.util.List;

/*
在杨辉三角中，每个数是它左上方和右上方的数的和。

示例:

输入: 5
输出:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */
public class day07_118杨辉三角 {
    public static void main(String[] args) {
        System.out.println(generate(0));
        System.out.println(generate(1));
        System.out.println(generate(2));
        System.out.println(generate(3));
        System.out.println(generate(5));


        System.out.println(generate2(5));
    }

    //list法
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> listList = new ArrayList<List<Integer>>();
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        list1.add(1);

        list2.add(1);
        list2.add(1);
        if (numRows==0){
            return listList;
        }
        listList.add(list1);
        if (numRows == 1) {
            return listList;
        }

        for (int i = 2; i <= numRows; i++) {
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(1);
            for (int j = 1; j < i - 1; j++) {
                temp.add(list2.get(j) + list2.get(j - 1));
            }
            temp.add(1);
            listList.add(temp);
            list2.clear();
            for (Integer integer : temp) {
                list2.add(integer);
            }

        }

        return listList;
    }

    //数组法
    public static List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> listList = new ArrayList<List<Integer>>();
        int[][] nums = new int[numRows][numRows];
        nums[0][0]=1;
        nums[1][0]=1;
        nums[1][1]=1;
        for (int i = 2; i < numRows; i++) {
            nums[i][0] = 1;

            for (int j = 1; j <= i-1; j++) {
                nums[i][j] = nums[i-1][j - 1] + nums[i-1][j];
            }
            nums[i][i] = 1;

        }

        ArrayList<Integer> temp = new ArrayList<Integer>();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < i; j++) {
                temp.add(nums[i][j]);
                System.out.print(nums[i][j]);
            }
            System.out.println();
            listList.add(temp);
            temp.clear();
        }
        return listList;
    }
}
