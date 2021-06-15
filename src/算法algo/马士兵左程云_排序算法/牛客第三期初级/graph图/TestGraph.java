package 算法algo.马士兵左程云_排序算法.牛客第三期初级.graph图;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class TestGraph {
    /***matrix
     边权 from to
     [7 ,1 ,2]

     */
    public static void TestGraph(int[][] matrix){
        Graph graph = new Graph();
        for (int i = 0; i < matrix.length; i++) {
            Integer weight = matrix[i][0];
            Integer from = matrix[i][1];
            Integer to = matrix[i][2];
            if (!graph.nodes.containsKey(from)){
                graph.nodes.put(from,new Node(from));
            } if (!graph.nodes.containsKey(to)){
                graph.nodes.put(to,new Node(to));
            }

            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge newEdge = new Edge(weight,fromNode,toNode);//生成边
            fromNode.nexts.add(toNode);//from指向to
            fromNode.out++; //from边集++
            toNode.in++;//to的
            fromNode.edges.add(newEdge);
            graph.edges.add(newEdge);
        }
    }
    public static void main(String[] args) {

    }


}

class Graph {
    HashMap<Integer, Node> nodes;
    HashSet<Edge> edges;

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}

class Node {
    public int value;
    int in; //入度
    int out; //出度
    ArrayList<Node> nexts; //我是from的时候next集合有多少
    ArrayList<Edge> edges; //边集合

    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<Edge>();
    }
}

class Edge {
    int weight;
    Node from;
    Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}