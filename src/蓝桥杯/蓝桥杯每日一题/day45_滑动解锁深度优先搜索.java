package 蓝桥杯.蓝桥杯每日一题;

public class day45_滑动解锁深度优先搜索 {
    /***
     滑动解锁是智能手机一项常用的功能。你需要在3x3的点阵上，从任意一个点开始，反复移动到一个尚未经过的"相邻"的点。这些划过的点所组成的有向折线，如果与预设的折线在图案、方向上都一致，那么手机将解锁。两个点相邻当且仅当以这两个点为端点的线段上不存在尚未经过的点。此外，这条折线还需要至少经过4个点。
     为了描述方便，我们给这9个点从上到下、从左到右依次编号1-9。那么1->2->3是不合法的，因为长度不足。1->3->2->4也是合不法的，因为1->3穿过了尚未经过的点2。2->4->1->3->6是合法的，因为1->3时点2已经被划过了。
     作为一个爱逛知乎的好少年，小Hi已经知道一共有389112种不同的解锁方案。不过小Hi不满足于此，他希望知道，当已经瞥视到一部分折线的情况下，有多少种不同的方案。
     遗憾的是，小Hi看到的部分折线既不一定是连续的，也不知道方向。例如看到1-2-3和4-5-6，那么1->2->3->4->5->6，1->2->3->6->5->4, 3->2->1->6->5->4->8->9等都是合法的方案。
     输入
     第一行包含一个整数T(1 <= T <= 10)，代表测试数据组数。
     每个测试数据第一行是一个整数N(0 <= N <= 8)，代表小Hi看到的折线段数目。
     以下N行每行包含两个整数X, Y (1 <= X, Y <= 9)，代表小Hi看到点X和点Y是直接相连的。
     输出
     对于每组数据输出合法的方案数目。
     样例输入
     3
     0
     8
     1 2
     2 3
     3 4
     4 5
     5 6
     6 7
     7 8
     8 9
     4
     2 4
     2 5
     8 5
     8 6
     样例输出
     389112
     2
     258
     */
    public static void andriodLock(){

    }

    public static void main(String[] args) {

    }
}
