package ACM.每日一题leecode.day141;

import java.util.*;

public class day168_1418点菜展示表 {
    public static void main(String[] args) {
        List<List<String>> orders = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list1.add("David");
        list1.add("3");
        list1.add("Ceviche");
        List<String> list2 = new ArrayList<>();
        list2.add("Corina");
        list2.add("10");
        list2.add("Beef Burrito");
        List<String> list3 = new ArrayList<>();
        list3.add("David");
        list3.add("3");
        list3.add("Fried Chicken");
        List<String> list4 = new ArrayList<>();
        list4.add("Carla");
        list4.add("5");
        list4.add("Water");
        List<String> list5 = new ArrayList<>();
        list5.add("Carla");
        list5.add("5");
        list5.add("Ceviche");
        List<String> list6 = new ArrayList<>();
        list6.add("Rous");
        list6.add("3");
        list6.add("Ceviche");
        orders.add(list1);
        orders.add(list2);
        orders.add(list3);
        orders.add(list4);
        orders.add(list5);
        orders.add(list6);

        System.out.println(displayTable(orders));


    }

    //52/53 超内存   1 <= customerNamei.length, foodItemi.length <= 20->这是字母的长度
    public static List<List<String>> displayTable(List<List<String>> orders) {
        int[][] nums = new int[500][500];//100 52错   81/54
        Map<String, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        //map1.put("table", 0);
        int index1 = 0;
        int index2 = 0;
        for (List<String> order : orders) {
            String eat = order.get(2);
            int table = Integer.parseInt(order.get(1));
            if (!map1.containsKey(eat)) {
                map1.put(eat, index1++);
            }
            if (!map2.containsKey(table)) {
                map2.put(table, index2++);
            }
            nums[map2.get(table)][map1.get(eat)]++;

        }
        /*for (int i = 0; i < nums.length; i++) {
            System.out.println(Arrays.toString(nums[i]));
        }*/

        List<List<String>> res = new ArrayList<>();
        String[] s1 = new String[map1.size()];
        int index = 0;
        for (String s : map1.keySet()) {
            s1[index++]=s;
        }
        int[] tables = new int[map2.size()];
        index = 0;
        for (Integer integer : map2.keySet()) {
            tables[index++] = integer;
        }
        Arrays.sort(tables);
        Arrays.sort(s1);
        //System.out.println(s1);
        List<String> list = new ArrayList<>();
        list.add("Table");
        for (int i = 0; i < s1.length; i++) {
            list.add(s1[i]);
        }
        res.add(list);
        for (int i = 0; i < tables.length; i++) {
            List<String> temp = new ArrayList<>();
            temp.add(tables[i]+"");
            int row = map2.get(tables[i]);
            for (int j = 0; j < s1.length; j++) {
                temp.add(nums[row][map1.get(s1[j])]+"");
            }
            res.add(temp);
        }

        return res;
    }
}
