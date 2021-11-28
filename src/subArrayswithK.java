import java.util.HashMap;
import java.util.Map;

class subArrayswithK {
    public int subarraysWithKDistinct(int[] nums, int k) {

        int start = 0;
        int end = 0;
        int count = 0;

        while(start < nums.length){
            HashMap<Integer, Integer> map = new HashMap<>();

            for(; end < nums.length; end++){
                Integer freq = map.getOrDefault(nums[end], 0);
                map.put(nums[end], freq + 1);
                if(map.keySet().size() == k){
                    count++;
                }else{
                    if(map.keySet().size() > k){
                        start++;
                        break;
                    }
                }
            }
        }
        return count;
    }

    public int subarraysWithKDistinct1(int[] nums, int k) {
        // Like three pointers.
        // we pick a left pointer which is left bound
        // of the subarr. After that, we start two new pointers
        // first and last, first stands for first time sat.
        // last stands for last time sat.

        Map<Integer, Integer> firstSat = new HashMap<>();
        int start = 0;
        int first = 0;
        int last = 0;
        int n = nums.length;

        int res = 0;
        while (start < n) {
            while (first < n &&
                    firstSat.size() < k) {
                int c = firstSat.getOrDefault(nums[first], 0);
                firstSat.put(nums[first], c + 1);

                first += 1;
            }

            // last = first;
            while (last < n &&
                    firstSat.containsKey(nums[last])) {
                last += 1;
            }

            // last now points to right most ind + 1
            res += firstSat.size() == k ? (last - first + 1) : 0;

            // move start
            int startValCount = firstSat.get(nums[start]);
            if (startValCount == 1) {
                firstSat.remove(nums[start]);
            } else {
                firstSat.put(nums[start], startValCount - 1);
            }

            start += 1;
        }

        return res;
    }
}
