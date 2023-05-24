class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        int i=0;
        while(i<s.length())
        { 
            char x=s.charAt(i);
            i++;
            if(x=='(' || x=='[' || x=='{')
                st.push(x);
            else if(!st.isEmpty() && st.peek()=='[' && x==']' )
                st.pop();
            else if(!st.isEmpty() && st.peek()=='{' && x=='}' )
                st.pop();    
            else if(!st.isEmpty() && st.peek()=='(' && x==')' )
                st.pop();
            else st.push(x);
            
            
        }

        if(st.isEmpty())
            return true;
        return false;
    }
}
