class Solution {

     static int floor(int arr[], int n, int x)
    {
        int res=-1;
        int low=0;
        int high=arr.length-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
           
            if(arr[mid]==x)
            {
                res=mid;
                high=mid-1;

            }      
            else if(arr[mid]>x)
            {
                high=mid-1;
            }
            else
            {
                
                low=mid+1;
            }
        }
        return res;
    }
    
    static int ceil(int arr[], int n, int x)
    {
        int res=-1;
        int low=0;
        int high=arr.length-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(arr[mid]==x)
               {
                   res=mid;
                   low=mid+1;
               }
            else if(arr[mid]>x)
            {
                
                high=mid-1;
            }
            else
            {
                
                low=mid+1;
            }
        }
        return res;
    }



    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0)
            return new int[]{-1,-1};
        int res[]=new int[2];
        int res1=floor(nums,nums.length,target);
        int res2=ceil(nums,nums.length,target);
        res[0]=res1;
        res[1]=res2;
        return res;
    }
}
