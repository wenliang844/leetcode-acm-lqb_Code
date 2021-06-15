package ACM.每日一题leecode.day141;

public class day154_GuessGame {
    static int pick = 6;
    static int guess(int num){
        if (pick<num){
            return -1;
        }else if (pick>num){
            return 1;
        }else {
            return 0;
        }
    }

}
