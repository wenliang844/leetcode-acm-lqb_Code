package ACM.每日一题leecode.自刷;

public class B汉诺塔 {
    public static void main(String[] args) {
        hanoi(1,'a','b','c');
    }

    public static void hanoi(int n,char a,char b,char c){
        if (n==0){

        }else{
            hanoi(n-1,a,c,b);
            System.out.print(a+"-->"+b +"\t");
            hanoi(n-1,c,b,a);
        }


    }
}
