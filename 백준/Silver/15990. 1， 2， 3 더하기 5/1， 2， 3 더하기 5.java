import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int[][] Dy;
    static final int MOD = 1000000009;
    
    static void preprocess(){
        Dy = new int[100005][4];
        // 초기값 구하기
        Dy[1][1] = 1;
        Dy[2][2] = 1;
        Dy[3][1] = 1;
        Dy[3][2] = 1;
        Dy[3][3] = 1;

        // 점화식을 토대로 Dy 배열 채우기
        for (int i = 4; i <= 100000; i++) {
            for (int cur = 1; cur <= 3; cur++) {
                for (int prev = 1; prev <= 3; prev++) {
                    if (cur == prev) continue;
                    Dy[i][cur] += Dy[i - cur][prev];
                    Dy[i][cur] %= MOD;
                }
            }
        }
    }

    static void pro() {
        int T = scan.nextInt();
        for (int tt = 1; tt <= T; tt++){
            int N = scan.nextInt();
            int ans = 0;
            for (int cur = 1; cur <= 3; cur++) {
                ans += Dy[N][cur];
                ans %= MOD;
            }
            sb.append(ans).append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) {
        preprocess();
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