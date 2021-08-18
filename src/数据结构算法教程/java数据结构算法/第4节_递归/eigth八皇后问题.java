package 数据结构算法教程.java数据结构算法.第4节_递归;

public class eigth八皇后问题 {
    public static void printNums(int[][] nums) {
        System.out.println("-------");
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                System.out.print(nums[i][j]);
            }
            System.out.println();
        }
    }

    public static void initNums(int[][] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                nums[i][j] = 0;
            }
        }
    }

    public static void printArrays(int arrays[]){
        for (int i = 0; i < arrays.length; i++) {
            System.out.print(arrays[i]+" ");
        }
        System.out.println();
    }
    //n表示第n个皇后
    public static boolean judge(int[] arrays,int n){
        for (int i = 0; i < n; i++) {
            //是否在同一行 同一列{num[i n]相等1 都是1} 同一斜线{行列相减相等}
            //需要判断同一行吗? 没有必要  n每次都在递增
            if (arrays[i] == arrays[n] || Math.abs(n-i)==Math.abs(arrays[n] - arrays[i])){
                return false;
            }
        }

        return true;
    }

    //编写一个方法 放置第n个皇后
    //注意 每一次进入check都有一次for循环   调用
    public static void check(int n,int max,int[] arrays){
        if (n==max){//n==8了,那么八个皇后放好了
            printArrays(arrays);
            count++;
            return;
        }

        //依次放入皇后 并判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把当前皇后n 放到该行的第一列
            arrays[n] = i;
            //当放置第n个皇后在i列的时候,是否冲突
            if (judge(arrays,n)){//不冲突,接着放n+1个皇后 即开始递归
                check(n+1,max,arrays);
            }
            //如果冲突 就继续执行num[n] = i; 第n个皇后放在本行的后一个位置

        }
    }
    public static void teachTest(){
        int max = 8;//表示有多少个皇后
        int[] array = new int[max];//定义一个数组 下标就是皇后摆放的列
        check(0,max,array);
        System.out.println("这是最后的结果哦---"+count);

    }

    static int count = 0;
    public static void main(String[] args) {
        /*****
         思路:
         回溯
         先第一个皇后放到第一行第一列
         第二个放到第二行第一列 如果OK就继续 不OK就往后面走

         贪心算法
         可以用一个一位数组进行存储解法

         */
        int[][] nums = new int[4][4];
        initNums(nums);
        printNums(nums);
        //eigtht1(nums);//四皇后问题

        //八皇后问题
        System.out.println("八皇后问题~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        int[][] nums2 = new int[8][8];
        initNums(nums2);
        printNums(nums2);
        //eigtht2(nums2);

        System.out.println("以下是老师的代码--------------code by teacher----------------------------");
        teachTest();

    }

    //四皇后_我的实现
    public static void eigtht1(int[][] nums) {
        /***
         传一个4*4的0二维矩阵进来
         */
        for (int i = 0; i < nums.length; i++) {

            if (yesOrNo(nums, 0, i)) {
                nums[0][i] = 1;
                for (int j = 0; j < nums.length; j++) {

                    if (yesOrNo(nums, 1, j)) {
                        nums[1][j] = 1;
                        for (int k = 0; k < nums.length; k++) {

                            if (yesOrNo(nums, 2, k)) {
                                nums[2][k] = 1;
                                for (int l = 0; l < nums.length; l++) {

                                    if (yesOrNo(nums, 3, l)) {
                                        nums[3][l] = 1;
                                        System.out.println("成功案例-------------------------");
                                        printNums(nums);
                                        //initNums(nums);
                                    } else {
                                        //nums[3][l] = 0;
                                    }
                                    nums[3][l] = 0;
                                }
                            } else {
                                //nums[2][k] = 0;
                            }
                            nums[2][k] = 0;
                        }
                    } else {
                        //nums[1][j] = 0;
                    }

                    nums[1][j] = 0;
                }
            } else {
                //nums[0][i] = 0;
            }
            nums[0][i] = 0;
        }


    }

    //八皇后_我的实现
    public static void eigtht2(int[][] nums) {
        /***
         传一个4*4的0二维矩阵进来
         92种 就是说有多少种不同的摆放方式
         */
        int count = 0;//计数器 解法的种数
        for (int i = 0; i < nums.length; i++) {
            //System.out.println("111");
            if (yesOrNo(nums, 0, i)) {
                nums[0][i] = 1;
                for (int j = 0; j < nums.length; j++) {
                    //System.out.println("222");

                    if (yesOrNo(nums, 1, j)) {
                        nums[1][j] = 1;
                        for (int k = 0; k < nums.length; k++) {
                            //System.out.println("333");

                            if (yesOrNo(nums, 2, k)) {
                                nums[2][k] = 1;
                                for (int l = 0; l < nums.length; l++) {
                                   // System.out.println("444");

                                    if (yesOrNo(nums, 3, l)) {
                                        nums[3][l] = 1;
                                        //System.out.println("成功案例-------------------------");
                                        //printNums(nums);

                                        for (int m = 0; m < nums.length; m++) {
                                            //System.out.println("555");
                                            if (yesOrNo(nums, 4, m)) {
                                                nums[4][m] = 1;
                                                for (int n = 0; n < nums.length; n++) {
                                                   // System.out.println("666");
                                                    if (yesOrNo(nums, 5, n)) {
                                                        nums[5][n] = 1;
                                                        for (int o = 0; o < nums.length; o++) {
                                                            //System.out.println("777");
                                                            if (yesOrNo(nums, 6, o)) {
                                                                nums[6][o] = 1;
                                                                for (int p = 0; p < nums.length; p++) {
                                                                    //System.out.println("888");
                                                                    if (yesOrNo(nums, 7, p)) {
                                                                        nums[7][p] = 1;
                                                                        count++;
                                                                        System.out.println("成功案例-------------------------");
                                                                        printNums(nums);
                                                                    }
                                                                    nums[7][p] = 0;
                                                                }
                                                            }
                                                            nums[6][o] = 0;
                                                        }
                                                    }
                                                    nums[5][n] = 0;
                                                }
                                            }
                                            nums[4][m] = 0;
                                        }
                                    } else {

                                    }
                                    nums[3][l] = 0;
                                }
                            } else {
                                //nums[2][k] = 0;
                            }
                            nums[2][k] = 0;
                        }
                    } else {
                        //nums[1][j] = 0;
                    }

                    nums[1][j] = 0;
                }
            } else {
                //nums[0][i] = 0;
            }
            nums[0][i] = 0;
        }

        System.out.println("解法一共有"+count);

    }

    //老师的一维数组实现_韩顺平老师
    public static boolean yesOrNo(int[][] nums, int i, int j) {
        //nums[i][j] = 0;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k][j] == 1) {
                return false;
            }
            if (nums[i][k] == 1) {
                return false;
            }
        }

        for (int k = 0; k < nums.length; k++) {
            for (int l = 0; l < nums.length; l++) {
                if ((k + l == i + j && nums[k][l] == 1) || (k - i == l - j && nums[k][l] == 1)) {
                    return false;
                }
            }
        }
        //printNums(nums);
        return true;
    }


}
