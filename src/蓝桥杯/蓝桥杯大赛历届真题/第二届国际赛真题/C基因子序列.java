package 蓝桥杯.蓝桥杯大赛历届真题.第二届国际赛真题;

public class C基因子序列 {
    /****
     字符串匹配问题:双指针解决
     */

    public static int getMatchLastIndex(String longS,String target){
        for (int i = 0; i <= longS.length()-target.length(); i++) {
            if (longS.charAt(i)==target.charAt(0)){//第一个匹配成功
                int index = i+1;
                int j = 1;
                while (index<longS.length()&&j<target.length()){
                    if (longS.charAt(index)==target.charAt(j)){
                        index++;
                        j++;
                    }else {
                        index++;
                    }
                }
                if (j>=target.length()){
                    return index;
                }

            }

        }

        return -1;
    }
    public static void main(String[] args) {
        System.out.println(getMatchLastIndex("ATCACAGGT", "TCG"));
    }
}
