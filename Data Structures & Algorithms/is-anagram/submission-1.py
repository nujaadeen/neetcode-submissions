class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        hashMap = {}
        if len(s) != len(t):
            return False
        for char in s:
            hashMap[char] = hashMap.get(char, 0) + 1
        for char2 in t:
            if char2 in hashMap:
                if hashMap.get(char2, 0) == 0:
                    return False
                else:
                    hashMap[char2] = hashMap.get(char2, 0) - 1
            else:
                return False
        return True

            