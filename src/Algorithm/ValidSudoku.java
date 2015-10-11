package Algorithm;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
	    boolean result=false;
	    
	    //test two or more char[r][c] exist in  same row char[r][:]
	    for (int r=0;r<=8;r++){
	    	if (!isValidRow(r,board)) return false;
	    }
	    
	    //test two or more char[r][c] exist in  same column char[:][c]
	    for (int c=0;c<=8;c++){
	    	if (!isValidCol(c,board)) return false;
	    }
	    
	    //test two or more char[r][c] exist in square;
	        
	    
	    
	    return result;    
	}
	
	private boolean isValidinSquare(int row, int col, char[][] board){
		
		//0-2,3-5,6-8
		/*int start_row=row/3*3;
		int start_col=col/3*3;
		
		for (int r=start_row; r<=start_row+2; r++){
			if (r==row) continue;
			for (int c=start_col;c<=start_col+2; c++){
				if (c==col) continue;
				
				if (board[r][c]==board[row][col])
					return false;
			}
		}*/
		
		return true;
		
	}
	
	
	private boolean isValidRow( int row,char[][] board ){
		Set<Character> row_set=new HashSet<Character>();
		for (int c=0;c<=8;c++){
			if (!row_set.add( board[row][c])) return false;
		}
		return true;
		
	}
	
	private boolean isValidCol( int col,char[][] board ){
		Set<Character> col_set=new HashSet<Character>();
		for (int r=0;r<=8;r++){
			if (!col_set.add( board[r][col])) return false;
		}
		return true;
		
	}

}
