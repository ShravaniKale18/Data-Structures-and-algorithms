import java.util.Stack;

/**
 * Approach:
 * 1. Use a Stack to store opening brackets.
 * 2. If the current character is an opening bracket, push it into the stack.
 * 3. If the current character is a closing bracket:
 *    - If the stack is empty, return false.
 *    - Pop the top element and check whether it matches the closing bracket.
 *    - If it does not match, return false.
 * 4. After processing all characters, the stack must be empty.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */

public class ValidParenthesis {

    static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(s.charAt(i));
            }else if (ch == ')' || ch == '}' || ch == ']') {
                if(stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if (top == '(' && ch == ')' || top == '{' && ch == '}' || top == '[' && ch == ']') {
                    continue;
                }else{
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()[]{}[(})";

        System.out.println(isValid(s));
    }
}
