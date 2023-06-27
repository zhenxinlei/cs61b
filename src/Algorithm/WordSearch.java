package Algorithm;

public class WordSearch {

    public static void main(String[] args) {

        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        boolean isFound = exist(board, "SEE");
        System.out.println(" isFoung "+isFound);
    }

    public static boolean exist(char[][] board, String word) {

        StringBuilder sb = new StringBuilder();
        int[][] visited = new int[board.length][board[0].length];
        boolean isFound = false;
        int index =0;
        for(int i =0; i<board.length;i++){
            for( int j =0; j< board[0].length;j++){
                isFound= board[i][j]==word.charAt(0) && helper (word,index, board, visited, i,j);
                if(isFound)
                    return isFound;
            }
        }
        return isFound;

    }

    public static boolean helper(String word, int index, char[][] board, int[][] visited,  int r, int c){


        if(r<0 || r>= board.length || c<0 || c>=board[0].length || visited[r][c]==1){
            return false;
        }
        if(index==word.length()){
            return true;
        }

        if(word.charAt(index) != board[r][c]){
            return false;
        }

        visited[r][c]=1; // other option modify board[r][c]= '*' some invalid char , to repersent visited
        // reverse back to valid char after check all direction

        if(helper(word, index+1, board,visited, r-1,c)||
                helper(word, index+1, board,visited, r+1,c)||
                helper(word, index+1, board,visited, r,c-1)||
                helper(word, index+1, board,visited, r,c+1))
            return true;
        visited[r][c]=0;

        return false;
    }
}
