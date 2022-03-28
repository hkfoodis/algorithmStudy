package BaekJoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class card11652 {
    // 정렬을 이용한 문제풀이

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input() {
        N = scan.nextInt();
        cards = new long[N];
        for (int i = 0; i < N; i++) {
            cards[i] = scan.nextLong();
        }
    }

    static int N;
    static long curCard;
    static long[] cards;

    static void pro() {
        Arrays.sort(cards);

        curCard = cards[0];
        int cardCnt = 1, curCnt = 1;
        for (int i = 1; i < N; i++) {
            if (cards[i] == cards[i - 1]) {
                curCnt++;
            } else {
                curCnt = 1;
            }

            if (curCnt > cardCnt) {
                cardCnt = curCnt;
                curCard = cards[i];
            }
        }
        System.out.println(curCard);
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
