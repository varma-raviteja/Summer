class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] res=new int[nums.length*2];
        for(int i=0;i<nums.length;i++)
            res[i]=nums[i];
        for(int i=0;i<nums.length;i++)   
            res[i+nums.length]=nums[i];

        return res; 
    }
}
