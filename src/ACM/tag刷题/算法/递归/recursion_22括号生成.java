package ACM.tag刷题.算法.递归;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/****
 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

 示例 1：
 输入：n = 3
 输出：["((()))","(()())","(())()","()(())","()()()"]


 显而易见的方法一是暴力法:2**2n个( ),构成的序列,检查每一个是否有效即可,
 有没有效是看右括号的个数,在前面每一个左括号找最近的右括号抵消{每一个都可以抵消},如果出现右括号,就是无效的

 class Solution {
 public List<String> generateParenthesis(int n) {
 List<String> combinations = new ArrayList<String>();
 generateAll(new char[2 * n], 0, combinations);
 return combinations;
 }

 public void generateAll(char[] current, int pos, List<String> result) {
 if (pos == current.length) {
 if (valid(current)) {
 result.add(new String(current));
 }
 } else {
 current[pos] = '(';
 generateAll(current, pos + 1, result);
 current[pos] = ')';
 generateAll(current, pos + 1, result);
 }
 }

 public boolean valid(char[] current) {
 int balance = 0;
 for (char c: current) {
 if (c == '(') {
 ++balance;
 } else {
 --balance;
 }
 if (balance < 0) {
 return false;
 }
 }
 return balance == 0;
 }
 }
 */
public class recursion_22括号生成 {

    /**
     想法：n=3初始化()()()每次碰到)(右括号-左括号时候,对换这两个,继续搜索对换的
     */
    //回溯,递归法:超时,需要剪枝 5 87___剪枝后合格
    public static List<String> generateParenthesis(int n) {
        //1.初始化生成一个()()()三对括号 并加入n
       //Set<String> set = new HashSet<>();//可能会重复,用set
        List<String>  res= new ArrayList<>();//还是用list,如果出现了list.contain的情况,可以剪枝
        String s = "";
        for (int i = 0; i < n; i++) {
            s += "()";
        }
        res.add(s);
        System.out.println("初始化的s="+s);
        dfs(s,res);

       // res.addAll(set);
        return res;
    }
    public static void dfs(String s,List<String> res){
        //对s进行遍历,发现有)(的情况,用另一个temp=s其中)(对调,调用dfs(tmep)
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i)==')' && s.charAt(i+1)=='('){
                //String temp = s.sub(0,i)+()+s.sub(i+2,s.length)
                String temp = s.substring(0,i)+"()"+s.substring(i+2,s.length());//将中间的)(替换为(),
                if (res.contains(temp))continue;
                res.add(temp);//temp属于一个答案,加入list,下面可能还有,所以继续s搜索
                //对tmep调用dfs 搜索tmep下面的答案
                dfs(temp,res);
            }
        }
    }

    /***
     网友的100%
     这次比较震惊，我的方法战胜了100%的用户，感觉就是DFS+少量的剪枝，剪枝的条件为：左括号的数目一旦小于右括号的数目，以及，左括号的数目和右括号数目均小于n。

     class Solution {
     public:
     vector<string> generateParenthesis(int n) {
     vector<string> res;
     func(res, "", 0, 0, n);
     return res;
     }

     void func(vector<string> &res, string str, int l, int r, int n){
     if(l > n || r > n || r > l) return ;
     if(l == n && r == n) {res.push_back(str); return;}
     func(res, str + '(', l+1, r, n);
     func(res, str + ')', l, r+1, n);
     return;
     }
     };

     dfs:选左括号还是右括号
     class Solution {
     private List<String> res = new ArrayList<>();
     public List<String> generateParenthesis(int n) {
     generate("", n, 0, 0);
     return res;
     }

     private void generate(String s, int n, int left, int right) {
     if (s.length() == n*2) {
     res.add(s);
     }
     if (left < n) {
     // 还可以加左括号
     generate(s + "(", n, left+1, right);
     }
     if (left > right) {
     // 还可以加右括号
     generate(s+")", n, left, right+1);
     }
     }
     }



     */
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
        System.out.println(generateParenthesis(4));
        System.out.println(generateParenthesis(5));
        System.out.println(generateParenthesis(6));
        System.out.println(generateParenthesis(7));
    }
}
