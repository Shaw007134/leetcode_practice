import java.util.ArrayList;
import java.util.List;

class minDistance {
    public int findMin(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        // if one of the strings is empty
        if(n * m == 0) return n + m;
        // array to store the conversion history
        int[][] dp = new int[n+1][m+1];
        // init boundaries
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < m + 1; i++) {
            dp[0][i] = i;
        }
        // dp compute
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                int left = dp[i - 1][j] + 1;
                int down = dp[i][j - 1] + 1;
                int left_down = dp[i - 1][j - 1];
                if(word1.charAt(i - 1) != word2.charAt(j - 1))
                    left_down += 1;
                dp[i][j] = Math.min(left, Math.min(down, left_down));
            }
        }
        return dp[n][m];
    }
}
