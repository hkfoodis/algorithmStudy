import java.util.*;

class Solution {
    public int[] solution(int n) {
        Set<Integer> set = new HashSet<>();

        while (n != 1) {

            for (int i = 2; i < 100000; i++) {
                if (n % i == 0) {
                    n /= i;
                    set.add(i);
                    break;
                }
            }
        }

        List<Integer> answer = new ArrayList<>(set);

        Collections.sort(answer);

        return answer.stream().mapToInt(o -> o).toArray();
    }
}