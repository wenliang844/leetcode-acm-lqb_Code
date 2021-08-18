package ACM.每日一题leecode.day185;

public class day188_551学生出勤记录I {
    public static void main(String[] args) {
        System.out.println(checkRecord("PPALLP"));
    }

    //方法一:直接扫描法  41/91
    public static boolean checkRecord(String s) {

        int Acount = 0;
        int Lcount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='A'){
                Acount++;
                Lcount=0;
            }else if (s.charAt(i)=='L'){
                Lcount++;
            }else {
                Lcount=0;
            }
            if (Lcount>=3){
                return false;
            }
        }
        return Acount<2;
    }
}
