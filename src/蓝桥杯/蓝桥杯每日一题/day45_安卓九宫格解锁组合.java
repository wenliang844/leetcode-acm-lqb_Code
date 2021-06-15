package 蓝桥杯.蓝桥杯每日一题;

import java.util.*;

public class day45_安卓九宫格解锁组合 {
    /***
     1.不能重复点
     2.不能跨过未使用的点
     */
    public static void BFS(int n, int k,StringBuilder cur,int depth, int x,ArrayList<String> res){
        if(depth == k){
            res.add(new String(cur));
            return;
        }
        for(int i=1;i<=n;i++){
            if(cur.indexOf(String.valueOf(i)) >=0) continue;
            cur.append(i);
            BFS(n,k,cur,depth+1,i,res);
            cur.deleteCharAt(cur.length()-1);
        }
    }

    public static ArrayList<String> permutation(int n,int k){
        ArrayList<String> res = new ArrayList<String>();
        for(int i =1;i<=n;i++){
            StringBuilder temp= new StringBuilder();
            temp.append(i);
            BFS(n,k,temp,1,i,res);
        }
        return res;
    }

    public static int counts(){
        HashMap<String,String> map = new HashMap<String,String>();
        ArrayList<String> permute = new ArrayList<String>();
        for(int i=4;i<=9;i++){
            permute.addAll(permutation(9,i));
        }
        System.out.println(permute.size());
        map.put("13", "2");
        map.put("46", "5");
        map.put("79", "8");
        map.put("17", "4");
        map.put("28", "5");
        map.put("39", "6");
        map.put("19", "5");
        map.put("37", "5");

        map.put("31", "2");
        map.put("64", "5");
        map.put("97", "8");
        map.put("71", "4");
        map.put("82", "5");
        map.put("93", "6");
        map.put("91", "5");
        map.put("73", "5");
        int count = permute.size();

        for(String cur :permute){
            for (Map.Entry<String, String> entry : map.entrySet()){
                String key = entry.getKey();
                String value = entry.getValue();
                if(cur.contains(key) && (cur.indexOf(value) == -1 || cur.indexOf(value) > cur.indexOf(key)) ){
                    count--;
                    break;
                }
            }

        }

        return count;
    }

    public static void main(String[] args) {
        int res = counts();
        System.out.println(res);
    }
}
