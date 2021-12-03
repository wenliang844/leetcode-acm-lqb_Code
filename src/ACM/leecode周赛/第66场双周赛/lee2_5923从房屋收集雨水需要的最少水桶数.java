package ACM.leecode周赛.第66场双周赛;

import java.util.Arrays;

public class lee2_5923从房屋收集雨水需要的最少水桶数 {
    public static void main(String[] args) {
        System.out.println(minimumBuckets("H..H...H.H.H..H"));
        System.out.println(minimumBuckets("H"));
        System.out.println(minimumBuckets("HH"));
        System.out.println(minimumBuckets("H.H"));
        System.out.println(minimumBuckets(".HH.H.H.H.."));
    }

    public static int minimumBuckets(String street) {
        char[] streets = street.toCharArray();
        //1.将H.H格式的中间填充W
        int len = street.length();
        if (len==1){
            if (streets[0]=='.'){
                return 0;
            }else {
                return -1;
            }
        }
        if (len>=3){
            for (int i = 0; i < len - 2; i++) {
                if (streets[i] == 'H' && streets[i + 1] == '.' && streets[i + 2] == 'H') {
                    streets[i+1]='W';
                    i+=2;
                }
            }
        }

        //2.将H两边没有W的找.变成W  找不到直接return -1
        if (streets[0]=='H'){
            if (streets[1]=='.'){
                streets[1] = 'W';
            }
            if (streets[1]=='H'){
                return -1;
            }
        }
        for (int i = 1; i < len-1; i++) {
            if (streets[i]=='H'){
                if (streets[i-1]=='W'||streets[i+1]=='W'){
                    continue;
                }
                if (streets[i-1]=='.'){
                    streets[i-1]='W';
                }else if (streets[i+1]=='.'){
                    streets[i+1]='W';
                }else {
                    return -1;
                }
            }
        }
        if (streets[len-1]=='H'){
            if (streets[len-2]=='.'){
                streets[len-2] = 'W';
            }
            if (streets[len-2]=='H'){
                return -1;
            }
        }
        System.out.println(Arrays.toString(streets));
        //3.统计W的个数
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (streets[i]=='W'){
                count++;
            }
        }
        return count;
    }
}
