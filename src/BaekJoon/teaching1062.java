package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class teaching1062 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, K, max = Integer.MIN_VALUE;
    static boolean[] visited;
    static String[] a;

    static void input() {
        N = scan.nextInt();
        K = scan.nextInt();
        a = new String[N];
        for (int i = 0; i < N; i++) {
            String word = scan.nextLine();
            word.replace("anta", "");
            word.replace("tica", "");
            a[i] = word;
        }
        visited = new boolean[26];
        visited['a' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['c' - 'a'] = true;
    }

    static void pro(int alphabet, int k) {
        if (K < 5) {
            max = 0;
            return;
        }

        if (K == 26) {
            max = N;
            return;
        }

        if (k == K - 5 + 1) {
            int cnt = isReadable();
            max = Math.max(max, cnt);
        } else {
            for (int i = alphabet; i < 26; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    pro(i, k + 1);
                    visited[i] = false;
                }
            }
        }
    }

    static int isReadable() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            boolean readable = true;
            for (int j = 0; j < a[i].length(); j++) {
                if (!visited[a[i].charAt(j) - 'a']) {
                    readable = false;
                    break;
                }
            }
            if (readable) cnt++;
        }

        return cnt;
    }

    public static void main(String[] args) {
        input();
        pro(0,1);
        System.out.println(max);
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
