package BaekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class treeAndQuery15681 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, R, Q;
    static ArrayList<Integer>[] adj;
    static int[] D;

    static void input() {
        N = scan.nextInt();
        R = scan.nextInt();
        Q = scan.nextInt();
        adj = new ArrayList[N + 1];
        D = new int[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            int x = scan.nextInt(), y = scan.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
    }

    /* DP 방식을 사용했다고 볼 수 있다. Rooted Tree의 경우는 DP를 사용하기 가장 좋은 방식이다.
    * DP를 사용할 때 대부분 DFS 한 번이면 원하는 해답을 구할 수 있다. DFS를 사용하여 leaf node까지 갔다가 시작 하기 때문 */
    static void dfs(int x, int par) {
        D[x] = 1;

        for (int y : adj[x]) {
            if (y == par) continue;

            dfs(y, x);
            D[x] += D[y];
        }
    }

    static void pro() {
        dfs(R, -1);

        for (int i = 1; i <= Q; i++) {
            int x = scan.nextInt();
            sb.append(D[x]).append('\n');
        }

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
