class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer> map1=new HashMap<>();
        HashMap<Character,Integer> map2=new HashMap<>();

        List<Integer> res=new ArrayList<>();
        if(p.length()>s.length())
        return res;
        for(int i=0;i<p.length();i++)
        {
            map1.put(p.charAt(i),map1.getOrDefault(p.charAt(i),0)+1);
            map2.put(s.charAt(i),map2.getOrDefault(s.charAt(i),0)+1);
        }
        if(map1.equals(map2))
            res.add(0);

        for(int i=p.length();i<s.length();i++)
        {
            map2.put(s.charAt(i),map2.getOrDefault(s.charAt(i),0)+1);
            
            int x=map2.get(s.charAt(i-p.length()));
            if(x==1)
            {
                map2.remove(s.charAt(i-p.length()));
            }
            else map2.put(s.charAt(i-p.length()), x-1);

           // System.out.println(map2);
            if(map1.equals(map2))
            res.add(i-p.length()+1);

        }


        return res;
    }
}
