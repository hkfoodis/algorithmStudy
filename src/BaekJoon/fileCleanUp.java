package BaekJoon;

import java.io.*;
import java.util.*;

public class fileCleanUp {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static String[] files;
    static Map<String, Object> map = new LinkedHashMap<>();

    static void input() {
        N = scan.nextInt();
        files = new String[N];
        for (int i = 0; i < N; i++) {
            files[i] = scan.nextLine().split("\\.")[1];
        }
    }

    static void pro() {
        Arrays.sort(files);

        for (int i = 0; i < N; i++) {
            if (map.containsKey(files[i])) {
                int cnt = (int) map.get(files[i]);
                map.replace(files[i], cnt + 1);
            } else {
                map.put(files[i], 1);
            }
        }

        for(String key : map.keySet()) {
            sb.append(key).append(" ").append(map.get(key)).append("\n");
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
