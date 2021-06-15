package ACM.其他的算法比赛.笔试.阿里.code1密码组合;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Main {

    /***
     1.去重
     2.
     * @param args
     */
    //1个数字,两个字母组合
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //int m = sc.nextInt();
        //int n = sc.nextInt();
        //char[] chs = new char[n];

        int m = 4;
        int n = 5;
        char[] chs = {'n','k','6','9','k'};
        Arrays.sort(chs);
        StringBuilder sChs = new StringBuilder();
        StringBuilder sNums = new StringBuilder();
        //System.out.println(chs);

        for (int i = 0; i < chs.length; i++) {
            if (chs[i]>='0' && chs[i]<='9'){
                sNums.append(chs[i]);
            }else {
                sChs.append(chs[i]);
            }
        }

        List<String> listNums = new ArrayList<>();
        List<String> listChs = new ArrayList<>();

        listNums.add(sNums.charAt(0)+"");
        for (int i = 1; i < sNums.length(); i++) {
            List<String> list = new ArrayList<>();
            for (String listNum : listNums) {
                list.add(listNum+sNums.charAt(i));
            }
            listNums.addAll(list);
            listNums.add(sNums.charAt(i)+"");
        }
        //System.out.println(listNums);

        listChs.add(sChs.charAt(0)+"");
        for (int i = 1; i < sChs.length(); i++) {
            List<String> list = new ArrayList<>();
            for (String listCh : listChs) {
                list.add(listCh + sChs.charAt(i));
            }
            listChs.addAll(list);
            listChs.add(sChs.charAt(i)+"");
        }
        //System.out.println(listChs);

        //System.out.println(sNums.toString());
        //System.out.println(sChs.toString());

       /* for (int i = 1; i <= m-2; i++) {//数字的可选长度   字母的可选长度是m-i   数字字母分类
            //从num里面选一个

            //从chs里面选两个
        }*/
       //组合全部的数字  字母
        //将其中数字>1  字母>2   总=3 print
        for (String listNum : listNums) {
            for (String listCh : listChs) {
                if (listNum.length()>=1 && listCh.length()>=2 && listCh.length()+listNum.length()==3){
                    System.out.println(listNum+listCh);
                }
            }
        }


    }
}
