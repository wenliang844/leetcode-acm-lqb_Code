package 蓝桥杯.蓝桥杯大赛历届真题.十一届;

public class A门牌制作 {//624
    //1-2020 有多少个2
    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i <= 2020; i++) {
            //取数字
            int temp = i;
            while (temp!=0){
                int t = temp%10;
                if (t==2)count++;
                temp=temp/10;
            }
        }
        System.out.println(count);
         int c = 0;
        for (int i = 1; i <= 2020; i++) {
            //取数字
            String s = i+"";
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j)=='2'){
                    c++;
                }
            }
        }
        System.out.println(c);


    }
}
