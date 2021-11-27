import java.util.Arrays;

class threeSumClosest {
    public int findSum(int[] nums, int target){
        if(nums.length < 3) return -1;

        int res = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            int start = i + 1;
            int end = nums.length - 1;
            while(start < end){
                int diff = target - nums[i] - nums[start] - nums[end];
                if(diff == 0) return target;
                if(diff > 0) start++;
                else end--;
                if(Math.abs(diff) < Math.abs(diff)) res = diff;
            }
        }
        return target - res;
    }
}
