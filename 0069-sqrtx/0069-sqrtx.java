class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x; // Square root of 0 is 0, and of 1 is 1.
        }
        
        int left = 0;
        int right = x;
        int result = 0;
        
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long midSq = mid * mid;
            
            if (midSq == x) {
                return (int) mid; // Exact square root found
            } else if (midSq < x) {
                result = (int) mid;  // Store mid as a candidate for the result
                left = (int) mid + 1; // Search in the right half
            } else {
                right = (int) mid - 1; // Search in the left half
            }
        }
        
        return result;
    }
}
