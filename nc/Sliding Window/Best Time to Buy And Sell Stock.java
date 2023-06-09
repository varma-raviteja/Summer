class Solution {
    public int maxProfit(int[] prices) {
        
        int buy=0;
        int res=0;
        for(int i=1;i<prices.length;i++)
        {
            int sell=i;
            if(prices[buy]>=prices[sell])
              buy=sell;
            if(prices[buy]<prices[sell])
                res=Math.max(res,prices[sell]-prices[buy]);
        }
        return res;
    }
}
