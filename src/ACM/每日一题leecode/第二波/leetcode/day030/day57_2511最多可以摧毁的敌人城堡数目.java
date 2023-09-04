package ACM.每日一题leecode.第二波.leetcode.day030;

public class day57_2511最多可以摧毁的敌人城堡数目 {
    public static void main(String[] args) {
        System.out.println(captureForts(new int[]{1, 0, 0, -1, 0, 0, 0, 0, 1}));
    }

    //找最长的0， 判断两边是否是1和-1， 是就保留答案， 不是就跳过。
    public static int captureForts(int[] forts) {

        int start = -1;
        int max = 0;

        for (int i = 0; i < forts.length; i++) {
            if (forts[i] != 0){
                if (start != -1 && forts[start]+forts[i]==0){
                    max = Math.max(max,i-start-1);
                }
                start = i;
            }
        }

        return max;
    }
}
