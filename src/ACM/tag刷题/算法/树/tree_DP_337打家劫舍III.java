package ACM.tag刷题.算法.树;

public class tree_DP_337打家劫舍III {

    /***
     在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。输入: [3,2,3,null,3,null,1]

     3
     / \
     2   3
     \   \
     3   1

     输出: 7
     解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
     计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
     */

    //方法一:层序遍历 每层的数字加起来,进行dp 不行

    //方法二:node节点 :偷父节点,那么子节点不能偷,继续偷子节点的左右节点,不偷父节点,那么偷左右
    //
    // 子节点 超时 122 /124
    public static int rob(TreeNode root) {
        //选择有两种 1.偷root和root的子节点的子节点 2.不偷root,偷子节点
        if (root.left == null && root.right == null) {
            return root.val;
        }

        //偷root的子节点
        int sum2 = 0;
        if (root.left != null) {
            sum2 += rob(root.left);
        }
        if (root.right != null) {
            sum2 += rob(root.right);
        }

        //偷root和子节点的子节点
        int sum1 = root.val;
        if (root.left != null && root.left.left != null) {
            sum1 += rob(root.left.left);

        }
        if (root.left != null && root.left.right != null) {
            sum1 += rob(root.left.right);
        }
        if (root.right != null && root.right.left != null) {
            sum1 += rob(root.right.left);

        }
        if (root.right != null && root.right.right != null) {
            sum1 += rob(root.right.right);
        }


        return Math.max(sum1, sum2);
    }

    //优化 超时
    public static int rob2(TreeNode root) {
        //选择有两种 1.偷root和root的子节点的子节点 2.不偷root,偷子节点
        if (root==null)return 0;
        if (root.left == null && root.right == null) {
            return root.val;
        }

        //偷root的子节点
        int sum2 = 0;
        //if (root.left != null) {
            sum2 += rob(root.left);
        //}
        //if (root.right != null) {
            sum2 += rob(root.right);
        //}

        //偷root和子节点的子节点
        int sum1 = root.val;
        if (root.left!=null){
            //if (root.left != null && root.left.left != null) {
            sum1 += rob(root.left.left);
            //}
            //if (root.left != null && root.left.right != null) {
            sum1 += rob(root.left.right);
            //}
        }

        if (root.right!=null){
            //if (root.right != null && root.right.left != null) {
            sum1 += rob(root.right.left);
            //}
            //if (root.right != null && root.right.right != null) {
            sum1 += rob(root.right.right);
            //}
        }



        return Math.max(sum1, sum2);
    }
    //优化
    public static int rob3(TreeNode root) {
        //选择有两种 1.偷root和root的子节点的子节点 2.不偷root,偷子节点
        if (root==null)return 0;
        /*if (root.left == null && root.right == null) {
            return root.val;
        }*/

        //偷root的子节点
        //if (root.left != null) {
            //sum2 += rob(root.left);
        //}
        //if (root.right != null) {
           // sum2 += rob(root.right);
        //}
        int sum2 = rob(root.left)+rob(root.right);
        //偷root和子节点的子节点
        int sum1 = root.val;
        if (root.left!=null){
            //sum2 += rob(root.left);
            //if (root.left.left != null) {
            sum1 += rob(root.left.left) + rob(root.left.right);
            //}
            //if (root.left.right != null) {
            //sum1 += rob(root.left.right);
            //}
        }
        if (root.right!=null){
           // sum2 += rob(root.right);
            //if (root.right.left != null) {
            sum1 += rob(root.right.left) +rob(root.right.right);
            //}
            //if (root.right.right != null) {
            //sum1 += rob(root.right.right);
            //}
        }
        return Math.max(sum1, sum2);
    }

    //优化:借助数组的优势,保存已经计算好的值  100 19
    public static int rob4(TreeNode root) {
        int[] res = helper(root);
        return Math.max(res[0],res[1]);
    }

    public static int[] helper(TreeNode r){
        if (r==null)return new int[2];
        int[] left = helper(r.left);
        int[] right = helper(r.right);
        int res[] = new int[2];
        res[0]=Math.max(left[1],left[0])+Math.max(right[1],right[0]); //不抢 抢左右节点
        res[1]=r.val + left[0]+right[0];//抢 r.val+左右节点的子节点的最大值{也就是子节点都不能抢的最大值};
        return res;
    }

    // 因为你从顶向下计算，中间有重复计算，所以时间复杂度比较高
    public static int rob5(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return root.val;

        if (root.left == null)
            return Math.max(root.val + rob(root.right.left) + rob(root.right.right), rob(root.left) + rob(root.right));
        if (root.right == null)
            return Math.max(root.val + rob(root.left.left) + rob(root.left.right), rob(root.left) + rob(root.right));

        return Math.max(root.val + rob(root.left.left) + rob(root.left.right) + rob(root.right.left) + rob(root.right.right), rob(root.left) + rob(root.right));
    }

    public static void main(String[] args) {
        System.out.println(rob5(new TreeNode(3, new TreeNode(4, new TreeNode(6, new TreeNode(15), new TreeNode(2)), new TreeNode(7, new TreeNode(1), new TreeNode(1))), new TreeNode(5, new TreeNode(8), new TreeNode(9)))));
        System.out.println("-----------------");//44
    }
}
