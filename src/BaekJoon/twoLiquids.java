package BaekJoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class twoLiquids {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input() {
        n = scan.nextInt();
        liquids = new int[n];
        for (int i = 0; i < n; i++) {
            liquids[i] = scan.nextInt();
        }
    }

    static int n;
    static int[] liquids;

    static void pro() {
        Arrays.sort(liquids);

        int start = 0, end = n - 1;

        int ans1 = 0;
        int ans2 = 0;
        int temp = 0;
        int gap = Integer.MAX_VALUE;
        int sum = 0;
        while (start < end) {
            sum = liquids[start] + liquids[end];
            temp = Math.abs(sum);
            if (temp < gap) {
                gap = temp;
                ans1 = liquids[start];
                ans2 = liquids[end];
            }
            if (sum < 0) start++;
            else end--;
        }

        System.out.println(ans1 + " " + ans2);
    }

    public static void main(String[] args) {
        input();

        // 1 번째 원소부터 M 번째 원소를 조건에 맞는 모든 방법을 찾아줘
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
