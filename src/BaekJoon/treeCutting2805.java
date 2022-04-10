package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class treeCutting2805 {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int N, M;
    static int[] trees;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        trees = new int[N];
        for (int i = 0; i < N; i++) {
            trees[i] = scan.nextInt();
        }
    }

    static boolean determination(int H) {
        long sum = 0;
        for (int i = 0; i < N; i++) {
            if (trees[i] > H) {
                sum += trees[i] - H;
            }
        }

        return sum >= M;
    }

    static void pro() {
        long L = 0, R = 2000000000, ans = 0;

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
