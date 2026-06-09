class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> colMap = new HashMap<>();
        Map<List<Integer>, Set<Character>> subBoxMap = new HashMap<>();

        for (int row=0; row < board.length; row++) {
            Set<Character> rowSet = new HashSet<>();

            for (int col=0; col < board[row].length; col++){
                char c = board[row][col];

                if (c == '.') continue;

                if (c < '1' || c > '9') return false;

                if (!rowSet.add(c)) return false;

                if (!colMap.computeIfAbsent(col, k -> new HashSet<>()).add(c)) 
                    return false;
                
                if (!subBoxMap.computeIfAbsent(List.of(row/3, col/3), k -> new HashSet<>()).add(c)) 
                    return false;
            }
        }

        return true;
    }
}
