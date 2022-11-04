import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] liquids;

    static void input() {
        N = scan.nextInt();
        liquids = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            liquids[i] = scan.nextInt();
        }
    }

    static void pro() {
        Arrays.sort(liquids, 1, N + 1);

        long bestSum = Long.MAX_VALUE;
        int v1 = 0, v2 = 0, v3 = 0;
        for (int i = 1; i <= N - 2; i++) { // 용액이 3개이기 때문에
            int target = -liquids[i];
            int L = i + 1, R = N;
            while (L < R) {
                if (bestSum > Math.abs(-(long)target + liquids[L] + liquids[R])) {
                    bestSum = Math.abs(-(long)target + liquids[L] + liquids[R]);
                    v1 = -target;
                    v2 = liquids[L];
                    v3 = liquids[R];
                }
                if (liquids[L] + liquids[R] > target) R--;
                else L++;
            }
        }

        sb.append(v1).append(" ").append(v2).append(" ").append(v3);
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
