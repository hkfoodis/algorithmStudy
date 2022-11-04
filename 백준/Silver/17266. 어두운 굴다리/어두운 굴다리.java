import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int N, M;
    static int[] location;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        location = new int[M + 1];
        for (int i = 1; i <= M; i++) {
            location[i] = scan.nextInt();
        }
    }

    static boolean determination(int height) {
        int last = 0;   // 마지막 위치

        for (int i = 1; i <= M; i++) {
            if (location[i] - last <= height) {     // 다음 가로등과의 거리가 높이가 되지 않으면 빈곳이 있다고 판단
                last = location[i] + height;
            } else {
                return false;
            }
        }

        return last >= N;
    }

    static void pro() {
        int L = 0, R = N, ans = 0;

        while (L <= R) {
            int mid = (L + R) / 2;
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
