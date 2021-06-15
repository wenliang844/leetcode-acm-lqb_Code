package 蓝桥杯.官方小模拟;

public class C整数1到2020连在一起长度为多少 {
    public static void main(String[] args) {

        System.out.println("这是结果==="+getNums(2020));

        System.out.println(((9 - 1 + 1) * 1 + (99 - 10 + 1) * 2 + (999 - 100 + 1) * 3 + (2020 - 1000 + 1) * 4));
    }

    public static int getNums(int n) {
        int sum = 0;
        int maxNum = 9;
        int i = 1;
        int j=1;
        int count1 = 0;
        while (n > maxNum) {

            for (int k=j; k <= maxNum; k++) {
                count1++;
            }
            sum += count1 * i;
            maxNum = (int) (maxNum + (9 * Math.pow(10, i)));
            System.out.println("这是maxNum"+maxNum);
            System.out.println("这是sum=="+sum);
            System.out.println("这是sount1=="+count1);
            i++;
            j=j*10;
            System.out.println("j=="+j);
            count1 = 0;
        }

        for (; j <= n; j++) {
            count1++;
        }
        sum += count1*i;





        return sum;
    }
}
