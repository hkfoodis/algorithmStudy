import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] numlist, int n) {
        List<Integer> numList = Arrays.stream(numlist).boxed().collect(Collectors.toList());

        Collections.sort(numList, (o1, o2) -> {
            int dif1 = Math.abs(o1 - n);
            int dif2 = Math.abs(o2 - n);
            if (dif1 > dif2) return 1;
            else if (dif1 == dif2) {
                return o2 - o1;
            } else {
                return -1;
            }
        });

        return numList.stream().mapToInt(o -> o).toArray();
    }
}