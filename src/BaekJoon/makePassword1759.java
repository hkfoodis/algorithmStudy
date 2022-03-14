package BaekJoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class makePassword1759 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int L, C;
    static char[] alphabets;
    static int[] selected;

    public static void input() {
        L = scan.nextInt();
        C = scan.nextInt();
        String[] token = scan.nextLine().split(" ");
        alphabets = new char[C + 1];
        selected = new int[L + 1];
        for (int i = 1; i <= C; i++) {
            alphabets[i] = token[i-1].charAt(0);
        }
        Arrays.sort(alphabets, 1, C + 1);
    }

    public static boolean isVowel(char x) {
        if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
            return true;
        }

        return false;
    }

    public static void rec_func(int k) {
        if (k == L + 1) {
            int vowel = 0;
            int consonant = 0;
            for (int i = 1; i <= L; i++) {
                if (isVowel(alphabets[selected[i]])) {
                    vowel++;
                } else {
                    consonant++;
                }
            }

            if (vowel >= 1 && consonant >= 2) {
                for (int i = 1; i <= L; i++) {
                    sb.append(alphabets[selected[i]]);
                }
                sb.append("\n");
            }
        } else {
            for (int cand = selected[k-1] + 1; cand <= C; cand++) {
                selected[k] = cand;
                rec_func(k + 1);
                selected[k] = 0;
            }
        }
    }

    public static void main(String[] args) {
        input();

        rec_func(1);
        System.out.println(sb.toString());
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
