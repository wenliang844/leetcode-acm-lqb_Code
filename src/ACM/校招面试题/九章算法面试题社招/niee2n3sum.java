package ACM.校招面试题.九章算法面试题社招;

public class niee2n3sum {
    public static void main(String[] args) {
        System.out.println(add(10));
    }

    public static int add(int number) {
        int i = 3;
        int sum = 0;
        // write your code here
        while (i<=number){
            sum+=i;
            i+=3;
        }
        return sum;
    }
}
