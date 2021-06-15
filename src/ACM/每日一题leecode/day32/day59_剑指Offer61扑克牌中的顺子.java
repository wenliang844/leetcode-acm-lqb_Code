package ACM.每日一题leecode.day32;

/***
 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。

  

 示例 1:

 输入: [1,2,3,4,5]
 输出: True
 */
public class day59_剑指Offer61扑克牌中的顺子 {

    public static void main(String[] args) {
        System.out.println("这是结果=" + isStraight(new int[]{1, 2, 3, 4, 5}));
        System.out.println("这是结果=" + isStraight(new int[]{0, 0, 1, 2, 5}));

    }

    public static boolean isStraight(int[] nums) {
        /*
       映射对:
        1 2 3 4 5 6 7 8 9 10 11 12 13
        0
         */


        return false;
    }

}
