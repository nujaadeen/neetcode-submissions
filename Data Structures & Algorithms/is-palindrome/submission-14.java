class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;

        char[] charStr = s.toLowerCase().toCharArray();

        while (start < end) {
            while (!Character.isLetterOrDigit(charStr[start]) || charStr[start]==' ') {
                if (start < s.length() - 1) {
                    start++;
                } else {
                    break;
                }
            }
            
            while (!Character.isLetterOrDigit(charStr[end]) || charStr[end]==' '){
                if(end > 0) {
                    end--;
                } else {
                    break;
                }
            }

            if (start < end && charStr[start] != charStr[end])
                return false;

            start++;
            end--;
        }
        return true;
    }
}
