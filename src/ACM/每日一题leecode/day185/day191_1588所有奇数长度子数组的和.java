package ACM.每日一题leecode.day185;

public class day191_1588所有奇数长度子数组的和 {

    /****
     给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。
     子数组 定义为原数组中的一个连续子序列。
     请你返回 arr 中 所有奇数长度子数组的和 。
     */
    public static void main(String[] args) {
        System.out.println(sumOddLengthSubarrays(new int[]{1, 4, 2, 5, 3}));
    }

    //方法一:枚举 62/36
    public static int sumOddLengthSubarrays(int[] arr) {
        //滑动窗口:直接从1开始
        int lenArr = arr.length;
        int lenIndex = 1;
        int sum = 0;
        //加一个 减一个 进行截取这一奇数段子数组的长度
        while (lenIndex <= arr.length) {
            int tempSum = 0;
            //第一段
            int i = 0;
            for (; i < lenIndex; i++) {
                tempSum += arr[i];
            }
            sum += tempSum;
            System.out.println("first---" + tempSum);
            //加一个 减一个
            for (; i < arr.length; i++) {
                tempSum += arr[i];
                tempSum -= arr[i - lenIndex];
                sum += tempSum;
                System.out.println("common---" + tempSum);
            }

            lenIndex += 2;
        }

        return sum;
    }

    //leetcode方法二:前缀和
    public static int sumOddLengthSubarrays2(int[] arr) {
        int n = arr.length;
        int[] prefixSums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSums[i + 1] = prefixSums[i] + arr[i];
        }
        int sum = 0;
        for (int start = 0; start < n; start++) {
            for (int length = 1; start + length <= n; length += 2) {
                int end = start + length - 1;
                sum += prefixSums[end + 1] - prefixSums[start];
            }
        }
        return sum;
    }

    //leetcode方法三:数学 100 92
    public static int sumOddLengthSubarrays3(int[] arr) {
        int sum = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int leftCount = i, rightCount = n - i - 1;
            int leftOdd = (leftCount + 1) / 2;
            int rightOdd = (rightCount + 1) / 2;
            int leftEven = leftCount / 2 + 1;
            int rightEven = rightCount / 2 + 1;
            sum += arr[i] * (leftOdd * rightOdd + leftEven * rightEven);
        }
        return sum;
    }
}
