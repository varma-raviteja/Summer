class Solution {
    public int calPoints(String[] operations) {
        int sum=0;
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<operations.length;i++)
        {
            String x=operations[i];
            if(x.equals("+"))
            {
                int a=s.pop();
                int b=s.pop();
                int c=a+b;
                s.push(b);
                s.push(a);
                s.push(c);
                sum+=c;

            }else if(x.equals("C"))
            {
                int a=s.pop();
                sum-=a;
            }else if(x.equals("D"))
            {
                int a=s.pop();
                int b=a*2;
                s.push(a);
                s.push(b);
                sum+=b;
            }else
            {
                s.push(Integer.parseInt(x));
                sum+=Integer.parseInt(x);
            }
            
        }
        return sum;
    }
}
