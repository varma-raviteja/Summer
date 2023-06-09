class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++)
        {
            if(i>0 && nums[i-1] == nums[i])
            continue;
            for(int j=i+1;j<nums.length-2;j++)
            {
                if(j>i+1 && nums[j]==nums[j-1])
                    continue;
                int low=j+1;
                int high=nums.length-1;
                long sum = nums[i]+nums[j];
                long val = ((long)target - sum);
                while(low<high)
                {
                   
                   
                    if(nums[low]+nums[high]==val)
                    {
                        if(nums[i]+nums[j]>Integer.MAX_VALUE)
                        continue;


                        List<Integer> tsol=new ArrayList<>();
                    tsol.add(nums[i]);
                    tsol.add(nums[j]);
                    tsol.add(nums[low]);
                    tsol.add(nums[high]);
                    res.add(tsol);
                    while(low<high && nums[low] == nums[low+1])
                    low++;
                    while(low<high && nums[low] == nums[high-1])
                    high--;
                    low++;
                    high--;
                }
                else if(nums[low]+nums[high] < val)
                {
                    low++;
                }else high--;
                }
            }
        }
        return res;
    }
}
