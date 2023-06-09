class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int target = 0;
        Arrays.sort(nums);
        Set<List<Integer>> s = new HashSet<>();
        List<List<Integer>> output = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
           if(i>0 && nums[i]==nums[i-1])
            continue;
            int low=i+1;
            int high=nums.length-1;
            while(low<high)
            {
                if(nums[i]+nums[low]+nums[high]==0)
                {
                    List<Integer> tsol=new ArrayList<>();
                    tsol.add(nums[i]);
                    tsol.add(nums[low]);
                    tsol.add(nums[high]);
                    output.add(tsol);
                    while(low<high && nums[low] == nums[low+1])
                    low++;
                    while(low<high && nums[low] == nums[high-1])
                    high--;
                    low++;
                    high--;
                }
                else if(nums[i]+nums[low]+nums[high]<0)
                {
                    low++;
                }else high--;
            }
            
        }
        
        return output;
    }
}
