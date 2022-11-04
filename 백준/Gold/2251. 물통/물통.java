import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class State {
    int[] X;
    State(int[] _X) {
        X = new int[3];
        for (int i = 0; i < 3; i++) X[i] = _X[i];
    }

    State move(int from, int to, int [] limit) {
        // from 물통에서 to 물통으로 물을 옮김
        int[] nX = new int[]{X[0], X[1], X[2]};
        if (X[from] + X[to] <= limit[to]) {
            nX[to] = nX[from] + nX[to];
            nX[from] = 0;
        } else {
            nX[from] -= limit[to] - nX[to];
            nX[to] = limit[to];
        }

        return new State(nX);
    }
}

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int[] limit;
    static boolean[] possible;
    static boolean[][][] visit;

    static void input() {
        limit = new int[3];
        for (int i = 0; i < 3; i++) limit[i] = scan.nextInt();
        visit = new boolean[205][205][205];
        possible = new boolean[205];
    }

    static void bfs(int x1, int x2, int x3) {
        Queue<State> q = new LinkedList<>();
        visit[x1][x2][x3] = true;
        q.add(new State(new int[]{x1, x2, x3}));

        // BFS 시작
        while (!q.isEmpty()) {
            State st = q.poll();
            if (st.X[0] == 0) possible[st.X[2]] = true;
            for (int from = 0; from < 3; from++) {
                for (int to = 0; to < 3; to++) {
                    if (from == to) continue;
                    // i번 물통에서 j번 물통으로 물 옮김
                    State nxt = st.move(from, to, limit);

                    // 바뀐 상태를 탐색한 적이 없다면
                    if (!visit[nxt.X[0]][nxt.X[1]][nxt.X[2]]) {
                        visit[nxt.X[0]][nxt.X[1]][nxt.X[2]] = true;
                        q.add(nxt);
                    }
                }
            }
        }
    }

    static void pro() {
        bfs(0, 0, limit[2]);
        for (int i = 0; i <= 200; i++) {
            if (possible[i]) sb.append(i).append(" ");
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
