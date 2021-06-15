package 蓝桥杯.十二届国赛;

import java.util.Calendar;

public class C完全日期 {//215   977
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR,2001);
        c.set(Calendar.MONTH,1);
        c.set(Calendar.DATE,1);
        int count = 0;
        while (c.get(Calendar.YEAR)!=2022){
            int temp1 = c.get(Calendar.YEAR);
            int temp2 = c.get(Calendar.MONTH);
            int temp3 = c.get(Calendar.DATE);
            int sum = 0;
            while (temp1!=0){
                sum+=temp1%10;
                temp1 = temp1/10;
            }while (temp2!=0){
                sum+=temp2%10;
                temp2 = temp2/10;
            }while (temp3!=0){
                sum+=temp3%10;
                temp3 = temp3/10;
            }
            if (check(sum)){
                count++;
                //System.out.println(c.get(Calendar.YEAR));
                //System.out.println(c.get(Calendar.MONTH));
                //System.out.println(c.get(Calendar.DAY_OF_MONTH));
            }
            c.add(Calendar.DATE,1);
        }
        System.out.println(c.get(Calendar.YEAR));
        System.out.println(c.get(Calendar.MONTH));
        System.out.println(c.get(Calendar.DAY_OF_MONTH));
        System.out.println(count);
    }

    /***
     如果只是的add方法执行，结果都一样，因为都是将日期+1
     就没有区别    在月的日期中加1  还是年的日期中加1  还是日期本身加1  效果都一样
     但是Calendar设置DAY_OF_MONTH和DAY_OF_YEAR的目的不是用来+1的
     将日期加1，这通过cal1.add(Calendar.DATE,1)就可以实现了
     DAY_OF_MONTH的主要作用是cal.get(DAY_OF_MONTH)，用来获得这一天在是这个月的第多少天
     Calendar.DAY_OF_YEAR的主要作用是cal.get(DAY_OF_YEAR)，用来获得这一天在是这个年的第多少天。
     * @param num
     * @return
     */
    private static boolean check(int num) {
        double check1 = Math.sqrt(num);
        double check2 = (double)(int)check1;
        return check1==check2;
    }
}
