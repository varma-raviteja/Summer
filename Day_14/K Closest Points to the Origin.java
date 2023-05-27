class Solution {
    public int[][] kClosest(int[][] points, int K) {
		// Handle null/empty edge cases
        if (points == null || points.length == 0) return new int[0][0];
        
        /* We're using the Distance formula to calculate the distance of a set of x/y points to another set of x/y points.
           Formula: sqrt(x1^2 + x2^2 - y1^2 + y2^2), where x2 and y2 is the origin (0,0) in this case. 
           So our formula is: sqrt(x1^2 + 0 - y1^2 + 0)
           We can ignore the sqrt() part and just simplify to: x1^2 - y1^2. 
           Now remember that x1^2 is x1 * x1. So our formula for calculating distance becomes: x1 * x1 + y1 * y2
        */
        
        // We use a priorityQueue to implement a minHeap (calculates disatance for a and b and the sorts by shortest to farthest distance)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]) );
     
        /*  PriorityQueue<int[]> pq = new PriorityQueue<>(K, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]);
            }
        });
        */
        // Now load each set of points on to the minHead
        for (int i = 0; i < points.length; i++) {
            minHeap.offer(points[i]);
        }
        
        // Next we create an array to contain points up to K
        int[][] results = new int[K][2];
        
        // Then iterate and add elements from our minHeap up to K
        for (int i = 0; i < K; i++) {
            results[i] = minHeap.poll();
        }
        
        return results;
    }
}

Time Complexity: O(nlogn)
Space Complexity: O(n)
  
  
  
/********************************************************************************************************************************************/
  
  class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (a, b) -> (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]));
        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            ans[i][0] = points[i][0];
            ans[i][1] = points[i][1];
        }
        return ans;
    }
}

Time Complexity: O(nlogn)
Space Complexity: O(1)
  

/********************************************************************************************************************************************/
  
  class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int i = 0, j = points.length - 1;
        while(i < j) {
            int mid = partition(points, i, j);
            if(mid == K) break;
            if(mid < K) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return Arrays.copyOf(points, K);
    }
    
    private int partition(int[][] points, int start, int end) {
        int[] pivot = points[end];
        int swapIndex = start - 1;
        for(int i = start; i < end; i++) {
            if(value(points[i]) < value(pivot)) {
                swapIndex++;
                swap(points, swapIndex, i);
            }
        }
        swap(points, ++swapIndex, end);
        return swapIndex;
    }
    
    private int value(int[] a) {
        return a[0] * a[0] + a[1] * a[1];
    }
    
    private void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
}

O(N) - Average Case   O(N^2) - Worst Case
O(1) - Space Complexity.
  
  
