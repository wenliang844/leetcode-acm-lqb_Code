package ACM.其他的算法比赛.笔试.同花顺;

import java.util.*;

public class ths找出全部大于指定长度的公共子串 {
    public static void main(String[] args) {
        System.out.println(exactAllCommonSeq("asdf", "sdghsdf",3));
        System.out.println(exactAllCommonSeq("我爱你，中国", "我爱你，我是中国人",3));
    }

    public static List<String> getAllCommonSubStrings1(String str1, String str2) {
        //TODO null check.

        String longString = str1;
        String shortString = str2;
        if(str1.length() < str2.length()){
            longString = str2;
            shortString = str1;
        }

        List<String> result = new ArrayList<String>();
        List<String> vacancy = new ArrayList<String>();
        vacancy.add("");

        List<String> list1 = Arrays.asList(shortString.split(""));
        List<String> list2 = Arrays.asList(longString.split(""));

        result.addAll(list1);
        result.retainAll(list2);
        result.removeAll(vacancy);

        List<String> commonSubStrings = new ArrayList<String>();
        StringBuffer strBuf = new StringBuffer();

        for(int i = 0; i < result.size()-1; i++){
            strBuf = strBuf.append(result.get(i));
            if(shortString.contains(strBuf + result.get(i+1))
                    && longString.contains(strBuf + result.get(i+1))
                    && i < result.size()-2){
                continue;
            }else{
                commonSubStrings.add(strBuf.toString());
                strBuf = new StringBuffer();
            }
        }
        String tail = commonSubStrings.get(commonSubStrings.size()-1)+ result.get(result.size()-1);
        if(shortString.contains(tail)
                && longString.contains(tail)){
            commonSubStrings.set(commonSubStrings.size()-1, tail);
        }else{
            commonSubStrings.add(result.get(result.size()-1));
        }

        return commonSubStrings;
    }
    public static List<String> getAllCommonSubStrings2(String str1, String str2,int minLen) {
        //TODO null check.

        String longString = str1;
        String shortString = str2;
        if(str1.length() < str2.length()){
            longString = str2;
            shortString = str1;
        }

        List<String> result = new ArrayList<String>();
        List<String> vacancy = new ArrayList<String>();
        vacancy.add("");

        List<String> list1 = Arrays.asList(shortString.split(""));
        List<String> list2 = Arrays.asList(longString.split(""));

        result.addAll(list1);
        result.retainAll(list2);
        result.removeAll(vacancy);

        List<String> commonSubStrings = new ArrayList<String>();
        StringBuffer strBuf = new StringBuffer();

        for(int i = 0; i < result.size()-1; i++){
            strBuf = strBuf.append(result.get(i));
            if(shortString.contains(strBuf + result.get(i+1))
                    && longString.contains(strBuf + result.get(i+1))
                    && i < result.size()-2 ){
                continue;
            }else{
                commonSubStrings.add(strBuf.toString());
                strBuf = new StringBuffer();
            }
        }
        String tail = commonSubStrings.get(commonSubStrings.size()-1)+ result.get(result.size()-1);
        if(shortString.contains(tail)
                && longString.contains(tail)){
            commonSubStrings.set(commonSubStrings.size()-1, tail);
        }else{
            commonSubStrings.add(result.get(result.size()-1));
        }

        return commonSubStrings;
    }
    /**
     * 求取两个字段所有的子序列
     * @param inputA
     * @param inputB
     * @return
     */
    public static List<String> exactAllCommonSeq(String inputA, String inputB,int minLen) {
        //把字符串转成字符数组
        char[] arr1 = inputA.toCharArray();
        char[] arr2 = inputB.toCharArray();
        // 把两个字符串分别以行和列组成一个二维矩阵
        int[][] temp = new int[arr1.length][arr2.length];
        //初始化二维矩阵中的第一行
        for (int i = 0; i < arr2.length; i++) {
            temp[0][i] = (arr1[0] == arr2[i]) ? 1 : 0;
        }
        //初始化二维矩阵中的第一列
        for (int j = 0; j < arr1.length; j++) {
            temp[j][0] = (arr2[0] == arr1[j]) ? 1 : 0;
        }
        //嵌套for循环：比较二维矩阵中每个点对应行列字符中否相等，相等的话值设置为1，否则设置为0
        for (int i = 1; i < arr1.length; i++) {
            for (int j = 1; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    //对角线上一个值加1，方便求取每个公共子序列的长度
                    temp[i][j] = temp[i - 1][j - 1] + 1;
                } else {
                    temp[i][j] = 0;
                }
            }
        }

        List<Map<String, Integer>> list = new ArrayList<>();
        //依次遍历对角矩阵的对角线
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                Map<String, Integer> map = new HashMap<>();
                if (temp[i][j] != 0 && temp[i][j] != 1) {
                    if (temp[i - 1][j - 1] == temp[i][j] - 1) {
                        if (i - 1 > 0 && j - 1 > 0 && i + 1 < arr1.length && j + 1 < arr2.length && temp[i - 1][j - 1] != 0 && temp[i + 1][j + 1] == 0) {
                            map.put("row", i);
                            map.put("column", j);
                            map.put("length", temp[i][j]);
                            list.add(map);
                        } else if ((i + 1 == arr1.length || j + 1 == arr2.length)) {
                            map.put("row", i);
                            map.put("column", j);
                            map.put("length", temp[i][j]);
                            list.add(map);
                        }
                    }
                }
            }
        }

        List<String> resultList = new ArrayList<>();
        if (!list.isEmpty()) {
            for (Map<String, Integer> map : list) {
                String s = getsubString(inputA, map.get("row"), map.get("length"));
                if (s.length()>=minLen){
                    resultList.add(s);
                }

            }
        }
        return resultList;
    }

    /**
     * 根据坐标位置及子串长度获取子串内容
     * @param s
     * @param a
     * @param b
     * @return
     */
    public static String getsubString(String s, int a, int b) {
        String s1 ;
        s1 = s.substring(a - b + 1, a + 1);
        return s1;
    }
}
