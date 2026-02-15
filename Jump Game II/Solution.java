import java.util.Arrays;

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(nums, 0, dp);
    }

    private int helper(int[] nums, int index, int[] dp) {
        int n = nums.length;

        // If we reach or cross last index
        if (index >= n - 1) {
            return 0;
        }

        // If already computed
        if (dp[index] != -1) return dp[index];

        // If stuck at zero
        if (nums[index] == 0) {
            return Integer.MAX_VALUE;
        }

        int min = Integer.MAX_VALUE;

        // Try all possible jumps
        for (int i = 1; i <= nums[index]; i++) {
            int result = helper(nums, index + i, dp);
            if (result != Integer.MAX_VALUE) {
                min = Math.min(min, result + 1);
            }
        }

        return dp[index] = min;
    }
}
