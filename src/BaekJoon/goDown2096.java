package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class goDown2096 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] a;
    static int[][] dyMax, dyMin;

    static void input() {
        N = scan.nextInt();
        a = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < 3; j++) {
                a[i][j] = scan.nextInt();
            }
        }

        dyMax = new int[N + 1][3];
        dyMin = new int[N + 1][3];
    }

    static void pro() {

        for (int i = 1; i <= N; i++) {
            dyMax[i][0] += Math.max(dyMax[i - 1][0], dyMax[i - 1][1]) + a[i][0];
            dyMax[i][1] += Math.max(Math.max(dyMax[i - 1][0], dyMax[i - 1][1]), dyMax[i - 1][2]) + a[i][1];
            dyMax[i][2] += Math.max(dyMax[i - 1][1], dyMax[i - 1][2]) + a[i][2];

            dyMin[i][0] += Math.min(dyMin[i - 1][0], dyMin[i - 1][1]) + a[i][0];
            dyMin[i][1] += Math.min(Math.min(dyMin[i - 1][0], dyMin[i - 1][1]), dyMin[i - 1][2]) + a[i][1];
            dyMin[i][2] += Math.min(dyMin[i - 1][1], dyMin[i - 1][2]) + a[i][2];
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < 3; i++) {
            min = Math.min(min, dyMin[N][i]);
            max = Math.max(max, dyMax[N][i]);
        }

        System.out.println(max + " " + min);
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
