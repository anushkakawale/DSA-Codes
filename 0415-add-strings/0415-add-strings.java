class Solution {
    public String addStrings(String num1, String num2) {
        // Initialize a StringBuilder to store the result
        StringBuilder result = new StringBuilder();

        // Initialize two pointers for num1 and num2 starting from their last digits
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        // Initialize carry to 0
        int carry = 0;

        // Loop through both strings until all digits are processed, or there's no carry left
        while (i >= 0 || j >= 0 || carry != 0) {
            // Get the current digit from num1 or use 0 if we've processed all its digits
            int digit1 = (i >= 0) ? num1.charAt(i) - '0' : 0;
            // Get the current digit from num2 or use 0 if we've processed all its digits
            int digit2 = (j >= 0) ? num2.charAt(j) - '0' : 0;

            // Sum the digits from num1, num2, and the carry
            int sum = digit1 + digit2 + carry;

            // Append the current digit (sum % 10) to the result
            result.append(sum % 10);

            // Update the carry for the next iteration
            carry = sum / 10;

            // Move the pointers leftward
            i--;
            j--;
        }

        // Reverse the result as we added digits from the least significant to the most significant
        return result.reverse().toString();
    }
}
