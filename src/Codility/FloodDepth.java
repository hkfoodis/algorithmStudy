package Codility;

public class FloodDepth {
    public static int solution(int[] A) {
        // write your code in Java SE 8

        int[] leftSide = new int[A.length];
        int[] rightSide = new int[A.length];

        int leftSideMax = 0, rightSideMax = 0;
        for (int i = 0; i < A.length; i++) {
            leftSideMax = Math.max(leftSideMax, A[i]);
            leftSide[i] = leftSideMax;

            rightSideMax = Math.max(rightSideMax, A[A.length - 1 - i]);
            rightSide[A.length - 1 - i] = rightSideMax;
        }

        int answer = 0;
        for (int i = 0; i < A.length; i++) {
            answer = Math.max(answer, Math.min(leftSide[i], rightSide[i]) - A[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] A = {1,3,2,1,2,1,5,3,3,4,2};
        System.out.println(solution(A));
    }
}
