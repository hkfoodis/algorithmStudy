import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, wolfCnt, sheepCnt, totalSheepCnt = 0, totalWolfCnt = 0;
    static String[] a;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static boolean[][] visit;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        a = new String[N];
        for (int i = 0; i < N; i++) {
            a[i] = scan.nextLine();
        }
        visit = new boolean[N][M];
    }

    static void pro() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (a[i].charAt(j) == '#') continue;
                if (visit[i][j]) continue;
                wolfCnt = 0;
                sheepCnt = 0;
                dfs(i, j);
                if (sheepCnt > wolfCnt) wolfCnt = 0;
                else sheepCnt = 0;
                totalSheepCnt += sheepCnt;
                totalWolfCnt += wolfCnt;
            }
        }

        System.out.println(totalSheepCnt + " " + totalWolfCnt);
    }

    static void dfs(int x, int y) {
        visit[x][y] = true;
        if (a[x].charAt(y) == 'o') sheepCnt++;
        if (a[x].charAt(y) == 'v') wolfCnt++;

        for (int k = 0; k < 4; k++) {
            int nx = x + dir[k][0], ny = y + dir[k][1];
            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (!visit[nx][ny] && a[nx].charAt(ny) != '#') dfs(nx, ny);
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
