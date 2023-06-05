package ACM.每日一题leecode.第二波.leetcode.day000;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 陈文亮
 * @date 2022/10/30 18:51
 */
public class day015_784字母大小写全排列 {
    public static void main(String[] args) {

        System.out.println(letterCasePermutation("a1b2"));
    }

    public static List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        res.add(s);
        int length = s.length();
        for (int i = 0; i < length; i++) {

            //["a1b2", "a1B2", "A1b2", "A1B2"]
            // a1b2   A1b2
            //a1B2  A1B2
            //转大写 -32
            List<String> temp = new ArrayList<>();
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                for (String re : res) {
                    temp.add(re.substring(0,i) + (char)(s.charAt(i)-32) + re.substring(i+1,length));
                }
            }
            //转小写 +32
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                for (String re : res) {
                    temp.add(re.substring(0,i) + (char)(s.charAt(i)+32) + re.substring(i+1,length));
                }
            }
            res.addAll(temp);
        }
        return res;
    }
}
