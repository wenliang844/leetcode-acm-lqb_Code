package 蓝桥杯.蓝桥杯大赛历届真题.第七届.决赛;

public class 填空3打靶 {
    /****

     */

    static void f(int[] ta,int[] da,int k,int ho,int bu,int sc){
        if (ho<0 ||bu<0||sc<0)return;
        if (k==ta.length){
            if (ho>0||bu>0||sc>0)return;
            for (int i = 0; i < da.length; i++) {
                for (int j = 0; j < da[i]; j++) {
                    System.out.println(ta[i]+"");
                }
                System.out.println();
                return;
            }

            for (int i = 0; i <= bu; i++) {
                da[k]=i;
                f(ta,da,k+1,(i == 0) ? ho : ho - 1,bu-i,sc-ta[k]*i);//天空
            }
            da[k]=0;

        }


    }

    public static void main(String[] args) {
        int ta[] = {1,2,3,5,10,20,25,50};
        int[] da = new int[8];
        f(ta,da,0,3,6,96);
    }
}
