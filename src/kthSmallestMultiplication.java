class kthSmallestMultiplication {

    public static int findKSmallest(int m, int n, int k){
        int l = 1, r = m*n;
        while(l < r){
            int mid = l + (r - l) / 2, cnt = 0;
            // count how many numbers are smaller than n
            for(int i = 1; i <= m; i++){
                cnt += n < mid / i ? n : mid / i;
            }
            if(cnt < k){
                l = mid + 1;
            }else r = mid;
        }
        return l;
    }
}
