class Solution {
    public String removeStars(String x) {
        Stack<Character> s=new Stack();
        for(int i=0;i<x.length();i++)
        {
            char c=x.charAt(i);
            if(c=='*')
            {
                if(!s.isEmpty());
                s.pop();
            }
            else s.push(c);
        }
        int size=s.size();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<size;i++)
        {
            sb.append(s.pop());
        }
        return sb.reverse().toString();
    }
}
