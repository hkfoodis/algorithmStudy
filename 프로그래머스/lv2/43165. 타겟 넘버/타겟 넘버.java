class Solution {
    public int solution(int[] numbers, int target) {
        answer = 0;
        operators = new int[numbers.length];

        dfs(0, numbers, target);

        return answer;
    }
    
    static int[] operators;
    static int answer;

    static void dfs(int k, int[] numbers, int target) {
        if (k == numbers.length) {
            if (cal(numbers) == target) answer++;
        } else {
            for (int cand = 1; cand <= 2; cand++) {
                operators[k] = cand;
                dfs(k + 1, numbers, target);
                operators[k] = 0;
            }
        }
    }

    static int cal(int[] numbers) {
        int result = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (operators[i] == 1) {
                result += numbers[i];
            } else if (operators[i] == 2) {
                result -= numbers[i];
            }
        }

        return result;
    }
}