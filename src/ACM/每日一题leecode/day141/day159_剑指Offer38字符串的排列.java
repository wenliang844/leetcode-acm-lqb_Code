package ACM.每日一题leecode.day141;

import java.util.*;

public class day159_剑指Offer38字符串的排列 {

    private static List<String> list;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(permutation("dkjphedy")));
    }

    //方法一:全排列在去重  递归,每次从字母中删除一个字母到s中,结束加入list map去重
    public static String[] permutation(String s) {
        list = new ArrayList<String>();
        dfs("",s);
        //对list进行去重操作
        List<String> list_res = new ArrayList<>();
        for (String temp : list) {
            if (!list_res.contains(temp)){
                //System.out.println(temp);
                list_res.add(temp);
            }
        }
        String[] res = new String[list_res.size()];
        //System.out.println(list_res.size());
        //System.out.println(list.size());
        //System.out.println(res.length);
        for (int i = 0; i < res.length; i++) {
            //System.out.println(res[i]);
            res[i]=list_res.get(i);
        }
        return res;
    }

    //采用树形选择 : 采用交换
    private static void dfs(String res, String s) {
        if (s.length()==1){
            list.add(res+s);
        }
        for (int i = 0; i < s.length(); i++) {
            dfs(res+s.substring(i,i+1),s.substring(0,i)+s.substring(i+1,s.length()));
        }
    }
}
