class Solution {
    public int[] rearrangeArray(int[] nums) {
       Arrays.sort(nums);
	   // sort in wave format
        for(int i = 0;i<nums.length-1;i+=2){
            int temp = nums[i];
            nums[i] = nums[i+1];
            nums[i+1] = temp;
        }
        return nums;
    }
}
