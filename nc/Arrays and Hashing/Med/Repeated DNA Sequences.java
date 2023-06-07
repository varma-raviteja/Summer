class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res=new ArrayList<>();
        HashSet<String> set=new HashSet<>();
        for(int i=0;i<s.length()-10+1;i++)
        {
            System.out.println(s.substring(i,i+10));
            if(set.contains(s.substring(i,i+10)))
            {
                if(!res.contains(s.substring(i,i+10)))
                    res.add(s.substring(i,i+10));
            }
            else set.add(s.substring(i,i+10));
        }

        return res;
    }
}
