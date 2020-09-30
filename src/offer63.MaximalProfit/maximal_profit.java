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