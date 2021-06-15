package ACM.每日一题leecode.day141;

public class day153_278第一个错误的版本 extends day153_VersionControl{
    public static void main(String[] args) {
        //1 1
        int a =2126753390;
        //int n = (2126753390 +1)/2;
        //System.out.println(n);
        System.out.println(firstBadVersion(a));


    }


    //方法一:二分法 5/9
    public static int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left<=right){
           /* int mid = left/2+right/2;//防止两个数相机之后超出范围
            if (left%2!=0 && right%2!=0){
                mid++;
            }*/
            int mid = left + (right- left) / 2;

            System.out.print(mid+" ");
            if (isBadVersion(mid) && !isBadVersion(mid-1)){
                return mid;
            }else {
                if (isBadVersion(mid) && isBadVersion(mid-1)){
                    right=mid-1;
                }else {
                    left=mid+1;
                }
            }
        }

        return 0;
    }

    //[********########] 就像这样的有序数组，找第一个 # 号。
    //找的是分隔点
    public static int firstBadVersion2(int n) {
        int lo = 1;
        int hi = n;

        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (isBadVersion(mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return hi;
    }
}
