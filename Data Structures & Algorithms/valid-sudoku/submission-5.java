class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> colMap = new HashMap<>();
        Map<Integer, Set<Character>> subBoxMap = new HashMap<>();

        for (int row=0; row < board.length; row++) {
            Set<Character> rowSet = new HashSet<>();

            for (int col=0; col < board[row].length; col++){
                char c = board[row][col];

                if (c == '.') continue;

                if (c < '1' || c > '9') return false;

                if (!rowSet.add(c)) return false;

                if (!colMap.computeIfAbsent(col, k -> new HashSet<>()).add(c)) 
                    return false;
                
                int subBoxKey = row/3 * 3 + col/3;
                if (!subBoxMap.computeIfAbsent(subBoxKey, k -> new HashSet<>()).add(c)) 
                    return false;
            }
        }

        return true;
    }
}
