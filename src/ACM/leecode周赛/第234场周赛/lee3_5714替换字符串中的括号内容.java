package ACM.leecode周赛.第234场周赛;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lee3_5714替换字符串中的括号内容 {

    /**
     * 给你一个字符串 s ，它包含一些括号对，每个括号中包含一个 非空 的键。
     * 比方说，字符串 "(name)is(age)yearsold" 中，有 两个 括号对，分别包含键 "name" 和 "age" 。
     * 你知道许多键对应的值，这些关系由二维字符串数组 knowledge 表示，其中 knowledge[i] = [keyi, valuei] ，表示键 keyi 对应的值为 valuei 。
     * 你需要替换 所有 的括号对。当你替换一个括号对，且它包含的键为 keyi 时，你需要：
     * 将 keyi 和括号用对应的值 valuei 替换。
     * 如果从 knowledge 中无法得知某个键对应的值，你需要将 keyi 和括号用问号 "?" 替换（不需要引号）。
     * knowledge 中每个键最多只会出现一次。s 中不会有嵌套的括号。
     * 请你返回替换 所有 括号对后的结果字符串。
     * <p>
     * 输入：s = "(name)is(age)yearsold", knowledge = [["name","bob"],["age","two"]]
     * 输出："bobistwoyearsold"
     * 解释：
     * 键 "name" 对应的值为 "bob" ，所以将 "(name)" 替换为 "bob" 。
     * 键 "age" 对应的值为 "two" ，所以将 "(age)" 替换为 "two" 。
     * <p>
     * s = "hi(name)", knowledge = [["a","b"]]
     * 输出："hi?"
     * 解释：由于不知道键 "name" 对应的值，所以用 "?" 替换 "(name)" 。
     */

    //用map 找到了就替换 没找到null就? 扫描
    public static String evaluate(String s, List<List<String>> knowledge) {
        //构造键值对
        Map<String, String> map = new HashMap<>();
        for (List<String> list : knowledge) {
            map.put(list.get(0), list.get(1));
        }

        //扫描匹配
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                i++;
                String tmp = "";
                while (s.charAt(i) != ')') {
                    tmp += s.charAt(i);
                    i++;
                }
                sb.append(map.get(tmp) != null ? map.get(tmp) : "?");
                //i++;
            }
            if (s.charAt(i) != ')')
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();
        List<String> l1 = new ArrayList<>();
        l1.add("name");
        l1.add("tes");
        List<String> l2 = new ArrayList<>();
        l2.add("q");
        l2.add("tes");
        list.add(l1);
        list.add(l2);
        System.out.println(evaluate("(name)(name)(name)()()(1)is()()(?)(?)(age)yearsold", list));
    }
}
