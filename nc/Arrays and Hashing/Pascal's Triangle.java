class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> first=new ArrayList<>();
        first.add(1);
        res.add(first);
        if(numRows==1)
        {
            return res;
        }
        List<Integer> second=new ArrayList<>();
        second.add(1);
        second.add(1);
        res.add(second);
        if(numRows==2)
        {
            return res;
        }
        for(int i=3;i<=numRows;i++)
        {
            List<Integer> temp=new ArrayList<>();
            temp.add(1);
            List<Integer> ptemp=res.get(i-2);
            System.out.println(temp);
            for(int j=0;j<ptemp.size()-1;j++)
            {
                int sum=ptemp.get(j)+ptemp.get(j+1);
                temp.add(sum);
            }
            temp.add(1);
            res.add(temp);
        }
        return res;
    }
}
