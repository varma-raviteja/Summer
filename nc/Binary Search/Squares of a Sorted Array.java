class Solution {
    public int[] sortedSquares(int[] nums) {
        int low=0;
        int high=nums.length-1;
        int res=0;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
             if(nums[mid]<0)
             {
                 low=mid+1;
             }
             else
             {
                 res=mid;
                 high=mid-1;
             }
             
        }
        if(nums[nums.length-1]<0)
        {
            res=nums.length;
        }
        int ans[]=new int[nums.length];
        int i=res-1;
        int j=res;
        int k=0;
        
        while(i>=0 && j<nums.length)
        {
            int left=nums[i]*nums[i];
            int right=nums[j]*nums[j];
          
            if(left<right)
            {
                ans[k]=left;
                i--;
            }else
            {
                ans[k]=right;
                j++;
            }
            k++;
           
        }
       
        while(i>=0)
        {
            
            ans[k]=nums[i]*nums[i];;
                i--;
            k++;
        }
        while(j<nums.length)
        {
            ans[k]=nums[j]*nums[j];
                j++;
            k++;
        }
        return ans;
    }
}
