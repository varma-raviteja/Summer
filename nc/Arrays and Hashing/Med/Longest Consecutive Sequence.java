class Solution {
    public int longestConsecutive(int[] nums) {
      
      HashSet<Integer> set=new HashSet<>();
      for(int i:nums)
        set.add(i);
      int res=0;
      for(int i=0;i<nums.length;i++)
      {
          int j=nums[i]-1;
          int left=0;
          while(set.contains(j))
          {
              set.remove(j);
              left++;
              j--;
          }
         
          int k=nums[i]+1;
          int right=0;
          while(set.contains(k))
          {
              set.remove(k);
              k++;
              right++;
          }
        
          res=Math.max(res,left+right+1);
        

      }
      

      return res;
    }
}
