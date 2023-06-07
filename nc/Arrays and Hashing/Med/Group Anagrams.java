class Solution {  //O(NKlogK), where NNN is the length of strs, and KKK is the maximum length of a string in strs , O(NK)
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();
        for(int i=0;i<strs.length;i++)
        {
            char[] res=strs[i].toCharArray();
            Arrays.sort(res);
            String conv=String.valueOf(res);
            if(map.containsKey(conv))
            {
                List<String> sres=map.get(conv);
                sres.add(strs[i]);
                map.put(conv,sres);
            }
            else {
                List<String> sres=new ArrayList<>();
                sres.add(strs[i]);
                map.put(conv,sres);
            }

        }
        List<List<String>> res=new ArrayList<>();
        for(Map.Entry<String,List<String>> m:map.entrySet())
        {
            res.add(m.getValue());
        }
        return res;
    }
}
