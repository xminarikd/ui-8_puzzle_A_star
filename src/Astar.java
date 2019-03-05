package src;

import java.util.*;

public class Astar {


    public void solve(int[][] start, int[][] ciel, int b_x, int b_y, int heuristic){

        Set<int[][]> visited = new HashSet<int[][]>();

        PComp compar = new PComp();
        Queue<Uzol> pq = new PriorityQueue<Uzol>(1000,compar);
        Uzol root = new Uzol(start,null,0, (char) 0);
        //if heuristic set....

        pq.add(root);
        Uzol curr = root;
        while(!Arrays.deepEquals(curr.getBoard(),ciel)){
            visited.add(curr.getBoard());

        }


    }
}
