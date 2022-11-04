import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int N, budget;
    static int[] requests;

    static void input() {
        N = scan.nextInt();
        requests = new int[N];
        for (int i = 0; i < N; i++) {
            requests[i] = scan.nextInt();
        }
        budget = scan.nextInt();
    }

    static boolean determination(int B) {
        // 총 예산을 넘지 않도록

        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (requests[i] > B) {
                sum += B;
            } else {
                sum += requests[i];
            }
        }

        return sum <= budget;
    }

    static void pro() {
        long L = 0, R = 1000000000, ans = 0;

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

        Arrays.sort(requests);
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += requests[i];
        }

        if (sum <= budget) {
            System.out.println(requests[requests.length - 1]);

            return;
        }

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
