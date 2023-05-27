class Solution {

    public int findKthLargest(int[] nums, int k) {
        //create a min heap
        PriorityQueue<Integer> heap = new PriorityQueue();

        //iterate over the array
        for (int n : nums) {
            //first add the integer to heap
            heap.add(n);
            //if size of the heap is greater than k
            if (heap.size() > k) {
                //remove the root element (lowest of all)
                heap.poll();
            }
        }
        //finally heap has k largest elements left with root as the kth largest element
        return heap.peek();
    }
}


Time complexity:
Min Heap: The time complexity of this approach is O(nlogk), where n is the size of the array and k is the number of largest elements we need to keep track of in the heap. We iterate over n elements and each heap operation takes logk time.

Max Heap: The time complexity of this approach is O(nlogn), where n is the size of the array. We initialize the heap with n elements, and each heap operation takes logn time.

Space complexity:
Min Heap: The space complexity of this approach is O(k), where k is the number of largest elements we need to keep track of in the heap.

Max Heap: The space complexity of this approach is O(n), where n is the size of the array as we need to store all the elements in the heap.
  
  /*******************************************************************************************************************************************/
  
  
  class Solution {
  public int findKthLargest(int[] nums, int k) {
  return quickSelect(nums, 0, nums.length - 1, k);
}

int quickSelect(int[] nums, int low, int high, int k) {
  int pivot = low;

  // use quick sort's idea
  // put nums that are <= pivot to the left
  // put nums that are  > pivot to the right
  for (int j = low; j < high; j++) {
    if (nums[j] <= nums[high]) {
      swap(nums, pivot++, j);
    }
  }
  swap(nums, pivot, high);
  
  // count the nums that are > pivot from high
  int count = high - pivot + 1;
  // pivot is the one!
  if (count == k) return nums[pivot];
  // pivot is too small, so it must be on the right
  if (count > k) return quickSelect(nums, pivot + 1, high, k);
  // pivot is too big, so it must be on the left
  return quickSelect(nums, low, pivot - 1, k - count);
}
private void swap(int[] nums, int x, int y) {
	int temp = nums[x];
	nums[x] = nums[y];
	nums[y] = temp;
}

}

TC Averrage Case
O(1) -SC
