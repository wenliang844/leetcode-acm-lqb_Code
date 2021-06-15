package ACM.tag刷题.算法.动态规划;

import java.util.Arrays;

public class dp_10正则表达式匹配 {
    /***
     给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。

     '.' 匹配任意单个字符
     '*' 匹配零个或多个前面的那一个元素
     所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
     */
/***
 状态机版本
 NFA自动机版本

 class Solution {
 ArrayList<ArrayList<Integer>> G;   // 红边 构成的 邻接表 图

 public boolean isMatch(String s, String p) {
 int lenp = p.length();
 G = new ArrayList<>();

 // 总状态数 比 p.length 多一个， 最后一个状态时 接收状态。到达接收状态就是成功了。
 for(int i = 0; i <= lenp; i++){
 G.add(new ArrayList<>());
 }
 nfa(p);

 ArrayList<Integer> fromSet = new ArrayList<>();
 fromSet.add(0);
 // 扩展初试 状态集
 bfs(fromSet);

 int n = s.length();
 for(int i = 0; i < n; i++){
 ArrayList<Integer> toSet = new ArrayList<>();
 for(int j = 0; j < fromSet.size(); j++){
 //System.out.println(fromSet.get(j)+"+++"+fromSet.size());
 if(fromSet.get(j) < p.length() && (p.charAt(fromSet.get(j)) == s.charAt(i) ||p.charAt(fromSet.get(j)) == '.' )){
 toSet.add(fromSet.get(j)+1);
 }
 }
 bfs(toSet);
 fromSet = toSet;
 }
 for(int i = 0; i < fromSet.size(); i++){
 if(fromSet.get(i) == p.length()){
 return true;
 }
 }
 return false;
 }

 public void nfa(String pat){
 int n = pat.length();
 for(int i = 0; i < n; i++){
 if(i < n-1 && pat.charAt(i+1) == '*'){
 G.get(i+1).add(i);
 G.get(i).add(i+1);
 }
 if(pat.charAt(i) == '*'){
 G.get(i).add(i+1);  // i+1 可能越界，所以取出的时候要注意判别。
 }
 }
 }
 // 把一个集合  进行 episo扩展(保留原有元素，并扩展)
 public void bfs(ArrayList<Integer> set){
 int n = G.size();
 boolean[] vis = new boolean[n+1];// 标记该点是否访问
 LinkedList<Integer> queue = new LinkedList<>();
 // 一次性入栈
 for(Integer it : set){
 queue.add(it);
 vis[it] = true;
 }
 while(!queue.isEmpty()){
 int v = queue.getFirst();
 queue.removeFirst();
 for(int i = 0;  i < G.get(v).size(); i++){
 if(!vis[G.get(v).get(i)]){
 set.add(G.get(v).get(i));
 vis[G.get(v).get(i)] = true;
 queue.addLast(G.get(v).get(i));
 }
 }
 }
 }
 }
 */
    /***

     * @param s
     * @param p
     * @return
     */
    //方法一,把*号的全部去掉先,再匹配
    public static boolean isMatch(String s, String p) {
        //找p中的*号,找到了就从开始i-1 相等的去掉,s中从i-1开始,去掉相等的
        char[] pattern = p.toCharArray();
        char[] substring = s.toCharArray();
        System.out.println(Arrays.toString(substring));
        System.out.println(Arrays.toString(pattern));

        boolean flag = true;
        while (flag){
            flag = false;
            for (int i = 0; i < pattern.length; i++) {
                if (pattern[i] == '*') {
                    flag = true;
                    pattern[i] = '+';
                    char ch;
                    if (pattern[i - 1] == '.') {
                        ch = substring[i - 1];
                    } else {
                        ch = pattern[i - 1];
                    }
                    for (int j = i - 1; j < pattern.length; j++) {
                        if (pattern[j] == ch) {
                            pattern[j] = '+';
                        } else {
                            break;
                        }
                    }

                    for (int j = i - 1; j < substring.length; j++) {
                        if (substring[j] == ch) {
                            substring[j] = '+';
                        } else {
                            break;
                        }
                    }

                    //弄玩玩了之后要把+去掉
                    substring = new String(substring).replaceAll("\\+", "").toCharArray();
                    pattern = new String(pattern).replaceAll("\\+", "").toCharArray();

                }
            }
        }

        System.out.println(Arrays.toString(substring));
        System.out.println(Arrays.toString(pattern));

        //开始双指针匹配,碰到.直接跳过
        //长度不一样的,直接去掉
        //最后可能是点,不能这么判断
        /*if (pattern.length != substring.length) {
            return false;
        }*/
        int i = 0;
        int j = 0;
        while ( j<pattern.length) {
            if (pattern[j] == '.') {
            } else if (substring[i] != pattern[j]) {
                return false;
            }
            i++;
            j++;
        }
        if (i<substring.length)return false;

        return true;
    }

    //方法二:动态规划 or 递归,将s p长度的二维数组,
    public static boolean isMatch2(String A, String B) {
        int n = A.length();
        int m = B.length();
        boolean[][] f = new boolean[n+1][m+1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <=m ; j++) {
                //分成空正则和非空正则两种
                if(j==0){
                    f[i][j]=i==0;
                }else {
                    //非空正则分为两种情况 * 和非*
                    if (B.charAt(j-1)!='*'){
                        if (i>0 && (A.charAt(i-1) == B.charAt(j-1))){
                            f[i][j] = f[i-1][j-1];
                        }
                    }else {
                        //碰到了* 分为看和不看两种情况
                        //不看
                        if(j>=2){
                            f[i][j] |= f[i][j-2];
                        }
                        //看
                        if (i >= 1 && j >= 2 && (A.charAt(i - 1) == B.charAt(j - 2) || B.charAt(j - 2) == '.')) {
                            f[i][j] |= f[i - 1][j];//等于后面的情况
                        }
                    }
                }
            }
        }
        return f[n][m];
    }

    //方法三:直接用正则jar包
    public static boolean isMatch3(String s, String p) {
        return s.matches(p);
        //return true;
    }

    public static void main(String[] args) {
        System.out.println(isMatch2("aa", "a"));//f
        System.out.println(isMatch2("aa", "a*"));//t
        System.out.println(isMatch3("aa", ".*"));//t
        System.out.println(isMatch3("aab", "c*a*b"));//t
        System.out.println(isMatch2("mississippi", "mis*is*p*."));//f
        System.out.println(isMatch3("ab", ".*c"));//f
    }
}
