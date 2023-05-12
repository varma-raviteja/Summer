// use an array to save numbers into different bucket whose index is the frequency O(N) O(N)
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        
        // corner case: if there is only one number in nums, we need the bucket has index 1.
        List<Integer>[] bucket = new List[nums.length+1];
        for(int n:map.keySet()){
            int freq = map.get(n);
            if(bucket[freq]==null)
                bucket[freq] = new LinkedList<>();
            bucket[freq].add(n);
        }
        
        List<Integer> res = new LinkedList<>();
        for(int i=bucket.length-1; i>0 && k>0; --i){
            if(bucket[i]!=null){
                List<Integer> list = bucket[i]; 
                res.addAll(list);
                k-= list.size();
            }
        }
        
        return res;
    }
}



// use maxHeap. Put entry into maxHeap so we can always poll a number with largest frequency
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
           
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = 
                         new PriorityQueue<>((a,b)->(b.getValue()-a.getValue())); //High freq stored first
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            maxHeap.add(entry);
        }
        
        List<Integer> res = new ArrayList<>();
        while(res.size()<k){
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            res.add(entry.getKey());
        }
        return res;
    }
}



class Solution {    //O(Nlogk) O(N+k) MINHEAP
    public int[] topKFrequent(int[] nums, int k) {
        // O(1) time
        if (k == nums.length) {
            return nums;
        }
        
        // 1. build hash map : character and how often it appears
        // O(N) time
        Map<Integer, Integer> count = new HashMap();
        for (int n: nums) {
          count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // init heap 'the less frequent element first'
        Queue<Integer> heap = new PriorityQueue<>(
            (n1, n2) -> count.get(n1) - count.get(n2));

        // 2. keep k top frequent elements in the heap
        // O(N log k) < O(N log N) time
        for (int n: count.keySet()) {
          heap.add(n);
          if (heap.size() > k) heap.poll();    
        }

        // 3. build an output array
        // O(k log k) time
        int[] top = new int[k];
        for(int i = k - 1; i >= 0; --i) {
            top[i] = heap.poll();
        }
        return top;
    }
}



class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums)
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);

        int[] arr = new int[frequencyMap.size()];
        int i = 0;
        for (int key : frequencyMap.keySet())
            arr[i++] = key;

        int pivot = quickSelect(0, arr.length - 1, arr, arr.length - k, frequencyMap);
        return Arrays.copyOfRange(arr, pivot, arr.length);
    }

    private int quickSelect(int left, int right, int[] arr, int k, Map<Integer, Integer> frequencyMap) {
        int pivot = right, prev = left;
        for (int i = left; i < right; i++) {
            if (frequencyMap.get(arr[i]) < frequencyMap.get(arr[pivot])) {
                swap(prev, i, arr);
                prev++;
            }
        }
        swap(prev, pivot, arr);
        if (prev == k) return k;
        else if (k < prev) return quickSelect(left, prev - 1, arr, k, frequencyMap);
        else return quickSelect(prev + 1, right, arr, k, frequencyMap);
    }

    private void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
