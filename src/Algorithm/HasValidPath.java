package Algorithm;

import java.util.LinkedList;

public class HasValidPath {

    public static void main(String[] args) {

        char[][] grid = new char[][]{
                {'(','(','('},{')','(',')'},{'(','(',')'},{'(','(',')'}
        };
        boolean isValid = hasValidPath(grid);
        System.out.println(" isvalid "+isValid);
    }
    public static boolean hasValidPath(char[][] grid) {
        return helper(grid,0,0,new LinkedList<Character>());
    }

    public static boolean helper(char[][] grid, int i , int j, LinkedList<Character> stack){
        //check id add grid[i][j] is valid

        System.out.println("init "+ ( i<= grid.length-1)+", "+ (j<=grid[0].length-1)+" i j "+ i+" "+ j  );
        // System.out.println("init "+ grid[i][j]  );

        if(i== grid.length-1 && j == grid[0].length-1){
            if(stack.size()==1 && stack.getLast()=='(' && grid[i][j]==')')
                return true;
            return false;
        } else if(stack.isEmpty() && grid[i][j]==')'){

            System.out.println("invalue "+ i +" "+j);
            return false;
        } else if(grid[i][j]==')' && stack.getLast()=='('){
            stack.removeLast();
            System.out.println("DX "+ i +" "+j);
            //go Down
            boolean res = false;
            if(i+1< grid.length) {
                System.out.println("1DN i + 1 "+ i+" , ");
                res = helper(grid, i + 1, j, stack);
                System.out.println("AFTER1DN i + 1 "+ i+" , ");
            }

            if(j+1<grid[0].length) {
                System.out.println("1RT j + 1 "+ j+" , "+ grid.length+" , "+ grid[0].length);
                res = res || helper(grid, i, j + 1, stack);
            }

            return res;
        } else if(grid[i][j]=='(' ){
            stack.add('(');
            System.out.println("NEW "+ i +" "+j);
            boolean res = false;
            if(i+1< grid.length) {
                System.out.println("DN i + 1 "+ i);
                res = helper(grid, i + 1, j, stack);
            }

            if(j+1<grid[0].length) {
                System.out.println("RT j + 1 "+ j);
                res = res || helper(grid, i, j + 1, stack);
            }
            //stack.removeLast();
            if(res== false && stack.getLast()=='(')
                stack.removeLast();
            return res;
        }

        return  false;
    }
}
