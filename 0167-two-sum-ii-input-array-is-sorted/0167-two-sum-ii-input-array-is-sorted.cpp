#include <vector>

class Solution {
public:
    std::vector<int> twoSum(std::vector<int>& numbers, int target) {
        int left = 0;
        int right = numbers.size() - 1;
        
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                return std::vector<int>{left + 1, right + 1};
            }
        }
        return std::vector<int>(); 
    }
};
