class Solution {
    public int countSubstrings(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans += checkPalindrome(s, i, i);     // Odd length palindromes
            ans += checkPalindrome(s, i, i + 1); // Even length palindromes
        }
        return ans;
    }

    public int checkPalindrome(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            count++;
        }
        return count;
    }
}
