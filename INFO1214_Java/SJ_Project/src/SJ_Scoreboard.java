/**
 * Program Name: SJ_Scoreboard.java
 * Purpose: This program will make a ENCA contest score board which shows the number of solved problems, the total time, the number of submissions, and 
 *          the success or failure of the problem from 24 teams, 11 problems. Also, this program will produce how many submissions are valid or invalid.
 * Coder: Seolan Jin 1037144
 * Date: 2021. 3. 26.
 * 
 * PSEUDO-CODE
 * 1. Create two file objects
 * 2. Print the title of the contest
 * 3. Get the number of teams, the number of problems, and the contest duration 
 *    to set the element of array and validate the file data
 * 4. Validate the data, and create timesArray and submissionsArray at once
 * 5. Create teamsArray
 * 6. Calculate the number of solved problems and the total time
 * 7. Print the output
 */
import java.util.Scanner;
import java.io.*;

public class SJ_Scoreboard
{

	public static void main(String[] args) throws FileNotFoundException
	{
		// 1. Create two file objects
		File submissionsFile = new File("submissions.txt");
		Scanner fileReader1 = new Scanner(submissionsFile);

		File teamsFile = new File("teams.txt");
		Scanner fileReader2 = new Scanner(teamsFile);
		
		// 2. Print the title of the contest
		String title = fileReader1.nextLine();
	  System.out.println(title + "\n");
		
	  // Get the number of teams, the number of problems, and the contest duration to set the element of array and validate the file data
		int numTeams = fileReader1.nextInt();
		int numProblems = fileReader1.nextInt();
		int contestDuration = fileReader1.nextInt();
		int penaltyTime = fileReader1.nextInt();
		
		
		//4. Validate the data, and create timesArray and submissionsArray at once
		
		// Create two two-dimensional arrays
		int[][] timesArray = new int[numTeams][numProblems]; 
		int[][] submissionsArray = new int[numTeams][numProblems];
		
		// Declare four variables to populate the arrays
		int teamId1; // teamId1 for the submissions file
		int timeSolved;
		int problemId;
		char resultProblem;
		
		// Declare and initialize two variables for get the number of valid data and invalid data
		final int MINIMUM_VALUE = 1;
		int numValid = 0;
		int numInvalid = 0;
		
		// Create while loop for populating the array and counting the valid data
		while (fileReader1.hasNext())
		{
			  // Get IDs and the result of the problem from the submissions file
				teamId1 = fileReader1.nextInt(); 
				
				timeSolved = fileReader1.nextInt();
				
				problemId = fileReader1.nextInt();
				
				resultProblem = fileReader1.next().charAt(0);
				resultProblem = Character.toUpperCase(resultProblem);
				
				// Create if-else-if statement to validate the values
				if (!(SJ_ScoreboardMethods.isValidInt(MINIMUM_VALUE, teamId1, numTeams, timeSolved, contestDuration, problemId, numProblems)))
				{
					numInvalid++; // If the data is invalid, numInValid is incremented.
				}
				else if (!(SJ_ScoreboardMethods.isValidChar(resultProblem, 'N', 'Y')))
				{
					numInvalid++;
				}
				else
				{
					// Subtract 1 because IDs start at 1 while the row and column indexes start at 0. 
					teamId1 -= 1;
					problemId -= 1;
					if (resultProblem == 'Y')// If the data is solved, populate timesArray. If not, populate submissionsArray only.
					{
						timesArray[teamId1][problemId] = timeSolved;
					}
					
					submissionsArray[teamId1][problemId] += 1;
					
					numValid++; // Increment numValid
				}
				
		}//end while loop
	
		
		
		//5. Create teamsArray
		
	  // Declare four variables to populate the arrays
		int teamId2 = 0; // teamId2 for the teams file
		String teamName;
		String trimmedTeamName;
		
	  // Create array
		String[] teamsArray = new String[numTeams];
	
		// Create while loop to populate teamsArray
		while (fileReader2.hasNext())
		{
			teamId2 = fileReader2.nextInt();
			teamId2 -= 1; // Subtract 1 because IDs start at 1 while the row and column indexes start at 0. 
			teamName = fileReader2.nextLine();
			trimmedTeamName = teamName.trim(); // Trim teamName. Otherwise the huge space before the team name is also printed when the team name is printed.
			teamsArray[teamId2] = trimmedTeamName; // populate teamsArray
		}// end while loop
		
		//Close the scanner objects
		fileReader1.close();
		fileReader2.close();
		
		
		
		//6. Calculate the number of solved problems and the total time
		
		// Create arrays to hold calculated the number of solved problems and the total time
		int[] numSolved = SJ_ScoreboardMethods.calArraySolvedProblems(timesArray);
		int[] totalTime = SJ_ScoreboardMethods.calcArrayTotalTime(timesArray, submissionsArray, penaltyTime);
		
		
		
		
		//7. Print the output
		
		// Print the score board title and a row of column labels.
		System.out.print("Team\t\t   Slv/Time");
		for (int i = 1; i <= numProblems; i++)
		{
			System.out.print("\tP" + i);
		}// end for loop
		
		System.out.println("\n");

		// Declare some variables to make the int value as string value for use the length() method
		String numSolvedString;
		String totalTimeString;
		String numSubmissionsString;
		
		// Declare and initialize some variables to use fillWithSpace() method
		int totalLength1 = 27;
		int totalLength2 = 4;
		
		// Create for loop to print output
		for (int i = 0; i < submissionsArray.length; i++)
		{
			// int values will be changed to string value
			numSolvedString = Integer.toString(numSolved[i]);
			totalTimeString = Integer.toString(totalTime[i]);
			
			
			System.out.print(teamsArray[i]); // Print team's name first
			SJ_ScoreboardMethods.fillWithSpace(teamsArray[i].length(), numSolvedString.length() + totalTimeString.length(), totalLength1); // For making the output more readable,
			                                                                                                                               // use fillWithSpace() method
			System.out.print(numSolvedString + "/" + totalTimeString + "   "); // After using the method, print out the rest of the values
			
			for (int j = 0; j < submissionsArray[i].length; j++)
			{
			  // int values will be changed to string value
				numSubmissionsString = Integer.toString(submissionsArray[i][j]);
				// Use fillWithSpace() method again
				SJ_ScoreboardMethods.fillWithSpace(0, numSubmissionsString.length(), totalLength2);
				  
					if (timesArray[i][j] > 0)// If the value of the timesArray is greater than zero, print out 'Y'
					{
						System.out.print("Y/" + submissionsArray[i][j] + "   ");
					}
					else// If the value of the timesArray is zero, print out 'N'
					{
						System.out.print("N/" + submissionsArray[i][j] + "   ");
					}
			}// end inner for loop
			System.out.println();
		}// end outer for loop
		
		// Print the number of valid submissions and the number of invalid submissions
		System.out.println("\n" + numValid + " valid submission(s) were processed.");
		System.out.println(numInvalid + " submission(s) were invalid and ignored.");
		
		
		

	}//end main
}//end class