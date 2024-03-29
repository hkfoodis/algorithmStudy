import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int N, K;

    static void input() {
        N = scan.nextInt();
        K = scan.nextInt();
    }

    static boolean determination(long C) {
        // C 이하의 숫자가 K 개인가?
        long sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += Math.min(C / i, N);
        }

        return sum >= K;
    }

    static void pro() {
        long L = 1, R = (long) N * N, ans = 0;

        while (L <= R) {
            long mid = (L + R) / 2;
            if (determination(mid)) {
                ans = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
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
