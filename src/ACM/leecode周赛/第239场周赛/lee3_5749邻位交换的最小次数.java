package ACM.leecode周赛.第239场周赛;

import java.util.Arrays;

public class lee3_5749邻位交换的最小次数 {
    /***
     你一个表示大整数的字符串 num ，和一个整数 k 。
     如果某个整数是 num 中各位数字的一个 排列 且它的 值大于 num ，则称这个整数为 妙数 。可能存在很多妙数，但是只需要关注 值最小 的那些。
     例如，num = "5489355142" ：
     第 1 个最小妙数是 "5489355214"
     第 2 个最小妙数是 "5489355241"
     第 3 个最小妙数是 "5489355412"
     第 4 个最小妙数是 "5489355421"
     返回要得到第 k 个 最小妙数 需要对 num 执行的 相邻位数字交换的最小次数 。
     测试用例是按存在第 k 个最小妙数而生成的。
     示例 1：
     输入：num = "5489355142", k = 4
     输出：2
     解释：第 4 个最小妙数是 "5489355421" ，要想得到这个数字：
     - 交换下标 7 和下标 8 对应的位："5489355142" -> "5489355412"
     - 交换下标 8 和下标 9 对应的位："5489355412" -> "5489355421"
     */

    public static int getMinSwaps(String num, int k) {
        int len = num.length();
        int nums[] = new int[len];

        for (int i = 0; i < len; i++) {
            nums[i] = num.charAt(i) - '0';
        }

        int numsStart[] = new int[len];
                System.arraycopy(nums,0,numsStart,0,len);

        for (int i = 0; i < k; i++) {
            nextPermutation(nums);
        }
        System.out.println(Arrays.toString(numsStart));
        System.out.println(Arrays.toString(nums));


        int count = 0;
        //计算numsStart到nums需要几步--暴力交换,如果不等于,就两两交换
        for (int i = 0; i < nums.length; i++) {
            if (numsStart[i]!=nums[i]){

                int j = i+1;
                while (nums[i]!=numsStart[j]){
                    j++;
                }
                //这个时候需要把i 和j进行加和
                //从j开始和j-1进行交换,直到j-1=i-1
                while (j!=i){
                    int temp = numsStart[j];
                    numsStart[j] = numsStart[j-1];
                    numsStart[j-1]=temp;
                    count++;
                    j--;
                }
            }
        }
        
        
        return count;
    }

    public static void main(String[] args) {
        System.out.println(getMinSwaps("5489355142",4));
        System.out.println(getMinSwaps("11112",4));
    }

    public static void nextPermutation(int[] nums) {
        boolean flag = false;
        //寻找最后一个逆序对
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                //swap num[i,i-1]  修正flag=true标志修改成功了,如果flag=false,没有修改,将进行下一步处理
                //是找一个大于的,最小的元素进行交换
                int index = i;
                for (int j = i+1; j < nums.length; j++) {
                    if (nums[j]>nums[i-1]){
                        if (nums[j]<nums[i]){//比较的是element
                            index=j;
                        }
                    }
                }
                //System.out.println("这是最终决定交换的大元素"+nums[index]);

                flag = true;
                int temp = nums[index];//交换
                nums[index] = nums[i - 1];
                nums[i - 1] = temp;

                //还需要对i包括i 后面的进行升序排序
                for (int j = i; j < nums.length-1; j++) {
                    for (int k = j+1; k < nums.length; k++) {
                        if (nums[j]>nums[k]){
                            //交换
                            int temp1 = nums[j];
                            nums[j]=nums[k];
                            nums[k]=temp1;
                        }
                    }
                }
                break;
            }
        }
        if (!flag){//如果是全降序,变成升序
            Arrays.sort(nums);
        }
    }

    /***
     class Solution {
     int result = 0;
     public int getMinSwaps(String num, int k) {
     int len = num.length();
     int[] intnum = new int[len];
     int[] beginnum = new int[len];//起始数据
     for(int i = 0; i < num.length(); i++){
     intnum[i] = num.charAt(i)-'0';
     beginnum[i] = num.charAt(i)-'0';
     }
     for(int i = 0; i < k; i++){
     intnum = nextPermutation(intnum);
     }
     int[] knum = intnum;//第k个妙数
     for(int i = 0; i < len; i++){
     if(beginnum[i]!=knum[i]){
     int j = i+1;
     while(beginnum[j]!=knum[i]){j++;}//找到相同数据，开始交换
     while(j != i){
     swap(beginnum, j-1, j);//只能两两交换
     result++;
     j--;
     }
     }
     }
     return result;
     }
     //寻找下一个妙数
     public int[] nextPermutation(int[] nums) {
     int len = nums.length;
     for(int i = len-1; i > 0; i--){
     if(nums[i] > nums[i-1]){//nums[i-1]处的元素要进行位置调换
     int j = len-1;
     while(nums[j] <= nums[i-1]){j--;}
     //从i到j都比nums[i-1]大
     //nums[i-1]和nums[j]先调换位置
     swap(nums, i-1, j);
     //反转nums[i-1]之后的所有元素
     j = len-1;
     while(i<j){swap(nums, i++, j--);}
     break;}
     }
     return nums;
     }
     //交换nums数组第i和第j处的元素
     public void swap(int[] nums, int i, int j){
     int m = nums[i];
     nums[i] = nums[j];
     nums[j] = m;
     }
     }
     */
}
