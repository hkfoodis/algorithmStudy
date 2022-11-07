import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, sx, sy;
    static int[][] dist, dir = {{-1,-2},{-2,-1},{-1,2},{-2,1},{1,-2},{2,-1},{1,2},{2,1}};

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        dist = new int[N + 1][N + 1];
        sx = scan.nextInt();
        sy = scan.nextInt();
    }

    static void pro() {
        bfs();
        while (M-- > 0) {
            int ex = scan.nextInt();
            int ey = scan.nextInt();
            System.out.print(dist[ex][ey]+ " ");
        }
    }

    static void bfs() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
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

                if (nx < 1 || ny < 1 || nx > N || ny > N) continue;
                if (dist[nx][ny] != -1) continue;
                q.add(nx);
                q.add(ny);
                dist[nx][ny] = dist[x][y] + 1;
            }
        }

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
