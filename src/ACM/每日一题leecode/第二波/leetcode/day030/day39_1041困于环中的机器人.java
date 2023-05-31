package ACM.每日一题leecode.第二波.leetcode.day030;

/**
 * @author 陈文亮
 * @date 2023/4/11 17:22
 */
public class day39_1041困于环中的机器人 {
    public static void main(String[] args) {
        System.out.println(isRobotBounded("GGLLGG"));
        System.out.println(isRobotBounded("GL"));
    }

    public static boolean isRobotBounded(String instructions) {
        int[] xy = new int[2];
        int direction = 1;
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < instructions.length(); i++) {
                char c = instructions.charAt(i);
                if (c == 'G') {
                    walk(direction, xy);
                } else {
                    direction = turn(direction, c);
                }
            }
            if (xy[0] == 0 && xy[1] == 0){
                return true;
            }
        }

        return false;
    }

    private static void walk(int direction, int[] xy) {
        switch (direction) {
            case 1:
                xy[1]++;
                break;
            case 2:
                xy[0]++;
                break;
            case 3:
                xy[1]--;
                break;
            case 4:
                xy[0]--;
            default:
        }
    }

    private static int turn(int direction, char c) {

        if (c == 'R') {
            direction++;
            if (direction == 5) {
                direction = 1;
            }
        } else {
            direction--;
            if (direction == 0) {
                direction = 4;
            }
        }

        return direction;
    }

}
