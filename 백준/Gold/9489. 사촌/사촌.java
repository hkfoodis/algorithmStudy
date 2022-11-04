import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, K;
    static int[] a, par;

    static void input() {
        N = scan.nextInt();
        K = scan.nextInt();
        a = new int[N + 1];
        par = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            a[i] = scan.nextInt();
        }
    }

    static void pro() {
        // 각 노드의 부모 노드 인덱스를 계산하자. 루트 노드가 1번 노드임을 주의하라.
        // 편의상 0번 정점의 부모를 -1 로 하자.
        par[0] = -1;
        par[1] = 0;

        int last = 1;
        for (int i = 2; i <= N; i++, last++) {
            // i 번째부터 연속된 수는 last의 자식으로
            for (; i <= N; i++) {
                par[i] = last;
                if (i < N && a[i] + 1 != a[i + 1]) {
                    break;
                }
            }
        }

        int kIdx = 0;
        for (int i = 1; i <= N; i++) {
            if (a[i] == K) {
                kIdx = i;
                break;
            }
        }

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            if (par[par[kIdx]] == par[par[i]] && par[kIdx] != par[i]) {
                ans++;
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        while(true) {
            input();
            if (N == 0 && K == 0) break;
            pro();
        }
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
