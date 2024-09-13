class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        // Initialize result vector with the same size as nums
        vector<int> result(nums.size(), 1);  // Fill it with 1 to ensure proper multiplication

        int pre = 1, post = 1;

        // First loop to store the prefix product in result array
        for (int i = 0; i < nums.size(); i++) {
            result[i] = pre;  // Assign current prefix product to result[i]
            pre = nums[i] * pre;  // Update prefix product
        }

        // Second loop to store the suffix product
        for (int i = nums.size() - 1; i >= 0; i--) {
            result[i] = result[i] * post;  // Multiply current suffix product with the stored prefix
            post = post * nums[i];  // Update suffix product
        }

        return result;
    }
};
