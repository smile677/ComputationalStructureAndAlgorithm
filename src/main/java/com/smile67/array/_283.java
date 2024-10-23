package com.smile67.array;

public class _283 {
    public static void main(String[] args) {

    }
    /*
    给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
    请注意 ，必须在不复制数组的情况下原地对数组进行操作。
    示例 1:
    输入: nums = [0,1,0,3,12]
    输出: [1,3,12,0,0]
    示例 2:
    输入: nums = [0]
    输出: [0]
    */
    // 右指针不断向右移动，每次右指针指向非零数，则将左右指针对应的数交换，同时左指针右移。
    // 注意的点：
    // 1. 左指针左边均为非零数；
    // 2. 右指针左边直到左指针处均为零。

    // 双指针
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        while (right < n) {
            if(nums[right] != 0){
                swap(nums,left,right);
                left++;
            }
            right++;
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
