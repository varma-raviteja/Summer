class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> l=new ArrayList<>();

        int carry=1;
        for(int i=digits.length-1;i>=0;i--)
        {
            int sum=digits[i]+carry;
            if(sum>=10)
            {
                carry=1;
            }
            else carry=0;
            l.add(0,sum%10);

        }

        if(carry==1)
            l.add(0,1);
        System.out.println(l);
        int ans[]=new int[l.size()];
        for(int i=0;i<l.size();i++)
            ans[i]=l.get(i);
        return ans;
    }
}
