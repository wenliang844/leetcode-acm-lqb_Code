package ACM.每日一题leecode.day237;

public class day238_686重复叠加字符串匹配 {
    public static void main(String[] args) {
        System.out.println(repeatedStringMatch("abcd", "cdabcdab"));
        System.out.println(repeatedStringMatch("a", "a"));
        System.out.println(repeatedStringMatch("abc", "cabcabca"));
        System.out.println(repeatedStringMatch("aaaaab", "ba"));
        System.out.println(repeatedStringMatch("abcbc", "cabcbca"));
    }

    //常规:check是否是子串 44|57 50|57   26|5解决
    public static int repeatedStringMatch(String a, String b) {

       StringBuilder sb = new StringBuilder();
        int count = 0;
        int max  =2 * a.length() + b.length();
        while(sb.length() < max) { //|| count < 20
            if (sb.toString().contains(b)){
                //System.out.println(a+"--"+count);
                return count;
            }
           sb.append(a);
            count++;
        }

        return -1;
    }

    public static int repeatedStringMatch2(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int ans = 0;
        int max = 2 * a.length() + b.length();
        while (sb.length() < max) {
            sb.append(a);
            ans++;
            if (sb.toString().indexOf(b) != -1) {
                return ans;
            }
        }
        return -1;
    }
}
