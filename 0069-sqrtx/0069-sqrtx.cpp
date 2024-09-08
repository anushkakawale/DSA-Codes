class Solution {
public:
    int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x; // Square root of 0 is 0, and of 1 is 1.
        }
        
        int left = 0;
        int right = x;
        int result = 0;
        
        while (left <= right) {
            long long mid = left + (right - left) / 2;
            long long midSq = mid * mid;
            
            if (midSq == x) {
                return mid; // Exact square root found
            } else if (midSq < x) {
                result = mid;  // Store mid as a candidate for the result
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }
        
        return result;
    }
};
