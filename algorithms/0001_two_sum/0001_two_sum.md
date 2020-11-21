## 1. Two Sum 两数之和
> [https://leetcode.com/problems/two-sum](https://leetcode.com/problems/two-sum)<br />Easy | 2020-11-21 **@threepotatox**
> 
> <br />[https://leetcode-cn.com/problems/two-sum](https://leetcode-cn.com/problems/two-sum/)<br />简单 | 2020-11-21 **@有三只土豆**

### 题目描述：

给定一个整数数组 `nums` 和一个目标值 `target`，请你在该数组中找出和为目标值的那 **两个** 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 
**示例：**
```nohighlight
给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
```

### 设计思路：
一次遍历，用哈希表存储遍历过的值和对应下标
- 若 (j = target - nums[i]) 在哈希表中，则成功找到，返回结果
- 若不在，则将当前值 nums[i] 存入哈希表，继续遍历

关键词：哈希表
### 实现代码 (Java)：
```java
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
```