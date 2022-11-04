import java.io.*;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class Info {
        int y, k;
        Info (int y, int k) {
            this.y = y;
            this.k = k;
        }
    }

    static int N, M;
    static int[] indeg;
    static int[][] needs;
    static ArrayList<Info>[] adj;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        adj = new ArrayList[N + 1];
        indeg = new int[N + 1];
        needs = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int x = scan.nextInt(), y = scan.nextInt(), k = scan.nextInt();
            adj[y].add(new Info(x, k));
            indeg[x]++;
        }
    }

    static void pro() {
        Deque<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (indeg[i] == 0) {
                q.add(i);
                needs[i][i] = 1;
            }
        }

        while (!q.isEmpty()) {
            int x = q.poll();

            for (Info info : adj[x]) {
                int y = info.y, k = info.k;
                indeg[y]--;
                // 제품 y에 x가 k개 필요하므로 기본 부품 개수에 k를 곱해서 누적
                for (int i = 1; i <= N; i++) {
                    needs[y][i] += needs[x][i] * k;
                }
                if (indeg[y] == 0) q.add(y);
            }
        }

        for (int i = 1; i <= N; i++) {
            if (needs[N][i] != 0) System.out.println(i + " " + needs[N][i]);
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
