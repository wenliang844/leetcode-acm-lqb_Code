package ACM.tag刷题.算法.设计;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/****
 前缀树的易用:
    1.自动补全
    2.拼写检查
    3.ip路由,最长前缀匹配
    4.九宫格,打字预测
    5.单词游戏
        网格内找单词
        trie里面加一个val =s就是这个路径的单词,可以用val=null 代替isend
 */
public class design_208实现Trie前缀树 {
    /***
     Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。

     请你实现 Trie 类：

     Trie() 初始化前缀树对象。
     void insert(String word) 向前缀树中插入字符串 word 。
     boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
     boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
     示例：

     输入
     ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
     [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
     输出
     [null, null, true, false, true, null, true]

     解释
     Trie trie = new Trie();
     trie.insert("apple");
     trie.search("apple");   // 返回 True
     trie.search("app");     // 返回 False
     trie.startsWith("app"); // 返回 True
     trie.insert("app");
     trie.search("app");     // 返回 True
     */
    public static void main(String[] args) {
        System.out.println((int) 'a');//97  a-97 = 0
        System.out.println('w' - 97);
        System.out.println("--------test-----------");
        Trie trie = new Trie();
        trie.insert("apple");
        //System.out.println(trie);
        System.out.println(trie.root.son[0]);
        System.out.println(trie.search("apple"));
        System.out.println("false要是终点"+trie.search("app"));
        System.out.println(trie.search("applewww"));
        System.out.println(trie.search("applee"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}

//33 14
class Trie {
    class TreeNode {
        char ch;
        TreeNode[] son;//用数组枚举,只有26个字母
       //boolean hasSon;
        boolean isend;

        TreeNode() {
        }

        TreeNode(char ch) {
            this.ch = ch;
            //hasSon = false;
            isend = false;
            son = new TreeNode[26];
           /* for (int i = 0; i < son.length; i++) {
                son[i] = new TreeNode('#');
                son[i].hasSon=false;
            }*/
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "ch=" + ch +
                    ", son=" + Arrays.toString(son) +
                    //", hasSon=" + hasSon +
                    '}';
        }
    }

    TreeNode root;

    @Override
    public String toString() {
        return "Trie{" +
                "root=" + root +
                '}';
    }

    /**
     * Initialize your data structure here. 初始化前缀树
     */
    public Trie() {
        root = new TreeNode('#');
    }

    /**
     * Inserts a word into the trie.前缀树插入一个字符串
     */
    public void insert(String word) {

        TreeNode cur = new TreeNode('#');
        cur = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            //只能用判空,因为null->false   但是可能cur.son[没有建立起来]
            if (cur.son[ch-97] !=null) {//这个字母存在 //if (cur.son[ch - 97].hasSon == true)
                    cur = cur.son[ch - 97];
            } else {
                //到这里不存在了
                while (i < word.length()) {
                    //TreeNode p =
                    cur.son[word.charAt(i) - 97] = new TreeNode(word.charAt(i));
                    //cur.hasSon = true;
                    cur = cur.son[word.charAt(i) - 97];
                    i++;
                }
            }
        }
        cur.isend=true;
    }

    /**
     * Returns if the word is in the trie.检查字符串
     */
    public boolean search(String word) {
        TreeNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (cur.son[word.charAt(i)-97]!=null){
                cur = cur.son[word.charAt(i)-97];
            }else {
                return false;
            }
        }
        //System.out.println(cur);
        if (cur.isend==true){
          return true;
        }else {
            return false;
        }
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix. 检查前缀
     */
    public boolean startsWith(String prefix) {
        TreeNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (cur.son[prefix.charAt(i)-97]!=null){
                cur = cur.son[prefix.charAt(i)-97];
            }else {
                return false;
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */