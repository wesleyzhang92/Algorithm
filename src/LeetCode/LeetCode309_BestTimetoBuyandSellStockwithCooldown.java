package LeetCode;

/**
 * Best Time to Buy and Sell Stock with Cooldown
 * <p>
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 * Example:
 * prices = [1, 2, 3, 0, 2]
 * maxProfit = 3
 * transactions = [buy, sell, cooldown, buy, sell]
 * <p>
 * KeyWords: Dynamic Programming
 * Difficulty: Medium
 */
public class LeetCode309_BestTimetoBuyandSellStockwithCooldown {
    // buy[i] = max(sell[i-2]-price, buy[i-1])
    // sell[i] = max(buy[i-1]+price, sell[i-1])
    //Since states of day i relies only on i-1 and i-2 we can reduce the O(n) space to O(1). And here we are at our final solution:
    public int maxProfit(int[] prices) {
        int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy;
        for (int price : prices) {
            prev_buy = buy;
            buy = Math.max(prev_sell - price, prev_buy);
            prev_sell = sell;
            sell = Math.max(prev_buy + price, prev_sell);
        }
        return sell;
    }
    //

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int[] sells = new int[prices.length];
        int[] buys = new int[prices.length];
        sells[0] = 0;
        sells[1] = Math.max(0, prices[1] - prices[0]);
        buys[0] = -prices[0];
        buys[1] = Math.max(-prices[0], -prices[1]);
        for (int i = 2; i < prices.length; i++) {
            sells[i] = Math.max(sells[i - 1], buys[i - 1] + prices[i]);
            buys[i] = Math.max(buys[i - 1], sells[i - 2] - prices[i]);
        }
        return sells[sells.length - 1];
    }

}
