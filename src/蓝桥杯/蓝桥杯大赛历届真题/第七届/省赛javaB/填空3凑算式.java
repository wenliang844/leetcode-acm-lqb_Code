package 蓝桥杯.蓝桥杯大赛历届真题.第七届.省赛javaB;

public class 填空3凑算式 {
    /**
        a + b/c + def/ghi = 10

     dfs:使用一个1-9的visited 一个int[9]存对应的数字,搜索

     or:直接9个for循环枚举
     */
    static int a[] = new int[9];
    static int v[] = new int[10];
    static long cnt=0;
    static void dfs(int k){
        if(k==9){
            int aa=a[0]*a[2]*(a[6]*100+a[7]*10+a[8]);
            int b=a[1]*(100*a[6]+10*a[7]+a[8]);
            int c=a[2]*(100*a[3]+10*a[4]+a[5]);
            int d=a[2]*(100*a[6]+10*a[7]+a[8]);
            if(aa+b+c==10*d)cnt++;
            return ;
        }
        for(int i=1;i<10;i++)if(v[i]==0){
            v[i]=1;
            a[k]=i;
            dfs(k+1);
            v[i]=0;
        }
    }

    public static void main(String[] args) {
        int count=0;
        for (int a = 1; a <=9; a++) {
            for (int b = 1; b <= 9; b++) {
            if (a==b)continue;
                for (int c = 1; c <=9; c++) {
                    if (a==c ||b==c)continue;
                    for (int d = 1; d <=9; d++) {
                        if (d==a ||d==b||d==c)continue;
                        for (int e = 1; e <=9; e++) {
                            if (e==a ||e==b||e==c||e==d)continue;
                            for (int f = 1; f <=9; f++) {
                                if (f==a ||f==b||f==c||f==d||f==e)continue;
                                for (int g = 1; g <=9; g++) {
                                    if (g==a ||g==b||g==c||g==d||g==e||g==f)continue;
                                    for (int h = 1; h <=9; h++) {
                                        if (h==a ||h==b||h==c||h==d||h==e||h==f||h==g)continue;
                                        for (int i = 1; i <=9; i++) {
                                            if (i==a ||i==b||i==c||i==d||i==e||i==f||i==g||i==h)continue;
                                            double temp1 = a;
                                            double temp2=b*1.0/c;
                                            double temp3=(d*100+e*10+f)*1.0/(g*100+h*10+i);
                                            double temp = temp1+temp2+temp3;
                                            if (temp== 10){//不可以约等于,所以用double类型把  除数乘以1.0
                                                System.out.println(a+"\t"+b+"\t"+c+"\t"+d+"\t"+e+"\t"+f+"\t"+g+"\t"+h+"\t"+i+"\t");
                                                System.out.println("---"+temp1);
                                                System.out.println("---"+temp2);
                                                System.out.println("---"+temp3);
                                                System.out.println("---"+temp);
                                                count++;
                                            }

                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println("answerIs=="+count);
        dfs(0);
        System.out.println("othersIs="+cnt);
    }
}
