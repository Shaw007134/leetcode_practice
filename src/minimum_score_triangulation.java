import java.util.Arrays;

class minimum_score_triangulation {
    int[][] dp;
    private int dfs(int[] arr, int i, int j){
        if(j - i == 1) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int min = Integer.MAX_VALUE;
        for(int k = i + 1; k < j; k++){
            int temp = arr[i] * arr[k] * arr[j] + dfs(arr, i, k) + dfs(arr, k, j);
            min = Math.min(temp, min);
        }
        return dp[i][j] = min;
    }
    public int minScoreTriangulation(int[] values){
        int n = values.length;
        dp = new int[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(values, 0, n - 1);
    }
}
