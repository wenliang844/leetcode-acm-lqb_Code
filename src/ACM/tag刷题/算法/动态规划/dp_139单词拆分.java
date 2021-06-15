package ACM.tag刷题.算法.动态规划;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class dp_139单词拆分 {

    /*****
     给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
     说明：
     拆分时可以重复使用字典中的单词。
     你可以假设字典中没有重复的单词。
     输入: s = "leetcode", wordDict = ["leet", "code"]
     输出: true
     解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
     示例 2：
     输入: s = "applepenapple", wordDict = ["apple", "pen"]
     输出: true
     解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
          注意你可以重复使用字典中的单词。
     示例 3：
     输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
     输出: false
     */

    static class TridNode {
        //定义多少重复前缀,多少重复结尾 int paht,int end;end大于0就是结尾
        boolean isEnd;
        char ch;
        TridNode[] map;

        TridNode() {
        }

        ;

        TridNode(char ch) {
            this.ch = ch;
            map = new TridNode[26];//a-0-97
        }

        @Override
        public String toString() {
            return "TridNode{" +
                    "isEnd=" + isEnd +
                    ", ch=" + ch +
                    ", root=" + Arrays.toString(map) +
                    '}';
        }
    }

    //方法一:字典树方法:
    public static boolean wordBreak(String s, List<String> wordDict) {
        //避免大量重复的单词,带一个没有的单词,提前避免,检查一下是否有wordlist里面没有的字母,存在即返回false,避免深度递归
        StringBuilder sb = new StringBuilder();
        for (String s1 : wordDict) {
            sb.append(s1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (!sb.toString().contains(s.charAt(i) + "")) {
                return false;
            }
        }

        System.out.println("字典树" + wordDict);
        //wordlist构造一颗字典树
        TridNode root = new TridNode('#');
        //TridNode p = new TridNode();
        for (String words : wordDict) {
            //对每一个words进行构造
            TridNode p = root;
            for (int i = 0; i < words.length(); i++) {
                TridNode[] map = p.map;
                if (map[words.charAt(i) - 97] == null) {
                    TridNode tmp = new TridNode(words.charAt(i));
                    map[words.charAt(i) - 97] = tmp;
                    p = map[words.charAt(i) - 97];
                } else {
                    p = map[words.charAt(i) - 97];
                }
            }
            p.isEnd = true;
        }

        //对s  在字典树中进行查找,i=0;apple pen apple 找到一个end就进行下一次查找成功了就返回true 失败了就往下继续查找
        System.out.println(root);

        return dfsSearch(root, s, 0);
    }

    //利用treinode树,对applepenapple单词进行递归查找
    public static boolean dfsSearch(TridNode root, String s, int i) {
        /*if (i==s.length()-1 && root.isEnd){//当i是最后一个元素,并且最后一个元素已经是end了,找到了
            return true;
        }*/
        boolean flag = false;
        TridNode p = root;
        while (i < s.length()) {
            TridNode[] map = p.map;
            if (map[s.charAt(i) - 97] != null) {
                p = map[s.charAt(i) - 97];
                System.out.println("这是我们勘察到的单词字母" + p.ch);
                i++;
                if (p.isEnd) {//到了单词的结尾,比如到了apple的e了,再从i=p出发,利用树查找pen
                    if (i - 1 == s.length() - 1) {
                        return true;
                    }
                    System.out.println("发现p是root某一个节点的终点了,这时候的i从新的节点开始=" + i);
                    flag = dfsSearch(root, s, i);
                    if (flag) return flag;
                }
            } else {
                break;
            }
        }
        return flag;

    }


    //方法二:动态规划的方法:动态规划。dp[i]表示字符串s的前i个字符能否拆分成wordDict

    /**
        a p p l e p e n a p p l e
     0  1 2 3 4 5 6 7 8 9
        i
         j
   dp0 1 2 3 4 5 6 7 8 9 10      13 14
     t            t     t         f t
     判断j-i之间有没有j=true && j-i存在于list中的 有的话i==true

     时间复杂度：O(n^2)O(n
     2
     ) ，其中 nn 为字符串 ss 的长度。我们一共有 O(n)O(n) 个状态需要计算，每次计算需要枚举 O(n)O(n) 个分割点，哈希表判断一个字符串是否出现在给定的字符串列表需要 O(1)O(1) 的时间，因此总时间复杂度为 O(n^2)O(n
     2
     )。

     空间复杂度：O(n)O(n) ，其中 nn 为字符串 ss 的长度。我们需要 O(n)O(n) 的空间存放 \textit{dp}dp 值以及哈希表亦需要 O(n)O(n) 的空间复杂度，因此总空间复杂度为 O(n)O(n)。
     */
    //动态规划:34 18
    public static boolean wordBreak2(String s, List<String> wordDict) {
        boolean dp[] = new boolean[s.length()+1];
        dp[0] = true;//0这里是可以切分的,空
        for (int i = 0; i <= s.length(); i++) {//sub的第二个
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j,i))){//模拟一下
                    dp[i] = true;
                    break;
                }
            }

        }
        System.out.println(Arrays.toString(dp));

        return dp[s.length()];
    }
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("pen");
        System.out.println(wordBreak2("applepenapple",list));
 List<String> list6 = new ArrayList<>();
        list6.add("cats");
        list6.add("dog");
        list6.add("sand");
        list6.add("and");
        list6.add("cat");
        System.out.println(wordBreak2("catsandog",list6));

        /*System.out.println("aaaaaaaab".matches("b"));
        System.out.println("aaaabaaaa".matches("\\.\\*b\\.\\*"));
        System.out.println("aaaaaaaab".matches("\\Sb\\S"));
        System.out.println("aaaaaaaabaaaaa".matches("\\Sb\\S"));
        System.out.println("baaaaaaaaaaaaa".matches("\\*\\Sb\\S\\*"));
        System.out.println("baaaaaaaaaaaaa".contains("b"));*/

        /*List<String> list2 = new ArrayList<>();//特殊情况
        list2.add("a");
        list2.add("aa");
        list2.add("aaa");
        list2.add("aaaa");
        list2.add("aaaaa");
        list2.add("aaaaaa");
        list2.add("aaaaaaa");
        list2.add("aaaaaaaa");
        list2.add("aaaaaaaaa");
        list2.add("aaaaaaaaaa");
        System.out.println(wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", list2));
        System.out.println(wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", list2));
        */
       /* List<String> list3 = new ArrayList<>();
        list3.add("leet");
        list3.add("code");
        list3.add("is");
        list3.add("a");
        list3.add("betcher");
        list3.add("bet");
        System.out.println(wordBreak("leetcodebetcheris",list3));
        System.out.println(wordBreak("leetcodebetaiscodeaisbetisisiscodebetbet",list3));*/

       /* List<String> list4 = new ArrayList<>();
        list4.add("aa");
        list4.add("aaa");
        list4.add("aaaa");
        list4.add("aaaaa");
        list4.add("aaaaaa");
        list4.add("aaaaaaa");
        list4.add("aaaaaaaa");
        list4.add("aaaaaaaaa");
        list4.add("aaaaaaaaaa");
        list4.add("ba");
        System.out.println(wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", list4));*/
    }
}
