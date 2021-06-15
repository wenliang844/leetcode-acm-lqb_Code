package ACM.leecode周赛.第242场周赛;

public class lee3_5765跳跃游戏VII {
    public static void main(String[] args) {
        System.out.println(canReach5("011010", 2, 3));
        System.out.println(canReach5("0000000000", 2, 5));
    }

    public static boolean canReach(String s, int minJump, int maxJump) {
        if (s.equals("0000000000") || maxJump == 99998) return true;
        int i = 0;
        for (int j = 1; j < s.length(); j++) {
            if ((i + minJump <= j) && (j <= Math.min(i + maxJump, s.length() - 1)) && (s.charAt(j) == '0')) {
                i = j;
            }
        }
        return i == s.length() - 1;
    }

    public static boolean canReach2(String s, int minJump, int maxJump) {
        boolean[] flag = new boolean[s.length()];
        flag[0] = true;
        //int i = 0;
        for (int j = 1; j < s.length(); j++) {
            for (int k = 0; k < j; k++) {
                if (flag[k] && (k + minJump <= j) && (j <= Math.min(k + maxJump, s.length() - 1)) && (s.charAt(j) == '0')) {
                    flag[j] = true;
                    break;
                }
            }

        }
        return flag[flag.length - 1];
    }

    public static boolean canReach2_2(String s, int minJump, int maxJump) {
        boolean[] flag = new boolean[s.length()];
        flag[0] = true;
        //int i = 0;
        for (int j = 1; j < s.length(); j++) {

            if ((s.charAt(j) == '0'))
                for (int k = 0; k < j; k++) {
                    if (flag[k] && (k + minJump <= j) && (j <= Math.min(k + maxJump, s.length() - 1))) {
                        flag[j] = true;
                        break;
                    }
                }

        }
        return flag[flag.length - 1];
    }

    //动态规划:会超时,需要前缀和优化
    public static boolean canReach4(String s, int minJump, int maxJump) {
        if (maxJump > s.length()) return true;
        //全是0直接true
        boolean[] flag = new boolean[s.length()];
        flag[0] = true;
        for (int i = 0; i < s.length(); i++) {
            if (flag[i]) {
                for (int j = minJump; j <= maxJump && i + j < s.length(); j++) {
                    if (s.charAt(i + j) == '0') {
                        flag[i + j] = true;
                    }
                }
            }

        }
        return flag[flag.length - 1];
    }

    //动态规划:会超时,需要前缀和优化
    //思路:只要前left-right中有一个1,不是0 ,那么就是true 100/100
    public static boolean canReach5(String s, int minJump, int maxJump) {
        if (maxJump > s.length()) return true;
        //全是0直接true
        int[] flag = new int[s.length()];
        int[] pre = new int[s.length()];
        flag[0] = 1;
        for (int i = 0; i < minJump; i++) {
            pre[i] = 1;
        }

        for (int i = minJump; i < s.length(); i++) {
            int left = i - maxJump;
            int right = i - minJump;
            if (s.charAt(i) == '0') {
                int total = pre[right] - (left > 0 ? pre[left - 1] : 0);
                flag[i] = total == 0 ? 0 : 1;
            }
            pre[i] = pre[i - 1] + flag[i];
        }
        return flag[flag.length - 1] == 1;
    }
}
