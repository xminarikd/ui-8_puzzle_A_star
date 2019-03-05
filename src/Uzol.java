package src;

import java.util.Arrays;

public class Uzol {

    private static final int T_x = -1;
    private static final int T_y = 0;
    private static final int B_x = 1;
    private static final int B_y = 0;
    private static final int L_x = 0;
    private static final int L_y = -1;
    private static final int R_x = 0;
    private static final int R_y = 1;

    private Uzol parent;
    private int[][] board;
    private int level;
    private char lastopp;
    private int Hcost;
    private int a, b;

    public Uzol(int[][] board, Uzol parent, int level, char lastopp) {
        this.parent = parent;
        this.board = Arrays.stream(board).map(int[]::clone).toArray(int[][]::new);

        this.Hcost = -1;
        this.level = level;
        this.lastopp = lastopp;
        getblank();
    }

public void move(char opp){
    switch (opp){
        case 'L': {
            board[a][b] = board[a][b] + board[a + L_x][b + L_y];
            board[a + L_x][b + L_y] = board[a][b] - board[a + L_x][b + L_y];
            board[a][b] = board[a][b] - board[a + L_x][b + L_y];
            break;
        }
        case 'R':{
            board[a][b] = board[a][b] + board[a+R_x][b+R_y];
            board[a+R_x][b+R_y] = board[a][b] - board[a+R_x][b+R_y];
            board[a][b] = board[a][b] - board[a+R_x][b+R_y];
            break;
        }
        case 'T':{
            board[a][b] = board[a][b] + board[a+T_x][b+T_y];
            board[a+T_x][b+T_y] = board[a][b] - board[a+T_x][b+T_y];
            board[a][b] = board[a][b] - board[a+T_x][b+T_y];
            break;
        }
        case 'B':{
            board[a][b] = board[a][b] + board[a+B_x][b+B_y];
            board[a+B_x][b+B_y] = board[a][b] - board[a+B_x][b+B_y];
            board[a][b] = board[a][b] - board[a+B_x][b+B_y];
            break;
        }
    }
    getblank();
}


    public void getblank() {
        for (int row = 0; row < board.length; row++)
            for (int col = 0; col < board[row].length; col++)
                if (board[row][col] == 0) {
                    setA(row);
                    setB(col);
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

    public char getLastopp() {
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

    public void setLastopp(char lastopp) {
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