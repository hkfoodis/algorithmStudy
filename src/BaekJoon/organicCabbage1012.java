package BaekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class organicCabbage1012 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, K, groupCnt;
    static int[][] a;
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static ArrayList<Integer> group;
    static boolean[][] visit;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        K = scan.nextInt();
        a = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                a[i][j] = 0;
            }
        }
        for (int i = 0; i < K; i++) {
            a[scan.nextInt()][scan.nextInt()] = 1;
        }
        visit = new boolean[N][M];
    }

    static void dfs(int x, int y) {
        visit[x][y] = true;

        for (int d = 0; d < 4; d++) {
            int nx = x + dir[d][0];
            int ny = y + dir[d][1];
            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (a[nx][ny] == 0) continue;
            if (visit[nx][ny]) continue;
            dfs(nx, ny);
        }
    }

    static void pro() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visit[i][j] && a[i][j] == 1) {
                    dfs(i, j);
                    groupCnt++;
                }
            }
        }

        group.add(groupCnt);
    }

    public static void main(String[] args) {
        int T = scan.nextInt();
        group = new ArrayList<>();

        for (int i = 0; i < T; i++) {
            input();

            groupCnt = 0;
            pro();
        }

        for (int cnt : group) {
            sb.append(cnt).append("\n");
        }
        System.out.println(sb.toString());
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
