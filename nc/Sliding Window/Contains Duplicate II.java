class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        Set<Integer> window = new HashSet<>();
        int left = 0;
        for (int right = 0; right < nums.length; right++) {

            if (window.size() > k) {
                window.remove(nums[left]);
                left++;
            }

            if (window.contains(nums[right])) {
                return true;
            }

            window.add(nums[right]);
        }

        return false;
    }
}


class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
         Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length; i++) {
        if (map.containsKey(nums[i])) {
            if (i - map.get(nums[i]) <= k) return true;
        }
        map.put(nums[i], i);
    }
    return false;
    }
}
