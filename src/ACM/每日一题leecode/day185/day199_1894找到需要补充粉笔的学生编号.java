package ACM.每日一题leecode.day185;

public class day199_1894找到需要补充粉笔的学生编号 {
    public static void main(String[] args) {
        System.out.println(chalkReplacer(new int[]{5, 1, 5}, 22));
        System.out.println(chalkReplacer(new int[]{3,4,1,2}, 25));
    }

    //对chalk粉笔进行累加 求余 一趟遍历直到为0就是这个下标 84/56
    public static int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for (int i = 0; i < chalk.length; i++) {
            sum += chalk[i];
        }

        long modNum = k%sum;

        for (int i = 0; i < chalk.length; i++) {
            modNum -= chalk[i];
            if (modNum<0){
                return i;
            }
        }
        return -1;
    }

    // 539095482
}
