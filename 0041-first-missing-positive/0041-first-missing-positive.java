class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Check if 1 is present in the array
        boolean containsOne = false;
        for (int num : nums) {
            if (num == 1) {
                containsOne = true;
                break;
            }
        }
        if (!containsOne) {
            return 1; // If 1 is not present, the first missing positive is 1
        }

        // Step 2: Replace non-positive numbers and numbers larger than n with 1
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1; // Replace with 1 if it's non-positive or out of range
            }
        }

        // Step 3: Use the array indices to mark the presence of numbers
        for (int i = 0; i < n; i++) {
            int a = Math.abs(nums[i]);
            if (a == n) {
                nums[0] = -Math.abs(nums[0]); // Special case for 'n'
            } else {
                nums[a] = -Math.abs(nums[a]); // Mark the presence of a
            }
        }

        // Step 4: Find the first missing positive
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                return i; // The index + 1 is the first missing positive
            }
        }

        // If nums[0] is positive, that means 1 is missing
        if (nums[0] > 0) {
            return n; // The first missing positive is n
        }

        return n + 1; // Otherwise, it's n + 1
    }
}
