package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class plus123315988 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int T, N, mod = 1000000009;
    static int[] dy;

    static void input() {
        T = scan.nextInt();
    }

    static void preprocess() {
        dy[0] = 1;
        for (int i = 1; i <= 1000000; i++) {
            dy[i] = dy[i - 1];  // 마지막에 1을 더하는 경우의 수
            if (i - 2 >= 0) dy[i] += dy[i - 2];  // 마지막에 2을 더하는 경우의 수
            dy[i] %= mod;
            if (i - 3 >= 0) dy[i] += dy[i - 3];  // 마지막에 3을 더하는 경우의 수
            dy[i] %= mod;
        }
    }

    static void pro() {
        dy = new int[1000005];
        preprocess();
        while (T-- > 0) {
            N = scan.nextInt();
            sb.append(dy[N]).append("\n");
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