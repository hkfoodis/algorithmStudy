package BaekJoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class movingOfKnight7562 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int l, sx, sy, dx, dy;
    static int[][] dist;
    static int[][] dir = {{-2, -1}, {-2, 1}, {-1, 2}, {-1, -2}, {2, -1}, {2, 1}, {1, -2}, {1, 2}};

    static void input() {
        l = scan.nextInt();
        sx = scan.nextInt();
        sy = scan.nextInt();
        dx = scan.nextInt();
        dy = scan.nextInt();
        dist = new int[l][l];
    }

    static int bfs() {
        for (int i = 0; i < l; i++) {
            for ( int j = 0; j < l; j++) {
                dist[i][j] = -1;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(sx);
        q.add(sy);
        dist[sx][sy] = 0;

        while (!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();
            for (int k = 0; k < 8; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= l || ny >= l) continue;
                if (dist[nx][ny] != -1) continue;

                q.add(nx);
                q.add(ny);
                dist[nx][ny] = dist[x][y] + 1;
            }
        }

        return dist[dx][dy];
    }

    static void pro() {
        System.out.println(bfs());
    }

    public static void main(String[] args) {
        int testNum = scan.nextInt();

        for (int i = 0; i < testNum; i++) {
            input();
            pro();
        }
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
