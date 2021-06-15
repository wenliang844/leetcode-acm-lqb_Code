package 蓝桥杯.蓝桥杯大赛历届真题.第七届.省赛javaB;

import java.util.Arrays;

public class 填空5剪邮票 {
    /***
     1 2 3 4
     5 6 7 8
     9 10 11 12

     1.找出所有取的组合 5个for循环

     2.判断是否相连116
     */
    public static void main(String[] args) {
        int count = 0;
        //int[][] nums = new int[3][4];
        int parameters[] = new int[5];
        for (int i = 0; i < 12; i++) {
            parameters[0] = i;
            for (int j = i + 1; j < 12; j++) {
                parameters[1] = j;
                for (int k = j + 1; k < 12; k++) {
                    parameters[2] = k;
                    for (int l = k + 1; l < 12; l++) {
                        parameters[3] = l;
                        for (int m = l + 1; m < 12; m++) {
                            parameters[4] = m;
                            if (judge(parameters)) {
                                System.out.println(Arrays.toString(parameters));
                                count++;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(count);//222

        //System.out.println(judge(new int[]{0,1,2,3,4}));
        //System.out.println(judge(new int[]{1,5,6,10,11}));
        //System.out.println(judge(new int[]{2,6,5,4,9}));
        //System.out.println(judge(new int[]{0,5,9,6,7}));
        //System.out.println(judge(new int[]{0,1,11,4,9}));
    }

    private static boolean judge(int[] parameters) {//116
        boolean[][] nums = new boolean[3][4];
        for (int i = 0; i < parameters.length; i++) {
            int row = parameters[i] / 4;
            int col = parameters[i] % 4;
            nums[row][col] = true;//被访问
        }

        printNums(nums);

        //判断这个nums是否是连着的
        //全部遍历,如果这个true,那么它的上下左右要有一个true 一个都没有直接返回false
        //只需要访问并考察这5个点就可以了

        /***
         true	true	false	false
         false	true	false	false
         false	false	true	true
         ----------------------
         [0, 1, 5, 10, 11]
         这种不行,需要全部相连;

         */
        /*for (int i = 0; i < parameters.length; i++) {
            int row = parameters[i] / 4;
            int col = parameters[i] % 4;
            boolean flag = false;
            if (row - 1 >= 0 && nums[row - 1][col]) {
                flag = true;
            }
            if (row + 1 < 3 && nums[row + 1][col]) {
                flag = true;
            }
            if (col - 1 >= 0 && nums[row][col - 1]) {
                flag = true;
            }
            if (col + 1 < 4 && nums[row][col + 1]) {
                flag = true;
            }
            if (!flag) return flag;

        }*/
        //要全部是可达的,使用dfs,将 bool nums传进去,如果自己是true,dfs上下左右,自己变false 之后有true则是大于要给连通分量的
        dfs(nums,parameters[0] / 4,parameters[0] % 4);
        //判断是否全部为false,有一个为true//直接false
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (nums[i][j]){
                    return false;
                }
            }
        }
        //只能有一个联通分量:使用并查集


        return true;
    }

    private static void dfs(boolean[][] nums, int row, int col) {
        if (nums[row][col]==true){
            nums[row][col]=false;
            if (row - 1 >= 0 && nums[row - 1][col]) {
                dfs(nums,row-1,col);
            }
            if (row + 1 < 3 && nums[row + 1][col]) {
                dfs(nums,row+1,col);
            }
            if (col - 1 >= 0 && nums[row][col - 1]) {
                dfs(nums,row,col-1);
            }
            if (col + 1 < 4 && nums[row][col + 1]) {
                dfs(nums,row,col+1);
            }
        }

    }

    private static void printNums(boolean[][] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                System.out.print(nums[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("----------------------");
    }


}
