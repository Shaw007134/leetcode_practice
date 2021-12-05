import java.util.Arrays;

class kthSmallestPair {
    public static int findKthSmallest(int[] nums, int k){
        Arrays.sort(nums);
        int l = 0, r = nums[nums.length - 1] - nums[0];
        while(l < r){
            int m = l + (r - l) / 2;
            // use sliding windows to count the number of pairs with distance smaller than mid
            int start = 0, cnt = 0;
            for(int end = 0; end < nums.length; end++){
                while(nums[end] - nums[start] > m) start++;
                cnt += end - start;
            }
            if(cnt < k) l = m + 1;
            else r = m;
        }
        return l;
    }
}
