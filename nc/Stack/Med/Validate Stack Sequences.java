class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int j=0;
        Stack<Integer> s=new Stack<Integer>();
        for(int i=0;i<pushed.length;i++)
        {
            s.push(pushed[i]);
            while(!s.isEmpty() && s.peek() == popped[j])
            {
                s.pop();
                j++;
            }
        }
        return s.size()==0;
    }
}
