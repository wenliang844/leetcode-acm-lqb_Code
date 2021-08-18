package ACM.每日一题leecode.day141;

public class day162_剑指Offer37序列化二叉树 {

    //方法一,深度优先搜索/ dfs 序列化和还原
    public static void main(String[] args) {
        //Your Codec object will be instantiated and called as such:
        day162_剑指Offer37序列化二叉树 codec = new day162_剑指Offer37序列化二叉树();
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        System.out.println(root);
        String serialize = codec.serialize(root);
        System.out.println(serialize);
        TreeNode resRoot = codec.deserialize(serialize);
        System.out.println(resRoot);
    }

    static String res = "";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root==null)return null;
        res = "";
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root){
        res += root.val + "&";
        if (root.left!=null){
            dfs(root.left);
        }else {
            res += "n&";
        }

        if (root.right!=null){
            dfs(root.right);
        }else {
            res+="n&";
        }
    }

    static int index = 1;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data==null)return null;
        data = data.substring(0,data.length()-1);
        String[] datas = data.split("&");
        TreeNode res = new TreeNode(Integer.parseInt(datas[0]));
        index = 1;
        dfs(datas,res);

        return res;
    }
    public void dfs(String[] datas,TreeNode res){
        if (!datas[index++].equals("n")){
            res.left = new TreeNode(Integer.parseInt(datas[index-1]));
            //index++;
            dfs(datas,res.left);
        }
        //index++;
        if (!datas[index++].equals("n")){
            res.right = new TreeNode(Integer.parseInt(datas[index-1]));
            //index++;
            dfs(datas,res.right);
        }
        //index++;
    }


    //Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }

        public TreeNode(int x, TreeNode left, TreeNode right) {
            val = x;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
