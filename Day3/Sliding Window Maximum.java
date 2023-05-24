class Solution {   //Time Limit Exceeded
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq =new PriorityQueue<>(Collections.reverseOrder());

        int res[]=new int[nums.length-k+1];

        for(int i=0;i<k;i++)
        {
            pq.add(nums[i]);
        }
        res[0]=pq.peek();
        int j=1;
        int l=0;
        for(int i=k;i<nums.length;i++)
        {
           
            pq.remove(nums[j-1]);
            pq.add(nums[i]);
            res[j]=pq.peek();       
            j++;

        }

        return res;

    }
}



//Deque O(N)
class Solution {
   public int[] maxSlidingWindow(int[] a, int k) {		
		if (a == null || k <= 0) {
			return new int[0];
		}
		int n = a.length;
		int[] r = new int[n-k+1];
		int ri = 0;
		// store index
		Deque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < a.length; i++) {
			// remove numbers out of range k
			while (!q.isEmpty() && q.peek() < i - k + 1) {
				q.poll();
			}
			// remove smaller numbers in k range as they are useless
			while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
				q.pollLast();
			}
			// q contains index... r contains content
			q.offer(i);
			if (i >= k - 1) {
				r[ri++] = a[q.peek()];
			}
		}
		return r;
	}
}
