class Solution {
    public int removeDuplicates(int[] nums) {
    int k=0;
    
     for(int i=0;i<nums.length;i++)
     {
        int j=i;
        int num=nums[i];
        int count=0;
      //   System.out.println(nums[i]);
        while(j<nums.length && nums[j]==nums[i])
        {
            count++;
            j++;
        }
        i=j-1;
      
        int sum=0;
        while(count!=0)
        {
            sum++;
            nums[k++]=num;
            if(sum==2)
            break;
            count--;
        }
        
     }
     
     return k;   
    }
}
