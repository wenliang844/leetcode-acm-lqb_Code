package 蓝桥杯.蓝桥杯大赛历届真题.第九届;

import java.util.Scanner;

public class code2螺旋折线 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int targetx = sc.nextInt();
        int targety = sc.nextInt();
        int x=0;
        int y=0;
        int step=0;
        int len=0;
        int change=0;//当方向变了两次就需要改变-->就是step++

        boolean finish = false;
        int currentStep = 0;
        while (true){
            step++;
            //左 x--
            currentStep = step;
            while (currentStep-- >0){
                x--;
                len++;
                if (targetx==x && targety==y){
                    finish=true;
                    break;
                }
            }
            //change++;
            if (finish)break;
            /*if (change==2){
                step++;
                change=0;
            }*/
            //上 y++
            currentStep = step;
            while (currentStep-- >0){
                y++;
                len++;
                if (targetx==x && targety==y){
                    finish=true;
                    break;
                }
            }
            //change++;
            if (finish)break;
            step++;
            //右 x++
            currentStep = step;
            while (currentStep-- >0){
                x++;
                len++;
                if (targetx==x && targety==y){
                    finish=true;
                    break;
                }
            }
            //change++;
            if (finish)break;

            //下y--
            currentStep = step;
            while (currentStep-- >0){
                y--;
                len++;
                if (targetx==x && targety==y){
                    finish=true;
                    break;
                }
            }
            //change++;
            if (finish)break;
        }

        System.out.println(len);

    }
}
