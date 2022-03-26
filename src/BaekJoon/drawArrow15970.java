package BaekJoon;

import java.io.*;
import java.sql.Array;
import java.util.*;

public class drawArrow15970 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input() {
        N = scan.nextInt();
        a = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            a[i] = new ArrayList<Integer>();
        }

        for (int i = 1; i <= N; i++) {
            int coord, color;
            coord = scan.nextInt();
            color = scan.nextInt();
            // color 색의 점의 Coord에 놓여있음
            a[color].add(coord);
        }
    }

    static int N;
    static ArrayList<Integer> a[];

    static int toLeft(int color, int idx) {
        if (idx == 0) return Integer.MAX_VALUE;
        return a[color].get(idx) - a[color].get(idx - 1);
    }

    static int toRight(int color, int idx) {
        if(idx == a[color].size() - 1) return Integer.MAX_VALUE;
        return a[color].get(idx + 1) - a[color].get(idx);
    }

    static void pro() {
        // 색 별로 정렬
        for (int color = 1; color <= N; color++) {
            Collections.sort(a[color]);
        }

        int ans = 0;
        for (int color = 1; color <= N; color++) {
            // 색깔별로 가장 가까운 점 찾아주기
            for (int i = 0; i < a[color].size(); i++) {
                // 왼쪽까지의 거리
                int left = toLeft(color, i);
                int right = toRight(color, i);

                ans += Math.min(left, right);
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
