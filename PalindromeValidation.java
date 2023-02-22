
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PalindromeValidation {

    public static void main(String[] args) throws IOException
    {
    	long maxValue=4294967295L;
    	Scanner systemInput = new Scanner(System.in);
    	ArrayList<String> userInput = new ArrayList<String>();
    	System.out.println("Enter multiple numbers :");
    	while (systemInput.hasNextLine()) {
    		String enteredString = systemInput.nextLine();
    	    if (enteredString.isEmpty()) {
    	        break;
    	    }
    	    userInput.add(enteredString);
    	}
    	systemInput.close();
    	
    	for(int i=0;i<userInput.size();i++) {
    	
    		long inputData = (Long.parseLong(userInput.get(i)));
    		if(inputData < maxValue) {
    			validatePalindrome(inputData);
    		}
    		else {
    			System.out.println("Input value is greater than "+ maxValue);
    		}
    	}
       
    }
    

	public static void validatePalindrome(long givenNumber) {
    	long tempNumber = givenNumber;
    	int iterations = 0;
    	boolean isPalindrome = false;
    	
    	while(!isPalindrome) {
    		
    		if(reverseOfDigit(tempNumber) == tempNumber) {
    			System.out.println(givenNumber  + ": Iterations: "+ iterations +" palindrome is "+ tempNumber);
    			isPalindrome = true;
    		}else {
    			iterations = iterations + 1;
    			tempNumber = tempNumber + reverseOfDigit(tempNumber);
    		}
    	}
    }
    
    public static long reverseOfDigit(long givenNumber)
    {
        long reverseNumber = 0;
        while (givenNumber > 0) {
        	reverseNumber = reverseNumber * 10 + givenNumber % 10;
        	givenNumber = givenNumber / 10;
        }
        return reverseNumber;
    }
}
