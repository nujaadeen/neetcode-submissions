class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] charS = s.toCharArray();

        int start = 0;
        int end = 0;
        
        Set<Character> set = new HashSet<>();

        int maxLen = 0;

        while (end < charS.length) {
            while (start < end && set.contains(charS[end])){
                set.remove(charS[start]);
                start++;
            } 
            maxLen = Math.max(maxLen, end-start+1);
            set.add(charS[end]);
            end++;
        }
        return maxLen;
    }
}
