import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int[][] dy, A;
    static int N;

    static void input() {
        N = scan.nextInt();
        dy = new int[N + 1][3];
        A = new int[N + 1][3];
        for (int i = 1; i <= N; i ++) {
            for (int j = 0; j < 3; j++) {
                A[i][j] = scan.nextInt();
            }
        }
    }

    static void pro() {
        dy[0][0] = dy[0][1] = dy[0][2] = 0;

        for (int i = 1; i <= N; i++) {
            dy[i][0] = Math.min(dy[i - 1][1], dy[i - 1][2]) + A[i][0];
            dy[i][1] = Math.min(dy[i - 1][0], dy[i - 1][2]) + A[i][1];
            dy[i][2] = Math.min(dy[i - 1][0], dy[i - 1][1]) + A[i][2];
        }

        int ans = Math.min(dy[N][0], Math.min(dy[N][1], dy[N][2]));

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
