class Solution {
public:
    int missingNumber(vector<int>& nums) {
       int x1 = 0, x2 = 0;
       int n = nums.size();
       for(int i=0; i<n; i++){
        x2 = x2 ^ nums[i];
        x1 = x1 ^ (i+1);
       }
       return (x1 ^ x2);
    }
};