class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int j = target - nums[i];
            if (hashMap.containsKey(j)) {
                return new int[]{hashMap.get(j), i};
            }
            hashMap.put(nums[i], i);
        }
        return null;
    }
}
