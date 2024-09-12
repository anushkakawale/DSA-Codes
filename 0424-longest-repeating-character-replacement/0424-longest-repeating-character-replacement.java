class Solution {
    public int characterReplacement(String s, int k) {
        int[] occurence = new int[26];
        int left = 0, ans = 0, maxOcc = 0;
        for(int right = 0; right < s.length(); right++){
            maxOcc = Math.max(maxOcc, ++occurence[s.charAt(right)-'A']);
            if(right - left + 1 - maxOcc > k){
                occurence[s.charAt(left)-'A']--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}