package ACM.其他的算法比赛.笔试.网易;

import java.util.HashMap;
import java.util.Map;

public class code1卡片 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 计算HR需要准备的神秘大奖数量
     * <p>
     * char字符型一维数组 每位同学手上卡片列表
     * char字符型一维数组 待搜寻的卡片列表
     *
     * @return int整型
     */
    public static void main(String[] args) {
        System.out.println(solve(new char[]{'N', 'T', 'E', 'S'}, new char[]{'N', 'E', 'T', 'S'}));
    }

    public static int solve(char[] person_cards, char[] hide_cards) {
        // write code here
        if (hide_cards.length <= 2) {
            return 0;
        }

        //大于三张,先凑4张,不能凑齐在凑3张也行
        //计数,初始为1张,
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        //map.put('N',1);
        //map.put('T',1);
        //map.put('E',1);
        //map.put('S',1);

        for (int i = 0; i < hide_cards.length; i++) {
            map.put(hide_cards[i], map.getOrDefault(hide_cards[i], 0) + 1);
        }
        int n = map.get('N');
        int t = map.get('T');
        int e = map.get('E');
        int s = map.get('S');
        //模拟发牌,先把手上的消耗完

        int count1 = Math.min(t, Math.min(e, Math.min(e, s)));
        if (count1 < 4) {
            if (n > 0 && t > 0 && e > 0) {
                count++;
                n--;
                t--;
                e--;
            }
            if (n > 0 && t > 0 && s > 0) {
                count++;
                n--;
                t--;
                s--;
            }
            if (n > 0 && e > 0 && s > 0) {
                count++;
                n--;
                e--;
                s--;
            }
            if (t > 0 && s > 0 && e > 0) {
                count++;
                t--;
                e--;
                s--;
            }

            int count2 = Math.min(t, Math.min(e, Math.min(e, s)));
            return count2+count;
        } else {
            return count1;
        }

    }
}
