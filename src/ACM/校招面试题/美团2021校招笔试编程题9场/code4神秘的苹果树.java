package ACM.校招面试题.美团2021校招笔试编程题9场;
/***
 小团找到一颗有n个节点的苹果树，以1号节点为根，且每个节点都有一个苹果，苹果都有一个颜色，
 但是这棵树被施加了咒术，这使得小团只能从某一个节点的子树中选取某一种颜色的拿。小团想要拿
 到数量最多的那种颜色的所有苹果，请帮帮她。每次她会指定一个节点t，如果小团只能从节点t的子
 树中选取某一种颜色的苹果，选取什么颜色能拿到最多的苹果？如果有多种颜色都可以拿同样多的苹果，
 输出颜色编号最小的那个对应的编号。
 节点x的子树定义为所有将x当作祖先的节点，x也视为x的子树的一部分。
 输入描述:
 第一行一个正整数n表示这颗树上节点的个数。
 接下来n-1行，每行两个正整数x­­i,yi,表示树上第i条边连接的两个节点。
 接下来一行n个正整数c­i，分别表示从1~n号节点上的苹果的颜色。
 接下来一行一个正整数q,表示接下来有q次独立的询问。
 接下来q行，每行一个正整数t表示询问：如果小团只能从节点t的子树中选取某一种颜色的苹果，
 选取什么颜色能拿到最多的苹果？如果有多种颜色都可以拿同样多的苹果，输出颜色编号最小的那个对应的编号。
 对于100%的数据n≤5000, 1≤xi,yi,t≤n, ci≤1000000000,q≤1000
 输出描述:
 输出q行，每行一个整数，表示答案。
 */

import java.util.*;

public class code4神秘的苹果树 {

    //方法一:利用树
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List> bigList = new ArrayList<>();
        Map<List, Integer> map = new HashMap<>();

        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(i);
            bigList.add(list);
        }
        System.out.println(bigList);
        for (int i = 0; i < n - 1; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            bigList.get(start - 1).add(end);
        }
        System.out.println(bigList);

        //将下一层的也都要
        for (int i = 0; i < n; i++) {
            List list = bigList.get(i);
            //System.out.println(list);
            for (Object o : list) {
                //System.out.println(o);
                bigList.get(i).addAll(bigList.get((int) o - 1));
            }
        }
        System.out.println(bigList);

    }

    //方法二:利用有向图->邻接矩阵

    public static void buildTree(Map<Integer, List<Integer>> map, Node node){

    }

    //方法三:利用树,构造树
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer,List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n-1; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            List<Integer> list = map.get(start);
            if (list==null){
                System.out.println("null");
                List<Integer> list1 = new ArrayList<>();
                list1.add(end);
                map.put(start,list);
            }else {
                list.add(end);
                map.put(start,list);
                System.out.println(map);
            }
        }
        System.out.println(map);
        //Node node = new Node();
        //buildTree(map,node);
    }

    public static void printGraph(int[][] graph){
        for (int i = 0; i < graph.length; i++) {
            System.out.println(Arrays.toString(graph[i]));
        }
    }
    //方法4:构造图  用邻接矩阵或数组 把map<下标树,color>
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //node
        int n = sc.nextInt();
        int[][] graph = new int[n][n];
        for (int i = 0; i < n-1; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            graph[start-1][end-1] = 1;
        }
        //printGraph(graph);

        //color
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int c = sc.nextInt();
            map.put(i,c);
        }
        //System.out.println(map);

        //queue
        int queueNums = sc.nextInt();
        while (queueNums-- >0){
            int queue = sc.nextInt();
            int[] color = new int[n+1];
            color[map.get(queue-1)]++;
            queue(map,color,graph,queue-1);
           // System.out.println(Arrays.toString(color));

            int max = 0;
            int index = 0;
            for (int i = 0; i < color.length; i++) {
                if (color[i]>max){
                    max = color[i];
                    index = i;
                }
            }
            System.out.println(index);
        }

    }



    private static void queue(Map<Integer, Integer> map, int[] color, int[][] graph, int queue) {
        for (int i = 0; i < graph.length; i++) {
            if (graph[queue][i]==1){
                color[map.get(i)]++;
                queue(map,color,graph,i);
            }
        }
    }

}






class Node {
    int color;
    Node left;
    Node right;
    Node(int color){
        this.color = color;
    }
}
