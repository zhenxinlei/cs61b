package Algorithm;

import java.util.HashSet;
import java.util.Set;

public class NumberOfIsland {
	public static void main(String[] args) {
		//char[][] grid = new char[4][5];
		
		String input = "11110,11010,11000,00000";
		input="11000,11000,00100,00011";
		input="1011011";
		input = "111111,100001,101101,100001,111111";
		input = "111,101,111";
		char[][] grid= generateGrid(input);
		
		int size = solution(grid);
		System.out.println(size);
		
	}

	private static int solution(char[][] grid) {
		if (grid.length==0)
			return 0;
		
		Land[][] landMtx = new Land[grid.length][grid[0].length];
		
		int islandCt = 0 ;
        int row = grid.length;
        int col = grid[0].length;
        System.out.println(" i,j");
        Set<String> set = new HashSet<String>();
        for( int i = 0 ; i<row;i++){
            for (int j=0; j<col;j++){
                System.out.println(" i,j"+i+","+j+"--"+grid[i][j]);
                if(grid[i][j]!='0'){
                    //check lndId mtx left , up right island 
                    Land l = new Land(i,j);
                    if(i>0 && i<row && j>0 ){ //general case
                        if(grid[i-1][j]=='0' &&grid[i][j-1]=='0' ){
                             System.out.println("+++ i,j"+i+","+j+", --- "+landMtx[i][j-1]);
                            l.parent=l.id;
                            landMtx[i][j]=l;
                            set.add(l.parent);
                            System.out.println(" add parent "+ i+", "+j+", p"+l.parent);
                        } else  {
                        	landMtx[i][j]=l;
                        	l.parent= l.id;
                            if (grid[i][j-1]!='0'){
                                // landMtx[i][j]=l;
                                l.parent=landMtx[i][j-1].parent;
                            }
                            
                            
                            System.out.println(grid[i-1][j]+" landMtx[i-1][j] "+ landMtx[i-1][j]+",");
                            System.out.println("-- "+landMtx[i][j].parent);
                            if (grid[i-1][j]!='0' && !landMtx[i-1][j].parent.equals(landMtx[i][j].parent) ){
                                set.remove(landMtx[i][j].parent);
                                
                                System.out.println(" rm parent "+ i+", "+j+", p"+l.parent);
                                
                                l.parent=landMtx[i-1][j].parent;
                                set.add(landMtx[i][j].parent);
                            }
                            
                        }
                    } else if(i==0){
                        if( j != 0){
                            // check left 
                            if (grid[i][j-1]!='0'){
                                System.out.println("+++ i,j"+i+","+j+", --- "+landMtx[i][j-1]);
                                l.parent=landMtx[i][j-1].parent;
                                landMtx[i][j]=l;
                            } else {
                            	landMtx[i][j]=l;
                            	l.parent=l.id;
                            	
                            }
                            
                        } else { // i=0, j=0
                            l.parent=l.id;
                            landMtx[i][j]=l;
                            set.add(l.parent);
                            System.out.println(" add parent "+ i+", "+j+", p"+l.parent);
                        }
                    } else if (j==0){
                         if( i != 0){
                            // check up 
                            if (grid[i-1][j]!='0'){
                                 System.out.println("+++ i,j"+i+","+j+", --- "+landMtx[i-1][j].parent);
                                 landMtx[i][j]=l;
                                l.parent=landMtx[i-1][j].parent;
                            }else {
                            	landMtx[i][j]=l;
                            	l.parent=l.id;
                            	set.add(l.parent);
                            	  System.out.println(" add parent "+ i+", "+j+", p"+l.parent);
                            }
                            
                        } 
                    }
                    
                    
                }
                
                
            }
        }
        
        return set.size();
		
	}

	private static char[][] generateGrid( String input) {
		
		if(input.isEmpty())
		 return new char[0][0];

		String[] rows = input.split(",");
		
		int r = rows.length;
		int c = rows[0].length();
		char[][] grid = new char[r][c];
		
		for (int i =0;i<grid.length;i++){
			for (int j=0;j<grid[0].length;j++){
				grid[i][j]=rows[i].charAt(j);
			}
		}
		
		return grid;
	}
	
	 public static class Land{
	        String id;
	        String parent;
	        Land(int row, int col){
	            id = String.valueOf(row)+String.valueOf(col);
	        }
	    }
}
