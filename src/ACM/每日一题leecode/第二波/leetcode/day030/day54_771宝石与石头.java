package ACM.每日一题leecode.第二波.leetcode.day030;

public class day54_771宝石与石头 {
    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));

        System.out.println(3 * 0.1 == 0.3);
        System.out.println(3*0.1);
    }


    public static int numJewelsInStones(String jewels, String stones) {


        int count = 0;
        for (int i = 0; i < stones.length(); i++) {
            if (jewels.contains(String.valueOf(stones.charAt(i)))) {
                count++;
            }
        }
        return count;
    }

}
