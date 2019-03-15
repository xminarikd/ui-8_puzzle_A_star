package src;

import java.util.*;

/**
 * Trieda, ktora obsahuje hlavny algoritmus s nazvom A-star (A*)
 */
public class Astar {
    private int sirka;
    private int vyska;
    //B,T,L,R
   private int[] row = { 1, -1, 0, 0 };
   private int[] col = { 0, 0, -1, 1 };

    /**
     * Algoritmus A*, ktory na zaklade prehladavania hlada postupnost operacii, na dosiahnutie cieloveho stavu
     * Tento algoritmus vytvara nove uzly, ktore reprezentuju nove stavy.
     * Tieto stavy sa uchovavaju v prioritnom rade, a na zaklade heristiky sa vynerie najlepsi uzol
     * @param start dvojrozmerne pole, v ktorom je reprezentovany pociatocny stav
     * @param ciel  dvojrozmerne pole, v ktorom je reprezentovany cielovy stav
     * @param b_x   x suradnica prazdneho miesta v hlavolame
     * @param b_y   y suradnica prazdneho miesta hlavolamu
     * @param heuristic cislo heristiky, ktora je pouzita v algoritme
     */
    public void solve(byte[][] start, byte[][] ciel, int b_x, int b_y, int heuristic) {
        long st = System.currentTimeMillis();
        int pocet = 0;
        Uzol curr;
        PCom compar = new PCom();

        Set<String> visited = new HashSet<String>();
        Queue<Uzol> pq = new PriorityQueue<Uzol>(1000, compar);

        Uzol root = new Uzol(start, null, 0, -1);
        root.setHcost(0);
        pq.add(root);

        curr = root;

        while (!Arrays.deepEquals(curr.getBoard(), ciel)) {
            visited.add(Arrays.deepToString(curr.getBoard()));
            if (pq.isEmpty()) {
                System.out.println("Riesenie sa nepodarilo najst");
                return;
            }
            for (int i = 0; i < 4; i++) {
                if (check(curr.getA() + row[i], curr.getB() + col[i])) {
                    if (!visited.contains(Arrays.deepToString(testboard(curr.getBoard(), i, curr.getA(), curr.getB())))) {

                        Uzol child = new Uzol(curr.getBoard(), curr, curr.getLevel() + 1, i);
                        child.move(i);
                        visited.add(Arrays.deepToString(child.getBoard()));

                        if (heuristic == 1) {
                            child.setHcost( /*curr.getHcost() +*/ h_one(child.getBoard(), ciel));
                        } else {
                            child.setHcost( /*curr.getHcost() +*/ h_two(child.getBoard(), ciel));
                        }

                        pq.add(child);
                        pocet++;
                    }
                }
            }
            curr = pq.poll();
        }
        long end = System.currentTimeMillis();
        results(curr,st,end,pocet);
    }

    /**
     * Testovanie moznoti pouzitia operacie
     * @return vracia ci sa moze vzkonat testovana operacia
     */
    private boolean check(int x, int y) {
        return (x >= 0 && x < vyska && y >= 0 && y < sirka);
    }

    /**
     *
     * @return vytvori novy stav hlavolamu, ktory sa nasledne tetuje ci sa uz dany stav neprehladaval
     */
    private byte[][] testboard(byte[][] board,int opp,int a, int b){
        byte[][] testboard = Arrays.stream(board).map(byte[]::clone).toArray(byte[][]::new);

        testboard[a][b] = (byte) (testboard[a][b] + testboard[a + row[opp]][b + col[opp]]);
        testboard[a + row[opp]][b + col[opp]] = (byte) (testboard[a][b] - testboard[a + row[opp]][b + col[opp]]);
        testboard[a][b] = (byte) (testboard[a][b] - testboard[a + row[opp]][b + col[opp]]);

    return testboard;
    }

    /**
     * @return vrati slovnu podobu operacie, ktora zadpoveda internemu cislu
     */
    public String translate(int cislo){
        if(cislo == 0) return "bottom";
        else if(cislo == 1) return "top";
        else if(cislo == 2) return "left";
        else if(cislo == 3) return "right";
        else return "start";
    }

    /**
     * Heuristicka funkcia cislo 1
     * Heristika na zaklade toho, kolko cisel sa nenachadza na spravnom mieste
     * @return  vrati hodnotu heristiky pre dany stav
     */
    private int h_one(byte[][] board,byte[][]ciel){
        int diff = 0;
        for (int row = 0; row < board.length; row++)
            for (int col = 0; col < board[row].length; col++){
                if(board[row][col] != ciel[row][col])
                    diff += 1;
            }
        return diff;
    }

    /**
     *Heuristicka funkcia cislo 2
     *Heristika na zaklade toho, ako daleko sa nachadza cislo od cielovej pozicie
     * @return vrati hodnotu heuristiky pre dany stav
     */
    private int h_two(byte[][] board, byte[][]ciel){
        int diff = 0;
        int tmp;
        for (int row = 0; row < board.length; row++)
            for (int col = 0; col < board[row].length; col++){
                tmp = getgoalcell(ciel,board[row][col]);
                diff += (Math.abs(row - (tmp / sirka) ) + Math.abs(col - (tmp % sirka)));
            }
        return diff;
    }


    private int getgoalcell(byte[][]ciel , int value){
        for (int row = 0; row < ciel.length; row++)
            for (int col = 0; col < ciel[row].length; col++){
                if(ciel[row][col] == value){
                    return (row * sirka) + col;
                }

            }
        return -1;
    }

    /**
     * Vypis vysledku hladania
     */
    private void results(Uzol curr, long st, long end, int pocet){
        backtrack(curr);
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("Pocet spracovanych uzlov je " + pocet);
        System.out.println("Hlbka: " + curr.getLevel());
        System.out.println("Doba trvania " + (end - st) + "ms");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
    }

    private void backtrack(Uzol root) {
        if (root == null) {
            return;
        }
        backtrack(root.getParent());
        System.out.println(translate(root.getLastopp()));
        System.out.println(Arrays.deepToString(root.getBoard()).replaceAll("], ","]" + System.lineSeparator()));
    }

    public void setSirka(int sirka) {
        this.sirka = sirka;
    }
    public void setVyska(int vyska) {
        this.vyska = vyska;
    }
}
