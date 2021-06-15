package ACM.其他的算法比赛.Codeforces;

import java.util.Scanner;

public class AGoHome_数组两两相加相等 {

    /***
     数组中存在两两相加相等的,返回下标
     输入
     6
     2 1 5 2 7 4
     输出
     是
     2 3 1 6
     输入
     5
     1 3 1 9 20
     输出
     不
     */

    public static void test(){
       /* Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] a = new int[count];
        for (int i = 0; i < count; i++) {
            a[i] = sc.nextInt();
        }*/
        int count = 6;
        int[] a = {2,1,5,2,7,4};
        boolean flag = false;
        for (int i = 0; i < a.length-3; i++) {
            if (flag) break;
            for (int j = i+1; j < a.length - 2; j++) {
                if (flag) break;
                for (int k = j+1; k < a.length - 1; k++) {
                    if (flag) break;
                    for (int l = k+1; l < a.length; l++) {
                        if (flag) break;

                        //判断这4个数会两两相等  就是最小的数加最大的数=和的一半
                        int max1 = Math.max(a[i],a[j]);
                        int max2 = Math.max(a[k],a[l]);
                        int min1 = Math.min(a[i],a[j]);
                        int min2 = Math.min(a[k],a[l]);
                        int max = Math.max(max1,max2);
                        int min = Math.min(min1,min2);
                        if ((min+max)*2 == a[i]+a[j]+a[k]+a[l]){
                            System.out.println("YES");
                            System.out.println((i+1)+" "+(j+1)+" "+(k+1)+" "+(l+1));
                            flag = true;
                            break;
                        }
                    }
                }
            }
        }

        if (!flag){
            System.out.println("NO");
        }




    }

    public static void main(String[] args) {
        test();

    }
}
