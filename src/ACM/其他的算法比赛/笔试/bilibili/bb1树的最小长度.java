package ACM.其他的算法比赛.笔试.bilibili;

import java.util.Stack;

public class bb1树的最小长度 {
    public static void main(String[] args) {

    }

    //方法一:利用stack找到最先子树null的树,这棵树就是最短高度, 利用树颗树 = 2 的层数次方  求出层数minLength
    public static int getLen(node root) {
        Stack<node> stack = new Stack<>();
        stack.push(root);
        int len = 1;
        while (!stack.isEmpty()) {
            node temp = stack.pop();
            if (temp.left == null || temp.right == null) {
                break;
            }
            if (temp.left != null) {
                stack.push(temp.left);
                len++;
            }
            if (temp.right != null) {
                stack.push(temp.right);
                len++;
            }
        }

        int count = 0;
        while (len / 2 != 0) {
            count++;
            len = len / 2;
        }
        if (len % 2 == 0) {
            count += 2;
        } else {
            count++;
        }
        return count;
    }

    static class node {
        node left;
        node right;
    }
}
