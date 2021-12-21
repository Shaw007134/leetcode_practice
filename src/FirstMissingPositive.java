class FirstMissingPositive {
    public int findFirstMissing(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            while(curr - 1 >= 0 && curr - 1 < nums.length && nums[curr - 1] != curr){
                int temp = nums[curr - 1];
                nums[curr - 1] = curr;
                curr = temp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) return i + 1;
        }
        return nums.length + 1;
    }
}
