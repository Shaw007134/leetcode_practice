class house_robber {
    public int rob1(int[] nums, int l, int r){
//        int n = nums.length;
        int prepre = 0, pre = 0, now = 0;
        for (int i = l; i <= r; i++) {
            now = Math.max(pre, prepre + nums[i]);
            prepre = pre;
            pre = now;
        }
        return now;
    }

    public int rob(int[] nums){
        int n = nums.length;
        if(n == 1) return nums[0];
        int a = rob1(nums, 0, n - 2);
        int b = rob1(nums, 1, n - 1);
        return Math.max(a, b);
    }
}
