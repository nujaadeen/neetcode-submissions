class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> colMap = new HashMap<>();
        Map<List<Integer>, Set<Character>> subBoxMap = new HashMap<>();

        for (int row=0; row < board.length; row++) {
            Set<Character> rowSet = new HashSet<>();

            for (int col=0; col < board[row].length; col++){
                char c = board[row][col];

                if (c != '.' && (c < '1' || c > '9' || rowSet.contains(c))) {
                    return false;
                }
                rowSet.add(c);
                
                Set<Character> colSet = colMap.getOrDefault(col, new HashSet<Character>());

                if (c != '.' && (c < '1' || c > '9' || colSet.contains(c))) {
                    return false;
                }
                colSet.add(c);
                colMap.put(col, colSet);

                Set<Character> subBoxSet = subBoxMap.getOrDefault(List.of(row/3, col/3), new HashSet<Character>());

                if (c != '.' && (c < '1' || c > '9' || subBoxSet.contains(c))) {
                    return false;
                }
                subBoxSet.add(c);
                subBoxMap.put(List.of(row/3, col/3), subBoxSet);
            }
        }

        System.out.println(colMap);
        return true;
    }
}
