package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class fibonacci1003DP {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static long[][] dy;
    static int N, T;

    static void preprocess() {
        dy[0][0] = 1;
        dy[1][1] = 1;

        for (int i = 2; i <= 40; i++) {
            dy[i][0] = dy[i-1][0] + dy[i-2][0];
            dy[i][1] = dy[i-1][1] + dy[i-2][1];
        }
    }

    public static void main(String[] args) {
        dy = new long[41][2];
        preprocess();

        T = scan.nextInt();
        while (T-- > 0) {
            N = scan.nextInt();
            System.out.println(dy[N][0] + " " + dy[N][1]);
        }
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
