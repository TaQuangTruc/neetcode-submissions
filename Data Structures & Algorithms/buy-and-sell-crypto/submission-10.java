class Solution {
    public int maxProfit(int[] prices) {
        int numDays = prices.length;
        int buy = prices[0];
        int sell = prices[0];
        int maxProfit = 0;
        int tempProfit = 0;

        for (int i = 1; i < numDays; i++) {
            if (prices[i] > sell){
                sell = prices[i];
                tempProfit = sell - buy;
                if (tempProfit > maxProfit) {
                    maxProfit = tempProfit;
                }
            } else if (prices[i] < buy) {
                if (tempProfit > maxProfit) {
                    maxProfit = tempProfit;
                }
                buy = prices[i];
                sell = prices[i];
                tempProfit = 0;
            }
        }

        return Math.max(maxProfit, sell - buy);
    }
}
