class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int res=0;
        int i=0;
        for(int j=0;j<s.length();j++)
        {
            if(map.containsKey(s.charAt(j)))
            {
                i=Math.max(map.get(s.charAt(j)),i);
            }
            res=Math.max(res,j-i+1);
            map.put(s.charAt(j),j+1);
        }
        return res;
    }
}
