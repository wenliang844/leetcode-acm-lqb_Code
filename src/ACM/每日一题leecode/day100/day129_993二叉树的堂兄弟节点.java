package ACM.每日一题leecode.day100;

public class day129_993二叉树的堂兄弟节点 {

    private static int deep1;
    private static int deep2;
    private static int parent1;
    private static int parent2;

    //判断是否同一深度 && 不同父节点 dfs
    public static void main(String[] args) {
        System.out.println(isCousins(new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3)), 2, 3));//true
        System.out.println(isCousins(new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3)), 4, 3));//false
    }

    //dfs一次遍历,保存两个值 100/90
    public static boolean isCousins(TreeNode root, int x, int y) {
        deep1 = 0;
        deep2 = 0;
        parent1 = 0;
        parent2 = 0;
        dfs(root,0,x,y,0);
        return deep1==deep2 && parent1!=parent2;
    }

    private static void dfs(TreeNode root, int deep, int x, int y,int parentNum) {
        if (root.val==x){
            deep1=deep;
            parent1=parentNum;
        }
        if (root.val==y){
            deep2=deep;
            parent2=parentNum;
        }

        if (root.left!=null){
            dfs(root.left,deep+1,x,y,root.val);
        }

        if (root.right!=null){
            dfs(root.right,deep+1,x,y,root.val);
        }
    }
}
