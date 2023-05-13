class Solution {    // O(N) O(N)
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer> map=new HashMap<>();
        HashMap<Character,Integer> map2=new HashMap<>();

        if (s1.length() > s2.length())
            return false;

        for(int i=0;i<s1.length();i++)
        {
            char c=s1.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
            char c2=s2.charAt(i);
            map2.put(c2,map2.getOrDefault(c2,0)+1);
        }

        int right=s1.length();
        int left=0;

         if(map.equals(map2))
                return true;

        while(right<s2.length())
        {

            map2.put(s2.charAt(right),map2.getOrDefault(s2.charAt(right),0)+1);
           
            int val=map2.get(s2.charAt(left));
            val--;
            if(val==0)
                map2.remove(s2.charAt(left));
            else map2.put(s2.charAt(left),val);


            if(map.equals(map2))
                return true;

            left++;
            right++;
        }

        return false;

    }
}





public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (s1map[i] == s2map[i])
                count++;
        }

        for (int i = 0; i < s2.length() - s1.length(); i++) {
            int r = s2.charAt(i + s1.length()) - 'a', l = s2.charAt(i) - 'a';
            if (count == 26)
                return true;
            s2map[r]++;
            if (s2map[r] == s1map[r]) {
                count++;
            } else if (s2map[r] == s1map[r] + 1) {
                count--;
            }
            s2map[l]--;
            if (s2map[l] == s1map[l]) {
                count++;
            } else if (s2map[l] == s1map[l] - 1) {
                count--;
            }
        }
        return count == 26;
    }
}
