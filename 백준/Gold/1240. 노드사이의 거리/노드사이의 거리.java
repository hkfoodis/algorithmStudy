import java.io.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class Edge {
        int y, c;

        Edge(int y,int c){
            this.y = y;
            this.c = c;
        }
    }

    static int N, M;
    static ArrayList<Edge>[] edges;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) edges[i] = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            int x = scan.nextInt(), y = scan.nextInt(), c = scan.nextInt();
            edges[x].add(new Edge(y, c));
            edges[y].add(new Edge(x, c));
        }
    }

    static int ans;

    static void dfs(int x, int prev, int goal, int dist) {
        if (x == goal) {
            ans = dist;
            return;
        }

        for (Edge e : edges[x]) {
            if (e.y == prev) continue;
            dfs(e.y, x, goal, dist + e.c);
        }
    }

    static void pro() {
        int x = scan.nextInt(), y = scan.nextInt();

        dfs(x, -1, y, 0);
        System.out.println(ans);
    }

    public static void main(String[] args) {
        // 세 가지 풀이가 가능하다.
        // 1. 트리도 일종의 그래프이므로 최단거리 알고리즘인 Dijkstra 사용
        // 2. 트리에서 두 노드 사이의 경로는 유일한 점을 활용해서 BFS 사용
        // 3. 트리를 Rooted 트리로 변환해서 구현이 짧은 DFS를 통해 거리 계산하기.
        //    마찬가지로 두 노드 사이의 경로가 유일함을 확인한다.

        // 본 풀이는 3 번 접근을 다룬다.

        input();

        while (M-- > 0) {
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
