class Solution:
    def isPalindrome(self, s: str) -> bool:
        l_ptr = 0
        r_ptr = len(s) - 1

        while l_ptr < r_ptr:
            while l_ptr < r_ptr and not s[l_ptr].isalnum():
                l_ptr += 1
            while r_ptr > l_ptr and not s[r_ptr].isalnum():
                r_ptr -= 1
            if s[l_ptr].lower() != s[r_ptr].lower():
                return False
            l_ptr += 1
            r_ptr -= 1
        return True
            

