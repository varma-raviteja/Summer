class Solution {

    public boolean checkifpalindrome(String s,int low,int high)
    {
        System.out.println(low+" "+high);
        while(low<=high)
        {
            if(s.charAt(low)!=s.charAt(high))
            {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        int low=0;
        int high=s.length()-1;
        int count=0;
        
        while(low<=high)
        {
            if(s.charAt(low)==s.charAt(high))
            {
                low++;
                high--;

            }
            else if(s.charAt(low)!=s.charAt(high)  )
            {
                if(count>=1)
                return false;
                count++;
                
                return checkifpalindrome(s,low+1,high) ||  checkifpalindrome(s,low,high-1);
            }
           // System.out.println(low+" "+high);


        }
        return true;
    }
}
