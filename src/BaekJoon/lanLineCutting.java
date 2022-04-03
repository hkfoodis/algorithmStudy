package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class lanLineCutting {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int K, N;
    static int[] lines;

    static void input() {
        K = scan.nextInt();
        N = scan.nextInt();
        lines = new int[K + 1];
        for (int i = 1; i <= K; i++) {
            lines[i] = scan.nextInt();
        }
    }

    static boolean determination(int L) {
        // K개의 랜선을 L만큼 잘라서 (버리는 경우 없음) 나오는 개수가 N보다 크면 true 아니면 false
        long cnt = 0;

        for (int i = 1; i <= K; i++) {
            cnt += lines[i] / L;
        }

        return cnt >= N;
    }

    static void pro() {
        long L = 1, R = Integer.MAX_VALUE, ans = 0;

        while (L <= R) {
            long mid = (L + R) / 2;
            if (determination((int) mid)) {
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
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
