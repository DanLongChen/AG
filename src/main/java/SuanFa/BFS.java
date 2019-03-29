package SuanFa;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Paser on 2019/2/22.
 */
public class BFS {
    public Graph graph = new Graph();

    public static void main(String[] args) {
        BFS bfs = new BFS();
        bfs.init();
        bfs.BFSReserve();
    }

    public void init() {
        char[] vt = {'0', '1', '2', '3', '4', '5', '6'};
        int[][] vr = {
                {0, 1, 1, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 1, 0},
                {0, 1, 0, 0, 1, 0, 0},
                {0, 1, 1, 0, 0, 0, 0}
        };
        graph = new Graph();
        graph.setVt(vt);
        graph.setVr(vr);
    }

    public void BFSReserve() {
        int length = graph.getVt().length;
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] flag = new boolean[length];
        for (int i = 0; i < length; i++) {
            if (!flag[i]) {
                flag[i] = true;
                System.out.println("当前遍历："+i);
                queue.add(i);
                while (queue.peek() != null) {
                    i = queue.poll();
                    for (int j = 0; j < length; j++) {
                        if (graph.getVr()[i][j]==1 && !flag[j]){
                            flag[j]=true;
                            System.out.println("当前访问："+j);
                            queue.offer(j);
                        }
                    }
                }
            }
        }
    }
}
