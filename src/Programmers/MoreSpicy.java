package Programmers;

import java.util.PriorityQueue;

public class MoreSpicy {

    public static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int s : scoville) {
            heap.offer(s);
        }

        while (heap.peek() <= K) {
            if (heap.size() == 1) return -1;

            int a = heap.poll();
            int b = heap.poll();

            int result = a + (b * 2);

            heap.offer(result);
            answer ++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] scoville = {12,9,10,2,3,1};
        int k = 7;
        System.out.println(solution(scoville, k));
    }
}
