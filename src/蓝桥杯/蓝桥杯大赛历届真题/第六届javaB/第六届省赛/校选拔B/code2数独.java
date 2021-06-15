package 蓝桥杯.蓝桥杯大赛历届真题.第六届javaB.第六届省赛.校选拔B;

import java.util.Arrays;
import java.util.Scanner;

public class code2数独 {
    /****
     推断9*9数独的未知数字
     3个visited->bool
     一个9*9数组->char
     一个

     //1.先尝试暴力方法,1-9全随机放,再用判断函数判断是否是合格的
     一个函数判断当前点在chs中是否合格,不合格直接return

     800000000
     003600000
     070090200
     050007000
     000045700
     000100030
     001000068
     008500010
     090000400

     800000020
     070010500
     400005300
     010070006
     003200080
     060500009
     004000030
     000009700
     */
    public static void printNums(int[][] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println(Arrays.toString(nums[i]));
        }
        System.out.println("--------------------");
    }

    public static boolean dfs(int[][] nums, int i, int j) {
      // printNums(nums);
        //判断是否整体符合条件
        //if (i >= 8 && j >= 9) {
            if (judge(nums)){
                System.out.println("end-----win---");
                printNums(nums);
                return true;
            }
            //return false;
        //}

        boolean flag = false;
        //先判断这个点是否需要填充数据 再判断这个点是否符合条件
        if (i<=8&&j<=8&&nums[i][j] == 0) {
           /* if (!judge(nums, i, j)) {
                return;
            }*/
            for (int k = 1; k <= 9; k++) {
                nums[i][j] = k;
                if (judge(nums, i, j)){
                    if (j <= 7) {
                        flag = dfs(nums, i, j + 1);
                        if (flag)return flag;
                    } else {
                        flag = dfs(nums, i + 1, 0);
                        if (flag)return flag;
                    }
                }else {
                    nums[i][j] = 0;
                }

            }
        } else {
            if (j <= 7) {
                flag = dfs(nums, i, j + 1);
                if (flag)return flag;
            } else {
                flag = dfs(nums, i + 1, 0);
                if (flag)return flag;
            }
        }

        return flag;

    }

    //全盘判断
    private static boolean judge(int[][] nums) {

        //判断行&列
        for (int i = 0; i < 9; i++) {
            boolean visitedrow[] = new boolean[9];
            boolean visitedcol[] = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (nums[i][j]==0 || nums[j][i]==0)return false;
                if (!visitedrow[nums[i][j] - 1]) {
                    visitedrow[nums[i][j] - 1] = true;
                } else {
                    return false;//遇到访问两次的
                }

                if (!visitedcol[nums[j][i] - 1]) {
                    visitedcol[nums[j][i] - 1] = true;
                } else {
                    return false;//遇到访问两次的
                }
            }
        }

        //判断9个格子
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                boolean visited[] = new boolean[9];
                //从0,0开始,遍历9个
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        if (!visited[nums[k][l] - 1]) {
                            visited[nums[k][l] - 1] = true;
                        } else {
                            return false;//遇到访问两次的
                        }
                    }
                }
            }
        }

        return true;
    }

    //单点判断
    private static boolean judge(int[][] nums, int i, int j) {
        //判断i j这个点是够符合数独
        //i这行没有一样的数字 j这列没有 i,j所在的九宫格没有
        for (int k = 0; k < 9; k++) {
            if (k != j && nums[i][k] == nums[i][j]) {//这行有一样的就退出false
                return false;
            }
            if (k != i && nums[k][j] == nums[i][j]) {//这列
                return false;
            }
        }


        //9个格子9个判断
        if (i <= 2 && j <= 2) {
            for (int k = 0; k <= 2; k++) {
                for (int l = 0; l <= 2; l++) {
                    if (k != i && l != j && nums[k][l] == nums[i][j]) {
                        return false;
                    }
                }
            }
        } else if (i <= 2 && j <= 5) {
            for (int k = 0; k <= 2; k++) {
                for (int l = 3; l <= 5; l++) {
                    if (k != i && l != j && nums[k][l] == nums[i][j]) {
                        return false;
                    }
                }
            }
        } else if (i <= 2 && j <= 8) {
            for (int k = 0; k <= 2; k++) {
                for (int l = 6; l <= 8; l++) {
                    if (k != i && l != j && nums[k][l] == nums[i][j]) {
                        return false;
                    }
                }
            }
        } else if (i <= 5 && j <= 2) {
            for (int k = 3; k <= 5; k++) {
                for (int l = 0; l <= 2; l++) {
                    if (k != i && l != j && nums[k][l] == nums[i][j]) {
                        return false;
                    }
                }
            }
        } else if (i <= 5 && j <= 5) {
            for (int k = 3; k <= 5; k++) {
                for (int l = 3; l <= 5; l++) {
                    if (k != i && l != j && nums[k][l] == nums[i][j]) {
                        return false;
                    }
                }
            }
        } else if (i <= 5 && j <= 8) {
            for (int k = 3; k <= 5; k++) {
                for (int l = 6; l <= 8; l++) {
                    if (k != i && l != j && nums[k][l] == nums[i][j]) {
                        return false;
                    }
                }
            }
        } else if (i <= 8 && j <= 2) {
            for (int k = 6; k <= 8; k++) {
                for (int l = 0; l <= 2; l++) {
                    if (k != i && l != j && nums[k][l] == nums[i][j]) {
                        return false;
                    }
                }
            }
        } else if (i <= 8 && j <= 5) {
            for (int k = 6; k <= 8; k++) {
                for (int l = 3; l <= 5; l++) {
                    if (k != i && l != j && nums[k][l] == nums[i][j]) {
                        return false;
                    }
                }
            }
        } else if (i <= 8 && j <= 8) {
            for (int k = 6; k <= 8; k++) {
                for (int l = 6; l <= 8; l++) {
                    if (k != i && l != j && nums[k][l] == nums[i][j]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] nums = {
                {8, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 3, 6, 0, 0, 0, 0, 0},
                {0, 7, 0, 0, 9, 0, 2, 0, 0},
                {0, 5, 0, 0, 0, 7, 0, 0, 0},
                {0, 0, 0, 0, 4, 5, 7, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 3, 0},
                {0, 0, 1, 0, 0, 0, 0, 6, 8},
                {0, 0, 8, 5, 0, 0, 0, 1, 0},
                {0, 9, 0, 0, 0, 0, 4, 0, 0},
        };

        System.out.println(judge(new int[][]{
                {8, 1, 2, 7, 5, 3, 6, 4, 9},
                {9, 4, 3, 6, 8, 2, 1, 7, 5},
                {6, 7, 5, 4, 9, 1, 2, 8, 3},
                {1, 5, 4, 2, 3, 7, 8, 9, 6},
                {3, 6, 9, 8, 4, 5, 7, 2, 1},
                {2, 8, 7, 1, 6, 9, 5, 3, 4},
                {5, 2, 1, 9, 7, 4, 3, 6, 8},
                {4, 3, 8, 5, 2, 6, 9, 1, 7},
                {7, 9, 6, 3, 1, 8, 4, 5, 2},
        }));
        /*for (int i = 0; i < 9; i++) {
            String s = sc.next();
            for (int j = 0; j < 9; j++) {
                nums[i][j] = s.charAt(i) - '0';
            }
        }*/

       dfs(nums, 0, 0);
    }
}
