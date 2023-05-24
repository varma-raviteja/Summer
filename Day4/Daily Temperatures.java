class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s=new Stack<Integer>();
        int ans[]=new int[temperatures.length];
        
        for(int i=0;i<temperatures.length;i++)
        {
            while(!s.isEmpty() && temperatures[s.peek()]<temperatures[i])
            {
                int prev=s.pop();
                ans[prev]=i-prev;
            }
            s.push(i);
        }

        return ans;
    }
}
