package 算法algo.马士兵左程云_排序算法.牛客第三期初级;

/***
 * 和二叉树进行联系
 怎么想到的?
 1. n->2**n-1 满二叉树
 2. 折的时候   左一个下 右一个上
 */
public class 二叉树遍历_折纸问题2简洁法 {

    public static void printProcess(int i, int N, boolean down) {
        if (i > N) {//当没有子树的时候,就结束
            return;
        }
        printProcess(i + 1, N, true); //进入左树
        System.out.print((down ? "down" : "up") + "" + " ");//打印
        printProcess(i + 1, N, false); //进入右树
    }

    public static void main(String[] args) {
        printProcess(1, 4, true);
    }

}
