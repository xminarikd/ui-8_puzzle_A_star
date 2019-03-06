package src;

public class Runner {

    public static void main(String[] args){

      /*  int[][] start = { {8, 0, 6}, {5, 4, 7}, {2, 3, 1} };
        int[][] ciel = { {0, 1, 2}, {3, 4, 5}, {6, 7, 8} };

        int x = 0;
        int y = 1;
*/
        int[][] start = { {4, 3, 2, 6, 1}, {9, 8, 7, 5, 0} };
        int[][] ciel = { {0, 1, 2, 3, 4}, {5, 6, 7, 8, 9} };

        int x = 1;
        int y = 4;

        Astar na = new Astar();
        na.setSirka(5);
        na.setVyska(2);
        na.solve(start,ciel,x,y,2);
    }

}
