package 蓝桥杯.蓝桥杯每日一题;

import java.util.*;

public class day42_会议中心 {
    /***
     　销售主管为了公平起见，决定按照如下的程序来确定选择何种租借策略：首先，将租借给客户数量最多的策略作为候选，将所有的公司按照他们发出请求的顺序编号。对于候选策略，将策略中的每家公司的编号按升序排列。最后，选出其中字典序最小[1]的候选策略作为最终的策略。
     　　例中，会堂最终将被租借给公司1和公司3：3个候选策略是{(1,3),(2,3),(1,4)}。而在字典序中(1,3)<(1,4)<(2,3)。
     　　你的任务是帮助销售主管确定应该将会堂租借给哪些公司。
     输入格式
     　　输入的第一行有一个整数N，表示发出租借会堂申请的公司的个数。第2到第N+1行每行有2个整数。第i+1行的整数表示第i家公司申请租借的起始和终止日期。对于每个公司的申请，起始日期为不小于1的整数，终止日期为不大于109的整数。
     输出格式
     　　输出的第一行应有一个整数M，表示最多可以租借给多少家公司。第二行应列出M个数，表示最终将会堂租借给哪些公司。
     数据规模和约定
     　　对于50%的输入，N≤3000。在所有输入中，N≤200000。
     样例输入
     4
     4 9
     9 11
     13 19
     10 17
     样例输出
     2
     1 3

     [1] 字典序指在字典中排列的顺序，如果序列l1是序列l2的前缀，或者对于l1和l2的第一个不同位置j，l1[j]<l2[j]，则l1比l2小。
     */
    //方法一:动态规划,每次选和不选两种状态,选择最优
    //dp[i][j] = max(dp[i-1][j],dp[i][j-1])+dp[i][j]
    public static void maxBlock(int[][] blocks){
        //利用一个map数组存储区间对应的序号
        Map<String,Integer> map = new HashMap<>();
        int step = 1;
        for (int[] block : blocks) {
            map.put(block[0]+""+block[1],step++);
        }

        //把block[][]按照这个区间第一个进行排序 4_9 9_11 10_17 13_19
        Arrays.sort(blocks,new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return ints[0] - t1[0];
            }
        });
        for (int i = 0; i < blocks.length; i++) {
            System.out.println(Arrays.toString(blocks[i]));
        }

        //进行动态规划,dp的数据结构选择 存储4-9 13-19
        ArrayList<Integer> get = new ArrayList<>();
        ArrayList<Integer> noget = new ArrayList<>();
        get.add(blocks[0][0]);
        get.add(blocks[0][1]);

        for (int i = 1; i < blocks.length; i++) {
            System.out.println("这是get"+get+"这是noget"+noget);
            ArrayList<Integer> compareList = myCompare(get, noget,map);
            //需要做一个限制,当getlist里面的最后一个元素小于block[i][0]就是不交叉的时候才可以拿
            if (get.size()<1 || get.get(get.size()-1) < blocks[i][0]){

                get.add(blocks[i][0]);
                get.add(blocks[i][1]);
            }
            if (noget.size()<1 || noget.get(noget.size()-1) < blocks[i][0]){
                noget.add(blocks[i][0]);
                noget.add(blocks[i][1]);
            }

            get = myCompare(get,noget,map);
            noget.clear();
            noget.addAll(compareList);
        }

        ArrayList<Integer> result = myCompare(get, noget, map);
        System.out.println(result);
        System.out.println("这是他们对应的序号=----------");
        for (int i = 0; i < result.size(); i+=2) {
            System.out.println(map.get(result.get(i) + "" + result.get(i + 1)));
        }

    }

    //比较两个list最优的方法,谁长选谁,请求的顺序的字典序,谁字典序小谁map有序号
    public static ArrayList<Integer> myCompare(ArrayList<Integer> list1,ArrayList<Integer> list2,Map<String,Integer> map){
        ArrayList<Integer> res = new ArrayList<>();
        if (list1==null)return list2;
        if (list2==null)return list1;
        if (list1.size() == list2.size()){//利用list1 01 23的map对应的序号进行选择
            int step = 0;
            boolean flag = true;
            while (step<list1.size()){
                Integer order1 = map.get(list1.get(step) + "" + list1.get(step + 1));
                Integer order2 = map.get(list2.get(step) + "" + list2.get(step + 1));
                if (order1<order2){
                    res.addAll(list1);
                    flag = false;
                    break;
                }else if (order1>order2){
                    res.addAll(list2);
                    flag = false;
                    break;
                }
                step+=2;
            }
            //当size相等,而里面的数也相等的时候,随意一个就可以了
            if (flag){
                res.addAll(list1);
            }
        }else {
            res.addAll(list1.size()>list2.size()?list1:list2);
        }
        return res;
    }

    //方法二:结合区间合并,对交接处的 包含,相交,相离的各种情况进行一个讨论.分类

    public static void main(String[] args) {
        maxBlock(new int[][]{{4,9},{9,11},{13,19},{10,17}});
    }
}
