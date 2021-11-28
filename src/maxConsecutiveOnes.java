class maxConsecutiveOnes {
    public static int longestOne(int[] nums, int k){
        if(nums == null || nums.length == 0) return 0;
        int start = 0;
        int count = 0;
        int res = Integer.MIN_VALUE;

        for(int end = 0; end < nums.length; end++){
            if(nums[end] == 0) count++;

            while(count > k && start < end){
                if(nums[start] == 0) count--;
                start++;
            }

            res = Math.max(res, end - start + 1);

        }
        return res;
    }
}
