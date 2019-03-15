package src;

import java.util.Arrays;

/**
 * Trieda, ktora reprezentuje dany hlavolam
 * Obsahuje dvojroymerne pole na uchovanie stavu, hlbku, rodica,poslednu operaciu a heristicku hodnotu
 */
public class Uzol {

    //B,T,L,R
   private static int[] row = { 1, -1, 0, 0 };
   private static int[] col = { 0, 0, -1, 1 };

    private Uzol parent;
    private byte[][] board;
    private int level;
    private int lastopp;
    private int Hcost;
    private int a, b;

    public Uzol(byte[][] board, Uzol parent, int level, int lastopp) {
        this.parent = parent;
        this.board = Arrays.stream(board).map(byte[]::clone).toArray(byte[][]::new);

        this.Hcost = -1;
        this.level = level;
        this.lastopp = lastopp;
        getblank();
    }

public void move(int opp){

            this.board[a][b] = (byte) (this.board[a][b] + this.board[a + row[opp]][b + col[opp]]);
            this.board[a + row[opp]][b + col[opp]] = (byte) (this.board[a][b] - this.board[a + row[opp]][b + col[opp]]);
            this.board[a][b] = (byte) (this.board[a][b] - this.board[a + row[opp]][b + col[opp]]);

    getblank();
}


    public void getblank() {
        for (int row = 0; row < board.length; row++)
            for (int col = 0; col < board[row].length; col++)
                if (this.board[row][col] == 0) {
                    setA(row);
                    setB(col);
                    return;
                }
    }


    public Uzol getParent() {
        return parent;
    }

    public byte[][] getBoard() {
        return board;
    }

    public int getLevel() {
        return level;
    }

    public int getLastopp() {
        return lastopp;
    }

    public int getHcost() {
        return Hcost;
    }

    public void setHcost(int hcost) {
        Hcost = hcost;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}