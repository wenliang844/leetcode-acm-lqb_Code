package 蓝桥杯.练习系统.算法训练;



    import java.util.*;
    public class q3plus{
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            Integer n = sc.nextInt();
            Integer nums[] = new Integer[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            Arrays.sort(nums,new Comparator<Integer>(){
                @Override
                public int compare(Integer integer, Integer t1) {
                    return t1-integer;
                }
            });
            for (int i = 0; i < n; i++) {
                System.out.print(nums[i]+" ");
            }
        }
    }
