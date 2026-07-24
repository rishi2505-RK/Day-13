import java.util.*;

class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] height = new int[n];
        int ans = 0;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }

            int[] sorted = height.clone();
            Arrays.sort(sorted);

            for (int j = 0; j < n; j++) {
                int h = sorted[n - 1 - j];
                ans = Math.max(ans, h * (j + 1));
            }
        }

        return ans;
    }
}