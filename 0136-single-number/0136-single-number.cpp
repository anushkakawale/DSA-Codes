class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int n = nums.size();
        int xxor = 0;
        for(int i=0; i<n; i++){
            xxor = xxor ^ nums[i];
        }
        return xxor;
    }
};