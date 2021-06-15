package 蓝桥杯.lan真题训练.lan2020省赛javaB组;

import java.io.*;

public class A组队 {
    /*
1 97 90 0 0 0
2 92 85 96 0 0
3 0 0 0 0 93
4 0 0 0 80 86
5 89 83 97 0 0
6 82 86 0 0 0
7 0 0 0 87 90
8 0 97 96 0 0
9 0 0 89 0 0
10 95 99 0 0 0
11 0 0 96 97 0
12 0 0 0 93 98
13 94 91  0 0 0
14 0 83 87 0 0
15 0 0 98 97 98
16 0 0 0 93 86
17 98 83 99 98 81
18 93 87 92 96 98
19 0 0 0 89 92
20 0 99 96 95 81
     */
    public static void main(String[] args) throws IOException {
        //File -> FileInputStream -> InputSteamReader -> BufferedRead
        File file = new File("E:\\算法\\蓝桥杯\\第十届蓝桥杯大赛省赛（软件类）真题\\JB\\JB\\team.txt");
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        String str;
        int[][] nums = new int[20][5];
        int i=0;
        while ((str = br.readLine())!=null && i<20){

            System.out.println(str);
            String[] s = str.split(" ");
            //System.out.println(s[1]);
            for (int j = 0; j < 5; j++) {
                //System.out.println(s[j+1]);
                nums[i][j] = Integer.parseInt(s[j+1]);
            }
            i++;
        }
        System.out.println("------------");
        for (int k = 0; k <20; k++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(nums[k][j]+"-");
            }
            System.out.println();
        }

        System.out.println("------------");
        int sum = 0;

            for (int k = 0; k <20; k++) {
                for (int j = 0; j < 20; j++) {
                    for (int l = 0; l < 20; l++) {
                        for (int m = 0; m < 20; m++) {
                            for (int n = 0; n < 20; n++) {

                                /*if (k==j || k==l || k==m || k==n ||
                                        j==l || j==m || j==n ||
                                        l==m || l==n ||
                                        m==n){
                                    break;
                                }*/
                                int max = nums[k][0]+nums[j][1]+nums[l][2]+nums[m][3]+nums[n][4];
                                if (max>sum){
                                    sum = max;
                                    System.out.println(k+"-"+j+"-"+l+"-"+m+"-"+n+"-"+sum);
                                }
                            }
                        }
                    }
                }

            }



    }
}
