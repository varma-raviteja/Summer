class Solution {
    public int[] productExceptSelf(int[] nums) {
        int temp[]=new int[nums.length];
        int prod=1;
        temp[0]=1;
        for(int i=1;i<nums.length;i++)
        {
            prod=prod*nums[i-1];
            temp[i]=prod;
            
        }
        prod=nums[nums.length-1];
        System.out.println(Arrays.toString(temp));
        for(int j=nums.length-2;j>=0;j--)
        {
            temp[j]=temp[j]*prod;
            prod=prod*nums[j];
        }
        return temp;
    }
}
