package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class sudoku {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int num;
    static int[][] matrix;

    static void input() {
        matrix = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }
    }

    static boolean possible(int row, int col, int value) {

        for (int i = 0; i < 9; i++) {
            // 같은 열
            if (value == matrix[row][i]) {
                return false;
            }

            // 같은 행
            if (value == matrix[i][col]) {
                return false;
            }
        }

        // 같은 구역
        int setRow = (row / 3) * 3;
        int setCol = (col / 3) * 3;
        for (int i = setRow; i < setRow + 3; i++) {
            for (int j = setCol; j < setCol + 3; j++) {
                if (value == matrix[setRow][setCol]) {
                    return false;
                }
            }
        }

        return true;
    }

    static void rec_func(int row, int col) {
        if (col == 9) {
            rec_func(row + 1, 0);
        }

        if (row == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(matrix[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb.toString());
            return;
        }

        if (matrix[row][col] == 0){
            for (int cand = 1; cand <= 9; cand++) {
                if(possible(row, col, cand)) {
                    matrix[row][col] = cand;
                    rec_func(row, col + 1);
                    matrix[row][col] = 0;
                }
            }
        } else {
            rec_func(row, col + 1);
        }
    }

    public static void main(String[] args) {
        input();

        rec_func(0, 0);
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
