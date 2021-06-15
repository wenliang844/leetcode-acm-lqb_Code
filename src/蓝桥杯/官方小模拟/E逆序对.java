package 蓝桥杯.官方小模拟;

public class E逆序对 {

    public static void main(String[] args) {
        int[] nums = {87, 39, 35, 1, 99, 10, 54, 1, 46, 24, 74, 62, 49, 13, 2, 80, 24, 58, 8, 14, 83, 23, 97, 85, 3, 2, 86, 10, 71, 15};
        System.out.println(niudui(nums));

        System.out.println(niudui(new int[]{3,2,2,1}));//5
        System.out.println(niudui(new int[]{1,2,3,4,5,6,7,0}));//7
        System.out.println(niudui(new int[]{5,4,2,6,3,1}));//11
    }

    public static int niudui(int nums[]){
        int count=0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]>nums[j]){
                    count++;
                }
            }
        }

        return count;
    }

}
