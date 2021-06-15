package ACM.每日一题leecode.day01;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/***
 编写一个 StockSpanner 类，它收集某些股票的每日报价，并返回该股票当日价格的跨度。
 今天股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
 例如，如果未来7天股票的价格是 [100, 80, 60, 70, 60, 75, 85]，那么股票跨度将是 [1, 1, 1, 2, 1, 4, 6]。

 示例：
 输入：["StockSpanner","next","next","next","next","next","next","next"], [[],[100],[80],[60],[70],[60],[75],[85]]
 输出：[null,1,1,1,2,1,4,6]
 解释：
 首先，初始化 S = StockSpanner()，然后：
 S.next(100) 被调用并返回 1，
 S.next(80) 被调用并返回 1，
 S.next(60) 被调用并返回 1，
 S.next(70) 被调用并返回 2，
 S.next(60) 被调用并返回 1，
 S.next(75) 被调用并返回 4，
 S.next(85) 被调用并返回 6。

 注意 (例如) S.next(75) 返回 4，因为截至今天的最后 4 个价格
 (包括今天的价格 75) 小于或等于今天的价格。
 */
public class day28_901股票价格跨度 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
/*        list.add(100);
        list.add(80);
        list.add(60);
        list.add(70);
        list.add(60);
        list.add(75);
        list.add(85);*/
        StockSpanner S = new StockSpanner();
        System.out.println(S.next(100));
        System.out.println(S.next(80));
        System.out.println(S.next(60));
        System.out.println(S.next(70));
        System.out.println(S.next(60));
        System.out.println(S.next(75));
        System.out.println(S.next(85));
        System.out.println("---------------------");
        StockSpanner S1 = new StockSpanner();
        System.out.println(S1.next(32));
        System.out.println(S1.next(82));
        System.out.println(S1.next(73));
        System.out.println(S1.next(99));
        System.out.println(S1.next(91));


    }
}

class StockSpanner {

    List<Integer> list=new ArrayList<>();
    public StockSpanner() {

    }

    public int next(int price) {
        /****
         一定要理解题意,今天开始股价小于等于今天的股价的,一旦大于了,就停止搜索
         */
        list.add(price);
        System.out.println("这是今天的list"+list);

        int maxLen = 0;
        int tempLen = 0;
        for (int i = list.size()-1; i >=0; i--) {
            if (list.get(i)<=price){
                tempLen++;
                maxLen=Math.max(maxLen,tempLen);

                /*
                for (int j = 0; j < 100; j++) {
                    int k = 0;
                }
                */
            }else {
                //maxLen=Math.max(maxLen,tempLen);
               // tempLen=0;
                break;
            }
        }
        return maxLen;
    }


    /***集百家之长
     最后一个case总是超时，分析发现存在大量连续重复的输入，比如： ...[280],[280],[280],[280],[281],[281],[281]...

     这分明就是在考察Cache思想呀！！！

     使用一个cache记录上一次输入

     如果和上次相同，不用计算，直接利用上一次结果+1即可。
     如果没有命中，利用跳表思想，跳过连续小值，快速计算当前结果。
     class StockSpanner {
     public:
     StockSpanner() {
     }

     int next(int price) {
     if (p.empty() || last_ > price) {
     p.push_back(price);
     v.push_back(1);
     last_ = price; // cache last price
     return 1;
     }

     // cache hint!
     if (last_ == price) {
     p.push_back(price);
     v.push_back(v.back() + 1);
     last_ = price; // cache last price
     return v.back();
     }

     // cache not hint!
     int i = p.size() - 1;
     while(i>=0 && p[i] <= price) {
     if (v[i] == 1) {
     i -= 1;
     } else {
     i -= (v[i] -1);  // 直接跳到比当前大的数那里，再和price比较大小
     }
     }
     v.push_back(1 + p.size()-1-i);
     p.push_back(price);
     last_ = price; // cache last price
     return v.back();
     }
     int last_;  // cache last price
     vector<int> v;  // span list
     vector<int> p;  // price list
     };

     */
}
class StockSpanner2 {
    /***
     维持两个单调栈
     一个price价格
     一个weights 每天的最长小于等于今日股价
     */
    Stack<Integer> prices,weigths;

    public StockSpanner2() {
        prices = new Stack<>();
        weigths=new Stack<>();
    }

    public int next2(int price) {
        int w=1;//首先自身包含进来
        while (!prices.isEmpty() && prices.peek()<=price){
            w+=weigths.pop();
            prices.pop();
        }

        prices.push(price);
        weigths.push(w);
        return w;
    }








    /***集百家之长
     最后一个case总是超时，分析发现存在大量连续重复的输入，比如： ...[280],[280],[280],[280],[281],[281],[281]...

     这分明就是在考察Cache思想呀！！！

     使用一个cache记录上一次输入

     如果和上次相同，不用计算，直接利用上一次结果+1即可。
     如果没有命中，利用跳表思想，跳过连续小值，快速计算当前结果。
     class StockSpanner {
     public:
     StockSpanner() {
     }

     int next(int price) {
     if (p.empty() || last_ > price) {
     p.push_back(price);
     v.push_back(1);
     last_ = price; // cache last price
     return 1;
     }

     // cache hint!
     if (last_ == price) {
     p.push_back(price);
     v.push_back(v.back() + 1);
     last_ = price; // cache last price
     return v.back();
     }

     // cache not hint!
     int i = p.size() - 1;
     while(i>=0 && p[i] <= price) {
     if (v[i] == 1) {
     i -= 1;
     } else {
     i -= (v[i] -1);  // 直接跳到比当前大的数那里，再和price比较大小
     }
     }
     v.push_back(1 + p.size()-1-i);
     p.push_back(price);
     last_ = price; // cache last price
     return v.back();
     }
     int last_;  // cache last price
     vector<int> v;  // span list
     vector<int> p;  // price list
     };

     */
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */