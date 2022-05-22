package BaekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class gameDevelop1516 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] indeg, tDone, t;
    static ArrayList<Integer>[] adj;

    static void input() {
        N = scan.nextInt();
        indeg = new int[N + 1];
        tDone = new int[N + 1];
        t = new int[N + 1];
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            t[i] = scan.nextInt();
            while (true) {
                int y = scan.nextInt();
                if (y == -1) break;
                adj[y].add(i);
                indeg[i]++;
            }
        }
    }

    static void pro() {
        Deque<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (indeg[i] == 0) {
                q.add(i);
                tDone[i] = t[i];
            }
        }

        while (!q.isEmpty()) {
            int x = q.poll();

            for (int y : adj[x]) {
                indeg[y]--;
                if (indeg[y] == 0) q.add(y);
                tDone[y] = Math.max(tDone[y], tDone[x] + t[y]);
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(tDone[i]);
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
