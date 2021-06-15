package ACM.tag刷题.算法.递归;

public class recursion_79单词搜索 {

    /***给定一个二维网格和一个单词，找出该单词是否存在于网格中。
     单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

     示例:
     board =
     [
     ['A','B','C','E'],
     ['S','F','C','S'],
     ['A','D','E','E']
     ]
     给定 word = "ABCCED", 返回 true
     给定 word = "SEE", 返回 true
     给定 word = "ABCB", 返回 false
     */
    //不能使用重复的,使用visited访问数组标记 35 86
    public static boolean exist(char[][] board, String word) {
        boolean flag = false;
        //创建一个一维的访问数组,意压缩空间,索引是i*board[0].length+j
        boolean visited[] = new boolean[board.length*board[0].length];//一共3*4=12长度
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)){
                    boolean newVisited[] = new boolean[board.length*board[0].length];
                    System.arraycopy(visited,0,newVisited,0,board.length*board[0].length);
                    newVisited[i*board[0].length+j]=true;
                    flag = dfs(board,word,i,j,1,newVisited);
                    if (flag)return flag;
                }

            }
        }

        return flag;
    }
    public static boolean dfs(char[][] board,String word,int row,int col,int index,boolean[] visited){//从word[1]开始上下左右匹配
        if (word.length()==index){
            return true;
        }
        boolean flag = false;
        //向右搜索:因为高概率在右能命中,先搞右j++
        if (col+1<board[0].length && board[row][col+1]==word.charAt(index) && !visited[row*board[0].length+col+1]){//col+1符合条件,不溢出&&匹配相等
            boolean newVisited[] = new boolean[board.length*board[0].length];
            System.arraycopy(visited,0,newVisited,0,board.length*board[0].length);
            newVisited[row*board[0].length+col+1]=true;
            flag = dfs(board,word,row,col+1,index+1,newVisited);
            if (flag)return flag;//剪枝
        }
        //向下搜搜i++
        if (row+1<board.length && board[row+1][col]==word.charAt(index) && !visited[(row+1)*board[0].length+col]){//col+1符合条件,不溢出&&匹配相等
            boolean newVisited[] = new boolean[board.length*board[0].length];
            System.arraycopy(visited,0,newVisited,0,board.length*board[0].length);
            newVisited[(row+1)*board[0].length+col]=true;
            flag = dfs(board,word,row+1,col,index+1,newVisited);
            if (flag)return flag;
        }
        //向上
        if (row-1>=0 && board[row-1][col]==word.charAt(index) && !visited[(row-1)*board[0].length+col]){//col+1符合条件,不溢出&&匹配相等
            boolean newVisited[] = new boolean[board.length*board[0].length];
            System.arraycopy(visited,0,newVisited,0,board.length*board[0].length);
            newVisited[(row-1)*board[0].length+col]=true;
            flag = dfs(board,word,row-1,col,index+1,newVisited);
            if (flag)return flag;
        }
        //向左
        if (col-1>=0 && board[row][col-1]==word.charAt(index) && !visited[row*board[0].length+col-1]){//col+1符合条件,不溢出&&匹配相等
            boolean newVisited[] = new boolean[board.length*board[0].length];
            System.arraycopy(visited,0,newVisited,0,board.length*board[0].length);
            newVisited[row*board[0].length+col-1]=true;
            flag = dfs(board,word,row,col-1,index+1,newVisited);
            if (flag)return flag;
        }

        return flag;
    }

    public static void main(String[] args) {
        System.out.println(exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},"ABCCE"));//t
        System.out.println(exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},"SEE"));//t
        System.out.println(exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},"ABCB"));//f  问题true 解决:不能折回去搜索
        System.out.println(exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},"ABCBg"));//f
    }
}
