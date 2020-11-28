class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int len = s.length();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0, j = 0; j < len; j++) {
            if (hashMap.containsKey(s.charAt(j))) {
                i = Math.max(hashMap.get(s.charAt(j)), i); //如果 get(s.charAt(j)) 小于 i，说明左侧重复的字符已经不在子串范围内，i 不用移动
            }
            ans = Math.max(j - i + 1, ans);
            hashMap.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}