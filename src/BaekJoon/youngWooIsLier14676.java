package BaekJoon;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class youngWooIsLier14676 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int K, N, M;
    static int[] indeg, cnt, satisfaction;
    static ArrayList<Integer>[] adj;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        K = scan.nextInt();
        adj = new ArrayList[N + 1];
        indeg = new int[N + 1];
        cnt = new int[N + 1];
        satisfaction = new int[N + 1];
        for (int i = 1; i <= N; i++)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int x = scan.nextInt(), y = scan.nextInt();
            adj[x].add(y);
            indeg[y]++;
        }
    }

    static void pro() {
        boolean abnormal = false;
        while (K-- > 0) {
            int t = scan.nextInt(), x = scan.nextInt();
            if (t == 1) {
                // x의 선행 건물들이 모두 지어졌는지 확인
                if (satisfaction[x] < indeg[x]) abnormal = true;

                cnt[x]++;
                // x가 처음 지어진 경우 x가 영향을 주는 건물들에 선행건물이 지어졌음을 알려주기
                if (cnt[x] == 1) {
                    for (int y : adj[x]) {
                        satisfaction[y]++;
                    }
                }
            } else {
                // x가 한 개 이상 지어져 있는지 확인
                if (cnt[x] == 0) abnormal = true;

                cnt[x]--;
                // x가 더이상 남아있지 않다면, 선행 건물들이 사라졌다고 알려주기
                if (cnt[x] == 0) {
                    for (int y : adj[x]) {
                        satisfaction[y]--;
                    }
                }
            }
        }

        if (abnormal) System.out.println("Lier!");
        else System.out.println("king-God-Emperor");
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
