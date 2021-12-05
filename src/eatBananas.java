class eatBananas {
    public static int finMin(int[] piles, int h){
        int l = 0, maxV = 0;
        for(int p: piles){
            maxV = Math.max(maxV, p);
        }
        int r = maxV;
        while(l < r){
            int m = l + (r - l) / 2;
            int cnt = 0;
            for(int p: piles){
                cnt += (p - 1) / m + 1;
            }
            if(cnt > h){
                l = m + 1;
            }else r = m;
        }
        return l;
    }
}
