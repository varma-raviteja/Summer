class Solution {
    public int shipWithinDays(int[] weights, int days) {
         if (weights == null || weights.length == 0 ) {
            return 0;
        }
        
        int max = 0;
        int sum = 0;
		
		// the lower boundary will be max and upper bounder will be sum for the binary search
        for ( int num :weights ) {
            sum = sum + num;
            max = Math.max(num, max);
        }

        int low=max;
        int high=sum;



        while(low<=high)
        {
            int mid=low+(high-low)/2;
            
            if(isPossible(weights,mid)>days)
            {
                low=mid+1;
            }else high=mid-1;
        }
        return low;       

    }


    public static int isPossible(int nums[], int mid)
    {
        int sum = 0;
        int requiredSubarrays = 1;
        
        for ( int i=0; i < nums.length; i++ ) {
            sum = sum+nums[i];
            if ( sum > mid ) {
                requiredSubarrays++;
                sum = nums[i];
            }
        }
        
       return requiredSubarrays;
    }
}
