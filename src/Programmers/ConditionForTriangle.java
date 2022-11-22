package Programmers;

import java.util.Arrays;

public class ConditionForTriangle {
    public static int solution(int[] sides) {
        int answer = 0;

        /* 가장 긴 변의 길이는 나머지 두 변의 길이의 합보다 작아야 함. */
        /* 들어온 두 변이 나머지 두 변 일수도 있고 가장 긴 변이 포함 되어 있을 수도 있다. */
        /* 1. sides 중 큰 수가 가장 긴 변 일 때
        * 2. sides 에 들어있는 두 변이 짧은 두 변일 때 */

        Arrays.sort(sides);

        int a = sides[1] - sides[0];
        int b = sides[1] + sides[0];

        answer = b - a - 1;

        return answer;
    }

    public static void main(String[] args) {
        int[] sides = {11,7};
        System.out.println(solution(sides));
    }
}
