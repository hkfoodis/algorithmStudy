import java.util.*;
class Solution {
    public int solution(int[][] lines) {
        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < lines.length; i++) {
            int x1 = lines[i][0], x2 = lines[i][1];

            for (int j = x1; j < x2; j++) {
                map.put(j, map.getOrDefault(j, 0) + 1);
            }
        }

        for (Integer key : map.keySet()) {
            if (map.get(key) > 1) {
                answer++;
            }
        }

        return answer;
    }
}