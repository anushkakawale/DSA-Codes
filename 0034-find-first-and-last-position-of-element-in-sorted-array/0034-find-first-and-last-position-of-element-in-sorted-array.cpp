class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int first = findBound(nums, target, true);
        if (first == -1) {
            return {-1, -1};
        }
        int last = findBound(nums, target, false);
        return {first, last};
    }

private:
    int findBound(vector<int>& nums, int target, bool isFirst) {
        int start = 0;
        int end = nums.size() - 1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;  // Prevent potential overflow
            
            if (nums[mid] == target) {
                if (isFirst) {
                    // Check if it's the first occurrence
                    if (mid == start || nums[mid - 1] != target) {
                        return mid;
                    }
                    end = mid - 1;
                } else {
                    // Check if it's the last occurrence
                    if (mid == end || nums[mid + 1] != target) {
                        return mid;
                    }
                    start = mid + 1;
                }
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
};
