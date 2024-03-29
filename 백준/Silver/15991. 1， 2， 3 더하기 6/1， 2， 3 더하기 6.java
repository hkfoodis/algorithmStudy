import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int Q, MOD = 1000000009;
    static int[] Dy;

    static void input() {
        Q = scan.nextInt();
    }

    static void preprocess() {
        Dy[0] = 1;
        for (int i = 1; i <= 100000; i++) {
            Dy[i] = Dy[i - 1];  // 마지막에 1을 더하는 경우의 수
            if (i - 2 >= 0) Dy[i] += Dy[i - 2];  // 마지막에 2을 더하는 경우의 수
            Dy[i] %= MOD;
            if (i - 3 >= 0) Dy[i] += Dy[i - 3];  // 마지막에 3을 더하는 경우의 수
            Dy[i] %= MOD;
        }
    }

    static void pro() {
        Dy = new int[100005];
        preprocess();
        while (Q-- > 0) {
            int x = scan.nextInt();

            int res = 0;
            // 홀수 개를 더한 경우
            for (int mid = 1; mid <= 3; mid++)  // 가운데에 mid 를 더한 상황
                if (x - mid >= 0 && (x - mid) % 2 == 0) {  // 양쪽이 대칭을 이루게 더하기 위함
                    res += Dy[(x - mid) / 2];
                    res %= MOD;
                }

            // 짝수 개를 더한 경우 (사실상 위에서 mid 가 0 인 경우. 즉, for loop을 0 부터 시작해도 됨)
            if (x % 2 == 0) {  // 양쪽이 대칭을 이루게 더하기 위함
                res += Dy[x / 2];
                res %= MOD;
            }

            sb.append(res).append('\n');
        }
        System.out.println(sb);
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
