package ACM.每日一题leecode.第二波.leetcode.day000;

/**
 * @author 陈文亮
 * @date 2022/12/23 15:24
 */
public class day26_2011执行操作后的变量值 {
    public static void main(String[] args) {
        System.out.println(finalValueAfterOperations(new String[]{"--X", "X++", "X++"}));
    }


    public static int finalValueAfterOperations(String[] operations) {
        int res = 0;
        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "--X":
                case "X--":
                    res--;
                    break;
                case "X++":
                case "++X":
                    res++;
                    break;
                default:
                    break;
            }
        }
        return res;
    }
}
