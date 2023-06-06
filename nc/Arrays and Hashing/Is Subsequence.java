class Solution {
    public boolean isSubsequence(String s, String t) {
        int i=0;
        if(s.length()==0)
            return true;
        for(int j=0;j<t.length();j++)
        {
            if(i<s.length() && s.charAt(i)==t.charAt(j))
            {
                i++;
            }
        }
        return i==s.length();
    }
}
