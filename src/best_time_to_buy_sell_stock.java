class best_time_to_buy_sell_stock {
    public int maxProfit(int[] prices) {
//        int[] MP = new int[prices.length + 2];
//        for (int i = prices.length - 1; i >= 0; i--) {
//            int C1 = 0;
//            // case 1, buy and sell the stock
//            for (int sell = i + 1; sell < prices.length; sell++){
//                int profit = (prices[sell] - prices[i]) + MP[sell + 2];
//                C1 = Math.max(profit, C1);
//            }
//            // case 2, do not transaction with the stock p[i]
//            int C2 = MP[i + 1];
//
//            // wrap up the two cases
//            MP[i] = Math.max(C1, C2);
//        }
//        return MP[0];

        int n =prices.length;
        if(n == 0) return 0;
        int[] dp0 = new int[n];
        int[] dp1 = new int[n];
        dp0[0] = -prices[0];
        dp1[0] = 0;

        for (int i = 1; i < n; i++) {
            dp0[i] = Math.max(dp0[i - 1], -prices[i]);
            if(i >= 2){
                dp0[i] = Math.max(dp0[i], dp1[i - 2] - prices[i]);
            }
            dp1[i] = Math.max(dp1[i - 1], dp0[i - 1] + prices[i]);
        }
        return dp1[n - 1];

        /** state machine **/
//        int sold = Integer.MIN_VALUE, held = Integer.MIN_VALUE, reset = 0;
//        for (int price : prices) {
//            int preSold = sold;
//            sold = held + price;
//            held = Math.max(held, reset - price);
//            reset = Math.max(reset, preSold);
//        }
//        return Math.max(sold, reset);
    }
}
