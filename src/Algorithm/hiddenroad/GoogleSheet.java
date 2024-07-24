package Algorithm.hiddenroad;

import javax.xml.transform.stream.StreamSource;
import java.util.*;

public class GoogleSheet {
    public static void main(String[] args) {
        GoogleSheet sheet = new GoogleSheet();
        sheet.init();
        sheet.print(2);


        Set<Integer> newDeps = new HashSet<>();
        newDeps.add(1);
        sheet.update(2, "B2", newDeps);

    }


        Map<Integer, Cell> cells = new HashMap<>();
        public void init(){
         Cell cellA = new Cell(1);
         Cell cellB = new Cell(2);
         Cell cellC = new Cell(3);
         Cell cellD = new Cell(4);

         /*
            A -> B -> D
                 ^
                 C
          */
         cellA.dependants.add(cellB);
         cellB.dependencies.add(cellA);
         cellB.dependencies.add(cellC);
         cellB.dependants.add(cellD);
         cellC.dependants.add(cellB);

         cellD.dependencies.add(cellB);

         this.cells.put(cellA.location,cellA);
            this.cells.put(cellB.location,cellB);
            this.cells.put(cellC.location,cellC);
            this.cells.put(cellD.location,cellD);



        }

        public void print(int location ){
            Cell cell = cells.get(location);
            for(Cell c: cell.dependencies){
                print(c.location);
            }
            System.out.println("Val: "+ cell.val);
        }

        public void update(int location , String str, Set<Integer> dependecies){
            System.out.println(" update cell "+location);
            Cell cell = cells.get(location);
            cell.val = str;
            if(dependecies!=null) {
                cell.dependencies.clear();
             for(Integer c:    dependecies){
                 cell.dependencies.add(cells.get(c));
             }
             print(cell.location);
            }

            System.out.println(" update donwstream ");
            for(Cell c : cell.dependants){
                print(c.location);
            }


        }


    class Cell{
        int location;
        Set<Cell> dependencies  = new HashSet<>();
        Set<Cell> dependants = new HashSet<>();//updating this cell , will trigger updating dapendants
        String function;
        String nestFunction;
        String val="";

        Cell( int loc ){
            this.location = loc;
            this.val += loc;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell cell = (Cell) o;
            return location == cell.location;
        }

        @Override
        public int hashCode() {
            return Objects.hash(location);
        }
    }
}
