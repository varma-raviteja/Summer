class Solution {
    public int arrangeCoins(int n) {
      long  low=1;
      long  high=n;
      long  res=0;
      while(low<=high)
      {
          long  mid=low+(high-low)/2;
          long sum=mid*(mid+1)/2;
          if(sum==n)
          return (int)mid;
          if(sum>n)
          {
              high=mid-1;
          }
          else
          {
              res=mid;
              low=mid+1;
          }
      }  
      return (int)res;
    }
}
