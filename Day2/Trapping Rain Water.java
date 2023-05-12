class Solution {                  // O(N) O(N)
    public int trap(int[] h) {
        int finalres=0;
        int l[]=new int[h.length];
        int r[]=new int[h.length];

        l[0]=h[0];
        for(int i=1;i<h.length;i++)
        {
            l[i]=Math.max(h[i],l[i-1]);
        }

        r[h.length-1]=h[h.length-1];
        for(int i=h.length-2;i>=0;i--)
        {
            r[i]=Math.max(h[i],r[i+1]);
        }

        for(int i=1;i<h.length-1;i++)
        {
            finalres+=Math.min(l[i],r[i])-h[i];
        }
        return finalres;
    }
}


class Solution {               //O(N) O(1)
    public int trap(int[] height) {
        int n = height.length;
  int lo = 0, hi = n - 1;
  int leftMax = 0, rightMax = 0;
  int water = 0;
  while (lo < hi) {
    // update
    if (height[lo] > leftMax)  leftMax = height[lo];
    if (height[hi] > rightMax) rightMax = height[hi];
    // compute
    if (leftMax < rightMax) { // consider the min
        water += (leftMax - height[lo]); // leftMax >= height[lo]
        ++lo;
    } else {
        water += (rightMax - height[hi]);
        --hi;
    }
  }
  return water;
    }
}
