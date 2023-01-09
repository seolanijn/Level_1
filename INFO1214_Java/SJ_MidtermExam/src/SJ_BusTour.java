/**
 * Program Name: SJ_BusTour.java
 * Purpose: This program will calculate the number of coaches that will be operated,
            the number of available seats, and the number of passengers for a CPA Tours 
            excursion.
 * Coder: Seolan Jin 1037144
 * Date: Feb. 18, 2021
 */
import java.util.Scanner;
public class SJ_BusTour
{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		// 1. Display a title and explanation of the program.
		System.out.println("Welcome to Seolan's Bus Tour Calculator");
		System.out.println("This program will calculate the number of coaches "
				                + "that will be operated, \nthe number of available seats, and "
			                 	+ "the number of passengers for a CPA Tours \nexcursion.");
		System.out.println("--------------------------------------------------------------------------------"
				                + "\n------");
		
		// 2. Prompt the user to input the total number of potential passengers 
		//    from the waiting list.
		System.out.print("\nEnter the number of people on the waiting list: ");
		int numPeople = input.nextInt();
		
		// 3. Prompt the user to input the number of seats on each coach.
		System.out.print("Enter the seats on a coach: ");
		int numSeat = input.nextInt();

		// 4. Prompt the user to input the number of drivers available.
		System.out.print("Enter the number of available drivers: ");
		int numDriver = input.nextInt();
		
		// 5. Prompt the user to input the full name of 
		//    the company tour guide who will accompany the tour group.
		System.out.print("Enter the name of the company tour guide for this tour: ");
		input.nextLine();
		String companyName = input.nextLine();
		
		// 6. Calculate the number of coaches required to transport ALL passengers 
		//    on the waiting list 
		double numCoach = (double) numPeople / (double) numSeat;
		
		// 7. round the number from step 1 DOWN if the decimal part of the number of coaches 
		//    required is LESS THAN 0.5.
		final double ROUNDING_FACTOR = 0.5;

		numCoach += ROUNDING_FACTOR;
		int numCoachRounded = (int) numCoach;
		
		// 7-1. If the number of coaches is greater than the number of drivers, 
		//      reduce the number of coaches to the same value as the number of drivers. 
		if (numCoachRounded > numDriver)
		{
			numCoachRounded = numDriver;
		}
		
		// 8. First calculate the total number of seats available based on the number 
		//    of coaches being operated and the number of seats on each coach.
		int totalSeats = numCoachRounded * numSeat;
		
		// 9-1. If the number of passengers on the waiting list is greater than the 
		//      total number of seats then the number of passengers will be limited
		//      to the total number of seats.
		if (numPeople > totalSeats)
		{
			numPeople = totalSeats;
		}
		
		// 10. Output
		System.out.println("\nThis tour will require " + numCoachRounded + " coaches with " + numSeat + " seats each.");
		System.out.println("There is a total of " + totalSeats + " seats available.");
		System.out.println("There will be a total of " + numPeople + " passengers on the tour led by " + companyName + ".");
		
		input.close();
		
		
		
		
	

	}
	//end main
}
//end class