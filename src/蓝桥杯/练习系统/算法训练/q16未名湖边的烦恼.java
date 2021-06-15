package 蓝桥杯.练习系统.算法训练;

import java.util.Scanner;

public class q16未名湖边的烦恼 {
    //排列组合 f(m,n) = f(m-1,n) + f(m,n-1)
    //只投熟人 找第一笔钱: 从身边找第一笔钱 相信的是赢得信任,有人愿意赌我
    //1.有原则 2.有梦想 3.技术发烧友
    //不看商业计划书 商学院的内容不一致

    /****
     商业计划书没用,VC忙,假定编的
     一个靠谱的推荐是决定性的,投资者关心团队结构,想一想一个小时投的是人
     团队介绍
     简明把自己的做的事情说清楚,简单, 比如solomo 云计算高大上的名词不可行
     5-10年之后的规模,梦想有多大
     留足账面的资金,让vc来找你,花了1半的钱就要去找钱了,有后手,有谈判资本


     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        System.out.println(dfs(m, n));
    }

    private static int dfs(int m, int n) {
        if (n>m)return 0;//借书的比还书的多
        if (n==0)return 1;//借书的人没有
        return dfs(m-1,n)+dfs(m,n-1);
    }
}
