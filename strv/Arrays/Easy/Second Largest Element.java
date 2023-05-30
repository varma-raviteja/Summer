class Solution {
    int print2largest(int arr[], int n) {
        int l=-1;
        int sl=-1;
        
        for(int i=0;i<n;i++)
        {
            if(arr[i]>l)
            {
                sl=Math.max(sl,l);
                l=arr[i];
                
            }  
            if(arr[i]>sl && arr[i]<l)
            {
                sl=arr[i];
            }

        }       
        return sl;
        
    }
}

