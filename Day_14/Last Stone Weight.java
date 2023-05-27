class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int st: stones) pq.add(st);
        while(pq.size() > 1) {
            int stone1 = pq.poll();
            int stone2 = pq.poll();
            if(stone1 > stone2) pq.add(stone1-stone2);
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }
}


Time complexity: O(n log n)

Space complexity: O(n)
  
Notes:
Collections.reverseOrder() for maxheap.
If Queue is empty then poll() method will return null . While in similar case , remove() method will throw NoSuchElementException. 
peek() method retrieves but does not remove the head of the Queue. If queue is empty then peek() method also returns null.
