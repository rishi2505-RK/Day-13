class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] ans = new int[n];
        int index = 0;

        // Add elements smaller than pivot
        for (int num : nums) {
            if (num < pivot) {
                ans[index++] = num;
            }
        }

        // Add elements equal to pivot
        for (int num : nums) {
            if (num == pivot) {
                ans[index++] = num;
            }
        }

        // Add elements greater than pivot
        for (int num : nums) {
            if (num > pivot) {
                ans[index++] = num;
            }
        }

        return ans;
    }
}