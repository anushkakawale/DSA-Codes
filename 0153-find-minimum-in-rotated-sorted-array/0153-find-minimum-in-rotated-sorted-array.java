class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If the middle element is greater than the rightmost element,
            // the smallest value is in the right half.
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // Otherwise, the smallest value is in the left half (including mid).
                right = mid;
            }
        }

        // At the end of the loop, left == right, pointing to the smallest element.
        return nums[left];
    }
}
