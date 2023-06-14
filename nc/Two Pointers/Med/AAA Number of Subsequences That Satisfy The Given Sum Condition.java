class Solution {
    public int numSubseq(int[] nums, int target) {
        int n=nums.length;
        int mod=1_000_000_007;
        Arrays.sort(nums);

        int power[]=new int[n];
        power[0]=1;
        for(int i=1;i<n;i++)
            power[i]=(power[i-1]*2)%mod;
        
        int ans=0;
        int l=0;
        int h=n-1;
        while(l<=h)
        {
            if(nums[l]+nums[h]<=target)
            {
                ans+=power[h-l];
                ans%=mod;
                l++;
            }
            else h--;
        }
        return ans;
    }
}
