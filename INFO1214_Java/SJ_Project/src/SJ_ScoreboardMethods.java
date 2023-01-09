/**
 * Program Name: SJ_ScoreboardMethods.java
 * Purpose: This will hold some useful methods for Scoreboard class.
 * Coder: Seolan Jin 1037144
 * Date: 2021. 3. 26.
 */

public class SJ_ScoreboardMethods
{
	/**
	 * Method Name #1: isValidInt()
	 * Purpose: a public class method that will validate numeric fields for the submission file.
	 * Accepts: seven values of type int.
	 * Returns: a boolean true if every field in the submission is valid, and 
	 *          a boolean false if any field is outside the valid range.
	 * Date: Mar 28, 2021
	 */
	public static boolean isValidInt(int minVal, int teamId, int numTeams, int timeSolved, int contestDuration, int problemId, int numProblems)
	{
		// Create if statement
		if (!((teamId >= minVal)&&(teamId <= numTeams)))//If any field is outside the valid range
		{
			return false;
		}
		else if (!((timeSolved >= minVal)&&(timeSolved <= contestDuration)))
		{
			return false;
		}
		else if (!((problemId >= minVal)&&(problemId <= numProblems)))
		{
			return false;
		}
		else//If every field in the submission is valid, return true
		{
			return true;
		}
	}//end method
	
	/**
	 * Method Name #2: calArraySolvedProblems()
	 * Purpose: a public class method that will count and return the number of problems solved.
	 * Accepts: one row of the times array (an two dimensional array of type int)
	 * Returns: an array of type int that is holding the number of solved problems
	 * Date: Mar 30, 2021
	 */
	public static int[] calArraySolvedProblems(int array[][])
	{
		// Create an array for holding the number of solved problems
		int[] numSolvedArray = new int[array.length];
		
		// Declare and initialize a variable for populating numSolvedArray
		int numSolved = 0;
		
		// Create for loop to populate numSolvedArray
		 for (int i = 0; i < array.length; i++)
		 {
			 for (int j = 0; j < array[i].length; j++)
			 {
				 if (array[i][j] > 0)
				 {
					 numSolved++; // If the value in array is greater than zero, increment numSolved
				 }// end if
			 }// end inner for loop
			 
			 numSolvedArray[i] = numSolved;
			 numSolved = 0; // reset the numSolved to avoid the accumulated previous value
		 }// end outer for loop
		 
		 return numSolvedArray;
		 
	}//end method
	
	/**
	 * Method Name #3: calcArrayTotalTime()
	 * Purpose: a public class method that will 
	 * Accepts: one row of the times array, one row of the submissions array and the time penalty for incorrect submissions
	 *          (two two dimensional array, a value of type int)
	 * Returns: an array of type int that is holding the calculated total time
	 * Date: Mar 30, 2021
	 */
	public static int[] calcArrayTotalTime(int timesArray[][], int submissionsArray[][], int penaltyTime)
	{
	  // Create an array for holding the calculated total time
		int[] calcTotalTime = new int[timesArray.length];
		
		// Declare and initialize a variable for populating calcTotalTime array
		int time = 0;
		
		// Create for loop to populate the calcTotalTime array
		for (int i = 0; i < timesArray.length; i++)
		 {
			time = 0;// Reset the numSolved to avoid the cumulative previous value
			 for (int j = 0; j < timesArray[i].length; j++)
			 {
				 time += timesArray[i][j]; // Add the value of timesArray to the variable time
				 if ((timesArray[i][j] > 0)&&(submissionsArray[i][j] > 1)) // If the problem is solved, and the submission is more than one, give the penalty
				 {
					 time += (submissionsArray[i][j] - 1 ) * penaltyTime; // Add the penalty time to the variable time
				 }// end if
			 }// end inner for loop
			 calcTotalTime[i] = time;
		 }// end outer for loop
		return calcTotalTime;
		
	}//end method
	
	/**
	 * Method Name #4: isValidChar()
	 * Purpose: a public class method that will validate character data from the submissions file.
	 * Accepts: three values of type character
	 * Returns: a boolean true if the data is same as the, and 
	 *          a boolean false if any field is outside the valid range of values for that field.
	 * Date: Apr 1, 2021
	 */
	public static boolean isValidChar(char a, char b, char c)
	{
		if ((a == b)||(a == c)) // If a is same as b, or c, return true
		{
			return true;
		}
		else
		{
			return false;
		}
	}//end method
	
	/**
	 * Method Name #5: fillWithSpace()
	 * Purpose: a public class method that will fill the blank between two values with space. This method will make the output more readable.
	 * Accepts: three values of type int
	 * Returns: Nothing. This is a void method.
	 * Date: Apr 1, 2021
	 */
	public static void fillWithSpace(int a, int b, int c)
	{
		// Declare and initialize slashLength because there is a slash between two variables a and b
		int slashLength = 1;
		
		// If a plus b is smaller than c, print 'space' until 'i' is almost same as 'c'
		if (a + b + slashLength < c)
		{
			for (int i = a + b + slashLength; i < c; i++)
			{
				System.out.print(" ");
			}// end for
		}// end if
		
	}//end method
	
	/**
	 * Method Name #6: copyArray()
	 * Purpose: a public class method that will copy an array.
	 * Accepts: an array of type String
	 * Returns: an array of type String holding the copy of the original array
	 * Date: Apr 3, 2021
	 */
	public static String[] copyArray(String array[])
	{
		//Create an array to copy the original array
		String[] copiedArray = new String[array.length];
		
		//Populate the copied array
		for(int i = 0; i < array.length; i++)
		{
			copiedArray[i] = array[i];
		}// end for loop
		
		return copiedArray;	
	}// end method

	
	/**
	 * Method Name #7: copyArray() OVERLOADED FOR TYPE int
	 * Purpose: a public class method that will copy an array.
	 * Accepts: an array of type int
	 * Returns: an array of type int holding the copy of the original array
	 * Date: Apr 3, 2021
	 */
	public static int[] copyArray(int array[])
	{
	  //Create an array to copy the original array
		int[] copiedArray = new int[array.length];
		
	  //Populate the copied array
		for(int i = 0; i < array.length; i++)
		{
			copiedArray[i] = array[i];
		}// end for loop
		
		return copiedArray;
	}// end method
	
	/**
	 * Method Name #8: copyTwoDArray() 
	 * Purpose: a public class method that will copy an two-dimensional array.
	 * Accepts: an two-dimensional array of type int
	 * Returns: an two-dimensional array of type int holding the copy of the original two-dimensional array
	 * Date: Apr 3, 2021
	 */
	public static int[][] copyTwoDArray(int array[][])
	{
		//Create an two-dimensional array to copy the original array
		int[][] copiedArray = new int[array.length][array[0].length];
		
	  //Populate the copied array
		for(int i = 0; i < array.length; i++)
		{
			for(int j = 0; j < array[i].length; j++)
			{
				copiedArray[i][j] = array[i][j];
			}//end inner for loop
		}// end outer for loop
		
		return copiedArray;
	}// end method
	
	/**
	 * Method Name #9: swapArray()
	 * Purpose: a public class method that will swap two values of an array, using an empty glass
	 * Accepts: an array of type int, two index numbers which will be swapped
	 * Returns: Nothing. This is a void method.
	 * Date: Apr 3, 2021
	 */
	public static void swapArray(int[] array, int index1, int index2)
	{
		//Declare an variable
		int emptyGlass;
		//First pour
		emptyGlass = array[index1];
		//Second pour
		array[index1] = array[index2];
		//Third pour
		array[index2] = emptyGlass;
	}//end method
	
	/**
	 * Method Name #10: swapTwoDIntArrayRow()
	 * Purpose: a public class method that will swap two rows of an two-dimensional array, using an empty array. However, this method will not change the columns of the rows.
	 * Accepts: an two-dimensional array, two index numbers which will be swapped.
	 * Returns: Nothing. This is a void method.
	 * Date: Apr 3, 2021
	 */
	public static void swapTwoDIntArrayRow(int[][] array, int index1, int index2)
	{
		//Create an array of type int, the length of the array is same as the column length of accepted array
		int[] emptyArray = new int[array[0].length];
		
		//First pour
		for (int i = 0; i < emptyArray.length; i++)
		{
			emptyArray[i] = array[index1][i];
		}// end for
		
		//Second pour
		for (int i = 0; i < emptyArray.length; i++)
		{
			array[index1][i] = array[index2][i];
		}// end for
		
		//Third pour
		for (int i = 0; i < emptyArray.length; i++)
		{
			array[index2][i] = emptyArray[i];
		}// end for
	}//end method
	
	/**
	 * Method Name #11: swapArray() OVERLOADED FOR TYPE String
	 * Purpose: a public class method that will swap two values of an array, using an empty glass.
	 * Accepts: an array of type String, two index numbers which will be swapped.
	 * Returns: Nothing. This is a void method.
	 * Date: Apr 3, 2021
	 */
	public static void swapArray(String[] array, int index1, int index2)
	{
		//Declare an variable
		String emptyGlass;
		//First pour
		emptyGlass = array[index1];
		//Second pour
		array[index1] = array[index2];
		//Third pour
		array[index2] = emptyGlass;
	}//end method
	
}//end class
