import java.util.Arrays;

class dungeon_game {
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length, m = dungeon[0].length;
        int[][] dp = new int[n + 1][m + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        dp[n][m-1] = dp[n-1][m] = 1;
        for (int i = n - 1; i >= 0 ; --i) {
            for (int j = m - 1; j >= 0; --j) {
                int min = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(1, min - dungeon[i][j]);
            }
        }
        return dp[0][0];
    }
}
