package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class sheepAndWolf3184 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int R, C, sheepCnt, wolfCnt, sheepTotal, wolfTotal;
    static boolean[][] visit;
    static String[] a;
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    static void input() {
        R = scan.nextInt();
        C = scan.nextInt();
        a = new String[R];
        for (int i = 0; i < R; i++) {
            a[i] = scan.nextLine();
        }

        visit = new boolean[R][C];
    }

    static void dfs(int x, int y) {
        if (a[x].charAt(y) == 'v') wolfCnt++;
        if (a[x].charAt(y) == 'o') sheepCnt++;
        visit[x][y] = true;

        for (int k = 0; k < 4; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];
            if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
            if (a[nx].charAt(ny) == '#') continue;
            if (visit[nx][ny]) continue;
            dfs(nx, ny);
        }
    }

    static void pro() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visit[i][j] && a[i].charAt(j) != '#') {
                    sheepCnt = 0;
                    wolfCnt = 0;
                    dfs(i, j);
                    if (sheepCnt > wolfCnt) wolfCnt = 0;
                    else sheepCnt = 0;
                    sheepTotal += sheepCnt;
                    wolfTotal += wolfCnt;
                }
            }
        }

        System.out.println(sheepTotal + " " + wolfTotal);
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
