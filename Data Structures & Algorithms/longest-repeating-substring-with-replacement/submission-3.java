class Solution {
    public int characterReplacement(String s, int k) {
        char[] charS = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        int start = 0;

        int maxFeq = 0;
        int maxLen = 0;
        
        for (int end=0; end < charS.length; end++){
            map.put(charS[end], map.getOrDefault(charS[end], 0) + 1);
            maxFeq = Math.max(maxFeq, map.get(charS[end]));

            while (((end-start+1)-maxFeq) > k) {
                map.put(charS[start], map.get(charS[start]) -1);
                start++;
            }
            maxLen = Math.max(maxLen, end-start+1);
        }

        return maxLen;
    }
}
