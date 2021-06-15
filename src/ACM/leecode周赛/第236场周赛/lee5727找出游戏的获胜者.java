package ACM.leecode周赛.第236场周赛;

public class lee5727找出游戏的获胜者 {
    /***

     通过的用户数1492
     尝试过的用户数1667
     用户总通过次数1502
     用户总提交次数1938
     题目难度Medium
     共有 n 名小伙伴一起做游戏。小伙伴们围成一圈，按 顺时针顺序 从 1 到 n 编号。确切地说，从第 i 名小伙伴顺时针移动一位会到达第 (i+1) 名小伙伴的位置，其中 1 <= i < n ，从第 n 名小伙伴顺时针移动一位会回到第 1 名小伙伴的位置。

     游戏遵循如下规则：

     从第 1 名小伙伴所在位置 开始 。
     沿着顺时针方向数 k 名小伙伴，计数时需要 包含 起始时的那位小伙伴。逐个绕圈进行计数，一些小伙伴可能会被数过不止一次。
     你数到的最后一名小伙伴需要离开圈子，并视作输掉游戏。
     如果圈子中仍然有不止一名小伙伴，从刚刚输掉的小伙伴的 顺时针下一位 小伙伴 开始，回到步骤 2 继续执行。
     否则，圈子中最后一名小伙伴赢得游戏。
     给你参与游戏的小伙伴总数 n ，和一个整数 k ，返回游戏的获胜者。
     */
    static class LinkNode {
        int val;
        LinkNode next;

        LinkNode(int val, LinkNode next) {
            this.val = val;
            this.next = next;
        }

        LinkNode(int val) {
            this.val = val;
        }

        LinkNode() {
        }
    }

    //约瑟夫环:方法一:链表法
    public static int findTheWinner(int n, int k) {
        //特殊情况,当k==1的时候,直接输出最后一个数字
        //因为k==1 就是删除自己,而在环中无法删除自己,or删除自己很麻烦
        if (k==1){
            return n;
        }
        LinkNode head = new LinkNode(1);
        LinkNode p =head;
        for (int i = 2; i <= n; i++) {
            LinkNode temp = new LinkNode(i);
            p.next=temp;
            p=p.next;
        }
        p.next=head;
        p=head;
        //开始从第k进行少人
        while (p.next!=p){
            for (int i = 1; i < k-1; i++) {
                p=p.next;
            }
            //将下一个节点删除
            System.out.println("删除了"+p.next.val);
            p.next=p.next.next;
            p=p.next;
        }
        return p.val;
    }

    public static void main(String[] args) {
        System.out.println(findTheWinner(5, 2));
        System.out.println(findTheWinner(6, 5));
        System.out.println(findTheWinner(6, 1));
    }
}
