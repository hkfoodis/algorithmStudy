package BaekJoon;

import java.io.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class houseNumbering2667 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, groupCnt;
    static String[] a;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};    // 인접한 4개의 점을 빠르게 찾기위한 배열
    static ArrayList<Integer> group;

    static void input() {
        N = scan.nextInt();
        a = new String[N];
        for (int i = 0; i < N; i++) {
            a[i] = scan.nextLine();
        }
        visit = new boolean[N][N];
    }

    static void dfs(int x, int y) {
        groupCnt++;
        visit[x][y] = true;

        for (int k = 0; k < 4; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];
            if (nx < 0 || ny < 0 || ny >= N || nx >= N) continue;   // 격자를 벗어나는 경우 체크
            if (a[nx].charAt(ny) == '0') continue;                  // 방문한 격자에 집이 없는 경우
            if (visit[nx][ny]) continue;                            // 이미 방문한 적이 있는지
            dfs(nx, ny);
        }
    }

    static void pro() {
        group = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j] && a[i].charAt(j) == '1') {
                    groupCnt = 0;
                    dfs(i, j);
                    group.add(groupCnt);
                }
            }
        }

        Collections.sort(group);
        sb.append(group.size()).append('\n');
        for (int cnt:group) sb.append(cnt).append('\n');
        System.out.println(sb.toString());
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
