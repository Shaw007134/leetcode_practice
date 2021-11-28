import java.util.HashMap;

class maxConsecutiveOne {
    public int longestOnes(int[] nums, int k) {

        int start = 0;
        int res = Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int end = 0; end < nums.length; end++){
            int freq = map.getOrDefault(nums[end], 0);
            map.put(nums[end], freq + 1);
            Integer d = map.get(0);
            if(d != null){
                while(d > k){
                    int s = nums[start];
                    int freqS = map.get(start);
                    if(s == 0){
                        start++;
                        map.put(s, freqS - 1);
                    }
                }
            }
            res = Math.max(end - start + 1, res);
        }
        return res;
    }
}
