package BaekJoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class findNum {
    static eatOrEaten.FastReader scan = new eatOrEaten.FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] A, B;

    static void input() {
        N = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
        M = scan.nextInt();
        B = new int[M + 1];
        for (int i = 1; i <= M; i++) {
            B[i] = scan.nextInt();
        }
    }

    static void lower_bound(int[] A, int L, int R, int X) {

        boolean res = false;
        while (L <= R) {
            int mid = (L + R) / 2;

            if (A[mid] == X) {
                res = true;
                sb.append(1).append("\n");
                break;
            }

            if (A[mid] < X) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }

        if (!res) {
            sb.append(0).append("\n");
        }
    }

    static void pro() {
        Arrays.sort(A, 1, N + 1);

        for (int i = 1; i <= M; i++) {
            lower_bound(A, 1, N, B[i]);
        }
    }

    public static void main(String[] args) {
        input();
        pro();
        System.out.println(sb.toString());
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
