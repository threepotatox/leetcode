## 3. Longest Substring Without Repeating Characters 无重复字符的最长子串
> [https://leetcode.com/problems/longest-substring-without-repeating-characters/](https://leetcode.com/problems/longest-substring-without-repeating-characters/)
> Medium | 2020-11-28 **@threepotatox**
> <br />[https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/)
> 中等 | 2020-11-28 **@有三只土豆**

### 题目大意：
给定一个字符串，请你找出其中不含有重复字符的 **最长子串** 的长度。


**示例 1:**
```nohighlight
输入: s = "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
```
**示例 2:**
```nohighlight
输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
```
**示例 3:**
```nohighlight
输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
```
**示例 4:**
```nohighlight
输入: s = ""
输出: 0
```

**提示：**
- 0 <= s.length <= 5 * 10<sup>4</sup>
- s 由英文字母、数字、符号和空格组成

### 设计思路：
滑动窗口
1. 用两个指针指向子串的左右边界
2. 用 Map 存储每个字符在子串中的位置
3. 右指针每次向右移动一个字符
    - 若哈希表中存在当前右指针所指字符，且大于左指针的位置，
    - 则左指针向右直接跳到哈希表记录的位置
4. 记录每次子串的最大值

例如字符串 `"abcdbaf"`，
- 当遇到第二个字符 `'b'` 时，左侧指针 i 可以直接跳到字符 `'c'` 处，
- 当遇到第二个字符 `'a'` 时，因为第一个 `'a'` 已经不在子串的范围，所以左侧指针 i 不动

关键词：最长子串，滑动窗口，哈希
### Java 版：
```java
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
```