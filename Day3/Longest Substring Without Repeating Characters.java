class Solution {      // Set O(N) O(N)
    public int lengthOfLongestSubstring(String s) {
         Set<Character> set=new HashSet<>();
         int res=0;
         int left=0;
         for(int r=0;r<s.length();r++)
         {
             while(set.contains(s.charAt(r)))
             {
                 set.remove(s.charAt(left));
                 left++;
             }
             set.add(s.charAt(r));
             res=Math.max(res,r-left+1 );
         }
         return res;
    }
}

class Solution {              // Hashmap O(N) O(N)
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int left=0;
        int right=0;
        int res=0;
        while(right<s.length())
        {
            char c=s.charAt(right);
            map.put(c,map.getOrDefault(c,0)+1);

            while(map.get(c)>1)
            {
                char l=s.charAt(left);
                map.put(l,map.get(l)-1);
                left++;
            }

            res=Math.max(res,right-left+1);


            right++;

        }
        return res;
    }
}



class Solution {   // Optimized Hashmap O(N) O(N)
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
