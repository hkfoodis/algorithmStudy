import java.io.*;
import java.util.*;

// 부분 수열의 합 1182
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input() {
        N = scan.nextInt();
        S = scan.nextInt();
        nums = new int[N + 1];
        for (int i = 1; i <= N; i++) nums[i] = scan.nextInt();
    }

    static int N, S, ans;
    static int[] nums;
    
    static void rec_func(int k, int value) {
        if (k == N + 1) {  
            if (value == S) ans++;
        } else {
            // Include
            rec_func(k + 1, value + nums[k]);
            // Not Include
            rec_func(k + 1, value);
        }
    }

    public static void main(String[] args) {
        input();
        
        rec_func(1, 0);
        if (S == 0){        // S가 0이면 아무것도 없는 수열인 경우가 있을 수 있음
            ans--;
        }
        System.out.println(ans);
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
