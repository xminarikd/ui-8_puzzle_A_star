package src;

public class Runner {

    public static void main(String[] args){

        int[][] start = { {1, 8, 2}, {0, 4, 3}, {7, 6, 5} };
        int[][] ciel = { {1, 2, 3}, {4, 5, 6}, {7, 8, 0} };

        int x = 1;
        int y = 0;

        Astar na = new Astar();
        na.solve(start,ciel,x,y,1);
        System.out.println("Dokon4il som neviem co :D");
    }

}
