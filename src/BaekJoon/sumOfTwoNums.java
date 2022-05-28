package BaekJoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sumOfTwoNums {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, X;
    static int[] nums;

    static void input() {
        N = scan.nextInt();
        nums = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            nums[i] = scan.nextInt();
        }
        X = scan.nextInt();
    }

    static boolean search(int[] a, int L, int R, int b, int x) {
        while (L <= R) {
            int mid = (L + R) / 2;
            if (b + a[mid] == x) return true;
            if (b + a[mid] < x) L = mid + 1;
            else R = mid - 1;
        }

        return false;
    }

    static void pro() {
        Arrays.sort(nums, 1, N + 1);

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            if (search(nums, i + 1, N, nums[i], X)) ans++;
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
