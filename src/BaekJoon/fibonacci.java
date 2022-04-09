package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class fibonacci {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input() {

        N = scan.nextInt();
        fibonacci = new int[N + 1];
    }

    static int N;
    static int[] fibonacci;

    static int rec_func(int k) {
        if (k == 0) return 0;
        if (k == 1) return 1;
        return rec_func(k - 1) + rec_func(k - 2);
    }

    public static void main(String[] args) {
        input();

        System.out.println(rec_func(N));
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
