class Solution {
    static int ceil(int arr[], int n, int x)
    {
        int res=n;
        int low=0;
        int high=arr.length-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(arr[mid]==x)
                return mid;
            if(arr[mid]>x)
            {
                res=mid;
                high=mid-1;
            }
            else
            {
                
                low=mid+1;
            }
        }
        return res;
    }
    public int searchInsert(int[] nums, int target) {
        int res=ceil(nums,nums.length,target);
        return res;
    }
}
