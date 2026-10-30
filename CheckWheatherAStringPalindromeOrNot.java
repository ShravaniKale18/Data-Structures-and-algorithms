public class CheckWheatherAStringPalindromeOrNot {
    public static boolean checkPalindrome(String str) {
		
		str = str.toLowerCase();
		String cleanedString = "";

		for(int i = 0; i < str.length(); i++) {
			if(Character.isLetterOrDigit(str.charAt(i))) {
				cleanedString += str.charAt(i);
			}
		}

		str = "";

		for(int i = cleanedString.length() - 1; i >= 0; i--) {
			str += cleanedString.charAt(i);
		}

		if(str.equals(cleanedString)) {
			return true;
		}

		return false;
	}

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama#$%";

        boolean isPalindrome = checkPalindrome(str);
        
        if(isPalindrome) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }
    }
}
