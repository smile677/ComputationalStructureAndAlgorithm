package com.smile67.array;

public class _27 {
    public static void main(String[] args) {

    }

    /*
    给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素。元素的顺序可能发生改变。然后返回 nums 中与 val 不同的元素的数量。
    假设 nums 中不等于 val 的元素数量为 k，要通过此题，您需要执行以下操作：
    更改 nums 数组，使 nums 的前 k 个元素包含不等于 val 的元素。nums 的其余元素和 nums 的大小并不重要。
    返回 k。
    用户评测：
    评测机将使用以下代码测试您的解决方案：
    int[] nums = [...]; // 输入数组
    int val = ...; // 要移除的值
    int[] expectedNums = [...]; // 长度正确的预期答案。
                            // 它以不等于 val 的值排序。
    int k = removeElement(nums, val); // 调用你的实现
    assert k == expectedNums.length;
    sort(nums, 0, k); // 排序 nums 的前 k 个元素
    for (int i = 0; i < actualLength; i++) {
    assert nums[i] == expectedNums[i];
    }
    如果所有的断言都通过，你的解决方案将会 通过。

    示例 1：
    输入：nums = [3,2,2,3], val = 3
    输出：2, nums = [2,2,_,_]
    解释：你的函数函数应该返回 k = 2, 并且 nums 中的前两个元素均为 2。
    你在返回的 k 个元素之外留下了什么并不重要（因此它们并不计入评测）。
    示例 2：
    输入：nums = [0,1,2,2,3,0,4,2], val = 2
    输出：5, nums = [0,1,4,0,3,_,_,_]
    解释：你的函数应该返回 k = 5，并且 nums 中的前五个元素为 0,0,1,3,4。
    注意这五个元素可以任意顺序返回。
    你在返回的 k 个元素之外留下了什么并不重要（因此它们并不计入评测）。
    */
    // 使用O(1)额外的空间并原地修改
    // 数组的元素在内存地址空间中是连续的，不能删除数组中的某个元素，只能覆盖
    // 暴力解法 时间复杂度：O(n^2) 空间复杂度：O(1)
    public int removeElement1(int[] nums, int val) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == val) {
                for (int j = i + 1; j < len; j++) {
                    nums[j - 1] = nums[j];
                }
                // 因为下标 i 以后的数组都向前移动了一位, 所以 i 也要向前移动一位
                i--;
                len--;
            }
        }
        return len;
    }

    // 双指针 空间复杂度：O(1)  空间复杂度：O(1)
    public int removeElement2(int[] nums, int val) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }
    // 同向双指针 空间复杂度：O(1)  空间复杂度：O(1)
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length -1;
        while (left <= right){
            if(nums[left] == val){
                nums[left] = nums[right];
                right--;
            }else {
                left++;
            }
        }
        return left;
    }

}
