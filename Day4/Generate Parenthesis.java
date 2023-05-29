class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        backtrack(n,res,"",0,0);
        return res;
    }

    public static void backtrack(int n, List<String> res, String s, int open, int close)
    {
        if(s.length()==n*2)
        {
            res.add(s);
        }

        if(open<n)
        {
            backtrack(n,res,s+'(',open+1,close);
        }
        if(open>close)
        {
            backtrack(n,res,s+')',open,close+1);
        }
    }
}

Time complexity: O(4^n/root(n))
Space Complexity: O(n)
