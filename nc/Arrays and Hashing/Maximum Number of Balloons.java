class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character,Integer> map=new HashMap<>();
        int n=text.length();
        for(int i=0;i<n;i++)
        {
            map.put(text.charAt(i),map.getOrDefault(text.charAt(i),0)+1);
        }
        String word="balon";
        int res=text.length();
        for(int i=0;i<word.length();i++)
        {
            int count=0;
            if(!map.containsKey(word.charAt(i)))
                return 0;
            if(word.charAt(i)=='l' || word.charAt(i)=='o')
            {
                count=map.get(word.charAt(i))/2;
            }else
            {
                count=map.get(word.charAt(i));
            }
            res=Math.min(res,count);
        }
        return res;
    }
}
