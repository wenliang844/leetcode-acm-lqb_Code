package 蓝桥杯.蓝桥杯大赛历届真题.第六届javaB.javaA;

import java.util.Arrays;

public class 填空2_四阶幻方 {
    /*****
     固定左上角为1,文多少种方案
     方法:暴力搜索
     弄成一维进行暴力搜 416
     */
    static int count = 0;

    public static void main(String[] args) {
        int[] nums = new int[16];
        boolean[] visited = new boolean[16];
        nums[0] = 1;//固定了
        visited[0] = true;
        dfs(nums, 1, visited);

        int[] a = {1, 2, 3};
        int b[] = new int[3];
        System.arraycopy(a, 0, b, 0, 3);
        System.out.println(Arrays.toString(b));
        System.out.println("这是最终的数量" + count);

        //和会等于1+...16 /4
        int sum = 0;
        for (int i = 1; i <= 16; i++) {
            sum += i;
        }
        System.out.println(sum);
        System.out.println(sum / 4);
    }

    public static void dfs(int[] nums, int i, boolean[] visited) {
        if (i == 16) {
            if (judgement(nums)/*||true*/) {
                //System.out.println(Arrays.toString(nums));
                count++;
            }
            return;
        }

        //剪枝:对不等于34的情况直接return
        if (i >= 4 && nums[0] + nums[1] + nums[2] + nums[3] != 34) return;
        if (i >= 8 && nums[4] + nums[5] + nums[6] + nums[7] != 34) return;
        if (i >= 12 && nums[8] + nums[9] + nums[10] + nums[11] != 34) return;
        //if (i>=16 &&nums[12] + nums[13] + nums[14] + nums[15]!=34)return;

        //没到终点,进行下一个的递归,传递
        for (int j = 1; j < 16; j++) {//找到下一个没访问过的,一个一个吧所有没访问过的都访问一遍
            if (!visited[j]) {//没被访问的数字
                int[] tempnums = new int[16];
                System.arraycopy(nums, 0, tempnums, 0, 16);
                boolean[] tempvisited = new boolean[16];
                System.arraycopy(visited, 0, tempvisited, 0, 16);
                //可以使用clone方法
                tempvisited[j] = true;
                tempnums[i] = j+1;
                dfs(tempnums, i + 1, tempvisited);
            }


        }
    }

    public static boolean judgement(int[] nums) {
        /***
         每排 0 1 2 3      4 5 6 7
         每列0 4 8 12
         两对角线0 5 10 15     3 6 9 12
         */
        //int a1 =
        //int a2 =
        //int a3 =
        //int a4 = ;


        return
                //行
                34 == nums[0] + nums[1] + nums[2] + nums[3]
                        && 34 == nums[4] + nums[5] + nums[6] + nums[7]
                        && 34 == nums[8] + nums[9] + nums[10] + nums[11]
                        && 34 == nums[12] + nums[13] + nums[14] + nums[15]
                && 34 == nums[0] + nums[4] + nums[8] + nums[12]//列
                && 34 == nums[1] + nums[5] + nums[9] + nums[13]
                && 34 == nums[2] + nums[6] + nums[10] + nums[14]
                && 34 == nums[3] + nums[7] + nums[11] + nums[15]
                && 34 == nums[0] + nums[5] + nums[10] + nums[15]//对角线
                && 34 == nums[3] + nums[6] + nums[9] + nums[12];

    }
}
