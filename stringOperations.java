/*
 * Name : Rudra Pratap Singh 
 * Date: 04/09/2024
 * 
 * Problem Description :
 *  [When the program is run, the user will first enter a string. After that, the program should
	ask the user which operation they want to execute on the string. The available operations are
	listed below: Append, CountWords, Replace, isPalindrome, Splice, Split,
	MaxRepeatingCharacter, Sort, Shift, and Reverse. Each method should perform its
	respective operation based on the user's input.]
	
	Examples:
		1. append(String newString)
			String currentString = "Hello";
			append(" World"); // Result: "Hello World"
			append(" Java"); // Result: "Hello World Java"
		2. countWords()
			String text = "Hello World from Codeup";
			int wordCount = countWords(); // Result: 4
		3. replace(String a, String b)
			String text = "Java Programming";
			replace('a', 'o'); // Result: "Jovo Progromming"
			replace('ava', 'o'); // Result: "Jo Progromming"
		4. isPalindrome()
			String text = "madam";
			boolean isPal = isPalindrome(); // Result: true
		5. splice(int start, int length)
			String text = "Academy";
			splice(2, 2); // Result: "Acemy"
		6. split(String pattern)
			String text = "Codeup ACE Academy";
			String[] words = split(“ “); // Result: ["Codeup", "ACE", "Academy"]
		7. maxRepeat()
			String text = "success";
			char maxChar = maxRepeat(); // Result:
			's' -> 3
		8. sort()
			String text = "program";
			String sortedText = sort(); // Result: "agmnoprr"
		9. shift(int n)
			String text = "abcdef";
			shift(2); // Result: "efabcd"
		10. reverse()
			String text = "Java";
**/

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Arrays;

public class stringOperations {
    static Scanner input = new Scanner(System.in);
    static String originalString;

    public static void main(String[] args) {
        System.out.println("Enter a String : ");
        originalString = input.nextLine();
        if (originalString == null || originalString.isEmpty()) {
            System.out.println("Error: String can't be empty");
            return;
        }

        boolean isQuit = false;
        String choice;

        while (!isQuit) {
            display_options();
            choice = input.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Result: " + append());
                    break;
                case "2":
                    countWords();
                    break;
                case "3":
                    replace();
                    break;
                case "4":
                    isPalindrome();
                    break;
                case "5":
                    splice();
                    break;
                case "6":
                    System.out.println("Enter the pattern to split on:");
                    split(originalString);
                    break;
                case "7":
                    maxRepeated(originalString);
                    break;
                case "8":
                    String lowerString = originalString.toLowerCase();
                    if (!lowerString.matches("[a-z]+")) {
                        System.out.println("Error: Input string must only contain Alphabatic characters.");
                        input.close();
                        return;
                    }
                    char[] newString = lowerString.toCharArray();
                    sort(newString, 0, (newString.length) - 1);
                    System.out.println(new String(newString));
                    break;
                case "9":
                    System.out.println("Enter number of characters to shift:");
                    shift();
                    break;
                case "10":
                    System.out.println(reverse(originalString));
                    break;
                case "11":
                    System.out.println("Enter new String: ");
                    originalString = input.nextLine();
                    break;
                case "0":
                    System.out.println("Exiting program.");
                    isQuit = true;
                    input.close();
                    break;
                default:
                    System.out.println("Invalid operation. Try again.");
            }
        }
    }

    public static String append() {
        System.out.println("Enter the string to append:");
        String appendString = input.nextLine();
        originalString += appendString;
        return originalString;
    }

    public static void countWords() {
        int count = 0;
        boolean isWord = false;

        for (int i = 0; i < originalString.length(); i++) {
            char currentCharacter = originalString.charAt(i);
            if (currentCharacter != ' ') {
                isWord = true;
            } else if (isWord) {
                count++;
                isWord = false;
            }
        }
        if (isWord) {
            count++;
        }
        System.out.println("Total number of words : " + count);
    }

    public static void replace() {
        System.out.println("Enter the string to replace:");
        String a = input.nextLine();

        System.out.println("enter new words for replacing ");
        String b = input.nextLine();

        int checkCount = 0;
        String newString = "";

        for (int i = 0; i < originalString.length(); i++) {
            char currentCharacter = originalString.charAt(i);

            if (originalString.substring(i).startsWith(a)) {
                newString += b;
                i = i + a.length() - 1;
                checkCount++;
            } else {
                newString = newString + currentCharacter;
            }
        }
        if (checkCount == 0) {
            System.out.println("No String is Found for replacing");
        }
        System.out.println(newString);

    }

    public static void isPalindrome() {
        String newString = "";
        for (int i = originalString.length() - 1; i >= 0; i--) {
            char currentLastCharacter = originalString.charAt(i);
            newString += currentLastCharacter;
        }
        if (newString == originalString) {
            System.out.println("The given String is Palindrome");
            return;
        }

        System.out.println("The given String is not Palindrome : " + newString);
    }

    public static void splice() {
        int startIndex;
        int length;

        while (true) {
            try {
                System.out.println("Enter the start index:");
                startIndex = input.nextInt();
                if (startIndex < 0) {
                    System.out.println("Invalid input. Start index cannot be negative.");
                } else if (startIndex >= originalString.length()) {
                    System.out.println("Invalid input. Start index is out of bounds.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer value.");
                input.next(); // Clear the invalid input
            }
        }

        while (true) {
            try {
                System.out.println("Enter length from starting Index:");
                length = input.nextInt();
                if (length < 0) {
                    System.out.println("Invalid input. Length cannot be negative.");
                } else if (startIndex + length > originalString.length()) {
                    System.out.println("Invalid input. Length is out of bounds.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer value.");
                input.next(); // Clear the invalid input
            }
        }

        String newString = "";
        for (int i = 0; i < originalString.length(); i++) {
            char currentCharacter = originalString.charAt(i);
            if (!(i >= startIndex && i <= startIndex + length - 1)) {
                newString += currentCharacter;
            }
        }
        System.out.println("Spliced String : " + newString);
    }

    public static void split(String MainString) {
        System.out.println("Enter a pattern for splitting into Array: ");
        String pattern = input.nextLine();
        String[] words = new String[originalString.length() + 1];
        int indexCount = 0;

        for (int i = 0; i < MainString.length(); i++) {
            if (MainString.startsWith(pattern, i)) {
                words[indexCount] = MainString.substring(0, i);
                indexCount++;
                MainString = MainString.substring(i + pattern.length());
                i = -1;
            }
        }

        words[indexCount] = MainString;

        String[] withoutNullWords = new String[indexCount + 1];
        for (int i = 0; i < indexCount + 1; i++) {
            withoutNullWords[i] = words[i];
        }
        System.out.println(Arrays.toString(withoutNullWords));
    }

    public static void sort(char[] characterArray, int low, int high) {
        if (low < high) {
            int pi = partition(characterArray, low, high);

            sort(characterArray, low, pi - 1);
            sort(characterArray, pi + 1, high);
        }

    }

    private static int partition(char[] characterArray, int low, int high) {
        char pivot = characterArray[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (characterArray[j] < pivot) {
                i++;

                char temp = characterArray[i];
                characterArray[i] = characterArray[j];
                characterArray[j] = temp;
            }
        }

        char temp = characterArray[i + 1];
        characterArray[i + 1] = characterArray[high];
        characterArray[high] = temp;

        return i + 1;
    }

    public static void maxRepeated(String string) {
        int[] characterFrequency = new int[256]; 
        
        for (int i = 0; i < string.length(); i++) {
            characterFrequency[string.charAt(i)]++;
        }
        
        int maxFrequency = 0;
        boolean hasDuplicates = false; //for checking Multiple Characters With Max Frequency
        
        for (int i = 0; i < 256; i++) {
            if (characterFrequency[i] > maxFrequency) {
                maxFrequency = characterFrequency[i];
                hasDuplicates = false;
            } else if (characterFrequency[i] == maxFrequency) {
                hasDuplicates = true;
            }
        }
        
        if (hasDuplicates) {
            System.out.println("Characters with max frequency " + maxFrequency + ": ");
            for (int i = 0; i < 256; i++) {
                if (characterFrequency[i] == maxFrequency) {
                    System.out.print((char) i + " ");
                }
            }
        } else {
            System.out.println("Character with max frequency " + maxFrequency + ": ");
            for (int i = 0; i < 256; i++) {
                if (characterFrequency[i] == maxFrequency) {
                    System.out.print((char) i);
                }
            }
        }
        System.out.println();
    }

    public static void shift() {
        int movingCharacters;
        String firstString = "";
        String secondString = "";

        while (true) {
            try {
                System.out.println("Enter moving Character : ");
                movingCharacters = input.nextInt();
                if (movingCharacters < 0) {
                    System.out.println("Invalid input. Moving Character cannot be negative.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer value.");
                input.next(); // Clear the invalid input
            }
        }

        int stringlength = originalString.length();
        for (int i = originalString.length() - 1; i >= 0; i--) {
            if (i >= stringlength - (movingCharacters % stringlength)) {
                firstString += originalString.charAt(i);
            } else {
                secondString += originalString.charAt(i);
            }
        }
        firstString = reverse(firstString);
        secondString = reverse(secondString);
        System.out.println(firstString + secondString);
    }

    public static String reverse(String inputString) {
        String newString = "";
        for (int i = inputString.length() - 1; i >= 0; i--) {
            char currentLastCharacter = inputString.charAt(i);
            newString += currentLastCharacter;
        }

        return newString;
    }

    public static void display_options() {

        System.out
                .println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n");
        System.out.println("Select any option from given below[Type 1,2,3 etc.] : ");
        System.out.println(
                "1. Append: \n"
                        + "2. CountWords: \n"
                        + "3. Replace: \n"
                        + "4. isPalindrome: \n"
                        + "5. Splice: \n"
                        + "6. Split: \n"
                        + "7. MaxRepeatingCharacter: \n"
                        + "8. Sort: \n"
                        + "9. Shift: \n"
                        + "10. Reverse: \n"
                        + "11. New String: \n"
                        + "0. Exit From the Program");
    }
}
