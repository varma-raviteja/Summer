class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int r=0;
        int l=0;
        int res=0;
        long total=0;
        while(r<nums.length)
        {
            total+=nums[r];
            while(nums[r]*(r-l+1)>total+k)
            {
                total=total-nums[l];
                l++;
            }
            res=Math.max(res,r-l+1);
            r++;
        }
        return res;
    }
}
