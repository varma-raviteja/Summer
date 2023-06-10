class Solution {
    public int maxVowels(String s, int k) {
        int sum=0;
        int max=0;
        for(int i=0;i<k;i++)
        {
            if(s.charAt(i)=='a'||s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u')
            sum++;
        }
        max=Math.max(max,sum);
        

        for(int i=k;i<s.length();i++)
        {
            char add=s.charAt(i);
            char remove=s.charAt(i-k);
            if(add=='a'||add=='e'||add=='i'||add=='o'||add=='u')
            sum++;
            if(remove=='a'||remove=='e'||remove=='i'||remove=='o'||remove=='u')
            sum--;

            max=Math.max(max,sum);

        }

        return max;
    }
}
