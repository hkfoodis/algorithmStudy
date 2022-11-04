import java.io.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] ans;
    static int[][] field;
    static List<Location>[] locationList;

    static int[] dx = {-1, -1};
    static int[] dy = {-1, 1};

    static class Location {
        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void input() {
        N = scan.nextInt();
        field = new int[N][N];
        ans = new int[2];
        locationList = new ArrayList[2];
        for (int i = 0; i < 2; i++) {
            locationList[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                field[i][j] = scan.nextInt();
                if (field[i][j] == 1) {
                    if (isBlack(i, j)) {
                        locationList[0].add(new Location(i, j));
                    } else {
                        locationList[1].add(new Location(i, j));
                    }
                }
            }
        }
    }

    static boolean isBlack(int x, int y) {
        if (x % 2 == 0 && y % 2 == 0) {
            return true;
        }

        if (x % 2 == 1 && y % 2 == 1) {
            return true;
        }

        return false;
    }

    static boolean isPossible(int x, int y) {
        for (int i = 1; i <= x; i++) {
            for (int j = 0; j < 2; j++) {
                int tx = x + dx[j] * i;
                int ty = y + dy[j] * i;

                if (tx >= 0 && tx < N && ty >= 0 && ty < N) {
                    if (field[tx][ty] == 2) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static void rec_func(int k, int cnt, int color) {
        for (int i = k; i < locationList[color].size(); i++) {
            Location cur = locationList[color].get(i);

            if (isPossible(cur.x, cur.y)) {
                field[cur.x][cur.y] = 2;
                rec_func(i + 1, cnt + 1, color);
                field[cur.x][cur.y] = 1;
            }
        }

        ans[color] = Math.max(ans[color], cnt);
    }

    public static void main(String[] args) {
        input();

        rec_func(0, 0, 0);
        rec_func(0, 0, 1);
        System.out.println(ans[0] + ans[1]);
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
