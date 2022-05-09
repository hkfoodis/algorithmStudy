package BaekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class strahler9470 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int K, M, P;
    static ArrayList<Integer>[] adj;
    static int[] indeg, order, maxCnt;

    static void input() {
        K = scan.nextInt();
        M = scan.nextInt();
        P = scan.nextInt();
        indeg = new int[M + 1];
        order = new int[M + 1];
        maxCnt = new int[M + 1];
        adj = new ArrayList[M + 1];
        for (int i = 1; i <= M; i++) adj[i] = new ArrayList<>();
        for (int i = 1; i <= P; i++) {
            int x = scan.nextInt(), y = scan.nextInt();
            adj[x].add(y);
            indeg[y]++;
        }
    }

    static void pro() {
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= M; i++) {
            if (indeg[i] == 0) {
                queue.add(i);
                order[i] = maxCnt[i] = 1;
            }
        }

        int ans = 0;
        while (!queue.isEmpty()) {
            int x = queue.poll();

            // strahler 최대 값의 개수가 2이상이면 order[x]값을 올려줌
            if (maxCnt[x] >= 2) order[x]++;
            ans = Math.max(ans, order[x]);

            for (int y : adj[x]) {
                // indeg 값 감소 시키고 0인 경우 queue에 추가
                indeg[y]--;
                if (indeg[y] == 0) queue.add(y);

                // x와 y의 strahler 값이 같으면 maxCnt[y]값 + 1
                if (order[y] == order[x]) maxCnt[y]++;
                // x의 strahler 값이 더 큰 경우 y의 strahler 값을 업데이트 해주고 maxCnt[y]는 1로 초기화
                else if (order[y] < order[x]) {
                    order[y] = order[x];
                    maxCnt[y] = 1;
                }
            }
        }

        System.out.println(K + " " + ans);
    }

    public static void main(String[] args) {
        int T = scan.nextInt();
        while (T-- > 0) {
            input();
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
