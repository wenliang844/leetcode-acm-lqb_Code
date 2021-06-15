package ACM.leecode周赛.力扣杯2021春战队赛;

public class lee2二叉树染色 {
    /****
     小扣有一个根结点为 root 的二叉树模型，初始所有结点均为白色，可以用蓝色染料给模型结点染色，模型的每个结点有一个 val 价值。小扣出于美观考虑，希望最后二叉树上每个蓝色相连部分的结点个数不能超过 k 个，求所有染成蓝色的结点价值总和最大是多少？
     示例 1：
     输入：root = [5,2,3,4], k = 2
     输出：12
     解释：结点 5、3、4 染成蓝色，获得最大的价值 5+3+4=12
     */


    /***
     方法一:递归:加四个变量:dk=2 dye=0 ndk=2 ndye=0;
     */
    int sum=0;
    public int maxValue(TreeNode root, int k) {
        dfs(k, 0, k, 0, root);
        return sum;
    }

    //到根节点,就对sum进行加和
    private void dfs(int k, int dye, int nok, int nodye, TreeNode root) {


    }

}
