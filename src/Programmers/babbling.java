package Programmers;

public class babbling {
    public static int solution(String[] babbling) {
        int answer = 0;

        String[] arr = {"aya", "ye", "woo", "ma"};

        for (int i = 0; i < babbling.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                babbling[i] = babbling[i].replace(arr[j], " ");
            }
        }

        for (String bab : babbling) {
            if (bab.trim().equals("")) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        String[] babbling = {"aya", "yee", "u", "maa", "wyeoo"};

        System.out.println(solution(babbling));
    }
}
