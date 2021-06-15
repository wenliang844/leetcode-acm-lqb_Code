package 蓝桥杯.蓝桥杯大赛历届真题.十一届;

public class C蛇形填数 {
    public static void main(String[] args) {

        //就是第39层的中位数 762
        int step = 1;
        int num = 1;
        for (int i = 1; i <= 39; i++) {
            for (int j = 1; j <= step; j++) {
                System.out.print(num+" ,");
                num++;
            }
            step++;
            System.out.println();
        }

        int a[] = new int[]{742 ,743 ,744 ,745 ,746 ,747 ,748 ,749 ,750 ,751 ,752 ,753 ,754 ,755 ,756 ,757 ,758 ,759 ,760 ,761 ,762 ,763 ,764 ,765 ,766 ,767 ,768 ,769 ,770 ,771 ,772 ,773 ,774 ,775 ,776 ,777 ,778 ,779 ,780};
        System.out.println(a.length);
        System.out.println(a[a.length/2+1]);
        System.out.println(a[20]);
    }
}
