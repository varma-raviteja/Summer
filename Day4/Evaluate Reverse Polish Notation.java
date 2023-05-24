class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s=new Stack<Integer>();
        for(int i=0;i<tokens.length;i++)
        {
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") ||tokens[i].equals("/"))
            {
               int op1=s.pop();
               int op2=s.pop();
               if(tokens[i].equals("+"))
               {
                   int res=op1+op2;
                   s.push(res);
               }
               else  if(tokens[i].equals("-"))
               {
                   int res=op2-op1;
                   s.push(res);
               }
               else  if(tokens[i].equals("*"))
               {
                   int res=op2*op1;
                   s.push(res);
               }
               else  if(tokens[i].equals("/"))
               {
                   int res=op2/op1;
                   s.push(res);
               }
            }
            else s.push(Integer.parseInt(tokens[i]));
          
        }

        return s.pop();
    }
}
