package 数据结构算法教程.acm_杭电李春英培训.线段树实现;

import java.awt.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;

public class 线段树 {
    /***
     比如 2 3 5 1
             1-4
         1-2   3-4
       1    2  3   4
             11
         5        6
       2   3     5  1
     假设某个兵营加了,updata

     懒惰lazy的说明
     */

    static final int maxn = 100007;
    static int A[] = new int[maxn]; //原始数组,不一定要用

    //采用内部类实现
    static class SegTreeNode {
        int val; //节点值,如区间最大值
        int lazy; //懒惰标志,又称延迟更新标记
        //这里还可以根据题意增加更多的元素

        //把l r也保存在里面,这样的话就不需要一个数组定义了
        SegTreeNode left;//老师说是多余信息,就是rt*2 rt*2+1 左子树
        SegTreeNode right;//rt*2+1 右子树
    }

    static SegTreeNode segTreeNode[] = new SegTreeNode[maxn];//结构体数组

    //线段树的构造函数 pushUp函数更新节点信息,以求和为例子
    public static void pushUp(int rt) {
        segTreeNode[rt].val = segTreeNode[rt << 1].val + segTreeNode[rt << 1 | 1].val;
    }

    public static void build(int l, int r, int rt) {//构造以根节点为rt,A区间为l,r线段树
        if (l == r) {
            segTreeNode[rt].val = A[l];
            return;
        }

        int m = (l + r) / 2;
        build(l,m,rt*2); //递归构造左子树
        build(m+1,r,rt*2+1); //递归构造右子树
        pushUp(rt); //回溯,向上更新 将左子树的值+右子树进行加和到自身

    }

    //单点更新 l,r表示当前节点区间,rt表示当前线段树的跟节点编号 假设A[L]+=C
    public static void updata(int L,int C,int l,int r,int rt){
        if (l==r){ //是叶节点,直接修改  不是叶节点,往下探索,
            segTreeNode[rt].val += C;
            return;
        }
        int m = (l+r)>>1;//右移一位,除
        if (L<=m) updata(L,C,m+1,r,rt<<1 | 1);//如果l会小于m,那就是在右边
        else updata(L,C,m+1,r,rt<<1|1);
        pushUp(rt); //回溯,向上更新, 上面=下面两个子节点的和
    }

    //区间查询:查[L,R] 当前这个节点代表的信息,和根节点的编号
    //如:查找1-4直接跟节点
    //查询2-4 查到3-4在范围内,这个需要交给我,然后2的区间节点需要向下查找
    public static int query(int L,int R,int l,int r,int rt){
        if (L<=l && r<=R)
                return segTreeNode[rt].val; //在区间内则直接返回
        if (L>r && R<1)
                return 0;
        int m = (1+r)>>1;//不完全包含,但是有关系,所以二分查找,
        int ANS =0;
        if (L<=m) ANS+= query(L,R,l,m,rt<<1);//左子区间与[L,R有重叠],递归,直达区间相等的情况,结束
        if (R>m)ANS+=query(L,R,m+1,r,rt<<1|1);//右子区间与[L,R]有重叠,递归,一样和上面,
        return ANS;
        //return query(L,R,l,m,rt<<1)+query(L,R,l,m,rt<<1|1);//自己写直接写这种,在判断0的过程中会返回0,不会死循环
    }

    //区间更新
    /***
     区间更新:某个区间内的所有叶子节点的值,因为叶子及诶单会影响非叶子节点
     父节点,回溯需要更新的非叶子节点多,如果一次性更新完,时间复杂度O{n}
     引入线段树中的延迟标记,称懒加载,懒惰标记,这是线段树的精华所在

     1.多次更新,一次下推
     2.无需要,不下推
     懒惰:可以,但是不可以出错(不主动,不拒绝,但负责)
     lazy说明:1,13
     每个兵营增加10兵; 但是后来又说要减少5个,
     标记+10:下面的每个+10, 再进行-5   +5就可以了;


     */
    //区间查询与更新 +lazy
    //区间更新 A[L,R]+=C为例子
    public static void updataBIG(int L,int R,int C,int l,int r,int rt){
        if (L<=1&& r<=R){
            segTreeNode[rt].val += C*(r-1+1);//更新数字和,向上保持正确
            segTreeNode[rt].lazy+=C;//累加还是赋值,看需求
            return;
        }
        int m=(1+r)>>1;
        pushDown(rt,m-l+1,r-m); //下推以后,才能准确更新新子节点
        if (L<=m)updataBIG(L,R,C,l,m,rt<<1);
        if (R>m)updataBIG(L,R,C,m+1,r,rt<<1|1);
        pushUp(rt); //更新本节点信息
    }

    private static void pushDown(int rt, int i, int i1) {

    }

    //区间更新的区间查询 A[L,R]的和
    public static int queryBIG(int L,int R,int l,int r,int rt){
        if (L<=l && r<=R){
            return segTreeNode[rt].val; //在区间内直接返回
        }
        if (L>r || R<1){
            return 0;
        }
        int m=(1+r)>>1;
        pushDown(rt,m-1+1,r-m); //下推之后,才准确查询子节点
        return queryBIG(L,R,l,m,rt<<1)+queryBIG(L,R,m+1,r,rt<<1|1);
    }

    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        hashSet.add(10);
        hashSet.add(98);
        hashSet.add(4);
        System.out.println(hashSet);
        Arrays.sort(new int[]{1});


    }

}













