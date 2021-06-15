package 蓝桥杯.蓝桥杯每日一题;

public class day47_传球游戏 {
    /****
     　上体育课的时候，小蛮的老师经常带着同学们一起做游戏。这次，老师带着同学们一起做传球游戏。
     　　游戏规则是这样的：n个同学站成一个圆圈，其中的一个同学手里拿着一个球，当老师吹哨子时开始传球，每个同学可以把球传给自己左右的两个同学中的一个（左右任意），当老师再次吹哨子时，传球停止，此时，拿着球没传出去的那个同学就是败者，要给大家表演一个节目。
     　　聪明的小蛮提出一个有趣的问题：有多少种不同的传球方法可以使得从小蛮手里开始传的球，传了m次以后，又回到小蛮手里。两种传球的方法被视作不同的方法，当且仅当这两种方法中，接到球的同学按接球顺序组成的序列是不同的。比如有3个同学1号、2号、3号，并假设小蛮为1号，球传了3次回到小蛮手里的方式有1->2->3->1和1->3->2->1，共2种。

     输入格式
     　　共一行，有两个用空格隔开的整数n，m（3<=n<=30，1<=m<=30）。
     输出格式
     　　t共一行，有一个整数，表示符合题意的方法数。

     样例输入
     3 3
     样例输出
     2
     */
    static int sumCount = 0;

    //方法一:递归
    public static int getMethodCount(int n, int m) {
        int circle[] = new int[n];

        for (int i = 0; i < circle.length; i++) {
            circle[i] = i;
        }
        dfs(circle, 0, 0, m);
        return sumCount;
    }

    public static void dfs(int circle[], int currentIndex, int currentCount, int targetCount) {
        if (currentCount == targetCount) {
            if (circle[currentIndex] == circle[0]){
                sumCount++;
            }
            return;
        }

        dfs(circle, currentIndex + 1 < circle.length ? currentIndex + 1 : 0, currentCount + 1, targetCount);
        dfs(circle, currentIndex - 1 >= 0 ? currentIndex - 1 : circle.length-1, currentCount + 1, targetCount);
    }

    public static void main(String[] args) {
        System.out.println(getMethodCount(3, 3));
        System.out.println(getMethodCount(9, 19));
    }
}
