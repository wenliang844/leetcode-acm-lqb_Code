package ACM.每日一题leecode.day66;

public class day90_1006笨阶乘 {

    /**
     * 通常，正整数 n 的阶乘是所有小于或等于 n 的正整数的乘积。例如，factorial(10) = 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1。
     * 相反，我们设计了一个笨阶乘 clumsy：在整数的递减序列中，我们以一个固定顺序的操作符序列来依次替换原有的乘法操作符：乘法(*)，除法(/)，加法(+)和减法(-)。
     * 例如，clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1。然而，这些运算仍然使用通常的算术运算顺序：我们在任何加、减步骤之前执行所有的乘法和除法步骤，并且按从左到右处理乘法和除法步骤。
     * 另外，我们使用的除法是地板除法（floor division），所以 10 * 9 / 8 等于 11。这保证结果是一个整数。
     * 实现上面定义的笨函数：给定一个整数 N，它返回 N 的笨阶乘。
     */
/*public static int clumsy2(int N) {
        int p = 0;
        int sum = N;
        for (int i = N - 1; i >= 1; i--) {
            sum = calc(sum, i, p);
            p++;
            if (p == 4) {
                p = 0;
            }
        }


        return sum;
    }*/

    /***
     规律: if(N>4)
     {
     switch(N%4)
     {
     case 0:return N+1;break;
     case 1:return N+2;break;
     case 2:return N+2;break;
     case 3:return N-1;break;
     default:break;
     }
     }
     switch(N)
     {
     case 0:return 0;
     case 1:return 1;
     case 2:return 2;
     case 3:return 6;
     case 4:return 7;
     default:break;
     }
     return 0;




     2.
     int clumsy(int N) {
     int num[4] = {1, 2, 2, -1};
     if(N > 4) return N + num[N % 4];
     if(N > 2) return N + 3;
     return N;
     }



     * @param a
     * @param b
     * @param p
     * @return
     */
    public static int calc(int a, int b, int p) {
        switch (p) {
            case 0:
                return a * b;
            case 1:
                return a / b;
            case 2:
                return a + b;
            case 3:
                return a - b;
        }
        return 0;
    }


    //方法二:中间数字规律消除法: 47 41 4个一组做运算
    public static int clumsy(int N) {
        if (N < 9) {
            switch (N) {
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 6;
                case 4:
                    return 7;
                case 5:
                    return 7;
                case 6:
                    return 8;
                case 7:
                    return 6;
                case 8:
                    return 9;
            }
            return 0;
        } else {
            int p = 0;
            int sum = N;
            for (int i = N - 1; i >= 1; i--) {
                sum = calc(sum, i, p);
                p++;
                if (p == 2) {

                    while (i > 5) {
                        i -= 4;
                    }

                    //System.out.println("这是p=" + p);
                    i--;
                    //System.out.println("这是i=" + i);
                    //System.out.println("这是sum=" + sum);
                    //+3-2*1
                    //+1
                   /* while (i >= 1) {
                        sum = calc(sum, i, p);
                        p++;
                        i--;
                        if (p == 4) {
                            p = 0;
                        }
                    }*/
                    switch (i) {
                        case 1:
                        case 2:
                        case 3:
                            sum += 1;
                            break;
                        case 4:
                            sum -= 2;
                        case 5:
                            break;

                    }
                    break;
                }
            /*if (p==4){
                p=0;
            }*/
            }
            return sum;
        }
    }
    public static int clumsy2(int N) {
        int sum=N*(N-1>0?N-1:1)/(N-2>0?N-2:1)+(N-3>0?N-3:0);
        System.out.println("初始化"+N+"--"+sum);
        for (int i = N-4; i >=1 ; i-=4) {
            System.out.println("开始操作"+i+"--"+sum);
            sum+=(-i*(i-1>0?i-1:1)/(i-2>0?i-2:1)) + (i-3>0?i-3:0);
        }

        return sum;
    }

    /**
     栈.出现优先极高的出栈运算,所有的数字弹出求和
     数学:if (N == 1) {
     return 1;
     } else if (N == 2) {
     return 2;
     } else if (N == 3) {
     return 6;
     } else if (N == 4) {
     return 7;
     }

     if (N % 4 == 0) {
     return N + 1;
     } else if (N % 4 <= 2) {
     return N + 2;
     } else {
     return N - 1;
     * @param args
     */

    public static void main(String[] args) {
        //System.out.println(clumsy(1));
        //System.out.println(clumsy(2));
        //System.out.println(clumsy(3));
        //System.out.println(clumsy(4));
        //System.out.println(clumsy(10)); //10*9/8+7-6
        System.out.println("special case----------------------------7-8");
        System.out.println(clumsy2(7));
        System.out.println(clumsy2(9));//
        System.out.println("-------case11=10-------");
        System.out.println(clumsy2(11));
        System.out.println(clumsy2(1));
    }
}
