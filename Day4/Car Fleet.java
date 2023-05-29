class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> stack=new Stack<>();
        int[][] sort=new int[position.length][2];


        for(int i=0;i<position.length;i++)
        {
            sort[i][0]=position[i];
            sort[i][1]=speed[i];
        }

        Arrays.sort(sort, (a,b)-> b[0]-a[0]);

        for(int i=0;i<position.length;i++)
        {
            double time=(double)(target-sort[i][0])/sort[i][1];
            
            stack.push(time);
            
            if(stack.size()>=2)
            {
                double current=stack.pop();
                if(stack.peek()>=current)
                {
                    continue;
                }else stack.push(current);
            }
        }
        return stack.size();
    }
}
