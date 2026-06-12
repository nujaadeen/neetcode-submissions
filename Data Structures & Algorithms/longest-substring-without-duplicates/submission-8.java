class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] charS = s.toCharArray();

        if (charS.length == 0) return 0;

        int start = 0;
        int end = 1;
        
        Set<Character> set = new HashSet<>();
        set.add(charS[start]);

        int maxLen = 1;

        while (end < charS.length) {
            if (set.contains(charS[end])) {
                start++;
                end = start + 1;
                set.clear();
                set.add(charS[start]);
            } else {
                maxLen = Math.max(maxLen, end-start+1);
                set.add(charS[end]);
                end++;
            }
        }
        return maxLen;
    }
}
