class KthLargest {
    PriorityQueue<Integer> pq;
    int k=0;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        for(int i: nums) {
            this.add(i); // call class's own function, instead of repeating yourself
        }
    }
    
    public int add(int val) {
        pq.add(val);
        if(pq.size()>k) { // remove elements ONLY when heap size is too big
            pq.remove();
        }
        return pq.peek();
    }
}

Time complexity: O((n+m)∗log(k)) where m is the number of calls to the add method
Space complexity: O(k)
  
Notes:
Check line 8, we are making sure that the size of minheap is k.
Kth largest - use minheap and vice versa
