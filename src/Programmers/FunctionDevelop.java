package Programmers;

import java.sql.Array;
import java.util.*;

public class FunctionDevelop {

    public static int[] solution(int[] progresses, int[] speeds) {

        /* 돌아가면서 progresses 에 speeds를 더하다가 100이 되면 앞에서부터 나가기 */

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            q.add((int) Math.ceil((100.0 - progresses[i]) / speeds[i]));
        }

        List<Integer> answer = new ArrayList<>();
        int cnt = 1;
        while (!q.isEmpty()) {
            int a = q.poll();

            while (!q.isEmpty() && q.peek() < a) {
                q.poll();
                cnt++;
            }

            answer.add(cnt);
            cnt = 1;
        }

        return answer.stream().mapToInt(o -> o).toArray();
    }

    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }
}
