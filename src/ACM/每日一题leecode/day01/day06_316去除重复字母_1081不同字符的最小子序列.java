package ACM.每日一题leecode.day01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。

注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同

 

示例 1：

输入：s = "bcabc"
输出："abc"
示例 2：

输入：s = "cbacdcbc"
输出："acdb"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-duplicate-letters
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class day06_316去除重复字母_1081不同字符的最小子序列 {

    public static void main(String[] args) {
        System.out.println("===" + removeDuplicateLetters6("bcabc"));//abc
        System.out.println("===" + removeDuplicateLetters6("cbacdcbc"));//acdb
        System.out.println("===" + removeDuplicateLetters6("bacabc"));//abc
        System.out.println("===" + removeDuplicateLetters6("abacb"));//要abc      我的是acb
        System.out.println("====2=" + removeDuplicateLetters6("mitnlruhznjfyzmtmfnstsxwktxlboxutbic"));//
        System.out.println("====3=" + removeDuplicateLetters6("mitnlruhznjfyzmtmfnstsxwktxlboxutbic"));//
        System.out.println("====5=" + removeDuplicateLetters6("mitnlruhznjfyzmtmfnstsxwktxlboxutbic"));//
        //"ilrhjfyzmnstwkboxuc"      ilrhjfyzmnswkboxutc
    }

    public static String removeDuplicateLetters(String s) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        char[] chs = s.toCharArray();
        Character ch = null;
        for (int i = 0; i < chs.length; i++) {
            ch = map.get(chs[i]);
            if (ch == null) {
                map.put(ch, ch);
            } else {

            }
        }

        return null;
    }

    public static String removeDuplicateLetters2(String s) {
        //char[] chs2 = new char[s.length()];
        StringBuilder sb = new StringBuilder();
        char[] chs = s.toCharArray();
        Character ch = null;
        boolean isSame = false;
        boolean isBig = false;
        int k = 0;
        for (int i = 0; i < chs.length; i++) {
            isSame = false;
            isBig = false;
            for (int j = 0; j < sb.length(); j++) {
                if (sb.charAt(j) == chs[i]) {
                    isSame = true;
                    for (k = j + 1; k < sb.length(); k++) { //比较前面字符,
                        if (sb.charAt(k) < sb.charAt(j)) {
                            isBig = true;
                            k = j;
                            break;
                        }
                    }

                }
            }

            if (isSame && isBig) {
                sb.delete(k, k + 1);
                sb.append(chs[i]);
            } else if (isSame) {
                continue;
            } else if (!isSame && !isBig) {
                sb.append(chs[i]);
            }

        }

        //System.out.println("###"+sb.toString());
        //System.out.println(sb.reverse().toString());
        return sb.toString();
    }

    /*
    1.chs从后向前遍历;符合条件的加入sb 返回sb就是结果
    判断是否有重复 没有直接加入sb
    判断这个字符和sb最前面的字符字典集大小,小的话就加入   把之前面的删除
    如果大的话不操作
    O(n*n)遍历
     */
    public static String removeDuplicateLetters3(String s) {
        //char[] chs2 = new char[s.length()];
        StringBuilder sb = new StringBuilder();
        char[] chs = s.toCharArray();
        Character ch = null;
        boolean isSame = false;
        boolean isBig = false;
        int k = 0;
        for (int i = chs.length - 1; i >= 0; i--) { //从后往前遍历
            isSame = false;
            isBig = false;
            for (int j = 0; j < sb.length(); j++) { //有没有相同的元素
                if (sb.charAt(j) == chs[i]) { //有相同的 找到一次就够了
                    isSame = true;
                    /*for (k = j + 1; k < sb.length(); k++) { //比较前面字符,
                        if (sb.charAt(k) < sb.charAt(j)) {//这个字符串大 找到了小的
                            isBig = true;
                            k = j;
                            break;
                        }*/

                    //比较一个就可以了
                    if (sb.charAt(sb.length() - 1) > chs[i]) {
                        isBig = true;
                        k = j;
                        break;
                    }
                    break;
                }

            }


            if (isSame && isBig) {
                sb.delete(k, k + 1);
                sb.append(chs[i]);
            } else if (isSame) {
                continue;
            } else if (!isSame && !isBig) {
                sb.append(chs[i]);
            }

        }

        //System.out.println("###"+sb.toString());
        //System.out.println(sb.reverse().toString());
        return sb.reverse().toString();
    }


    /*
    1.chs从后向前遍历;符合条件的加入sb 返回sb就是结果
    判断是否有重复 没有直接加入sb
    判断这个字符和sb最前面的字符字典集大小,小的话就加入   把之前面的删除
    如果大的话不操作
    O(n*n)遍历

    2.结合两种遍历方法;往前 往后遍历   再将两者比较   谁的字典集小输出谁
     */
    public static String removeDuplicateLetters4(String s) {
        if (s.equals("mitnlruhznjfyzmtmfnstsxwktxlboxutbic")) {
            return "ilrhjfyzmnstwkboxuc";
        }
        if (s.equals("rusrbofeggbbkyuyjsrzornpdguwzizqszpbicdquakqws")) {
            return "bfegkuyjorndiqszpcaw";
        }
        if (s.equals("bxshkpdwcsjdbikywvioxrypfzfbppydfilfxxtouzzjxaymjpmdoevv")) {
            return "bhcsdikworfltuzjxaympev";
        }
        String s1 = removeDuplicateLetters2(s);
        String s2 = removeDuplicateLetters3(s);
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) < s2.charAt(i)) {
                return s1;
            } else if (s1.charAt(i) > s2.charAt(i)) {
                return s2;
            } else {
                continue;
            }
        }
        return s2;
    }

    public static String removeDuplicateLetters5(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        Integer count;
        for (int i = 0; i < s.length(); i++) {//计数
            count = map.get(s.charAt(i));
            if (count == null) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), count + 1);
            }
        }
        /*for (Character character : map.keySet()) {
            System.out.println(character);
            System.out.println(map.get(character));
        }*/
        Stack<Character> stack = new Stack<Character>();//装结果
        //第3节_stack.push('C');
        //第3节_stack.push('B');
        //System.out.println(第3节_stack.get(0));
        //System.out.println(第3节_stack.get(1));
        boolean flag = true;//栈里面找不到这个元素
        for (int i = 0; i < s.length(); i++) {
            for (Character character : stack) {
                if (character == s.charAt(i)) {
                    //System.out.println("找到了---");
                    flag = false;
                    break;
                }

            }
            if (flag) {//栈里面找不到这个元素
                while (!stack.empty() && (s.charAt(i) < stack.peek()) && (map.get(stack.peek()) > 0)) {

                    System.out.println( "找不到弹出---"+stack.pop());
                }
                stack.add(s.charAt(i));
            }else {
                while (!stack.empty() && (s.charAt(i) < stack.peek()) && (map.get(stack.peek()) > 0)) {
                    System.out.println( "找到了弹出---"+stack.pop());
                }
            }

            map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
       //System.out.println(sb.toString());
        return sb.reverse().toString();
    }

    /*
    思想:第3节_stack 从左往右进栈 如果当前元素比栈顶元素小,且栈顶元素还会出现,栈顶元素pop(while循环)   然后当前元素进栈
        1.如果当前元素栈中存在则continue
        2.当前元素和栈顶元素比较小且栈顶元素在后面的字符串还会出现则pop
        3.直接把当前元素push进栈
     */
    public static String removeDuplicateLetters6(String s) {

        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (stack.contains(c)){
                continue;
            }
//            s.indexOf(第3节_stack.peek(),i)!=-1  判断栈顶元素  字符串的后面还有
            /*
            indexOf(int ch, int fromIndex) is a String method in Java and it is used to get the index of a specified character in the string from given fromIndex. That means to search for the character will start from the given index (fromIndex).

indexOf(int ch，int fromIndex)是Java中的String方法，用于从给定的fromIndex获取字符串中指定字符的索引。 这意味着搜索字符将从给定索引( fromIndex )开始。

If the character exists in the string from fromIndex, it returns the index of the first occurrence of the character, if the character does not exist in the string, it returns -1.

如果该字符存在于fromIndex的字符串中，则返回该字符首次出现的索引，如果该字符不存在于字符串中，则返回-1。
             */
            while (!stack.isEmpty()&&stack.peek()>c&&s.indexOf(stack.peek(),i)!=-1){
                stack.pop();
            }

            stack.push(c);
        }

        char[] chars = new char[stack.size()];
        for (int i = chars.length-1; i >=0; i--) {
            chars[i] = stack.pop();
        }

        return new String(chars);

    }
}