package Programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DividePowerGrid {

    static int[][] adj;

    public static int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        adj= new int[n+1][n+1];

        for(int i=0; i<wires.length; i++){
            adj[wires[i][0]][wires[i][1]]=1;
            adj[wires[i][1]][wires[i][0]]=1;
        }

        int a, b;
        for(int i=0; i<wires.length; i++){
            a= wires[i][0];
            b= wires[i][1];

            adj[a][b]=0;
            adj[b][a]=0;

            answer = Math.min(answer, bfs(n, a));

            adj[a][b]=1;
            adj[b][a]=1;
        }

        return answer;
    }

    public static int bfs(int n, int start) {
        Queue<Integer> q = new LinkedList<>();

        boolean[] visit = new boolean[n + 1];
        int cnt = 1;
        q.add(start);

        while (!q.isEmpty()) {
            int x = q.poll();

            for (int y = 1; y <= n; y++) {
                if (visit[y]) continue;
                if (adj[x][y] == 0) continue;
                q.add(y);
                cnt++;
                visit[x] = true;
            }
        }

        return Math.abs(cnt - (n - cnt));
    }

    public static void main(String[] args) {
        int[][] a = {{1,2}, {2,3}, {3,4}};

        System.out.println(solution(4, a));
    }
}
