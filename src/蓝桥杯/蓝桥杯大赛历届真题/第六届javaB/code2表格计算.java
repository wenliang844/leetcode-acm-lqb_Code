package 蓝桥杯.蓝桥杯大赛历届真题.第六届javaB;

import java.util.Arrays;

public class code2表格计算 {
    /**
     * 递归
     */
    public static void printNums(Double[][] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println(Arrays.toString(nums[i]));

        }
    }

    public static void main(String[] args) {
        String[][] originS = {{"1", "SUM(2,1:3,1)"}, {"2", "AVG(1,1:1,2)"}, {"SUM(1,1:2,1)", "STD(1,1:2,2)"}};
        Double[][] nums = new Double[originS.length][originS[0].length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                if (nums[i][j]!=null) {
                    System.out.println("这数字不是null");
                    continue;
                } else {
                    //解析originS[i][j]
                    String s = originS[i][j];
                    if (s.charAt(0) >= '0' && s.charAt(0) <= '9') {//如果这个s就是一个数字,直接赋值
                        nums[i][j] = Double.valueOf(s);
                        System.out.println("这是ij-nums赋值的数字="+i+"--"+j+"="+nums[i][j]);
                    } else {
                        //double num = 0;
                        String method = s.substring(0, 3);
                        String val = s.substring(4, s.length() - 1);
                        String[] split = val.split(":");
                        String[] splitfrom = split[0].split(",");
                        String[] splitto = split[1].split(",");
                        int fromI = Integer.parseInt(splitfrom[0])-1;
                        int fromJ = Integer.parseInt(splitfrom[1])-1;
                        int toI = Integer.parseInt(splitto[0])-1;
                        int toJ = Integer.parseInt(splitto[1])-1;
                        switch (method) {
                            case "SUM":
                                nums[i][j] = SUM(nums, originS, fromI, fromJ, toI, toJ, i, j);
                                break;
                            case "AVG":
                                nums[i][j] = AVG(nums, originS, fromI, fromJ, toI, toJ, i, j);
                                break;
                            case "STD":
                                nums[i][j] = STD(nums, originS, fromI, fromJ, toI, toJ, i, j);
                                break;
                        }
                    }
                }
                // nums[i][j] = num;

            }
        }

        //输出nums
        printNums(nums);

    }

    public static void analysis(String s) {

    }

    public static double SUM(Double[][] nums, String[][] originS, int fromi, int fromj, int toi, int toj, int currenti, int currentj) {
        double sum = 0;
        for (int i = fromi; i <= toi; i++) {
            for (int j = fromj; j <= toj; j++) {
                if (nums[i][j] != null) {
                    sum += nums[i][j];
                } else {
                    //解析originS[i][j]
                    String s = originS[i][j];
                    if (s.charAt(0) >= '0' && s.charAt(0) <= '9') {//如果这个s就是一个数字,直接赋值
                        nums[i][j] = Double.valueOf(s);
                    } else {
                        String method = s.substring(0, 3);
                        String val = s.substring(4, s.length() - 1);
                        String[] split = val.split(":");
                        String[] splitfrom = split[0].split(",");
                        String[] splitto = split[1].split(",");
                        int fromI = Integer.parseInt(splitfrom[0])-1;
                        int fromJ = Integer.parseInt(splitfrom[1])-1;
                        int toI = Integer.parseInt(splitto[0])-1;
                        int toJ = Integer.parseInt(splitto[1])-1;
                        switch (method) {
                            case "SUM":
                                SUM(nums, originS, fromI, fromJ, toI, toJ, i, j);
                                break;
                            case "AVG":
                                AVG(nums, originS, fromI, fromJ, toI, toJ, i, j);
                                break;
                            case "STD":
                                STD(nums, originS, fromI, fromJ, toI, toJ, i, j);
                                break;
                        }
                    }


                    sum += nums[i][j];
                }
            }
        }

        nums[currenti][currentj] = sum;
        return sum;
    }

    private static double STD(Double[][] nums, String[][] originS, int fromi, int fromj, int toi, int toj, int currenti, int currentj) {
        int count = (toi - fromi + 1) * (toj - fromj + 1);
        double avg = AVG(nums, originS, fromi, fromj, toi, toj, currenti, currentj);
        double fangcha = 0;
        for (int i = fromi; i <= toi; i++) {
            for (int j = fromj; j <= toj; j++) {
                fangcha += (nums[i][j] - avg) * (nums[i][j] - avg);
            }
        }
        fangcha = fangcha / count;
        double biaozhuncha = Math.sqrt(fangcha);
        nums[currenti][currentj] = biaozhuncha;
        return biaozhuncha;
    }

    private static double AVG(Double[][] nums, String[][] originS, int fromi, int fromj, int toi, int toj, int currenti, int currentj) {
        int count = (toi - fromi + 1) * (toj - fromj + 1);
        double sum = SUM(nums, originS, fromi, fromj, toi, toj, currenti, currentj);
        nums[currenti][currentj] = sum / count;
        return sum / count;
    }
}
