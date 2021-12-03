package ACM.校招面试题.网易校招;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class wy2字符串的最小删除次数 {

    public static void main(String[] args) {
        System.out.println(minDeletions("abb"));
        System.out.println(minDeletions("ceabaacb"));
    }

    public static int minDeletions (String s) {
        // write code here
        //1.计数
        Map<Character,Integer> map = new HashMap<>();
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            maxLen = Math.max(map.get(s.charAt(i)),maxLen);
        }

        System.out.println("maxlen:"+maxLen);
        int count = 0;
        int[] nums = new int[maxLen+1];
        for (Integer value : map.values()) {
            if (nums[value]==0){
                nums[value] = 1;
            }else {//重复了,直接往前面走,有0 就补充,全部没有就count += value-i
                int i= value-1;
                for ( ; i >=0; i--) {
                    if (nums[i]==0){
                        nums[i]=1;
                        break;
                    }
                }
                count += value-i;
            }

        }

        return count;
    }
}
