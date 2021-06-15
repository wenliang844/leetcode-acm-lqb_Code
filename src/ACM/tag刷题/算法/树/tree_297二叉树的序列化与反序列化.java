package ACM.tag刷题.算法.树;

import ACM.tag刷题.数据结构.栈.stack_94二叉树的中序遍历;
import sun.reflect.generics.tree.Tree;

import java.util.*;

public class tree_297二叉树的序列化与反序列化 {

    //序列化二叉树
    public static void main(String[] args) {
// Your Codec object will be instantiated and called as such:
        /*Codec2.TreeNode root = new Codec2.TreeNode(1);
        Codec2.TreeNode tree1 = new Codec2.TreeNode(2);
        Codec2.TreeNode tree2 = new Codec2.TreeNode(3);
        Codec2.TreeNode tree3 = new Codec2.TreeNode(4);
        Codec2.TreeNode tree4 = new Codec2.TreeNode(5);
        Codec2.TreeNode tree5 = new Codec2.TreeNode(6);
        Codec2.TreeNode tree6 = new Codec2.TreeNode(7);
        root.left = tree1;
        root.right = tree2;
        tree1.left = tree3;
        tree1.right = tree4;
        tree2.left = tree5;
        tree2.right = tree6;
        System.out.println(root);
        Codec2 ser = new Codec2();
        Codec2 deser = new Codec2();
        System.out.println(ser.serialize(root));
        System.out.println(ser.deserialize(ser.serialize(root)));*/
        //System.out.println(ser.deserialize("123|321"));
        //Codec2.TreeNode ans = deser.deserialize(ser.serialize(root));
        //System.out.println(ser.deserialize(ser.serialize(root)));
        //System.out.println(root == ser.deserialize(ser.serialize(root)));
        //System.out.println(root.equals(ser.deserialize(ser.serialize(root))));

        /*System.out.println("_____________________1.问题,有重复的键,map会覆盖,会出错_____");
        Codec2 codec2 = new Codec2();
        //Codec2.TreeNode root2 = new Codec2.TreeNode(4, new Codec2.TreeNode(-7), new Codec2.TreeNode(-3, new Codec2.TreeNode(-9), new Codec2.TreeNode(-3)));
        Codec2.TreeNode root2 = new Codec2.TreeNode(-1, new Codec2.TreeNode(0), new Codec2.TreeNode(1));
        System.out.println(root2);
        Map<Integer, String> serialize = codec2.serialize(root2);
        System.out.println(serialize);
        System.out.println(codec2.deserialize(serialize));*/

        System.out.println("----------利用队列->s  s->队列----------------");
        Codec3 codec3 = new Codec3();
        Codec3.TreeNode root3 = new Codec3.TreeNode(1, new Codec3.TreeNode(2, new Codec3.TreeNode(4, new Codec3.TreeNode(6), new Codec3.TreeNode(7)), new Codec3.TreeNode(5)), new Codec3.TreeNode(3));
        System.out.println(root3);
        String serialize = codec3.serialize(root3);
        System.out.println(serialize);
        System.out.println(codec3.deserialize(serialize));
    }
}

class Codec {

    // Encodes a tree to a single string.
    //前序遍历,and中序遍历 分隔符为"|"
    public String serialize(TreeNode root) {
        if (root == null) return null;
        //容器
        String sb = "";
        //前序遍历
        Stack<TreeNode> stack1 = new Stack<>();
        TreeNode cur1 = new TreeNode(0);
        cur1 = root;
        while (cur1 != null || !stack1.isEmpty()) {
            if (cur1 != null) {//不为空就左走,
                stack1.add(cur1);
                sb += cur1.val;
                cur1 = cur1.left;
            } else {//当cur==null 也就是到了stack.top要打印,的最左边的节点
                cur1 = stack1.pop().right;

            }
        }
        //System.out.println("前序遍历=" + sb);


        sb += "|";
        //中序遍历
        //List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack2 = new Stack<>();
        TreeNode cur = new TreeNode(0);
        cur = root;
        while (cur != null || !stack2.isEmpty()) {
            if (cur != null) {//不为空就左走,
                stack2.add(cur);
                cur = cur.left;
            } else {//当cur==null 也就是到了stack.top要打印,的最左边的节点
                cur = stack2.pop();
                //list.add(cur.val);
                sb += cur.val;
                cur = cur.right;//右走还空,就一直右走
            }
        }
        //System.out.println("前中=" + sb);
        //return list;
        return sb;
    }

    // Decodes your encoded data to tree.
    //案例中有相同的数字 怎么办?
    public TreeNode deserialize(String data) {
        if (data == null) return null;
        String[] split = data.split("\\|");//特殊字符,需要转义
        char[] chs1 = split[0].toCharArray();
        char[] chs2 = split[1].toCharArray();
        int[] preorder = new int[chs1.length];
        int[] inorder = new int[chs2.length];
        for (int i = 0; i < chs1.length; i++) {
            preorder[i] = chs1[i] - 48;
        }
        for (int i = 0; i < chs2.length; i++) {
            inorder[i] = chs2[i] - 48;
        }
        /*System.out.println(Arrays.toString(chs1));
        System.out.println(Arrays.toString(chs2));
        System.out.println(Arrays.toString(preorder));
        System.out.println(Arrays.toString(inorder));*/

        int len = preorder.length;
        int[] visited = new int[len];
        Stack<TreeNode> stackTree = new Stack<>();//方便直接加左右子树tree
        Stack<Integer> stackIndex = new Stack<>();//方便判断是左还是右子树

        TreeNode root = new TreeNode(preorder[0]);//第一个是头结点
        stackTree.add(root);
        Map<Integer, Integer> map = new HashMap<>();//inorder的值 下标
        for (int i = 0; i < len; i++) {
            map.put(Integer.valueOf(inorder[i]), i);
        }
        visited[map.get(preorder[0])] = 1;
        stackIndex.push(map.get(preorder[0]));//把下标1放进去
        for (int i = 1; i < len; i++) {//遍历preorder
            TreeNode tree = new TreeNode(preorder[i]);
            //TreeNode p = stackTree.peek();
            int inorderIndex = map.get(preorder[i]);
            boolean flag = false;

            //考核的位置变一下
            while (stackIndex.size() > 1) {
                int l1 = stackIndex.peek() - 1 >= 0 ? stackIndex.peek() - 1 : stackIndex.peek();
                int r1 = stackIndex.peek() + 1 < len ? stackIndex.peek() + 1 : stackIndex.peek();
                if (visited[l1] == 1 && visited[r1] == 1) {//两边的节点都访问过了,继续peek栈的下一个
                    stackIndex.pop();
                    stackTree.pop();
                } else {
                    break;//考核结束
                }
            }


            if (inorderIndex < stackIndex.peek()) {//在上一个父节点的左边
                //TreeNode p = stackTree.pop();
                stackTree.peek().left = tree;
                flag = true;
                //stackTree.add(p);
            } else {
                //TreeNode p = stackTree.pop();
                stackTree.peek().right = tree;
                //stackTree.add(p);
            }
            //将9这个节点设为已访问
            visited[inorderIndex] = 1;

            //弄完之后栈里面有可能null   解决:size大于1才进行考核
            //1加在考核当前index值进栈之前,对栈中的peek元素进行考核,是否有资格
           /* while (stackIndex.size()>1){
                int l1 = stackIndex.peek() - 1 >= 0 ? stackIndex.peek() - 1 : stackIndex.peek();
                int r1 = stackIndex.peek() + 1 < len ? stackIndex.peek() + 1 : stackIndex.peek();
                if (visited[l1]==1 && visited[r1]==1){//两边的节点都访问过了,继续peek栈的下一个
                    stackIndex.pop();
                    stackTree.pop();
                }else {
                    break;//考核结束
                }
            }*/

            //这个perorder[i] 9可能作为根节点,判断9的左右有没有0 有的话就进栈
            int left = inorderIndex - 1 >= 0 ? inorderIndex - 1 : inorderIndex;
            int right = inorderIndex + 1 < len ? inorderIndex + 1 : inorderIndex;//两个值,处理边界情况
            if (visited[left] == 0 || visited[right] == 0) {
                //有任何一边有没访问的情况,把节点和下标加入栈
                stackIndex.add(inorderIndex);
                //stackTree.add(new TreeNode(preorder[i]));
                if (flag) {
                    stackTree.add(stackTree.peek().left);
                } else {
                    stackTree.add(stackTree.peek().right);
                }

            }

        }

        return root;
    }


    // Definition for a binary tree node.
    //leetcode跑案例的时候不要这个
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
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

// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
}

class Codec2 {
    /**
     * [0,0,0,0,null,null,1,null,null,null,2] 超时,应该是0重复,但是0*10还是0
     *
     * @param root
     * @return
     */
    //利用map map中提前push一个(1000,root.val+n)
    //问题一:有负数的情况:解决:分隔符用s
    public Map<Integer, String> serialize(TreeNode root) {

        if (root == null) {
            return null;
        }
        Map<Integer, String> map = new HashMap<>();
        //处理重复值 用list装层序遍历的值,重复的就*10;然后不重复了就把map变换值,原始值;  需要先行处理,不能并行
        Queue<TreeNode> queue2 = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queue2.add(root);
        //list.add(root.val);
        while (!queue2.isEmpty()) {
            TreeNode p2 = queue2.poll();
            int key = p2.val;
            while (list.contains(key)) {
                key += 226;
            }
            if (key == p2.val) {//不重复
                list.add(p2.val);
            } else {//重复了
                list.add(key);
                //map.put(key, String.valueOf(p2.val));//会被key的覆盖洛
                map.put(key + 127, String.valueOf(p2.val));
                p2.val = key;
            }
            if (p2.left != null) {
                queue2.add(p2.left);
            }
            if (p2.right != null) {
                queue2.add(p2.right);
            }

            Queue<TreeNode> queue = new LinkedList<>();
            map.put(1000, root.val + "n");
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode p = queue.poll();
                String s = "";
                if (p.left != null) {
                    queue.add(p.left);
                    s += p.left.val;
                } else {
                    s += "n";
                }
                s += "s";
                if (p.right != null) {
                    queue.add(p.right);
                    s += p.right.val;
                } else {
                    s += "n";
                }
                map.put(p.val, s);
            }
            //重复的p.val处理
            /*int key = p.val;//-3 -> -30
            while (map.get(key) != null) {
                key *= 10;
            }*/

            //if (key == p.val) {//没有重复

           /* } else {//重复处理
                map.put(key, s + ("s" + p.val));//将他实际的值放到split[3]=-3  同时把p.val改成key
                //从新将原来-3的value设置为left+right
                String s1 = map.get(p.val);
                s1.replace("" + p.val, "" + key);
                map.put(p.val,s1);
                p.val = key;
                System.out.println(root);
                //System.out.println(s);
            }*/

        }
        //System.out.println(map);
        return map;
    }

    public static void mapToTree(Map<Integer, String> map, TreeNode root) {

        String[] split = map.get(root.val).split("s");//[0]左,[1]右
            /*String s = map.get(root.val);
            String[] split = s.split("s");*/
        /*if (split.length>=3){//split[3]的值是原始值-3

        }*/
        if (!split[0].equals("n")) {
            root.left = new TreeNode(Integer.parseInt(split[0]));
            mapToTree(map, root.left);
        }
        if (!split[1].equals("n")) {
            root.right = new TreeNode(Integer.parseInt(split[1]));
            mapToTree(map, root.right);
        }

            /*if (Math.abs(root.val)>=10){//进行了重复值处理的; //有大于10的数
                root.val = Integer.parseInt(map.get(root.val*127));
            }*/
        if (map.get(root.val + 127) != null) {//非空->操作
            root.val = Integer.parseInt(map.get(root.val + 127));//0*127 = 127 加一个数呗
        }

    }

    public TreeNode deserialize(Map<Integer, String> map) {
        if (map == null) {
            return null;
        }
        String s = map.get(1000);
        String s1 = s.split("n")[0];//假如是负数就不行了
        System.out.println(s1);
        int rootNum = Integer.parseInt(s1);
        TreeNode root = new TreeNode(rootNum);
        mapToTree(map, root);

        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int x, TreeNode left, TreeNode right) {
            this.val = x;
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

class Codec3 {
    //利用队列->s  s->队列   注意,nn代表空 _代表分隔符 16 60
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        String s = "";
        s += root.val + "_";
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                queue.add(cur.left);
                s += cur.left.val + "_";
            } else {
                s += "n_";
            }
            if (cur.right != null) {
                queue.add(cur.right);
                s += cur.right.val + "_";
            } else {
                s += "n_";
            }
        }

        return s;
    }

    public TreeNode deserialize(String s) {
        if (s == null) {
            return null;
        }
        //1_2_3_4_5_n_n_6_7_n_n_n_n_n_n_
        Queue<TreeNode> queue = new LinkedList<>();
        String[] ss = s.split("_");
        TreeNode root = new TreeNode(Integer.parseInt(ss[0]));
        queue.add(root);

        int i = 1;
        //queue递归处理
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) continue;
            if (!ss[i].equals("n")) {
                TreeNode leftT = new TreeNode(Integer.parseInt(ss[i]));
                i++;
                cur.left = leftT;
                queue.add(leftT);
            } else {
                cur.left = null;
                queue.add(null);
                i++;
            }
            if (!ss[i].equals("n")) {
                TreeNode rightT = new TreeNode(Integer.parseInt(ss[i]));
                i++;
                cur.right = rightT;
                queue.add(rightT);
            } else {
                cur.right = null;
                queue.add(null);
                i++;
            }
        }

        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int x, TreeNode left, TreeNode right) {
            this.val = x;
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