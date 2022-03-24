package BaekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class parentOfTree11725dfs {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static boolean[] visit;
    static int[] parent;
    static ArrayList<Integer>[] adj;

    static void input() {
        N = scan.nextInt();
        adj = new ArrayList[N + 1];
        parent = new int[N + 1];
        for (int i = 1;i <= N; i++)
            adj[i] = new ArrayList<>();
        for (int i = 0; i < N - 1; i++) {
            int x = scan.nextInt(), y = scan.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
    }

    static void dfs(int x) {
        visit[x] = true;

        for (int y : adj[x]) {
            if (visit[y]) continue;
            parent[y] = x;
            dfs(y);
        }
    }

    static void pro() {
        visit = new boolean[N + 1];
        dfs(1);
        int ans = 0;
        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb);
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
