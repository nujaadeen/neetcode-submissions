class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;

        char[] charStr = s.toLowerCase().toCharArray();

        while (left < right) {
            while (left < right && !isAlphaNum(charStr[left])) left++;
            
            while (left < right && !isAlphaNum(charStr[right])) right--;

            if (charStr[left] != charStr[right])
                return false;

            left++;
            right--;
        }
        return true;
    }

    private boolean isAlphaNum(char c) {
        return (('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z') || ('0' <= c && c <= '9'));
    }
}
