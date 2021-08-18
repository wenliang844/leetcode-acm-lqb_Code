package ACM.每日一题leecode.day141;

import java.util.Arrays;

public class day184_1337矩阵中战斗力最弱的K行 {
    /***
     给你一个大小为 m * n 的矩阵 mat，矩阵由若干军人和平民组成，分别用 1 和 0 表示。
     请你返回矩阵中战斗力最弱的 k 行的索引，按从最弱到最强排序。
     如果第 i 行的军人数量少于第 j 行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。
     军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(kWeakestRows2(new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1},
        }, 3)));

        System.out.println(Arrays.toString(kWeakestRows2(new int[][]{
                {1, 0}, {1, 0}, {1, 0}, {1, 1}
        }, 4)));
    }

    //方法一:直接用一个数组对每一行的数量进行计数,sort,返回前k行即可
    public static int[] kWeakestRows(int[][] mat, int k) {
        int counts[] = new int[mat.length];//记录每行军人的数量
        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    count++;
                } else {
                    break;
                }
            }
            counts[i] = count;
        }
        Arrays.sort(counts);
        int res[] = new int[k];
        System.arraycopy(counts, 0, res, 0, k);
        return res;
    }

    //方法二:直接一列一列扫描,扫描到这个数字是1,0的结构就是少  99/6
    public static int[] kWeakestRows2(int[][] mat, int k) {

        int index = 0;
        int res[] = new int[k];
        //现将第一行是0的直接安排进count
       /* for (int i = 0; i < mat.length; i++) {
            if (mat[0][i]==0){
                res[index]=i;
                index++;
            }
            if (index>=k){
                return res;
            }
        }*/

        int visiable[] = new int[mat.length];
        for (int i = 0; i < mat[0].length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (visiable[j] == 0 && mat[j][i] == 0) {
                    res[index++] = j;
                    visiable[j] = 1;
                }
                if (index >= k) {
                    return res;
                }
            }
        }

        if (index < k) {
            //如果index < k  直接将最后一行的1进行加进res
           /* for (int i = 0; i < mat.length; i++) {
                if (mat[i][mat[0].length-1]==1){

                }
            }*/

            //or直接将visiable = 0的直接加进来
            for (int i = 0; i < visiable.length; i++) {
                if (visiable[i] == 0) {
                    res[index++] = i;
                }
                if (index>=k){
                    return res;
                }
            }
        }
        return res;
    }

}
