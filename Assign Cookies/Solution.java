import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n = g.length;
        int m = s.length;
        int l = 0; 
        int r = 0; 
        
        // Sort greed factors and cookie sizes
        Arrays.sort(g);
        Arrays.sort(s);
        
        // Two pointer approach
        while (l < n && r < m) {
            if (g[l] <= s[r]) {
                l++;  // child is satisfied
            }
            r++;  // move to next cookie
        }
        
        return l; // number of satisfied children
    }
}
