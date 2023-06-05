package ACM.每日一题leecode.第二波.leetcode.day000;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 陈文亮
 * @date 2022/12/13 11:02
 */
public class day020_1832判断句子是否为全字母句 {
    public static void main(String[] args) {

        System.out.println(checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
        System.out.println(checkIfPangram("leetcode "));
    }

    //方法一：set去重方法
    public static boolean checkIfPangram(String sentence) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < sentence.length(); i++) {
            set.add(sentence.charAt(i));
        }

        if (set.size() == 26){
            return true;
        }
        return false;
    }
}
