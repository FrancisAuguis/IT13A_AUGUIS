import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        
        Scanner auguis = new Scanner(System.in);

        
        System.out.print("Enter first word: ");
        String ondo1 = auguis.nextLine();

      
        System.out.print("Enter second word: ");
        String ondo2 = auguis.nextLine();

        
        if (isPalindrome(ondo1)) {
            System.out.println(ondo1 + " is a palindrome.");
        } else {
            System.out.println(ondo1 + " is not a palindrome.");
        }

        if (isPalindrome(ondo2)) {
            System.out.println(ondo2 + " is a palindrome.");
        } else {
            System.out.println(ondo2 + " is not a palindrome.");
        }

     
        auguis.close();
    }

    public static boolean isPalindrome(String word) {
        int length = word.length();
        for (int i = 0; i < length / 2; i++) {
            if (word.charAt(i) != word.charAt(length - 1 - i)) {
                return false; 
            }
        }
        return true; 
    }
}