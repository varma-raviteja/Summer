class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        generatep(n,res,"",0,0);
        return res;
    }

    public void generatep(int n, List<String> res, String s, int open, int close )
    {
        if(s.length()==2*n)
        {
            res.add(s);
        }
        if(open<n)
        {
            generatep(n,res,s+'(',open+1,close);
        }
        if(open>close)
        {
            generatep(n,res,s+')',open,close+1);
        }
    }


}
