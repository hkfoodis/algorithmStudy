package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class sequence2559 {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int N, K;
    static int[] temps;

    static void input() {
        N = scan.nextInt();
        K = scan.nextInt();
        temps = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            temps[i] = scan.nextInt();
        }
    }

    static void pro() {
        int R = 0, sum = 0, ans = -100 * N;

        for (int L = 1; L + K - 1 <= N; L++) {
            sum -= temps[L - 1];

            while (R + 1 <= L + K - 1) {
                R++;
                sum += temps[R];
            }

            ans = Math.max(ans, sum);
        }
        System.out.println(ans);
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
