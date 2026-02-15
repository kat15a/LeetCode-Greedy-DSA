class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxReach = 0;

        for (int i = 0; i < n; i++) {
            // If current index is beyond maximum reachable index
            if (i > maxReach) return false;

            // Update maximum reachable index
            maxReach = Math.max(maxReach, i + nums[i]);
        }

        return true;
    }
}
