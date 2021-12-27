public class wiggleMaxLen {
    public int findMax(int[] nums){
//        int n = nums.length;
//        if(n <= 1) return n;
//        int res = 1, ord = 1, pre_ord = -1;
//        for(int i = 1; i < n; ++i){
//            if(nums[i] == nums[i - 1]) continue;
//            if(nums[i] > nums[i - 1]) ord = 1;
//            else ord = 0;
//            if(ord != pre_ord) res++;
//            pre_ord = ord;
//        }
//        return res;

//        if(nums.length < 2){
//            return nums.length;
//        }
//        int[] up = new int[nums.length];
//        int[] down = new int[nums.length];
//        for (int i = 1; i < nums.length; i++) {
//            for (int j = 0; j < i; j++) {
//                if(nums[i] > nums[j]){
//                    up[i] = Math.max(up[i], down[j] + 1);
//                }else if(nums[i] < nums[j]){
//                    down[i] = Math.max(down[i], up[j] + 1);
//                }
//            }
//        }
//        return 1 + Math.max(down[nums.length - 1], up[nums.length - 1]);

//        if (nums.length < 2)
//            return nums.length;
//        int[] up = new int[nums.length];
//        int[] down = new int[nums.length];
//        up[0] = down[0] = 1;
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] > nums[i - 1]) {
//                up[i] = down[i - 1] + 1;
//                down[i] = down[i - 1];
//            } else if (nums[i] < nums[i - 1]) {
//                down[i] = up[i - 1] + 1;
//                up[i] = up[i - 1];
//            } else {
//                down[i] = down[i - 1];
//                up[i] = up[i - 1];
//            }
//        }
//        return Math.max(down[nums.length - 1], up[nums.length - 1]);

        if (nums.length < 2)
            return nums.length;
        int down = 1, up = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1])
                up = down + 1;
            else if (nums[i] < nums[i - 1])
                down = up + 1;
        }
        return Math.max(down, up);

    }
}
