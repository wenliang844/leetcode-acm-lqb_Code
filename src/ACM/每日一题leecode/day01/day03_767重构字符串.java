package ACM.每日一题leecode.day01;

import java.util.HashMap;
import java.util.Map;

/*
给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。

若可行，输出任意可行的结果。若不可行，返回空字符串。

示例 1:

输入: S = "aab"
输出: "aba"
示例 2:

输入: S = "aaab"
输出: ""
注意:

S 只包含小写字母并且长度在[1, 500]区间内。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reorganize-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class day03_767重构字符串 {
    public static void main(String[] args) {
        String S="qwerqwerttttttttt";
        System.out.println(reorganizeString(S));
    }
    public static String reorganizeString(String S) {
        Map<Character,Integer> map = new HashMap<Character,Integer>();//map装字符串
        char[] chs = S.toCharArray();
        Integer sum = 0;
        int maxNum = 0;
        char maxChar = chs[0];
        for (int i = 0; i < chs.length; i++) {//获取字符在map中的出现次数
            sum = map.get(chs[i]);

            if (sum==null){//没有出现就是1
                map.put(chs[i],1);
            }else{  //出现了就+1即可
                sum++;
                if (sum>maxNum){//找出出现次数最多的字符  赋值给maxNum
                    maxNum=sum;
                    maxChar=chs[i];
                }
                map.put(chs[i],sum);
            }
        }
        //System.out.println(maxNum);
        if (maxNum>chs.length-maxNum+1){    //满足这个条件不能重新排列字符串
            return "";
        }else {
           // char[] chs2 = new char[chs.length];
            int j = 0;
            for (int i = 0; i < map.get(maxChar); i++) {    //固定j的值;j为0;先把最大字符开始隔两个放一个;j到了尾部,就让j=1
                chs[j]=maxChar;
                j=j+2;
                if (j>=chs.length){
                    j=1;
                }
            }
            map.remove(maxChar);
            for (Character character : map.keySet()) {//再把其他的字符赋值到char数组
                Integer integer = map.get(character);
                for (int i = 0; i < integer; i++) {
                    chs[j]=character;
                    j=j+2;
                    if (j>=chs.length){
                        j=1;
                    }
                }
            }
            //System.out.println(map);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < chs.length; i++) {  //转换为字符串形式输出
                //System.out.print(chs[i]+"\t");
                sb.append(chs[i]);
            }
            //System.out.println(chs.toString());
            return sb.toString();
        }
    }
}
