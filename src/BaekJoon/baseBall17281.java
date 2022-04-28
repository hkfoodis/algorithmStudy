package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class baseBall17281 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, ans;
    static int[][] play;
    static boolean[] select;
    static int[] lineUp;

    static void input() {
        N = scan.nextInt();
        play = new int[N + 1][10];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= 9; j++) {
                play[i][j] = scan.nextInt();
            }
        }
        select = new boolean[10];
        lineUp = new int[10];
    }

    static void playBaseBall() {
        int score = 0;
        int startPlayer = 1;
        boolean[] base;

        for (int i = 1; i <= N; i++) {
            int outCnt = 0;
            base = new boolean[4];

            outer: while (true) {
                for (int j = startPlayer; j <= 9; j++) {
                    int hitter = play[i][lineUp[j]];

                    switch (hitter) {
                        case 0:
                            outCnt++;
                            break;
                        case 1:
                            for (int k = 3; k >= 1; k--) {
                                if (base[k]) {
                                    if (k == 3) {
                                        score++;
                                        base[k] = false;
                                        continue;
                                    }
                                    base[k] = false;
                                    base[k + 1] = true;
                                }
                            }
                            base[1] = true;
                            break;
                        case 2:
                            for (int k = 3; k >= 1; k--) {
                                if (base[k]) {
                                    if (k == 3 || k == 2) {
                                        score++;
                                        base[k] = false;
                                        continue;
                                    }
                                    base[k] = false;
                                    base[k + 2] = true;
                                }
                            }
                            base[2] = true;
                            break;
                        case 3:
                            for (int k = 3; k >= 1; k--) {
                                if (base[k]) {
                                    score++;
                                    base[k] = false;
                                }
                            }
                            base[3] = true;
                            break;
                        case 4:
                            for (int k = 1; k <= 3; k++) {
                                if (base[k]) {
                                    score++;
                                    base[k] = false;
                                }
                            }
                            score++;
                            break;
                    }

                    if (outCnt == 3) {
                        startPlayer = j + 1;
                        if (startPlayer == 10) {
                            startPlayer = 1;
                        }
                        break outer;
                    }
                }

                startPlayer = 1;
            }
        }

        ans = Math.max(ans, score);
    }

    static void rec_func(int k) {
        if (k == 10) {
            playBaseBall();
            return;
        } else {
            for (int i = 1; i <= 9; i++) {
                if (select[i]) continue;
                select[i] = true;
                lineUp[i] = k;
                rec_func(k + 1);
                select[i] = false;
            }
        }
    }

    static void pro() {
        select[4] = true;
        lineUp[4] = 1;

        rec_func(2);
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
