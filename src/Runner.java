package src;

public class Runner {

    public static void main(String[] args){

        byte[][] start = { {8, 0, 6}, {5, 4, 7}, {2, 3, 1} };
        byte[][] ciel = { {0, 1, 2}, {3, 4, 5}, {6, 7, 8} };

        int x = 0;
        int y = 1;

      /*
        byte[][] start = { {5, 10, 3, 2, 7, 1}, {11, 4, 9, 8, 6, 0} };
        byte[][] ciel = { {0, 1, 2, 3, 4, 5}, {6, 7, 8, 9, 10, 11} };

        int x = 1;
        int y = 5;
*/
        Astar na = new Astar();
        na.setSirka(3);
        na.setVyska(3);
        na.solve(start,ciel,x,y,2);
    }

}
