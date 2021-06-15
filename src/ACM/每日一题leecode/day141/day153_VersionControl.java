package ACM.每日一题leecode.day141;

public class day153_VersionControl {
    static int v = 1702766719;
    public day153_VersionControl(){

    }
    /*public day153_VersionControl(int version){
        this.v = version;
    }*/
    static boolean isBadVersion(int version){
        if (version>=v){
            return true;
        }else {
            return false;
        }
    }

    public static int getV() {
        return v;
    }

    public static void setV(int v) {
        day153_VersionControl.v = v;
    }
}
