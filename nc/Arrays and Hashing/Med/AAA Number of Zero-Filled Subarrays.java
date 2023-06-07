class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long res=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                long count=1;
                int j=i+1;
                long sum=2;
                while(j<nums.length && nums[j]==0)
                {
                    count=count+sum;
                    sum++;
                    j++;
                }
                res+=count;
                i=j;
            }

        }
        return res;
    }
}
