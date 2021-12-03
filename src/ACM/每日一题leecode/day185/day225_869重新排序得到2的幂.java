package ACM.每日一题leecode.day185;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class day225_869重新排序得到2的幂 {
    public static void main(String[] args) {

        System.out.println(reorderedPowerOf2(1));//true
        System.out.println(reorderedPowerOf2(10));
        System.out.println(reorderedPowerOf2(16));//true
        System.out.println(reorderedPowerOf2(24));
        System.out.println(reorderedPowerOf2(46));//true
    }

    //用2一直幂,直到大于最大值 从大到小排序   31|9
    public static boolean reorderedPowerOf2(int n) {
        String s = getString(n);
        System.out.println("--------------"+s);
        n=Integer.parseInt(s);
        int target = 1;
        while (target<=n){
            String ts = getString(target);
            System.out.println("------"+ts);
            if (ts.equals(s)){
                return true;
            }
            target *=2;
        }
        return false;
    }

    public static String getString(int n) {
        List<Integer> list = new ArrayList<>();
        while (n>0){
            list.add(n%10);
            n=n/10;
        }
        Collections.sort(list);
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer integer : list) {
            stringBuilder.append(integer);
        }

        return stringBuilder.reverse().toString();
    }
}
