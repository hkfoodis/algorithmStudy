package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class wineTasting2156 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int[][] dy;
    static int[] a;
    static int N;

    static void input() {
        N = scan.nextInt();
        dy = new int[N + 1][2];
        a = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            a[i] = scan.nextInt();
        }
    }

    static void pro() {
        dy[1][0] = 0;
        dy[1][1] = a[1];

        if (N >= 2) {
            dy[2][0] = a[2];
            dy[2][1] = a[1] + a[2];
        }

        for (int i = 3; i <= N; i++) {
            dy[i][0] = Math.max(dy[i - 2][0], dy[i - 2][1]) + a[i];
            dy[i][0] = Math.max(dy[i][0], Math.max(dy[i - 3][0], dy[i - 3][1]) + a[i]);
            dy[i][1] = dy[i - 1][0] + a[i];
        }

        System.out.println(Math.max(Math.max(dy[N][0], dy[N][1]), Math.max(dy[N - 1][0], dy[N - 1][1])));
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
