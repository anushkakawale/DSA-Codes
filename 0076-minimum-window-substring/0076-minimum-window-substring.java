import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }

        // Map to store the frequency of characters in string `t`
        Map<Character, Integer> mapT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }

        int required = mapT.size(); // Number of unique characters needed
        int l = 0, r = 0; // Two pointers
        int formed = 0; // To track how many characters are formed correctly
        int[] ans = {-1, 0, 0}; // Result array: {window size, left, right}

        // Map to store the frequency of characters in the current window
        Map<Character, Integer> subStringMap = new HashMap<>();

        while (r < s.length()) {
            // Add the character at position `r` to the window
            char c = s.charAt(r);
            subStringMap.put(c, subStringMap.getOrDefault(c, 0) + 1);

            // If this character's frequency matches the required frequency in `t`
            if (mapT.containsKey(c) && subStringMap.get(c).intValue() == mapT.get(c).intValue()) {
                formed++;
            }

            // Contract the window until it ceases to be 'desirable'
            while (l <= r && formed == required) {
                c = s.charAt(l);

                // Update the result if the current window is smaller
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                // Remove the character at position `l` from the window
                subStringMap.put(c, subStringMap.get(c) - 1);
                if (mapT.containsKey(c) && subStringMap.get(c).intValue() < mapT.get(c).intValue()) {
                    formed--;
                }

                l++; // Contract the window
            }

            r++; // Expand the window
        }

        // If no valid window was found, return an empty string
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
