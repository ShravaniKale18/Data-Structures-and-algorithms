import java.util.*;

/** 
 * TC : O(n)
 * SC : O(n)
 */

public class RemoveKDigits {

    static String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);

            while(!stack.isEmpty() && stack.peek() > ch && k > 0) {
                stack.pop();
                k--;
            }

            if(!stack.isEmpty() || ch != '0') {
                stack.push(ch);
            }
        }

        while(stack.size() > 0 && k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();

        for(char ch: stack) {
            if(ch == '0' && sb.length() == 0) {
                continue;
            }

            sb.append(ch);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        System.out.println(removeKdigits(num, k)); // Output: "1219"    
    }
}
