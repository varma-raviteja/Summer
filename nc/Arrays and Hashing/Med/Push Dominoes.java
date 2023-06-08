class Solution {
    public String pushDominoes(String dominoes) {
        int r[]=new int[dominoes.length()];
        Arrays.fill(r,Integer.MAX_VALUE);
        for(int i=0;i<r.length;i++)
        {
            char c=dominoes.charAt(i);
            if(c=='.' || c=='L')
                continue;
            if(c=='R')
            {
                int j=i+1;
                r[i]=0;
                int count=1;
                while(j<r.length && dominoes.charAt(j)!='L')
                {
                    r[j++]=count++;
                }
            }

        }

        int l[]=new int[dominoes.length()];
        Arrays.fill(l,Integer.MAX_VALUE);
        for(int i=l.length-1;i>=0;i--)
        {
            char c=dominoes.charAt(i);
            if(c=='.' || c=='R')
                continue;
            if(c=='L')
            {
                int j=i-1;
                l[i]=0;
                int count=1;
                while(j>=0 && dominoes.charAt(j)!='R')
                {
                    l[j--]=count++;
                }
            }

        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<l.length;i++)
        {
            if(l[i]==r[i])
            {
                sb.append('.');
            }else if(l[i]>r[i])
            {
                sb.append('R');
            }else sb.append('L');
        }


       // System.out.println(Arrays.toString(r));
       // System.out.println(Arrays.toString(l));
        return sb.toString();
    }
}
