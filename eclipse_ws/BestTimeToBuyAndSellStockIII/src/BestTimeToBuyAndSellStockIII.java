class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;

        int[] profits = {0, 0};

        boolean ifHandFull = (prices[0] <= prices[1])? true : false;
        int buyPrice = (prices[0] <= prices[1])? prices[0] : 0;
        for (int t = 0; t < prices.length; t++) {
            if (!ifHandFull && t < prices.length - 1 && prices[t] <= prices[t+1])   {
                buyPrice = prices[t];
                ifHandFull = true;
            }
            
            if ((ifHandFull && t == prices.length - 1 && prices[t] > prices[t-1]) || 
                (ifHandFull && t < prices.length - 1 && prices[t] > prices[t+1]))    {
                int profit = prices[t] - buyPrice;
                ifHandFull = false;
                
                if (profit > profits[0] && profit <= profits[1])
                    profits[0] = profit;
                else if (profit > profits[1])   {
                    profits[0] = profits[1];
                    profits[1] = profit;
                }
            }
        }

        return profits[0] + profits[1];
    }
}

public class BestTimeToBuyAndSellStockIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {1,2,4,2,5,7,2,4,9,0};
		System.out.println((new Solution()).maxProfit(prices));
	}

}
