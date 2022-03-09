package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class cuteLion15565 {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int N, K;
    static int[] dolls;

    static void input() {
        N = scan.nextInt();
        K = scan.nextInt();
        dolls = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            dolls[i] = scan.nextInt();
        }
    }

    static void pro() {

        int R = 0, ans = -1, cnt = 0;

        for (int L = 1; L <= N; L++) {

            while (R + 1 <= N && cnt < K) {
                R++;
                if (dolls[R] == 1) cnt++;
            }

            if (cnt == K) {
                if (ans == -1) ans = R - L + 1;
                ans = Math.min(ans, R - L + 1);
            }

            if (dolls[L] == 1) cnt--;
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
