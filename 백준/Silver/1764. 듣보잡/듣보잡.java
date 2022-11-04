import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static String[] A, answer;

    static void input() {
        N = scan.nextInt();
        A = new String[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextLine();
        }
    }

    static boolean search(String[] a, int L, int R, String b) {

        while (L <= R) {
            int mid = (L + R) / 2;
            if (a[mid].equals(b)) {
                return true;
            }
            if (a[mid].compareTo(b) < 0) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }

        return false;
    }

    static void pro() {
        int M = scan.nextInt();
        int ans = 0;
        Arrays.sort(A, 1, N + 1);

        answer = new String[N + 1];

        for (int i = 1; i <= M; i++) {
            String X = scan.nextLine();
            if (search(A, 1, N, X)) {
                answer[++ans] = X;
            }
        }

        Arrays.sort(answer, 1, ans + 1);
        sb.append(ans).append("\n");
        for (int i = 1; i <= ans; i++) {
            sb.append(answer[i]).append("\n");
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
