package ACM.校招面试题.美团2021校招笔试编程题9场;

import java.util.*;

public class code4参考网络 {

        public static void main(String[] args){
            Scanner scanner = new Scanner(System.in);
            int TreeSize = scanner.nextInt();
            Map<Integer, List<Integer>> map = new HashMap<>();
            for(int i=0;i<TreeSize-1;i++){
                int father = scanner.nextInt();
                int son = scanner.nextInt();
                List<Integer> fatherList = map.getOrDefault(father,new ArrayList<Integer>());
                List<Integer> sonList =map.getOrDefault(son,new ArrayList<Integer>());
                fatherList.add(son);
                sonList.add(father);
                map.put(father,fatherList);
                map.put(son,sonList);
            }
            modify(1,map);  //root是1 这是已知条件
            //对map里面的元素进行modyfy 使得它只能含有指向儿子的有向图

            //开始通过map 进行dfs遍历 并统计 数量

            //1.查字典  id 对应的 颜色
            Map<Integer,Integer> dictionary = new HashMap<>();
            Map<Integer,Integer> counter = new TreeMap<>();//计数器
            for(int i=0;i<TreeSize;i++){
                int color  = scanner.nextInt();
                dictionary.put(i+1,color);

            }
            int time = scanner.nextInt();
            for(int i=0;i<time;i++){
                int root = scanner.nextInt();
                Dfs(root,dictionary,counter,map);
                List<Integer>  list =new ArrayList<>(counter.values());
                Collections.sort(list);
                //现在想知道 list.szie-1 这个数量的key
                for(Map.Entry entry: counter.entrySet()){
                    if(entry.getValue() == list.get(list.size()-1)){
                        System.out.println(entry.getKey());
                        break;
                    }
                }
                //清空counter
                counter.clear();
            }

        }

        public static void Dfs(int root,Map<Integer,Integer>  dictionary,Map<Integer,Integer>  counter,Map<Integer,List<Integer>> map){
            //1.把root的color加入
            int color = dictionary.get(root);
            counter.put(color,counter.getOrDefault(color,0)+1);
            for(int child: map.get(root)){
                Dfs(child,dictionary,counter,map);
            }
        }

        public static void  modify(Integer root, Map<Integer,List<Integer>> map){
            List<Integer> fatherList =  map.get(root);
            if(fatherList.size()==0){
                return;//递归的终点
            }
            for(Integer child:fatherList){
                List<Integer> children = map.get(child);
                children.remove(root);
                //删除child为键的 邻接数组里面是root的部分
                map.put(child,children);
                modify(child,map);
            }
        }


}
