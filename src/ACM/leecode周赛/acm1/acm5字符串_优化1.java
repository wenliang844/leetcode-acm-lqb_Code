package ACM.leecode周赛.acm1;

import java.util.*;

public class acm5字符串_优化1 {

    private static List<Integer> ans;

    //1.暴力解法 / 字典树+dfs /
    public static void main(String[] args) {
        //System.out.println((int)'a');
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();

        //构造字典树
        treeTrix treeTrix = new treeTrix();
        //System.out.println(treeTrix.chs[0]);

        //存在前缀是一样的情况-保存坑位前一个的cur,下次直接从cur开始
        //存在相等的情况
        treeTrix safe = treeTrix;
        for (int i = 0; i < n; i++) {
            treeTrix cur = safe;
            //System.out.println(cur);
            for (int j = i+1; j < n; j++) {
                //if (j==i)continue;
                //对这串字符构造字典树
                char c = s.charAt(j);
                if (cur.chs[c - 'a']==null){
                    cur.chs[c - 'a'] = new treeTrix();
                }
                cur=cur.chs[c - 'a'];
            }
            cur.list.add(i+1);
            if (safe.chs[s.charAt(i)-'a']==null){
                safe.chs[s.charAt(i)-'a']=new treeTrix();
            }
            safe=safe.chs[s.charAt(i)-'a'];
            while (i<n-1 && s.charAt(i+1)==s.charAt(i)){
                i++;
                cur.list.add(i+1);
                if (safe.chs[s.charAt(i)-'a']==null){
                    safe.chs[s.charAt(i)-'a']=new treeTrix();
                }
                safe=safe.chs[s.charAt(i)-'a'];
            }
            //System.out.println(cur);
            //System.out.println(treeTrix);
        }
        //System.out.println(treeTrix);
        //遍历tree  dfs//找到最近的输出到数组中
        ans = new ArrayList<>();
        dfs(treeTrix);
        for (Integer an : ans) {
            System.out.print(an+" ");
        }

    }

    private static void dfs(treeTrix treeTrix) {
        if (treeTrix.list.size()>0){
            if (treeTrix.list.size()>1){
                Collections.sort(treeTrix.list);
                for (Integer integer : treeTrix.list) {
                    ans.add(integer);
                }
            }else {
                ans.add(treeTrix.list.get(0));
            }

            return;
        }
        for (int i = 0; i < 26; i++) {
            if (treeTrix.chs[i]!=null){
                dfs(treeTrix.chs[i]);
            }
        }
    }

    static class treeTrix{
        List<Integer> list;//这也是判断end的条件
        treeTrix[] chs;

        treeTrix(){
            list = new ArrayList<>();
            chs = new treeTrix[26];
        }

        @Override
        public String toString() {
            return "treeTrix{" +
                    "list=" + list +
                    ", chs=" + Arrays.toString(chs) +
                    '}';
        }
    }

}
