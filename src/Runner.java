package src;

/**
 *  Trieda, ktora obsahuje testovacie scenare, ktora sa taktiez tu spustaju
 */
public class Runner {

    private static byte[][] start;
    private static byte[][] ciel;
    private static int x_blank;
    private static int y_blank;


    public static void main(String[] args) {

        test1();
        test1_2();
//        test2();
//        test3();
//        test4();
    }

    /**
     *
     * @param sirka sirka plochy hlavolamu
     * @param vyska vyska plochy hlavolamu
     * @param heur Cislo heuristiky, nadobuda hodnoty 1/2
     */
    public static void solve(int sirka, int vyska, int heur){
        Astar na = new Astar();
        na.setSirka(sirka);
        na.setVyska(vyska);
        na.solve(start,ciel,x_blank,y_blank,heur);
    }

    /**
     * Testovaci scenar pre hlavolam rozmerov 3*3
     */
    public static void test1(){
        start = new byte[][]{{8, 0, 6}, {5, 4, 7}, {2, 3, 1}};
        ciel =new byte[][]{ {1, 0, 2}, {3, 4, 5}, {6, 7, 8} };
        getblank();
        solve(3,3,2);
    }

    public static void test1_2(){
        ciel = new byte[][]{{8, 0, 6}, {5, 4, 7}, {2, 3, 1}};
        start =new byte[][]{ {1, 0, 2}, {3, 4, 5}, {6, 7, 8} };
        getblank();
        solve(3,3,2);
    }

    /**
     * Testovaci scenar pre hlavolam rozmerov 3*2
     */
    public static void test2(){
        start = new byte[][]{{3, 4, 5}, {0, 1, 2}};
        ciel =new byte[][]{ {0, 1, 2}, {3, 4, 5}};
        getblank();
        solve(3,2,1);
    }

    /**
     * Testovaci scenar pre hlavolam rozmerov 4*2
     */
    public static void test3(){
        start = new byte[][]{{3, 2, 5, 4}, {7, 6, 1, 0}};
        ciel =new byte[][]{ {0, 1, 2, 3}, {4, 5, 6, 7}};
        getblank();
        solve(4,2,1);
    }

    /**
     * Testovaci scenar pre hlavolam rozmerov 5*2
     */
    public static void test4(){
        start = new byte[][]{{4, 3, 2, 6, 1}, {9, 8, 7, 5, 0}};
        ciel =new byte[][]{ {0, 1, 2, 3, 4}, {5, 6, 7, 8, 9}};
        getblank();
        solve(5,2,1);
    }


    private static void getblank() {
        for (int row = 0; row < start.length; row++)
            for (int col = 0; col < start[row].length; col++)
                if (start[row][col] == 0) {
                    x_blank = row;
                    y_blank = col;
                    return;
                }
    }

}
