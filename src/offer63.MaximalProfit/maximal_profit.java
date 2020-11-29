class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2){
            return 0;
        }
        int min = prices[0];
        int maxDiff = prices[1] - min;
        for(int i = 2; i < prices.length; i++){
            if(prices[i-1] < min){
                min = prices[i-1];
            }
            int curDiff = prices[i] - min;
            if(curDiff > maxDiff){
                maxDiff = curDiff;
            }
        }
        return maxDiff > 0 ? maxDiff : 0;
    }
}
class Solution {
    public int maxProfit(int[] prices) {
        // dp[i] = max(dp[i-1], prices[i] - min(prices[0...i]))
        // min(prices[0...i]) -> cost成本，记录最小值
        // dp[i] -> profit
        int cost = Integer.MAX_VALUE;
        int profit = 0;
        for (int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        LinkedList<Integer> list = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        for (int price : prices) {
            if (list.isEmpty()) {
                list.offerLast(price);
            } else {
                while (!list.isEmpty() && price < list.peekLast()) {
                    list.pollLast();
                }
                list.offerLast(price);
            }
            max = Math.max(max, price - list.peekFirst());
        }
        return max;
    }
}