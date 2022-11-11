
import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            q.add((int) Math.ceil((100.0 - progresses[i]) / speeds[i]));
        }

        List<Integer> answer = new ArrayList<>();
        int cnt = 1;
        while (!q.isEmpty()) {
            int a = q.poll();

            while (!q.isEmpty() && q.peek() <= a) {
                q.poll();
                cnt++;
            }

            answer.add(cnt);
            cnt = 1;
        }

        return answer.stream().mapToInt(o -> o).toArray();
    }
}