package BaekJoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class pathFinder11403Re {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] adj;
    static boolean[] visit;

    static void input() {
        N = scan.nextInt();
        adj = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                adj[i][j] = scan.nextInt();
            }
        }
    }

    static void pro() {
        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            bfs(i);
        }

        System.out.println(sb);
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            visit[i] = false;
        }

        q.add(start);
        visit[start] = false;

        while (!q.isEmpty()) {
            int x = q.poll();

            for (int y = 0; y < N; y++) {
                if (adj[x][y] == 0) continue;
                if (visit[y]) continue;

                q.add(y);
                visit[y] = true;
            }
        }

        for (int i = 0; i < N; i++) {
            sb.append(visit[i] ? 1 : 0).append(" ");
        }
        sb.append("\n");
    }

    public static void main(String[] args) {
        input();
        pro();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
