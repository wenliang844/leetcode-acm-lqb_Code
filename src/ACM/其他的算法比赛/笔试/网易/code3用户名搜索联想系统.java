package ACM.其他的算法比赛.笔试.网易;

import java.util.ArrayList;
import java.util.Arrays;

public class code3用户名搜索联想系统 {
    public static void main(String[] args) {
        System.out.println(tree);
        System.out.println(search(new String[]{"just", "java", "jar", "jack", "jackson"}, new int[]{1, 5, 3, 4, 2}, "jack"));
    }


    static trix tree = new trix();

    public static ArrayList<ArrayList<String>> search(String[] users, int[] hot, String keyword) {
        /**
         字典树:trix
         */
        ArrayList<ArrayList<String>> lists = new ArrayList<>();
        // write code here
        gettrix(users, hot);
        System.out.println(tree);
        //利用字典树进行查询最近的3个返回
        for (int i = 0; i < keyword.length(); i++) {
            String s = "";
            s += keyword.charAt(i);
            ArrayList<String> list = searchOne(s);
            lists.add(list);
        }

        return lists;
    }

    public static ArrayList<String> searchOne(String s) {
        //获取一个s的热度前三
        return null;
    }

    static void gettrix(String[] users, int[] hot) {
        for (int i = 0; i < users.length; i++) {
            String s = users[i];
            /*for (int j = 0; j < s.length(); j++) {
                char ch = s.charAt(j);
                trix p = tree;
                if (p.next[ch-'a']!=null){
                    p=p.next[ch-'a'];
                }
            }*/
            trix p = tree;
            int index = 0;
            System.out.println(p.next[s.charAt(index) - 97]);
            while (index < s.length()&& p.next[s.charAt(index) - 97] != null) {
                index++;
                p = p.next[s.charAt(index) - 'a'];
            }

            while (index < s.length()) {
                //向下创建字符
                trix temp = new trix();
                p.next[s.charAt(index) - 'a'] = temp;
                p = temp;
                index++;
            }

            //p是最后一个,在这里设置idend
            p.hot = hot[i];
            p.s = s;
        }
    }

    static class trix {
        String s;
        int hot;
        trix[] next;

        trix() {
            hot = 0;
            next = new trix[26]; //0-25  表示a - z
            s = "";
        }

        @Override
        public String toString() {
            return "trix{" +
                    "s='" + s + '\'' +
                    ", hot=" + hot +
                    ", next=" + Arrays.toString(next) +
                    '}';
        }
    }
}
