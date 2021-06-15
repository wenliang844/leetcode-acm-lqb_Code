package 蓝桥杯.第一次小选拔;

/*
海伦定理
 */
public class lanqiao_5_土地面积的计算 {
    public static void main(String[] args) {
        double AB = 53.1;
        double BC = 57.2;
        double CD = 43.5;
        double DE = 57.9;
        double EA = 33.4;
        double EB = 68.2;
        double EC = 71.9;

       double s1 = (AB+EB+EA)/2;
       double s2 = (BC+EC+EB)/2;
       double s3 = (CD+DE+EB)/2;

       double A1 = Math.sqrt(s1*(s1-AB)*(s1-EB)*(s1-EA));
       double A2 = Math.sqrt(s2*(s2-BC)*(s2-EC)*(s2-EB));
       double A3 = Math.sqrt(s3*(s3-CD)*(s3-DE)*(s3-EB));

       double A = A1+A2+A3;
        System.out.println(A);

        System.out.println(A1+A2+A3);

        System.out.println("--------------------------");
        me();


    }

    public static void me(){
        double s1 = (53.1+68.2+33.4)/2;
        double s2 = (57.2+71.9+68.2)/2;
        double s3 = (71.9+43.5+57.9)/2;
        double a1 = Math.sqrt(s1*(s1-53.1)*(s1-68.2)*(s1-33.4));
        double a2 = Math.sqrt(s2*(s2-57.2)*(s2-71.9)*(s2-68.2));
        double a3 = Math.sqrt(s3*(s3-71.9)*(s3-43.5)*(s3-57.9));
        System.out.println(a1+a2+a3);

    }
}
