class maximum_one_deletion {
    /**
    Think of each state as reaching index i with j deletes. For this problem, we are just dealing with 1 delete, but if you see an extension of j deletes, we can use a similar approach.

    Basically, to reach index i with 0 deletion done, there are 2 possiblities:

    We carry over the max sum with 0 delete done at index i-1
    We start fresh from index i.
    Next, for index i with 1 deletion done, again, 2 possiblities:
    We carry over previous index i-1 with 1 delete done and add the current because we have already used our 1 delete.
    We carry over previous index i-1 with 0 delete done and instead use our 1 delete to delete index i
    **/
    public int maximumSum(int[] nums){
        int n = nums.length;
        if(n == 1) return nums[0];
        int[][] dp = new int[n][2];
        int res = Integer.MIN_VALUE;
        dp[0][0] = nums[0];

        for (int i = 1; i < n; i++) {
            // take this element
            // restart OR carry over from prev max taking cur
            dp[i][0] = Math.max(nums[i], dp[i-1][0] + nums[i]);
            // del current OR carry over prev del with cur
            dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1] + nums[i]);
            res = Math.max(res, Math.max(dp[i][0], dp[i][1]));
        }
        return res;
    }
}
