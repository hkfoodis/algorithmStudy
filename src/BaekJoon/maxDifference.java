package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

// 10819 차이를 최대로
public class maxDifference {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input() {
        N = scan.nextInt();
        nums = new int[N + 1];
        selected = new int[N + 1];
        used = new int[N + 1];
        for (int i=1; i<=N; i++) {
            nums[i] = scan.nextInt();
        }
        max = Integer.MIN_VALUE;
    }

    static int N, max;
    static int[] nums, used, selected;

    static int calculator() {
        // |A[0] - A[1]| + |A[1] - A[2]| + ... + |A[N-2] - A[N-1]| 계산
        int value = 0;
        for (int i = 2; i <= N; i++) {
            value += Math.abs(selected[i - 1] - selected[i]);
        }

        return value;
    }

    static void rec_func(int k) {
        if (k == N + 1) {
            int value = calculator();
            max = Math.max(max, value);
        } else {
            for (int cand = 1; cand <= N; cand++) {
                if (used[cand] == 1) continue;
                selected[k] = nums[cand];
                used[cand] = 1;
                rec_func(k + 1);
                selected[k] = 0;
                used[cand] = 0;
            }
        }
    }

    public static void main(String[] args) {
        input();

        // 1 번째 원소부터 M 번째 원소를 조건에 맞는 모든 방법을 찾아줘
        rec_func(1);
        System.out.println(max);
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
