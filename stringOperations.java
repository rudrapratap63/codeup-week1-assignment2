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

public class stringOperations {
    static Scanner input = new Scanner(System.in);
    static String originalString ;        
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
            System.out.println("Enter the string to append:");
            System.out.println("Result: " + append());
            break;
        case "2":
            countWords();
            break;
        case "3":
            System.out.println("Enter the string to replace:");
            replace();
            break;
        case "4":
            System.out.println("Enter the string to check palindrome:");
            isPalindrome();
            break;
        case "5":
            System.out.println("Enter the start index:");
            splice();
            break;
        case "6":
            System.out.println("Enter the pattern to split on:");
            split();
            break;
        case "7":
            maxRepeated(originalString);
            break;
        case "8":
            sort();
            break;
        case "9":
            System.out.println("Enter number of characters to shift:");
            shift();
            break;
        case "10":
            reverse(originalString);
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


        // System.out.println(append());
        // countWords(originalString);

        // replace(originString);
        // System.out.println("Reverse String : "+);

        // isPalindrome();
        // splice();
        // shift();

        // split();
        // sortString();
        // maxRepeatedChar(originalString);

        // reverse(originalString);
    

    public static String append() {
        System.out.println("Enter a new String : ");
        String appendStr = input.nextLine();
        return originalString+appendStr;
    }
    
    public static void countWords(){
        int count = 0;
        boolean isWord = false;

        for (int i = 0; i < originalString.length(); i++) {
            char currentChar = originalString.charAt(i);
            if (currentChar != ' ') {
                isWord = true;
            }else if(isWord){
                count++;
                isWord = false;
            }
        }
        if (isWord) {
            count++;
        }
        System.out.println("Total number of words : "+count);
    }

    public static void replace(){
        System.out.println("enter replacing string ");
        String a = input.nextLine();
        
        System.out.println("enter new words for replacing ");
        String b = input.nextLine();

        String newString = "";
        
        for (int i = 0; i < originalString.length(); i++) {
            char currentChar = originalString.charAt(i);

            if (originalString.substring(i).startsWith(a)) {
                newString += b;
                i = i + a.length() -1;
            }else{
                newString = newString + currentChar;
            }
        }
        System.out.println(newString);

    }
    
    public static void isPalindrome(){
        String newString = "";
        for (int i = originalString.length()-1; i >=0 ; i--) {
            char currentLastChar = originalString.charAt(i);
            newString += currentLastChar;
        }
        if (newString == originalString) {
            System.out.println("The given String is Palindrome");
            return;
        }

        System.out.println("The given String is not Palindrome : "+newString);
    }

    public static void splice(){
        System.out.println("enter starting Index ");
        int startIndex = input.nextInt();
        
        System.out.println("enter length from starting Index ");
        int length = input.nextInt();

        String newString = "";
        for (int i = 0; i <originalString.length() ; i++) {
            char currentChar = originalString.charAt(i);
            if (!(i>=startIndex && i<=startIndex+length-1)) {
                newString += currentChar;
            }
        }
        System.out.println("Spliced String : "+newString);
    }
    
    public static void split() {
        System.out.println("Enter a pattern for splitting into Array: ");
        String pattern = input.nextLine();
        String[] words = new String[originalString.length() + 1];
        int indexCount = 0;
        
        for (int i = 0; i < originalString.length(); i++) {
            if (originalString.startsWith(pattern, i)) {
                words[indexCount++] = originalString.substring(0, i);
                originalString = originalString.substring(i + pattern.length());
                i = -1;
            }
        }
        
        words[indexCount] = originalString;


        String[] withoutNullWords = new String[indexCount+1];
        for (int i = 0; i < indexCount+1; i++) {
            withoutNullWords[i] = words[i];
        }
        System.out.println(java.util.Arrays.toString(withoutNullWords));
    }

    public static void sort() {
        String lowerString =  originalString.toLowerCase();
        if (!lowerString.matches("[a-z]+")) {
            System.out.println("Error: Input string must only contain Alphabatic characters.");
            input.close();
            return;
        }
        char[] charArray = lowerString.toCharArray();
        int length = charArray.length;

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (charArray[i] > charArray[j]) {
                    
                    char temp = charArray[i];
                    charArray[i] = charArray[j];
                    charArray[j] = temp;
                }
            }
        }
        String sortedString = new String(charArray);
        System.out.println(sortedString);

    }

    public static void maxRepeated(String str) {
        char maxCharacter = str.charAt(0);
        int maxFreq = 0;
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            int currentFreq = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == currentChar) {
                    currentFreq++;
                }
            }
            if (currentFreq > maxFreq) {
                maxCharacter = currentChar;
                maxFreq = currentFreq;
            }
        }
        char[] result = {maxCharacter, (char) (maxFreq+'0')};
        System.out.println(result);
    }

    public static void shift(){
        System.out.println("Enter moving Character : ");
        int n  = input.nextInt();
        String firstString = "";
        String secondString = "";

        int stringlength = originalString.length();
        for (int i = originalString.length()-1; i >=0 ; i--) {
            if (i>=stringlength-n) {
                firstString += originalString.charAt(i);
            }else{
                secondString += originalString.charAt(i);
            }
        }
        firstString = reverse(firstString);
        secondString = reverse(secondString);
        System.out.println(firstString+secondString);
    }

    public static String reverse(String inputString){
        String newString = "";
        for (int i = inputString.length()-1; i >=0 ; i--) {
            char currentLastChar = inputString.charAt(i);
            newString += currentLastChar;
        }
        
        return newString;
    }
    

    public static void display_options() {

		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n");
		// System.out.println(ENTER_OPTION);
		System.out.println("1. Append: \n"
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