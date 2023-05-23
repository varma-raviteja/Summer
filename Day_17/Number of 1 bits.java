public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res=1;
        int count=0;
        for(int i=0;i<32;i++)
        {
            if((res & n)==1)
            count++;
            n=n>>1;
        }
        return count;
    }
}
