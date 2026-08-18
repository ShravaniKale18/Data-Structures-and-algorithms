import java.util.Stack;

public class InfixToPrefix {

    static String convertInfixToPrefix(String s) {
        s = reverseString(s);

        String prefix = convertToPostFix(s);

        return reverseString(prefix);
    }

    static String convertToPostFix(String s) {
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

    static String reverseString(String s) {

        String ans = "";

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if (ch == '(') {
                ans += ')';
            }else if (ch == ')') {
                ans += '(';
            }else {
                ans += ch;
            }
        }

        return ans;
    }

    static int priority(char ch) {
        if (ch == '^') {
            return 3;
        }else if (ch == '*' || ch =='/') {
            return 2;
        }else if (ch == '+' || ch == '-') {
            return 1;
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
        String s = "a*(b+c)/d"; ///*a+bcd

        System.out.println(convertInfixToPrefix(s));
    }
}
