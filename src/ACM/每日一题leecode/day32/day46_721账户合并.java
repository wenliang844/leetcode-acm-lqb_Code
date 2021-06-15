package ACM.每日一题leecode.day32;

import java.util.*;
import java.util.stream.Collectors;

/***
 给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其余元素是 emails 表示该账户的邮箱地址。

 现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。请注意，即使两个账户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。

 合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是按顺序排列的邮箱地址。账户本身可以以任意顺序返回。


  

 示例 1：

 输入：
 accounts = [["John", "johnsmith@mail.com", "john00@mail.com"},{"John", "johnnybravo@mail.com"},{"John", "johnsmith@mail.com", "john_newyork@mail.com"},{"Mary", "mary@mail.com"]]
 输出：
 [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"},{"Mary", "mary@mail.com"]]
 解释：
 第一个和第三个 John 是同一个人，因为他们有共同的邮箱地址 "johnsmith@mail.com"。
 第二个 John 和 Mary 是不同的人，因为他们的邮箱地址没有被其他帐户使用。
 可以以任何顺序返回这些列表，例如答案 [['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com']，
 ['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']] 也是正确的

 */
public class day46_721账户合并 {
    public static void test1() {
        String[][] ss = {{"John", "johnsmith@mail.com", "john00@mail.com"}, {"John", "johnnybravo@mail.com"}, {"John", "johnsmith@mail.com", "john_newyork@mail.com"}, {"Mary", "mary@mail.com"}};
        List<List<String>> accounts = new ArrayList<>();
        for (int i = 0; i < ss.length; i++) {
            List<String> list = new ArrayList<String>();
            for (int j = 0; j < ss[i].length; j++) {
                list.add(ss[i][j]);
            }
            accounts.add(list);
        }


        System.out.println("合并前=" + accounts);
        accountsMerge2(accounts);
        System.out.println("合并后=" + accounts);
    }

    public static void test2() {
        String[][] ss = {{"Gabe", "Gabe0@m.co", "Gabe3@m.co", "Gabe1@m.co"}, {"Kevin", "Kevin3@m.co", "Kevin5@m.co", "Kevin0@m.co"}, {"Ethan", "Ethan5@m.co", "Ethan4@m.co", "Ethan0@m.co"}, {"Hanzo", "Hanzo3@m.co", "Hanzo1@m.co", "Hanzo0@m.co"}, {"Fern", "Fern5@m.co", "Fern1@m.co", "Fern0@m.co"}};
        List<List<String>> accounts = new ArrayList<>();
        for (int i = 0; i < ss.length; i++) {
            List<String> list = new ArrayList<String>();
            for (int j = 0; j < ss[i].length; j++) {
                list.add(ss[i][j]);
            }
            accounts.add(list);
        }

        for (int i = 0; i < accounts.size(); i++) {
            Collections.sort(accounts.get(i));
        }
        System.out.println("合并前=" + accounts);
        accountsMerge2(accounts);
        System.out.println("合并后=" + accounts);
    }

    public static void test3() {
        String[][] ss = {{"Alex", "Alex5@m.co", "Alex4@m.co", "Alex0@m.co"}, {"Ethan", "Ethan3@m.co", "Ethan3@m.co", "Ethan0@m.co"}, {"Kevin", "Kevin4@m.co", "Kevin2@m.co", "Kevin2@m.co"}, {"Gabe", "Gabe0@m.co", "Gabe3@m.co", "Gabe2@m.co"}, {"Gabe", "Gabe3@m.co", "Gabe4@m.co", "Gabe2@m.co"}};
        List<List<String>> accounts = new ArrayList<>();
        for (int i = 0; i < ss.length; i++) {
            List<String> list = new ArrayList<String>();
            for (int j = 0; j < ss[i].length; j++) {
                list.add(ss[i][j]);
            }
            accounts.add(list);
        }

       /* for (int i = 0; i < accounts.size(); i++) {
            Collections.sort(accounts.get(i));
        }*/
        System.out.println("合并前=" + accounts);
        accountsMerge3(accounts);
        System.out.println("合并后=" + accounts);
    }
    public static void test4() {
        String[][] ss = {{"Alex","Alex5@m.co","Alex4@m.co","Alex0@m.co"},{"Ethan","Ethan3@m.co","Ethan3@m.co","Ethan0@m.co"},{"Kevin","Kevin4@m.co","Kevin2@m.co","Kevin2@m.co"},{"Gabe","Gabe0@m.co","Gabe3@m.co","Gabe2@m.co"},{"Gabe","Gabe3@m.co","Gabe4@m.co","Gabe2@m.co"}};
        List<List<String>> accounts = new ArrayList<>();
        for (int i = 0; i < ss.length; i++) {
            List<String> list = new ArrayList<String>();
            for (int j = 0; j < ss[i].length; j++) {
                list.add(ss[i][j]);
            }
            accounts.add(list);
        }

       /* for (int i = 0; i < accounts.size(); i++) {
            Collections.sort(accounts.get(i));
        }*/
        System.out.println("合并前=" + accounts);
        accounts = accountsMerge3(accounts);
        System.out.println("合并后=" + accounts);
    }
    public static void test5() {
        String[][] ss = {{"David","David0@m.co","David1@m.co"},{"David","David3@m.co","David4@m.co"},{"David","David4@m.co","David5@m.co"},{"David","David2@m.co","David3@m.co"},{"David","David1@m.co","David2@m.co"}};
        List<List<String>> accounts = new ArrayList<>();
        for (int i = 0; i < ss.length; i++) {
            List<String> list = new ArrayList<String>();
            for (int j = 0; j < ss[i].length; j++) {
                list.add(ss[i][j]);
            }
            accounts.add(list);
        }

       /* for (int i = 0; i < accounts.size(); i++) {
            Collections.sort(accounts.get(i));
        }*/
        System.out.println("合并前=" + accounts);
        accounts = accountsMerge6(accounts);
        System.out.println("合并后=" + accounts);
    }


    public static void main(String[] args) {
        //test1();
        //test02();
        //test3();
        //test4();
        test5();
    }

    //暴力遍历
    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        for (int i = 0; i < accounts.size() - 1; i++) {
            for (int j = i + 1; j < accounts.size(); j++) {

                for (int k = 1; k < accounts.get(i).size(); k++) {
                    for (int l = 1; l < accounts.get(j).size(); l++) {
                        if (accounts.get(i).get(k).equals(accounts.get(j).get(l))) {
                            System.out.println(accounts.get(i).get(k) + "===" + accounts.get(j).get(l));
                            //就merge
                            List<String> s = accounts.get(j);
                            accounts.remove(j);
                            for (int m = 1; m < s.size(); m++) {
                                accounts.get(i).add(s.get(m));
                            }
                            break;
                        }
                    }
                }
            }
        }


        return accounts;
    }

    //优化使用set  存储
    public static List<List<String>> accountsMerge2(List<List<String>> accounts) {
        List<String> myList = accounts.get(0).stream().distinct().collect(Collectors.toList());

        for (int i = 0; i < accounts.size() - 1; i++) {
            for (int j = i + 1; j < accounts.size(); j++) {


                for (int k = 1; k < accounts.get(i).size(); k++) {
                    for (int l = 1; j < accounts.size() && l < accounts.get(j).size(); l++) {
                        if (accounts.get(i).get(k).equals(accounts.get(j).get(l))) {
                            // System.out.println(accounts.get(i).get(k) + "===" + accounts.get(j).get(l));
                            //就merge
                            List<String> s1 = accounts.get(i);
                            List<String> s2 = accounts.get(j);
                            //System.out.println("这是要删除的i j"+i+"-"+j+"--"+accounts.get(i)+"--"+accounts.get(j));
                            accounts.remove(s1);
                            accounts.remove(s2);
                            //System.out.println("这是删除之后的accounts======="+accounts);
                            //Set<String> set = new LinkedHashSet<>();
                            // set.addAll(s1);
                            //set.addAll(s2);
                            //System.out.println("这是set"+set);
                            List<String> list1 = merge(s1, s2);
                            /*for (String s : set) {
                                list1.add(s);
                            }*/
                            accounts.add(list1);
                            //System.out.println("这是现在的account="+accounts);
                            break;
                        }
                    }
                }
            }
        }


        for (int i = 0; i < accounts.size(); i++) {
            Collections.sort(accounts.get(i));
        }
        return accounts;
    } //优化使用set  存储

    private static List<String> merge(List<String> s1, List<String> s2) {
        List<String> list = new ArrayList<>();
        list.add(s2.get(0));
        list.add(s2.get(1));
        //比较两个字符串的字典序
        for (int i = 1; i < s2.size(); i++) {
            for (int j = 1; j < list.size(); j++) {
                if (s2.get(i).equals(list.get(j))) {
                    break;
                }
                //如果s2.get(i) 的字典序比 s1的小      就插入
                if (zidianxu(s2.get(i), list.get(j))) {
                    list.add(j, s2.get(i));

                    break;
                } else if (j >= list.size() - 1) {
                    list.add(s2.get(i));
                }

            }
        }

        // System.out.println("合并s2zhihou de list="+list);
        for (int i = 1; i < s1.size(); i++) {
            for (int j = 1; j < list.size(); j++) {
                if (s1.get(i).equals(list.get(j))) {
                    break;
                }
                //如果s2.get(i) 的字典序比 s1的小      就插入
                if (zidianxu(s1.get(i), list.get(j))) {
                    list.add(j, s1.get(i));
                    break;
                } else if (j >= list.size() - 1) {
                    list.add(s1.get(i));
                }
            }
        }


        return list;
    }

    private static boolean zidianxu(String s, String s1) {
        for (int i = 0; i < s.length(); ) {
            for (int j = 0; j < s1.length(); ) {
                if (s.charAt(i) < s1.charAt(j)) {
                    return true;
                } else if (s.charAt(i) > s1.charAt(j)) {
                    return false;
                }
                i++;
                j++;
            }
        }
        return false;
    }


    //优化: 思路  将每个list相同的进行合并      然后一起进行去重;排序
    public static List<List<String>> accountsMerge3(List<List<String>> accounts) {
        //List<String> myList = accounts.get(0).stream().distinct().collect(Collectors.toList());

        for (int i = 0; i < accounts.size() - 1; i++) {
            for (int j = i + 1; j < accounts.size(); j++) {

                for (int k = 1; k < accounts.get(i).size(); k++) {
                    for (int l = 1; j < accounts.size() && l < accounts.get(j).size(); l++) {
                        if (accounts.get(i).get(k).equals(accounts.get(j).get(l))) {
                            //List<String> s1 = accounts.get(i);
                            List<String> s2 = accounts.get(j);
                            //accounts.remove(s1);
                            accounts.remove(s2);
                            accounts.get(i).addAll(s2);

                            break;
                        }
                    }
                }
            }
        }

        //排序
        for (int i = 0; i < accounts.size(); i++) {
            Collections.sort(accounts.get(i));
        }

        //去重复
        for (List<String> account : accounts) {
            for (int i = 0; i < account.size()-1;) {
                if (account.get(i).equals(account.get(i+1))){
                    account.remove(i+1);
                }else{
                    i++;
                }
            }
        }

        return accounts;
    }//优化: 思路  将每个list相同的进行合并      然后一起进行去重;排序

    //优化:思路:合并后的list放在后面去,防止有扫描匹配不到的情况   ---   43 / 49 个通过测试用例
    public static List<List<String>> accountsMerge4(List<List<String>> accounts) {
        //List<String> myList = accounts.get(0).stream().distinct().collect(Collectors.toList());
        boolean flag = false;
        for (int i = 0; i < accounts.size() - 1;) {
            for (int j = i + 1; j < accounts.size(); j++) {

                for (int k = 1; k < accounts.get(i).size(); k++) {
                    for (int l = 1; j < accounts.size() && l < accounts.get(j).size(); l++) {
                        if (accounts.get(i).get(k).equals(accounts.get(j).get(l))) {
                            //List<String> s1 = accounts.get(i);
                            List<String> s2 = accounts.get(j);
                            //accounts.remove(s1);
                            accounts.remove(s2);
                            accounts.get(i).addAll(s2);
                            flag = true;
                            break;
                        }

                    }

                    if (flag){
                        break;
                    }
                }
               /* if (flag){
                    j=i+1;
                }*/

            }

            if(!flag){
                i++;
            }
            flag=false;
        }

        //排序
        for (int i = 0; i < accounts.size(); i++) {
            Collections.sort(accounts.get(i));
        }

        //去重复
        for (List<String> account : accounts) {
            for (int i = 0; i < account.size()-1;) {
                if (account.get(i).equals(account.get(i+1))){
                    account.remove(i+1);
                }else{
                    i++;
                }
            }
        }

        return accounts;
    }

    //并查集
    public static List<List<String>> accountsMerge5(List<List<String>> accounts) {
        /***
         思路:并查集:
         union
         find
         */
        /***
         直接使用一个hashSet也可以呀
         hashset<"1@David" , "David">
         hashset<"2@David" , "David">

         hashsET<"david" , list<"1","2">>
         */
        //1.将list中的邮箱进行合并
        Map<String,String> map = new HashMap<>();
        List<List<String>> newList = new ArrayList<>();

        boolean flag = false;
        for (List<String> account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                if (map.get(account.get(i)) != null){//找到了有相同邮箱的人
                    flag = true;

                    for (int j = 0; j < newList.size(); j++) {
                        if (newList.get(j).contains(account.get(i))){
                            newList.get(j).addAll(account);
                        }
                    }
                    break;
                }else {
                    map.put(account.get(i),account.get(0));
                }
            }
            if (!flag){
                newList.add(account);

            }
            flag = false;
        }
        //排序
        for (int i = 0; i < newList.size(); i++) {
            Collections.sort(newList.get(i));
        }

        //去重复
        for (List<String> account : newList) {
            for (int i = 0; i < account.size()-1;) {
                if (account.get(i).equals(account.get(i+1))){
                    account.remove(i+1);
                }else{
                    i++;
                }
            }
        }
        return newList;
    }

    //并查集实现
    public static List<List<String>> accountsMerge6(List<List<String>> accounts){
        Map<String,Integer> emailIndex = new HashMap<>();
        Map<String,String> emailName = new HashMap<>();
        int emailsCount = 0;
        for (List<String> account : accounts) {
            String name = account.get(0);
            int size = account.size();
            for (int i = 1; i < size; i++) {
                String email = account.get(i);
                if (!emailIndex.containsKey(email)){
                    emailIndex.put(email,emailsCount++);
                    emailName.put(email,name);
                }
            }
        }

        System.out.println(emailsCount);
        System.out.println(emailIndex);
        System.out.println(emailName);

        UnionFind uf = new UnionFind(emailsCount);
        for (List<String> account : accounts) {
            String firstEmail = account.get(1);
            Integer firstIndex = emailIndex.get(firstEmail);
            int size = account.size();
            for (int i = 2; i < size; i++) {
                String nextEmail = account.get(i);
                int nextIndex = emailIndex.get(nextEmail);
                uf.union(firstIndex,nextIndex);
            }
        }

        HashMap<Integer, List<String>> indexToEmail = new HashMap<>();
        for (String email : emailIndex.keySet()) {
            int index = uf.find(emailIndex.get(email));
            List<String> account = indexToEmail.getOrDefault(index, new ArrayList<String>());
            account.add(email);
            indexToEmail.put(index,account);
        }

        List<List<String>> merged = new ArrayList<List<String>>();
        for (List<String> emails : indexToEmail.values()) {
            Collections.sort(emails);
            String name = emailName.get(emails.get(0));
            List<String> account = new ArrayList<String>();
            account.add(name);
            account.addAll(emails);
            merged.add(account);
        }
        return merged;


//        return accounts;
    }

    static class UnionFind {
        int[] parent;

        public UnionFind(int n){
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void union(int index1,int index2){
            parent[find(index2)] = find(index1);
        }

        private int find(int index) {
            if (parent[index] != index){//路径压缩
                parent[index] = find(parent[index]);
            }
            return parent[index];
        }
    }

}
