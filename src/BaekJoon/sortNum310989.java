package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class sortNum310989 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] count = new int[10001];

        // 각 원소의 개수를 저장한다.
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            count[input]++;

        }

        StringBuilder sb = new StringBuilder();

        // 존재하는 원소의 수만큼 i를 출력한다.
        for (int i = 1; i <= 10000; i++) {
            for (int j = 0; j < count[i]; j++) {
                sb.append(i + "\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}
