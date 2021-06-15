package 蓝桥杯.蓝桥杯每日一题;

public class day49_37Hankson的趣味题 {
    /***
     Hanks 博士是BT (Bio-Tech，生物技术) 领域的知名专家，他的儿子名叫Hankson。现 在，刚刚放学回家的Hankson 正在思考一个有趣的问题。 今天在课堂上，老师讲解了如何求两个正整数c1 和c2 的最大公约数和最小公倍数。现 在Hankson 认为自己已经熟练地掌握了这些知识，他开始思考一个“求公约数”和“求公 倍数”之类问题的“逆问题”，这个问题是这样的：已知正整数a0,a1,b0,b1，设某未知正整 数x 满足： 1． x 和a0 的最大公约数是a1； 2． x 和b0 的最小公倍数是b1。 Hankson 的“逆问题”就是求出满足条件的正整数x。但稍加思索之后，他发现这样的 x 并不唯一，甚至可能不存在。因此他转而开始考虑如何求解满足条件的x 的个数。请你帮 助他编程求解这个问题。

     输入格式
     　　输入第一行为一个正整数n，表示有n 组输入数据。

     　　接下来的n 行每 行一组输入数据，为四个正整数a0，a1，b0，b1，每两个整数之间用一个空格隔开。输入 数据保证a0 能被a1 整除，b1 能被b0 整除。
     输出格式
     　　输出共n 行。每组输入数据的输出结果占一行，为一个整数。
     　　对于每组数据：若不存在这样的 x，请输出0； 若存在这样的 x，请输出满足条件的x 的个数；

     样例输入
     2
     41 1 96 288
     95 1 37 1776
     样例输出
     6
     2
     */
    //最小公倍数比较容易求，只要两数相乘，然后除以最大公约数就可以得到。
    //辗转相除法,最后一个除数就是最大公倍数
    public static int getGreatestCommonDivisor(int x, int y) {
        if (x < y) {
            int temp = y;
            y = x;
            x = temp;
        }//将x作为最大值

        //辗转相除法 高效,快捷,不用一个一个try
        while (x % y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return y;
    }
    public static int getLeastCommonMultiple(int x,int y){
        return (x*y)/getGreatestCommonDivisor(x,y);
    }

    //计算给定x的最小公倍数,x的最大公因数 求x
    public static int getX(int a0,int a1,int a2,int a3){
        /**
         x和a0的最大公因数是a1
         x个a2的最小公倍数是a2
         */
        int count=0;
        for (int i = a1; i <= a3; i += a1) {
            int greatNum = getGreatestCommonDivisor(i, a0);
            int minNum = (i*a2)/ getGreatestCommonDivisor(i,a2);
            //System.out.println("i和a0,a2的最大a1和最小a3->>>>>>"+i+"-"+greatNum+"--"+minNum+"==="+a1+"---"+a3);
            if (greatNum==a1 && minNum==a3){
                count++;
                System.out.println("这是符合要求的数"+i);
            }
        }
        return count;

    }

    public static void main(String[] args) {
        //System.out.println(getGreatestCommonDivisor(3, 9));
        //System.out.println(getGreatestCommonDivisor(9, 9));
        //System.out.println(getGreatestCommonDivisor(6, 9));
        System.out.println(getX(41, 1, 96, 288));
        System.out.println(getX(95, 1, 37, 1776));
    }

}
