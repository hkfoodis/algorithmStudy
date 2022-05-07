package BaekJoon;

import java.io.*;
import java.util.*;

public class minimumCost1916Practice {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class Edge {
        public int to, weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Info {
        public int idx, dist;

        public Info(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }

    static int N, M, start, end;
    static int[] dist;
    static ArrayList<Edge>[] edges;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        dist = new int[N + 1];
        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) edges[i] = new ArrayList<>();
        for (int i = 1; i <= M; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();
            int weight = scan.nextInt();
            edges[from].add(new Edge(to, weight));
        }
        start = scan.nextInt();
        end = scan.nextInt();
    }

    static void dijkstra(int start) {
        for (int i = 1; i <= N; i++) dist[i] = Integer.MAX_VALUE;

        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));

        pq.add(new Info(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Info info = pq.poll();

            if (dist[info.idx] != info.dist) continue;

            for (Edge e : edges[info.idx]) {
                if (dist[info.idx] + e.weight >= dist[e.to]) continue;

                dist[e.to] = dist[info.idx] + e.weight;
                pq.add(new Info(e.to, dist[e.to]));
            }
        }
    }

    static void pro() {
        dijkstra(start);
        System.out.println(dist[end]);
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
