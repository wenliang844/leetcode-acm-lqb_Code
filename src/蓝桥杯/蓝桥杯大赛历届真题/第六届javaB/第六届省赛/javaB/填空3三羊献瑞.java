package 蓝桥杯.蓝桥杯大赛历届真题.第六届javaB.第六届省赛.javaB;

public class 填空3三羊献瑞 {
    /***三一定是1
     枚举7个数,看是否满足等式
     */
    public static void main(String[] args) {
        int L = 1;//三
        for (int x = 0; x < 10; x++) {//详
            for (int y = 0; y < 10; y++) {
                if (y == x||y==1) continue;
                for (int z = 0; z < 10; z++) {
                    if (z == y || z == x||z==1) continue;
                    for (int k = 0; k < 10; k++) {
                        if (k == z || k == x || k == y||k==1) continue;
                        for (int j = 0; j < 10; j++) {
                            if (j == x || j == y || j == z || j == k||j==1) continue;
                            for (int i = 0; i < 10; i++) {
                                if (i == j || i == x || i == y || i == z || i == k||i==1) continue;//这里吧最后的一个i写成了y,照成多种答案,debug能力突出,找到并解决
                                for (int m = 0; m < 10; m++) {
                                    if (m == x || m == y || m == z || m == k || m == j || m == i ||m==1) continue;

                                    //计算 详 瑞 生 辉
                                    int num1 = x * 1000 + y * 100 + z * 10 + k;

                                    //计算 三羊献瑞
                                    int num2 = 1000 + j*100+i*10+y;

                                    //计算 三羊生瑞气
                                    int numSum = 10000 + j*1000 + z*100+y*10+m;

                                    if (numSum == num1+num2){
                                        System.out.println("-----answer---------------");
                                        System.out.println("这是祥"+x);
                                        System.out.println("这是瑞"+y);
                                        System.out.println("这是生"+z);
                                        System.out.println("这是辉"+k);


                                        System.out.println("answer1这是三"+L);
                                        System.out.println("answer2这是羊"+j);
                                        System.out.println("answer3这是献"+i);
                                        System.out.println("answer4这是瑞"+y);

                                        System.out.println("这是气"+m);
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
