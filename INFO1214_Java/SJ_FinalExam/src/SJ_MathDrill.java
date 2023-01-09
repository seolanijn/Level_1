import java.util.Scanner;

/**
 * Program Name: SJ_MathDrill.java
 * Purpose: This program will ask the user to answer a series of random multiplication questions.
 *          Also, This program will display the number of questions answered correctly and incorrectly.
 * Coder: Seolan Jin 1037144
 * Date: 2021. 4. 22.
 * 
 * Pseudo-Code
 * 1. Display a title and a short explanation of the program.
 * 2. Ask the user to enter the total number of questions to be asked and answered. 
 * 3. Create a boolean array of the same size as the number of questions.
 * 4. Write a class method called displayQuestion() to display the questions.
 * 5. Write another class method called countInArray() to count 
 *    the number of correct or incorrect answers.
 * 6. Write another class method called printFeedback() to print the result.
 * 7. Inside the main() loop generate two random integers in the range 0 to 15 (inclusive) 
 *    to use as the numbers for the multiplication question.
 * 8. use displayQuestion() method
 * 9. get the user's answer
 * 10. populate the array
 * 11. use countInArray() method
 * 12. user printFeedback() method
 * 13. housekeeping
 */

public class SJ_MathDrill
{
	//4. Write a class method called displayQuestion() to display the questions.
	/**
	 * Method Name: displayQuestion()
	 * Purpose: a public class method that will display the formatted question
	 * Accepts: three values of type int
	 * Returns: nothing. 
	 * Date: April 22, 2021
	 */
	public static void displayQuestion(int questionNum, int val1, int val2)
	{
		//print the question
		System.out.println("\nQuestion #" + questionNum + ": " + val1 + " x " + val2 + " = ?");
	}// end method
	
	//5. Write another class method called countInArray() to count 
	//   the number of correct or incorrect answers.
	/**
	 * Method Name: countInArray()
	 * Purpose: a public class method that will count and return the number of times 
	 *          the passed in boolean value appears in the array.
	 * Accepts: one array of type boolean and one value of type boolean
	 * Returns: a value of type int that is the number of matched value
	 * Date: April 22, 2021
	 */
	public static int countInArray(boolean[] array, boolean val)
	{
		int numMatching = 0;
		
		for (int i = 0; i < array.length; i++)
		{
			if (array[i] == val)
			{
				numMatching++;// if the value is same as 'val', increment 'numMatching'
			}// end if
		}// end for
		return numMatching;
	}// end method
	
	//6. Write another class method called printFeedback() to print the result.
	/**
	 * Method Name: printFeedback()
	 * Purpose: a public class method that will generate a single line of output. 
	 *          If the boolean argument is true, it will print the numbers of the correct answers.
	 *          If the boolean argument is false, it will print the numbers of the incorrect answers.
	 * Accepts: one array of type boolean, one value of type boolean, one value of type int
	 * Returns: nothing.
	 * Date:  April 22, 2021
	 */
	public static void printFeedback(boolean[] array, boolean val, int numCorrectOrIncorrect)
	{
		// declare to choose a string between "right" and "wrong"
		String rightOrWrong;
		
		if (val) 
		{
			rightOrWrong = "right";// if 'val' is true, initialize it "right"
		}
		else
		{
			rightOrWrong = "wrong";// if 'val' is false, initialize it "wrong"
		}
		
		System.out.print("You got the following " + numCorrectOrIncorrect + 
				               " question(s) " + rightOrWrong + ":");
		
		for (int i = 0; i < array.length; i++)
		{
			if (array[i] == val)
			{
				System.out.print(" #" + (i+1)); // if there is an element which is same as 'val', print it out.
			}// end if
		}// end for
		
		
	}// end method

	public static void main(String[] args)
	{
		// create Scanner object
		Scanner input = new Scanner(System.in);
		
		//1. Display a title and a short explanation of the program.
		System.out.println("Math Drill\n\nThis program will test your" +
				               " multiplication skills by asking you a series of questions.");
		
		//2. Ask the user to enter the total number of questions to be asked and answered. 
		System.out.print("How many multiplication questions do you want? ");
		
		// create some useful variables
		int numQuestion;
		boolean isValidNumQuestion = false;
		
		// create constant variable to avoid magic number
		final int MIN_NUM_QUESTION = 3;
		final int MAX_NUM_QUESTION = 10;
		
		// data validation
		do
		{
			numQuestion = input.nextInt();
			if (numQuestion >= MIN_NUM_QUESTION && numQuestion <= MAX_NUM_QUESTION)
			{
				isValidNumQuestion = true; // if the user entered valid input, it is true
			}
			else
			{
				System.out.print("\nThe number of questions should be from 3 to 10\nPlease re-enter: ");
			}
		}while (!isValidNumQuestion);
		
		//3. Create a boolean array of the same size as the number of questions.
		boolean[] resultQuestionArray = new boolean[numQuestion];
		
	  // create constant variable to avoid magic number
		final int HIGHEST_VALUE = 15;
		
	  // create some useful variables
		int num1;
		int num2;
		int userAnswer;
		int correctAnswer;
		
    //7. Inside the main() loop generate two random integers in the range 0 to 15
		for (int i = 0; i < resultQuestionArray.length; i++)
		{
			num1 = (int)(Math.random() * (HIGHEST_VALUE + 1));// generate random value
			num2 = (int)(Math.random() * (HIGHEST_VALUE + 1));
			
			//8. use displayQuestion() method
			displayQuestion(i+1, num1, num2);
			
			//9. get the user's answer
			System.out.print("Answer: ");
			userAnswer = input.nextInt();
			
			// calculate the correct answer to know if the user's input if correct
			correctAnswer = num1 * num2;
			
			// 10. populate the array
			if (userAnswer == correctAnswer)
			{
				resultQuestionArray[i] = true;
			}
			else
			{
				resultQuestionArray[i] = false;
			}
		}// end for
		
		// 11. use countInArray() method
		int numCorrect = countInArray(resultQuestionArray, true);
		int numIncorrect = countInArray(resultQuestionArray, false);

		// 12. user printFeedback() method
		System.out.println();
		printFeedback(resultQuestionArray, true, numCorrect);
		System.out.println();
		printFeedback(resultQuestionArray, false, numIncorrect);
		
		//13. housekeeping
		input.close();

	}
	//end main
}
//end class