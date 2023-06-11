class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int res[]=new int[temperatures.length];
        Stack<Integer> s=new Stack<Integer>();
      
        for(int i=0;i<res.length;i++)
        {
            while(!s.isEmpty() && (temperatures[s.peek()] < temperatures[i]))
            {
                int x=s.pop();
                res[x]=i-x;
               
            }
            s.push(i);
            
        }
        return res;
    }
}
