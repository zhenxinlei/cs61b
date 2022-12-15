package Algorithm;

import java.util.LinkedList;

public class ShortestPathInAGridWithObstaclesElimination {

    public static void main(String[] args) {
        ShortestPathInAGridWithObstaclesElimination obj = new ShortestPathInAGridWithObstaclesElimination();

       int res =  obj.shortestPath(new int[][]{{0,0,0}, {1,1, 0}, {0,0,0}, {0, 1,1}, {0,0,0}}, 1);
       System.out.println(res);

       // int res = obj.shortestPath(new int[][] {{0,1,0,0,0,1,0,0},{0,1,0,1,0,1,0,1},{0,0,0,1,0,0,1,0}}, 1);
        //System.out.println(res);

    }
    public class State{
        int k;
        int x;
        int y;
        int step;
        public State(int x,int y, int k, int step){
            this.x = x;
            this.y = y;
            this.k = k;
            this.step = step;
        }
    }
    public int shortestPath(int[][] grid, int k) {
        int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        int m = grid.length, n = grid[0].length;
        State[][] visited = new State[m][n];

        for (int r =0; r<m; r++ ){
            for(int c = 0;  c< n; c++){
                visited[r][c] = new State(r,c,Integer.MAX_VALUE, Integer.MAX_VALUE);
            }
        }

        State s = new State(0,0,k,0);
        LinkedList<State> cur = new LinkedList<>();
        cur.addLast(s);

        visited[0][0]=s;
        //O(M*N*K)
        while(!cur.isEmpty()){
            s= cur.removeFirst();

            for (int[]dir :DIRECTIONS ){
                int newX = s.x+dir[0];
                int newY = s.y+dir[1];

                if(newX<0||newX>=m || newY<0 || newY>=n)
                    continue;

                State v = visited[newX][newY];
                int newK = grid[newX][newY]==1?s.k-1:s.k;
                int newS = s.step+1;

                if(newK<0)
                    continue;
                else{
                    if(newS<v.step  || newK>v.k){ //should add back any possible cell, even visted before,
                         // update node if better than visited
                        if(newX==m-1 && newY == n-1){
                            if(newS<v.step) {//only need to check min step if it is then end node
                                v.k = newK;
                                v.step = newS;
                            }
                        } else {
                            v.k = newK;
                            v.step = newS;
                            cur.addLast(v);
                        }
                    }
                }


            }

        }

        return visited[m-1][n-1].step==Integer.MAX_VALUE?-1:visited[m-1][n-1].step ;
    }

}
