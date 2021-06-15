package 算法algo.马士兵左程云_排序算法.牛客第三期进阶.NK01_算法;

public class code9_上左右下螺旋走会不会交叉 {

    /***
     4. 一个人开始在(0,0) 总是第一次上 左 下 右
     arr[i]表会死第i次走的步数
     返回:按照数组的步数走,会不会让走过的路劲交叉在一起
     */

    //方法一:找规律:左要小于右走的,上要小于下走的;也就是要符合下标0<2 1<3 2<4 3<5 i<i+1(一旦不符合false)
    //特殊情况:一直小,一直大都没问题,但是一次小,一次大就要直接交叉了
    //扣边界
    public static boolean isCross(int[] distance){
        //路径小于3的话,不可能交叉
        if (distance.length <4)return false;//小于4的一定不会交叉

        //前4个特殊情况,当0>=2 1>=3的时候直接true
        /*if (distance[0]>=distance[2] && distance[3]>=distance[1]){
            return true;//交叉 2 1 2 3
        }*/

       /* for (int i = 4; i < distance.length; i++) {//倒退.做减法
           *//* if ((distance[i]<=distance[i+2] && distance[i+1]>=distance[i+3]) || (distance[i]>=distance[i+2] && distance[i+1]<=distance[i+3])){
                return true;
            }*//*
           if ((distance[i]<=distance[i-2]&&distance[i-1]>=distance[i-3] )|| (distance[i]>=distance[i-2] && distance[i-1]<=distance[i-3])){
               return true;
           }
        }*/

        //1.前面的初始情况 100 54
        if ((distance.length > 3 && distance[2]<=distance[0] && distance[3]>=distance[1])||
                (distance.length >4 &&(distance[3]<=distance[1] && distance[4]>=distance[2]
                || (distance[3] ==distance[1] && distance[0]+distance[4]==distance[2])))){
            return true;
        }

        //2.后面的几种情况 边界情况特别多
        for (int i = 5; i < distance.length; i++) {
            if (distance[i-1] <= distance[i-3] && ((distance[i]>=distance[i-2])||(distance[i-2]>=distance[i-4]&&
                    distance[i-5]+distance[i-1]>=distance[i-3] && distance[i-4] +distance[i]>=distance[i-2]))){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isCross(new int[]{2, 1, 3, 2, 2, 4}));//true
        System.out.println(isCross(new int[]{2, 1, 3, 2,4}));//false

        System.out.println(isCross(new int[]{2,1,1,2}));//true
        System.out.println(isCross(new int[]{1,2,3,4}));//false
        System.out.println(isCross(new int[]{1,1,1,1}));//true
        System.out.println("-----------wrong");
        System.out.println(isCross(new int[]{3,3,4,2,2}));//false
        System.out.println(isCross(new int[]{1,1,2,2,3,3,4,4,10,4,4,3,3,2,2,1,1}));//false  经箍咒一样的图形 有
        //[1,1,2,2,3,3,4,4,10,4,4,3,3,2,2,1,1]
    }
}
