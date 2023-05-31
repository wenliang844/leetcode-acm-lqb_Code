package ACM.每日一题leecode.第二波.leetcode.day030;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 陈文亮
 * @date 2023/4/14 14:18
 */
public class day41_1023驼峰式匹配 {
    public static void main(String[] args) {

//        System.out.println(camelMatch(new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"}, "FB"));
        System.out.println(camelMatch(new String[]{"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"}, "FoBaT"));
    }

    //暴力解法
    public static List<Boolean> camelMatch(String[] queries, String pattern) {

        int length = queries.length;
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            int index1 = 0;
            String query = queries[i];
            boolean flag = true;
            for (int j = 0; j < query.length(); j++) {
                if (index1<pattern.length() && query.charAt(j) == pattern.charAt(index1)){
                    index1++;
                }else if (query.charAt(j) >= 'A' && query.charAt(j) <= 'Z'){
                    flag = false;
                    break;
                }
            }

            if (flag && index1==pattern.length()){
                res.add(new Boolean(true));
            }else {
                res.add(new Boolean(false));
            }
        }

        return res;
    }
}
