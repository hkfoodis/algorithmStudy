package HackerRank;

import java.util.Scanner;
import java.util.*;

public class JavaStack {

    public static void main(String []argh)
    {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input=sc.next();
            //Complete the code

            Stack<Character> stack = new Stack<>();
            boolean flag = true;

            for (int i = 0; i < input.length(); i++) {

                Character c = input.charAt(i);

                if (c == '(' || c == '{' || c == '[') {
                    stack.add(c);
                } else {
                    if (stack.size() == 0) {
                        flag = false;
                        break;
                    } else {
                        Character output = stack.pop();
                        if (!((output == '(' && c == ')') || (output == '{' && c == '}') || (output == '[' && c == ']')) ) {
                            flag = false;
                            break;
                        }
                    }
                }
            }
            System.out.println(flag && stack.size() == 0);
        }

    }
}
