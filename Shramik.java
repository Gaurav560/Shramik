import java.util.Scanner;
import java.util.Stack;

/**
 * Shramik class contains various methods to reverse strings in Java
 * Demonstrates different approaches to string reversal
 */
public class Shramik {
    
    /**
     * Reverses a string using StringBuilder
     * @param str the string to reverse
     * @return reversed string
     */
    public static String reverseUsingStringBuilder(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return new StringBuilder(str).reverse().toString();
    }
    
    /**
     * Reverses a string using character array and two pointers
     * @param str the string to reverse
     * @return reversed string
     */
    public static String reverseUsingTwoPointers(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        
        char[] charArray = str.toCharArray();
        int left = 0;
        int right = charArray.length - 1;
        
        while (left < right) {
            // Swap characters
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            
            left++;
            right--;
        }
        
        return new String(charArray);
    }
    
    /**
     * Reverses a string using recursion
     * @param str the string to reverse
     * @return reversed string
     */
    public static String reverseUsingRecursion(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        return reverseUsingRecursion(str.substring(1)) + str.charAt(0);
    }
    
    /**
     * Reverses a string using Stack data structure
     * @param str the string to reverse
     * @return reversed string
     */
    public static String reverseUsingStack(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        
        Stack<Character> stack = new Stack<>();
        
        // Push all characters to stack
        for (char c : str.toCharArray()) {
            stack.push(c);
        }
        
        // Pop all characters from stack to form reversed string
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        
        return reversed.toString();
    }
    
    /**
     * Reverses a string using a simple loop (manual approach)
     * @param str the string to reverse
     * @return reversed string
     */
    public static String reverseUsingLoop(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        
        return reversed;
    }
    
    /**
     * Reverses only words in a string, keeping word order same
     * @param str the string with words to reverse
     * @return string with each word reversed
     */
    public static String reverseWordsOnly(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        
        String[] words = str.split(" ");
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < words.length; i++) {
            result.append(reverseUsingStringBuilder(words[i]));
            if (i < words.length - 1) {
                result.append(" ");
            }
        }
        
        return result.toString();
    }
    
    /**
     * Main method to demonstrate different string reversal techniques
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== String Reversal Techniques by Shramik ===");
        System.out.println();
        
        System.out.print("Enter a string to reverse: ");
        String input = scanner.nextLine();
        
        System.out.println("\nOriginal String: " + input);
        System.out.println("=====================================");
        
        // Demonstrate all reversal methods
        System.out.println("1. Using StringBuilder: " + reverseUsingStringBuilder(input));
        System.out.println("2. Using Two Pointers: " + reverseUsingTwoPointers(input));
        System.out.println("3. Using Recursion: " + reverseUsingRecursion(input));
        System.out.println("4. Using Stack: " + reverseUsingStack(input));
        System.out.println("5. Using Simple Loop: " + reverseUsingLoop(input));
        System.out.println("6. Reverse Words Only: " + reverseWordsOnly(input));
        
        // Interactive menu
        while (true) {
            System.out.println("\n=== Choose an option ===");
            System.out.println("1. Reverse another string");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            if (choice == 1) {
                System.out.print("Enter a string to reverse: ");
                input = scanner.nextLine();
                System.out.println("\nOriginal: " + input);
                System.out.println("Reversed: " + reverseUsingStringBuilder(input));
            } else if (choice == 2) {
                System.out.println("Thank you for using Shramik's String Reversal Tool!");
                break;
            } else {
                System.out.println("Invalid choice! Please try again.");
            }
        }
        
        scanner.close();
    }
}