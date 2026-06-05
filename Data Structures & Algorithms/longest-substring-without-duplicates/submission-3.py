class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        start, end = 0, 0
        sub_string = set()
        maxLen = 0

        while end < len(s):
            while start <= end and s[end] in sub_string:
                sub_string.remove(s[start])
                start += 1 
            sub_string.add(s[end]) 
            maxLen = max(maxLen, len(sub_string)) 
            end += 1   
        return maxLen