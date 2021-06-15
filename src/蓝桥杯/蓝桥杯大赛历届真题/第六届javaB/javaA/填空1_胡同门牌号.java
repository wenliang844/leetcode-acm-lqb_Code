package 蓝桥杯.蓝桥杯大赛历届真题.第六届javaB.javaA;

public class 填空1_胡同门牌号 {
    /***
     从5开始,找到20结束
     */
    public static void getNum(){
        for(int i = 2;i < 100;i++) {
            int sum = 0;//所有人，包括小明，门牌号之和
            int count = 0;//总户数
//              当前最小的门牌号为 i
            for(int j = i;j < 100;j++) {
//                count为小明的门牌号+1，因为这里是先给count加1，再去判断，所以在本次循环中i为最小的门牌号，count-1为当前小明的门牌号；
//                这里的count不仅是小明的门牌号+1，还是总户数。
//                根据我们的分析，
//                小明家的门牌号=总户数-1    换句话说    总户数-1就是小明家的门牌号
//                100=除小明家以外的所有用户的门牌号之和      换句话说     所有的门牌号加起来-小明家的门牌号==100
                count++;
                sum = sum + j;
                if(sum - count + 1 == 100 && count - 1 >= i)
                    System.out.println("i = "+i+", j = "+j+", count = "+(count-1));
            }
        }
    }
    public static void main(String[] args) {
        for (int i = 5; i <= 20; i++) {//这个i就是小明的门牌号
            //从i-i开始,选择i+1个数,数都加起来=100+i  return i;
            for (int j = 2; j <= i; j++) {//从j开始选i个数
                int sum=0;
                for (int k = j; k <= j+i; k++) {
                    sum+=k;
                }
                if (sum-i==100){
                    System.out.println("这是i="+i);
                    System.out.println("这是开始节点j="+j);
                    System.out.println("这是结束节点j="+(j+i));
                    System.out.println("这是和sum="+sum);
                }

            }

        }

        getNum();
    }
}
