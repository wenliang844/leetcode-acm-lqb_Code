package ACM.tag刷题.算法.树;

import java.util.Arrays;

public class tree_96不同的二叉搜索树 {

    /***
     给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
     method1:找规律
     n[0] = 1
     n[1] = 1
     n[2] = n[0]*n[1] + n[1]*n[0]=2
     n[3] = n[0]*n[2] +n[1]*n[1]+n[2]*n[0]  100 40
     */
    public static int numTrees(int n) {
        int[] result = new int[n+1];
        result[0]=1;
        result[1]=1;
        for (int i = 2; i <= n; i++) {
            //n[2] = n[0]*n[1] + n[1]*n[0]=2
            for (int j = 0; j < i; j++) {
                result[i] += result[j]*result[i-j-1];
            }

        }
        //System.out.println(Arrays.toString(result));
        return result[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(5));
    }
}
