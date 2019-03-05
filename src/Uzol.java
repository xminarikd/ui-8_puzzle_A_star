package src;

import java.util.Arrays;

public class Uzol {

    //B,T,L,R
    int[] row = { 1, -1, 0, 0 };
    int[] col = { 0, 0, -1, 1 };

    private Uzol parent;
    private int[][] board;
    private int level;
    private int lastopp;
    private int Hcost;
    private int a, b;

    public Uzol(int[][] board, Uzol parent, int level, int lastopp) {
        this.parent = parent;
        this.board = Arrays.stream(board).map(int[]::clone).toArray(int[][]::new);

        this.Hcost = -1;
        this.level = level;
        this.lastopp = lastopp;
        getblank();
    }

public void move(int opp){

            this.board[a][b] = this.board[a][b] + this.board[a + row[opp]][b + col[opp]];
            this.board[a + row[opp]][b + col[opp]] = this.board[a][b] - this.board[a + row[opp]][b + col[opp]];
            this.board[a][b] = this.board[a][b] - this.board[a + row[opp]][b + col[opp]];

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

    public int[][] getBoard() {
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

    public void setParent(Uzol parent) {
        this.parent = parent;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setLastopp(int lastopp) {
        this.lastopp = lastopp;
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