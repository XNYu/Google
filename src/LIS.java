public class LIS {
    public static int lengthOfLIS(int[] nums) {
        int[] max = new int[nums.length];
        if(nums.length==0)
            return 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[j]<nums[i])
                {
                    max[i] = Math.max(max[i],max[j] + 1);
                    ans = Math.max(max[i], ans);
                }
            }
        }
        return ans+1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 22, 9, 33, 21, 50, 41, 60, 80};
        System.out.println();
    }
}
