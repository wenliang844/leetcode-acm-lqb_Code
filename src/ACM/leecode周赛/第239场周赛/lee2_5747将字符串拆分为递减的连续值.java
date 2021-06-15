package ACM.leecode周赛.第239场周赛;

public class lee2_5747将字符串拆分为递减的连续值 {

    /*****
     给你一个仅由数字组成的字符串 s 。
     请你判断能否将 s 拆分成两个或者多个 非空子字符串 ，使子字符串的 数值 按 降序 排列，且每两个 相邻子字符串 的数值之 差 等于 1 。
     例如，字符串 s = "0090089" 可以拆分成 ["0090", "089"] ，数值为 [90,89] 。这些数值满足按降序排列，且相邻值相差 1 ，这种拆分方法可行。
     另一个例子中，字符串 s = "001" 可以拆分成 ["0", "01"]、["00", "1"] 或 ["0", "0", "1"] 。然而，所有这些拆分方法都不可行，因为对应数值分别是 [0,1]、[0,1] 和 [0,0,1] ，都不满足按降序排列的要求。
     如果可以按要求拆分 s ，返回 true ；否则，返回 false 。
     子字符串 是字符串中的一个连续字符序列。
     示 1：
     输入：s = "1234"
     输出：false
     解释：不存在拆分 s 的可行方法。
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(splitString2("1234"));
        System.out.println(splitString2("050043"));//true
        System.out.println(splitString2("9080701"));
        System.out.println(splitString2("10009998"));//true
        System.out.println(splitString2("53520515049"));//true
        System.out.println(splitString2("0095749573"));//true
        System.out.println(splitString2("4771447713"));//true
        System.out.println(splitString2("14188802907687215148"));
        System.out.println(splitString2("1000000000999999999"));
        System.out.println(splitString2("200100"));

        //int  a = 7687215148;
    }

    public static boolean splitString(String s) {
        /***
         尝试第一个裁成 一个数,...n个数,后面直接将这个数减一纳入

         //每次只需要最后两位数即可
         */

        //去掉前导0
       // System.out.println(s);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)!='0'){
                s=s.substring(i,s.length());
                break;
            }
        }
        //System.out.println(s);
        long nextNum;
        for (int i = 1; i <= s.length() / 2; i++) {
            nextNum = Integer.parseInt(s.substring(0, i)) - 1;
            int start = i;
            int end = i + 1;
            boolean flag = false;
            while (end <= s.length()) {
                long temp = Long.parseLong(s.substring(start, end));
                //judgement(s.substring(start,end),nextNum);
                if (temp == nextNum) {
                    if (end == s.length()) {
                        return true;
                    }
                    start = end;
                    end = start + 1;
                    nextNum--;
                } else if (temp < nextNum) {
                    end++;
                } else {
                    break;
                }

            }
        }
        return false;
    }

    //  167/173
    public static boolean splitString2(String s) {
        /***
         尝试第一个裁成 一个数,...n个数,后面直接将这个数减一纳入

         //每次只需要最后两位数即可
         此处撰写解题思路
         边界情况:1.前导0 先去掉
         2.后导0 如果去掉后导0可以成立,也返回true

         注意,转换成数进行比较会越界
         */

        //去掉前导0
       // System.out.println(s);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)!='0'){
                s=s.substring(i,s.length());
                break;
            }
        }
        //System.out.println(s);
        String currentNum;
        for (int i = 1; i <= s.length() / 2+1; i++) {
            currentNum =s.substring(0, i);
            int start = i;
            int end = i + 1;
            boolean flag = false;
            while (end <= s.length()) {
                //long temp = Long.parseLong(s.substring(start, end));
                String temp = judgement(s.substring(start,end),currentNum);
                if (temp.equals("break")) {
                    break;
                } else if (temp.equals("continue")) {
                    end++;
                } else {
                    //如果后面都是0了,直接true
                    for (int j = end; j <s.length() ; j++) {
                        if (s.charAt(j)=='0'){
                            if (j==s.length()-1){
                                return true;
                            }
                        }else {
                            break;
                        }
                    }
                    if (end == s.length()) {
                        return true;
                    }
                    start = end;
                    end = start + 1;
                    currentNum=temp;
                }

            }
        }
        return false;
    }

    private static String judgement(String s, String currentNum) {
        //去掉前导0
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)!='0'){
                s=s.substring(i,s.length());
                break;
            }
        }
        if (s.charAt(0)=='0'){
            s="0";
        }
        if (s.length()>currentNum.length()){
            return "break";
        }

        //将s+1,看能不能得到current
        String res = "";
        char[] chars = s.toCharArray();
        for (int i = chars.length-1; i >=0 ; i--) {
            if (chars[i]!='9'){
                chars[i]+=1;
                break;
            }else {
                chars[i]='0';
            }
        }
        if (chars[0]=='0'){
            res +='1';
        }
        res+=String.valueOf(chars);
        //System.out.println(res);

        if (res.equals(currentNum)){
            return s;
        }
        else {
            return "continue";
        }
    }

}
