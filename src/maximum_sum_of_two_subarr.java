public class maximum_sum_of_two_subarr {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int[] dpl = new int[n];
        int[] dpm = new int[n];
        int[] sum = new int[n];
        sum[0] = 0;
        for (int i = 0; i < n; i++) {
            sum[i+1] = sum[i] + nums[i];
        }
        dpl[firstLen] = sum[firstLen];
        dpm[secondLen] = sum[secondLen];
        int res = 0;
        for(int i = 0; i < n; i++){
            if(i >= firstLen){
                dpl[i+1] = Math.max(dpl[i], sum[i+1] - sum[i+1-firstLen]);
                res = Math.max(res, sum[i+1] - sum[i+1-firstLen] + dpm[i+1-firstLen]);
            }
            if(i >= secondLen){
                dpm[i+1] = Math.max(dpm[i], sum[i+1] - sum[i+1-secondLen]);
                res = Math.max(res, sum[i+1] - sum[i+1-secondLen] + dpl[i+1-secondLen]);
            }
        }
        return res;
    }
}
