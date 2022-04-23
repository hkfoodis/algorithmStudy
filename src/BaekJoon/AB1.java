package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class AB1 {
    static eatOrEaten.FastReader scan = new eatOrEaten.FastReader();
    static StringBuilder sb = new StringBuilder();

    static int A, B;

    static void input() {
        A = scan.nextInt();
        B = scan.nextInt();
    }

    public static void main(String[] args) {
        input();

        System.out.println(A-B);
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
