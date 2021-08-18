package ACM.每日一题leecode.day141;

public class day178_1736替换隐藏数字得到的最晚时间 {
    public static void main(String[] args) {
        System.out.println(maximumTime("2?:?0"));
    }

    //16 15
    public static String maximumTime(String time) {
        String answer = "";
        if (time.charAt(0) == '?' && time.charAt(1) == '?') {
            answer += "23";
        } else if (time.charAt(0) == '?') {
            if ((int) (time.charAt(1) - '0') <= 3) {
                answer += "2";
            } else {
                answer += "1";
            }
            answer += time.charAt(1);
        } else if (time.charAt(1) == '?') {
            answer += time.charAt(0);
            if (time.charAt(0) == '2') {
                answer += "3";
            } else {
                answer += "9";
            }
        } else {
            answer += time.substring(0, 2);
        }
        answer += ":";

        if (time.charAt(3) == '?') {
            answer += "5";
        } else {
            answer += time.charAt(3);
        }

        if (time.charAt(4) == '?') {
            answer += "9";
        } else {
            answer += time.charAt(4);
        }
        return answer;
    }
}
