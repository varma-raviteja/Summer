class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=nums1.length-1;
        if(m==0 && n!=0)
        {

            while(n>0)
            {
                nums1[n-1]=nums2[n-1];
                n--;
            }
        }
        m--;
        n--;
        while(i>=0)
        {
           
            if(m>=0 && n>=0 && nums1[m]>=nums2[n])
            {
                nums1[i]=nums1[m];
                m--;
            }
            else if(m>=0 && n>=0 && nums2[n]>nums1[m])
            {
                nums1[i]=nums2[n];
                n--;
            }
            
            i--;
        }
        while(n>=0)
        {
            nums1[n]=nums2[n];
           
            n--;
        }
        
       
    }
}
