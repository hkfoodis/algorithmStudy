import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] par;
    static boolean[] check;

    static void input() {
        N = scan.nextInt();
        par = new int[N + 1];
        check = new boolean[N + 1];
        for (int i = 1; i < N; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            par[y] = x;
        }
    }

    static void pro() {
        int x = scan.nextInt(), y = scan.nextInt();

        while (x > 0) {
            check[x] = true;
            x = par[x];
        }

        while (y > 0 && !check[y]) {
            y = par[y];
        }

        System.out.println(y);
    }

    public static void main(String[] args) {
        int T = scan.nextInt();

        while (T-- > 0) {
            input();
            pro();
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
