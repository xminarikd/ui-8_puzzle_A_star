package src;

import java.util.*;

public class Astar {
    private int len = 3;
    //B,T,L,R
   private int[] row = { 1, -1, 0, 0 };
   private int[] col = { 0, 0, -1, 1 };

    public void solve(int[][] start, int[][] ciel, int b_x, int b_y, int heuristic){

        Set<String> visited = new HashSet<String>();

        PCom compar = new PCom();
        Queue<Uzol> pq = new PriorityQueue<Uzol>(1000,compar);
        Uzol root = new Uzol(start,null,0, (char) 0);
        root.setHcost(0);

        pq.add(root);
        Uzol curr = root;
        while(!Arrays.deepEquals(curr.getBoard(),ciel)){
            visited.add(Arrays.deepToString(curr.getBoard()));
           for(int i = 0; i < 4; i++){
               if (check(curr.getA() + row[i], curr.getB() + col[i])) {
                   if(!visited.contains(Arrays.deepToString(testboard(curr.getBoard(),i,curr.getA(),curr.getB())))) {

                       Uzol child = new Uzol(curr.getBoard(), curr, curr.getLevel() + 1, i);
                       child.move(i);
                       visited.add(Arrays.deepToString(child.getBoard()));

                       if (heuristic == 1) {
                           child.setHcost(h_one(child.getBoard(), ciel));
                       } else {
                           child.setHcost(h_two(child.getBoard(), ciel));
                       }
                       pq.add(child);
                   }
               }
           }
           curr = pq.poll();
        }
        System.out.println("OK");
    }

    public boolean check(int x, int y) {
        return (x >= 0 && x < len && y >= 0 && y < len);
    }

    public int[][] testboard(int[][] board,int opp,int a, int b){
        int[][] testboard = Arrays.stream(board).map(int[]::clone).toArray(int[][]::new);

        testboard[a][b] = testboard[a][b] + testboard[a + row[opp]][b + col[opp]];
        testboard[a + row[opp]][b + col[opp]] = testboard[a][b] - testboard[a + row[opp]][b + col[opp]];
        testboard[a][b] = testboard[a][b] - testboard[a + row[opp]][b + col[opp]];

    return testboard;

    }

    private int h_one(int[][] board,int[][]ciel){
        int diff = 0;
        for (int row = 0; row < board.length; row++)
            for (int col = 0; col < board[row].length; col++){
                if(board[row][col] != ciel[row][col])
                    diff += 1;
            }
        return diff;
    }

    private int h_two(int[][] board, int[][]ciel){
        int diff = 0;
        int tmp;
        for (int row = 0; row < board.length; row++)
            for (int col = 0; col < board[row].length; col++){
                tmp = getgoalcell(ciel,board[row][col]);
                diff += (Math.abs(row - (tmp/len) ) + Math.abs(col - (tmp%len)));
            }
        return diff;
    }


    private int getgoalcell(int[][]ciel , int value){
        for (int row = 0; row < ciel.length; row++)
            for (int col = 0; col < ciel[row].length; col++){
                if(ciel[row][col] == value){
                    return (row*len)+col;
                }

            }
        return -1;
    }

}
