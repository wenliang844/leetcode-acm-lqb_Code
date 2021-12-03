package ACM.其他的算法比赛.笔试.同花顺;

public class ths正则匹配url {
    public static void main(String[] args) {
        String url = "https://www.baidu.com";
        String regex = "^(?:https?://)?[\\w]{1,}(?:\\.?[\\w]{1,})+[\\w-_/?&=#%:]*$";
        boolean matches = url.matches(regex);
        if (matches){
            System.out.println("is url");
        }else{
            System.out.println("not url");
        }


        //Pattern p = Pattern.compile("^(http|www|ftp|)?(://)?(//w+(-//w+)*)(//.(//w+(-//w+)*))*((://d+)?)(/(//w+(-//w+)*))*(//.?(//w)*)(//?)?(((//w*%)*(//w*//?)*(//w*:)*(//w*//+)*(//w*//.)*(//w*&)*(//w*-)*(//w*=)*(//w*%)*(//w*//?)*(//w*:)*(//w*//+)*(//w*//.)*(//w*&)*(//w*-)*(//w*=)*)*(//w*)*)$",Pattern.CASE_INSENSITIVE );

    }
}
