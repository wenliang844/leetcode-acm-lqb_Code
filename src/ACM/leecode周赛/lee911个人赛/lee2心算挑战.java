package ACM.leecode周赛.lee911个人赛;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class lee2心算挑战 {

    //通过
    public static void main(String[] args) {
        System.out.println(maxmiumScore(new int[]{1, 2, 8, 9}, 3));
    }

    //奇偶数分组, 一开始拿全部的偶数,剩下的拿奇数   然后dfs 减两个小的偶数 加两个奇数 返回大的   通过
    public static int maxmiumScore(int[] cards, int cnt) {
        List<Integer> jiList = new ArrayList<>();
        List<Integer> ouList = new ArrayList<>();
        for (int i = 0; i < cards.length; i++) {
            if (cards[i] % 2 == 0) {
                ouList.add(cards[i]);
            } else {
                jiList.add(cards[i]);
            }
        }

        if (cards.length < cnt || (ouList.size() == 0 && cnt % 2 != 0) || (cards.length == cnt && jiList.size() % 2 != 0)) {
            return 0;
        }

        int len;
        if (ouList.size() >= cnt) {
            len = cnt;
        }else {
            len = (cnt - ouList.size())%2==0?ouList.size():ouList.size()-1;
        }
        //System.out.println("--->"+len);

        //偶数拿len个
        //奇数拿cnt - len个
        Collections.sort(ouList, new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return t1-integer;
            }
        });
        Collections.sort(jiList ,new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return t1-integer;
            }
        });
        int jiLen = cnt-len;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += ouList.get(i);
        }
        for (int i = 0; i < jiLen; i++) {
            sum += jiList.get(i);
        }



        return dfs(sum,ouList,len,jiList,jiLen);
    }

    private static int dfs(int sum, List<Integer> ouList, int ouLen, List<Integer> jiList, int jiLen) {
        ouLen-=2;
        jiLen+=2;
        if (ouLen<0 || jiLen>jiList.size()){
            return sum;
        }else {
//            sum -= ouList.get(ouLen);
//            sum -= ouList.get(ouLen+1);
//            sum+=jiList.get(jiLen-1);
//            sum+=jiList.get(jiLen-2);
            int sub = jiList.get(jiLen-1)+jiList.get(jiLen-2)-ouList.get(ouLen)-ouList.get(ouLen+1);
            if (sub>0){
                sum +=sub;
            }
            return Math.max(sum,dfs(sum,ouList,ouLen,jiList,jiLen));
        }
    }
}
