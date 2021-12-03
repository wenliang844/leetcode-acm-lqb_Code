package ACM.每日一题leecode.day185;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class day206_212单词搜索II {
    public static void main(String[] args) {
        System.out.println(findWords(new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}}, new String[]{"oath", "pea", "eat", "rain"}));
//        System.out.println(findWords(new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}}, new String[]{"eat"}));
    }

    //方法一,暴力破解 n*m*m*n
    static boolean flag;

    public static List<String> findWords(char[][] board, String[] words) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            flag = false;
            for (int j = 0; j < board.length; j++) {
                if (flag){
                    break;
                }
                for (int k = 0; k < board[0].length; k++) {
                    check(board, words[i], 0, j, k);
                    if (flag) {
                        list.add(words[i]);
                        break;
                    }
                }
            }
        }
        return list;
    }

    //注意:不能吃回头草
    private static void check(char[][] board, String word, int index, int row, int col) {
        if (index >= word.length() || board[row][col] != word.charAt(index)) {
            return;
        }
        if (index == word.length() - 1) {
            flag = true;
            return;
        }
        if (row - 1 >= 0) {
            check(board, word, index + 1, row - 1, col);
        }
        if (row + 1 < board.length) {
            check(board, word, index + 1, row + 1, col);
        }
        if (col - 1 >= 0) {
            check(board, word, index + 1, row, col - 1);
        }
        if (col + 1 < board[0].length) {
            check(board, word, index + 1, row, col + 1);
        }
    }


    //leetcode参考方法: 字典树写法
    public static List<String> findWords2(char[][] board, String[] words) {
        //构建字典树
        WordTrie myTrie = new WordTrie();
        TrieNode root = myTrie.root;
        //插入数据
        for (String word : words){
            myTrie.insert(word);
        }

        //构建结果集容器
        List<String> result = new LinkedList<>();
        //矩阵行数
        int m = board.length;
        //矩阵列数
        int n = board[0].length;
        //存储该节点是否访问
        boolean[][] visited = new boolean[n][m];
        //遍历整个二维数组
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                find(board, visited, i, j, m, n, result, root);
            }
        }
        return result;
    }

    private static void find(char[][] board, boolean[][] visited, int i, int j, int m, int n, List<String> result, TrieNode cur) {
        //边界判断以及是否已经访问判断
        if (i < 0 || i >= m || j < 0 || j >= n || visited[j][i]){
            return;
        }
        //获取子节点状态，判断其是否有子节点
        cur = cur.child[board[i][j] - 'a'];
        if (cur == null) {
            return;
        }
        //修改节点状态，防止重复访问
        visited[j][i] = true;
        //找到单词加入
        if (cur.isEnd) {
            result.add(cur.val);
            //找到单词后，修改字典树内叶子节点状态为false，防止出现重复单词
            cur.isEnd = false;
        }
        find(board, visited, i + 1, j, m, n, result, cur);
        find(board, visited, i - 1, j, m, n, result, cur);
        find(board, visited, i, j + 1, m, n, result, cur);
        find(board, visited, i, j - 1, m, n, result, cur);
        //最后修改节点状态为未访问状态
        visited[j][i] = false;
    }


    /**
     * 字典树
     */
    static class WordTrie {
        //创建根节点
        TrieNode root = new TrieNode();

        void insert(String s) {
            TrieNode cur = root;
            for (char c : s.toCharArray()) {
                //判断是否存在该字符的节点，不存在则创建
                if (cur.child[c - 'a'] == null) {
                    cur.child[c - 'a'] = new TrieNode();
                    cur = cur.child[c - 'a'];
                } else{
                    cur = cur.child[c - 'a'];
                }
            }
            //遍历结束后，修改叶子节点的状态，并存储字符串
            cur.isEnd = true;
            cur.val = s;
        }
    }

    /**
     * 字典树节点
     */
    static class TrieNode {
        /**
         * 存储最后节点的字符串
         */
        String val;
        /**
         * 根据字符排序，[a,b,c,……,z]
         */
        TrieNode[] child = new TrieNode[26];
        /**
         * 是否是最后叶子节点
         */
        boolean isEnd = false;
    }
}
