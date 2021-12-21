import java.util.HashMap;

class subarraysWithKDifferent {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int res_K = findK(nums, k);
        int res_K_1 = findK(nums, k - 1);
        System.out.println(res_K + " " + res_K_1);
        return res_K - res_K_1;
    }

    public int findK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int start = 0;

        for (int end = start; end < nums.length; end++) {
            int cur = nums[end];
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            while (map.size() > k) {
                int s = nums[start++];
                int freqS = map.get(s);
                if (freqS == 1) {
                    map.remove(s);
                } else {
                    map.put(s, freqS - 1);
                }
            }
            res += end - start + 1;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 1, 2, 3};
        int res = new subarraysWithKDifferent().subarraysWithKDistinct(test, 2);
        System.out.println(res);
    }
}

