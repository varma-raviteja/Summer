class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s=new Stack<Integer>();
        s.push(asteroids[0]);
        for(int i=1;i<asteroids.length;i++)
        {
            s.push(asteroids[i]);
            while(s.size()>=2 )
            {
                
                int a=s.pop();
                int b=s.pop();
                if((a>0 && b>0) || (a<0 && b<0) || (b<0 && a>0))
                {
                    s.push(b);
                    s.push(a);
                    break;
                }else
                if( a<0 && b>0)
                {
                    if(Math.abs(a)>Math.abs(b))
                {
                    s.push(a);
                }else if(Math.abs(a)<Math.abs(b))
                {
                    s.push(b);
                }

                }
            }
           
            
        }
        int[] res=new int[s.size()];
        for(int i=res.length-1;i>=0;i--)
        {
            res[i]=s.pop();
        }
        
        return res;

    }
}
