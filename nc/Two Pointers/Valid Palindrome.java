class Solution {
    public boolean isPalindrome(String s) {
        int l=0;
        int h=s.length()-1;
        s=s.toLowerCase();
        while(l<=h)
        {
            while(l<h &&  !Character.isLetterOrDigit(s.charAt(l)))
                l++;
            while(l<h &&  !Character.isLetterOrDigit(s.charAt(h)))
                h--;    
          
            char m=s.charAt(l);
            char n =s.charAt(h);
            if(m==n)
            {
                l++;
                h--;
            }
            else return false;
        }

        return true;
    }
}
