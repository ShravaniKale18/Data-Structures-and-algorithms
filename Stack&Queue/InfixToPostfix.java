import java.util.Stack;

public class InfixToPostfix {

    static String convertInfixToPostFix(String s) {

        String ans = "";
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                ans += ch;
            }else if (ch == '(') {
                stack.push(ch);
            }else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    ans += stack.pop();
                }

                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }else{
                while (!stack.isEmpty() && priority(ch) <= priority(stack.peek())) {
                    ans += stack.pop();
                }

                stack.push(ch);
            }

        }
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }

        return ans;
    }

    static int priority(char ch) {
        if (ch == '^') {
            return 3;
        } else if (ch == '*' || ch == '/') {
            return 2;
        } else if (ch == '+' || ch == '-') {
            return 1;
        } else {
            return -1;
        }
    }
    public static void main(String[] args) {
        String s = "A+B*C";

        System.out.println(convertInfixToPostFix(s));
    }
}
