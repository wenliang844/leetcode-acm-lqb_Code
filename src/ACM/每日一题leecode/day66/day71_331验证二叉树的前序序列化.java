package ACM.每日一题leecode.day66;

import java.util.Stack;

public class day71_331验证二叉树的前序序列化 {

    /***
     序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。

     _9_
     /   \
     3     2
     / \   / \
     4   1  #  6
     / \ / \   / \
     # # # #   # #
     例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。
     给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
     每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。
     你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如 "1,,3" 。
     */

    /**
     每一次不断的删除叶子节点,并且用#代替
     1.每一次都消除叶子节点,数字后面加2个#  如9 # #
     2.直到字符串中只剩下一个#这就是正确的序列化
     3.如果一次循环操作中,字符串没有减少,表明就是错误的序列化
     "9,3,4,#,#,1,#,#,2,#,6,#,#"
     "9,3,#,#,2,#,#"
     "9,#,#"
     "#"

     * @param preorder
     * @return
     */
    public static boolean isValidSerialization(String preorder) {

        /***
         让字符串入栈
         出栈3个字符  是##数字   就入栈一个#   当栈中剩下一个# 就是正确的

         */
        String[] split = preorder.split(",");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < split.length; i++) {
            stack.push(split[i]);
        }


        int count = 0;
        while (stack.size()>=3){

            System.out.println(stack);

            String a1 = stack.pop();
            String a2 = stack.pop();
            String a3 = stack.pop();
            if (a1.equals("#")&&a2.equals("#")&&!a3.equals("#")){

                count++;
            }else {
                stack.add(a3);
                stack.add(a2);
                stack.add(a1);
                if (count==0){
                    return false;
                }else {
                    while (count>0){
                        stack.push("#");
                        count--;
                    }
                }
            }
        }
        if (stack.size()==1 && stack.pop().equals("#")){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println("这是结果="+isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));

    }
}
