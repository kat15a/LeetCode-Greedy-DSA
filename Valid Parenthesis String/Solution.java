import java.util.Arrays;

class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        int[][] dp = new int[n][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(s, 0, 0, dp);
    }

    private boolean helper(String s, int index, int openCount, int[][] dp) {
        int n = s.length();

        if (openCount < 0) return false;

        if (index == n) {
            return openCount == 0;
        }

        if (dp[index][openCount] != -1) {
            return dp[index][openCount] == 1;
        }

        char ch = s.charAt(index);
        boolean ans;

        if (ch == '(') {
            ans = helper(s, index + 1, openCount + 1, dp);
        }
        else if (ch == ')') {
            ans = helper(s, index + 1, openCount - 1, dp);
        }
        else { // '*'
            ans = helper(s, index + 1, openCount + 1, dp)   // treat as '('
               || helper(s, index + 1, openCount - 1, dp)   // treat as ')'
               || helper(s, index + 1, openCount, dp);      // treat as empty
        }

        dp[index][openCount] = ans ? 1 : 0;
        return ans;
    }
}
