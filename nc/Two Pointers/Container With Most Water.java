class Solution {
    public int maxArea(int[] height) {
        int low=0;
        int high=height.length-1;
        int max=0;
        while(low<=high)
        {
            int res=(high-low)*Math.min(height[low],height[high]);
            max=Math.max(max,res);
            if(height[low]<=height[high])
                low++;
            else high--;
        }
        return max;
    }
}
