package ACM.每日一题leecode.day01;

public class ListNode {

    public static void test1() {
        System.out.println("这是我的程序   学好树,图论");

    }
    public static void test(){
        // 使用函数 draw 绘制图形，反斜杠 "\" 请使用 "\\" 转义
       /* String s = "  _   _      _ _    __        __         _     _
                | | | | ___| | | __\\ \\      / /__  _ __| | __| |
                | |_| |/ _ \\ | |/ _ \\ \\ /\\ / / _ \\| '__| |/ _` |
                |  _  |  __/ | | (_) \\ V  V / (_) | |  | | (_| |
                |_| |_|\\___|_|_|\\___/ \\_/\\_/ \\___/|_|  |_|\\__,_|
                ";*/
    }
    int val;
    ListNode next;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    ListNode(int x) {
        val = x;
    }
}
