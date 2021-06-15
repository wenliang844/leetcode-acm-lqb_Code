package 蓝桥杯.官方小模拟;

public class D2020个结点的无向图如果图中没有自环和重边最多包含多少条边 {

    public static void main(String[] args) {
        //5 ->4+3+2+1

        //2020 2019+2018...1
        int count =0;
        for (int i = 2019; i >0 ; i--) {
            count+=i;
        }
        System.out.println(count);
    }
}
