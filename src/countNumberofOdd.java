class countNumberofOdd {
    public static int numberOfSubarrays(int[] nums, int k) {
        int start = 0, start1 = 0;
        int end = 0, end1 = 0;
        int count = 0;
        int res = 0;
        for(; end < nums.length; end++){
            if(nums[end] % 2 == 1){
                count++;
                if(count == 1 && start1 == 0){
                    start1 = end;
                }
                if(count == k){
                    end1 = end;
                }
            }
            System.out.println(end + " " + count + " " + start1 + " " + end1);
            if(count > k || end == nums.length - 1 ){
                int pre = start1 - start + 1;
                int pos = end - end1 + 1;
                res += pre * pos;
            }
            while(count > k && start <= end){
                if(nums[start] % 2 == 1){
                    count--;
                    start1 = end1;
                }
                start++;
            }

        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        int k = 2;
        int res = countNumberofOdd.numberOfSubarrays(nums, k);
        System.out.println(res);
    }
}
