package ACM.每日一题leecode.第二波.leetcode.day030;

/**
 * @author 陈文亮
 * @date 2023/3/13 17:49
 */
public class day033_2383赢得比赛需要的最少训练时长 {

    /**
     * initialEnergy = 5, initialExperience = 3,
     * energy = [1,4,3,2],
     * experience = [2,6,3,1]
     *
     * @return
     */
    //暴力出奇迹 eazy
    public static int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {

        int energyMinAddCount = 0;
        int experienceMinAddCount = 0;
        int length = energy.length;
        for (int i = 0; i < length; i++) {
            if (initialEnergy <= energy[i]){
                energyMinAddCount += energy[i] - initialEnergy + 1;
                initialEnergy = 1;
            }else {
                initialEnergy -= energy[i];
            }

            if (initialExperience <= experience[i]){
                experienceMinAddCount += experience[i] - initialExperience + 1;
                initialExperience += experience[i] - initialExperience + 1;
            }
            initialExperience += experience[i];
        }

        return energyMinAddCount + experienceMinAddCount;
    }


    public static void main(String[] args) {
        System.out.println(minNumberOfHours(5, 3, new int[]{1, 4, 3, 2}, new int[]{2, 6, 3, 1}));
        System.out.println(minNumberOfHours(1, 1, new int[]{1, 1, 1, 1}, new int[]{1, 1, 1, 50}));//51

        /**
         * 1 = 1 1 1 1
         * 1 = 3 4 5
         *
         * 1 1
         * 1 0
         * 1 0
         * 1 46
         */
    }
}
