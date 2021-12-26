class jump {
    public boolean canJump(int[] nums){
//        int n = nums.length;
//        int[] dp = new int[n];
//        dp[0] = 1;
//        for (int i = 0; i < n; i++) {
//            if(dp[i] == 0) return false;
//            if(i + nums[i] >= n - 1) return true;
//            for (int j = i + 1; j <= i + nums[i]; j++) {
//                dp[j] = 1;
//            }
//        }
//        return false;
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if(i > max) return false;
            max = Math.max(max, i + nums[i]);
        }
        return max >= n - 1;
    }
}
