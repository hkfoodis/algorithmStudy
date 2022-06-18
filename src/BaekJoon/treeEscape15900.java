package BaekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class treeEscape15900 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, totalDepth;
    static ArrayList<Integer>[] childs;

    static void input() {
        N = scan.nextInt();
        childs = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) childs[i] = new ArrayList<>();
        for (int i = 1; i <= N - 1; i++) {
            int x = scan.nextInt(), y = scan.nextInt();
            childs[x].add(y);
            childs[y].add(x);
        }
    }

    static void dfs(int x, int par, int depth) {
        if (x != 1 && childs[x].size() == 1) totalDepth += depth;

        for (int y : childs[x]) {
            if (y == par) continue;
            dfs(y, x, depth + 1);
        }
    }

    static void pro() {
        dfs(1, -1, 0);
        if (totalDepth % 2 == 0) System.out.println("No");
        else System.out.println("Yes");
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
