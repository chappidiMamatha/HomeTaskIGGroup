import java.io.*;
import java.util.Scanner;
public class ValidateCreditCard {

	public static void main(String[] args) {
		
		boolean allInts = false;
		String cardNumber = "";
		do {
			Scanner userInput = new Scanner(System.in);

			System.out.print("Enter your credit card number: ");

			cardNumber = userInput.nextLine();

			for (int i = 0; i < cardNumber.length(); i++) {
				if(!Character.isDigit(cardNumber.charAt(i))) {
					allInts = false;
					System.out.println("Credit card number should only contain numeric values. Please re-enter.");
					break;
				}else {
					allInts = true;
				}
			}
		}while(!allInts);
		
		
		validateCreditCardNumber(cardNumber);  
	}
	
	private static void validateCreditCardNumber(String cardNumber) {
	    int[] splittedCardNumber = new int[cardNumber.length()];
	    for (int i = 0; i < cardNumber.length(); i++) {
	    	splittedCardNumber[i] = Integer.parseInt(cardNumber.substring(i, i + 1));
	    }
	    for (int i = splittedCardNumber.length - 2; i >= 0; i = i - 2) {
	        int checkDigit = splittedCardNumber[i];
	        checkDigit = checkDigit * 2;
	        if (checkDigit > 9) {
	        	checkDigit = checkDigit - 9;
	        }
	        splittedCardNumber[i] = checkDigit;
	    }
	    
	    int total = 0;
	    for (int i = 0; i < splittedCardNumber.length; i++) {
	        total += splittedCardNumber[i];
	    }
	    
	    if (total % 10 == 0) {
	        System.out.println(cardNumber + " is a valid credit card number");
	    } else {
	        System.out.println(cardNumber + " is an invalid credit card number");
	    }
	}

}
