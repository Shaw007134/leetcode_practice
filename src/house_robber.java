class house_robber {
    public int rob(int[] nums){
        int n = nums.length;
        int prepre = 0, pre = 0, now = 0;
        for (int i = 0; i < n; i++) {
            now = Math.max(pre, prepre + nums[i]);
            prepre = pre;
            pre = now;
        }
        return now;
    }
}
