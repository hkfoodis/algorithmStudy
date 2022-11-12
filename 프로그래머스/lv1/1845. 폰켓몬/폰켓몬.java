import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        /* 중복 허용 가질 수 있는 포켓몬 종류의 최대값 */
        /* 포켓몬이 N 마리면 그 중 N/2 마리를 가질 수 있음 */

        Set<Integer> list = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }

        if (nums.length / 2 < list.size()) {
            answer = nums.length / 2;
        } else {
            answer = list.size();
        }

        return answer;
    }
}