class best_time_to_buy_sell_with_fee {
    public int maxProfit(int[] prices, int fee) {
        int dp0 = -prices[0], dp1 = 0;
        for (int i = 1; i < prices.length; i++) {
            dp1 = Math.max(dp1, dp0 + prices[i] - fee);
            dp0 = Math.max(dp0, dp1 - prices[i]);
        }
        return dp1;
    }
}
