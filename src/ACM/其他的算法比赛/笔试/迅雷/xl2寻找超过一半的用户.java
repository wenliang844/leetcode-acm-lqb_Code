package ACM.其他的算法比赛.笔试.迅雷;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class xl2寻找超过一半的用户 {



// 徒步打卡
//#include <iostream>
//#include <cstdio>
//
//    using namespace std;
//

//    int main(){
//        //freopen("1.in","r",stdin);
//        int n;
//        cin >> n;
//        int nums[n];
//        for(int i = 0; i < n; i++){
//            cin >> nums[i];
//        }
//        if(nums[0]>nums[1]){
//            nums[1] = nums[0];
//        }
//
//        for(int i=2;i<n;i++){
//            if(nums[i-1]>nums[i-2]+nums[i]){
//                nums[i] = nums[i-1];
//            }else{
//                nums[i] =nums[i-2]+nums[i];
//            }
//        }
//        cout << nums[n-1] << endl;
//        return 0;
//    }


        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            String s = in.next();
            String[] ss = s.split(",");
            Map<String,Integer> map = new HashMap<>();
            for(int i=0;i<ss.length;i++){
                map.put(ss[i],map.getOrDefault(ss[i],0)+1);
            }

            for(String temp : map.keySet()){
                if(map.get(temp)*2>ss.length){
                    System.out.println(temp);
                    return;
                }
            }

            System.out.println(0);
        }

}
