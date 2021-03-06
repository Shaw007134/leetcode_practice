class distinct_subsequences {
    public int numDistinct(String s, String t) {
        int M = s.length();
        int N = t.length();

        int[] dp = new int[N];

        int prev = 1;

        for(int i = M - 1; i >= 0; i--){
            prev = 1;
            for(int j = N - 1; j >= 0; j--){
                int old_dpj = dp[j];
                if(s.charAt(i) == t.charAt(j)){
                    dp[j] += prev;
                }

                prev = old_dpj;
            }
        }
        return dp[0];
    }

}
