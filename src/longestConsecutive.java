import java.util.HashSet;

class longestConsecutive {
    public int findLongest(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;

        for (int num : set) {
            if(!set.contains(num - 1)){
                int cur = num;
                int count = 1;
                while(set.contains(++num)) count++;
                res = Math.max(res, count);
            }
        }
        return res;
    }
}
