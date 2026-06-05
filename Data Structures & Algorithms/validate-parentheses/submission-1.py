class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        hashMap = {
            ')': '(',
            ']': '[',
            '}': '{'
        }
        for char in s:
            if char in hashMap:
                if len(stack) and stack[-1]==hashMap[char]:
                    stack.pop()
                else:
                    return False
            else:
                stack.append(char)
        if len(stack) == 0:
            return True
        else:
            return False
