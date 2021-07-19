import java.util.Scanner;

public class StudentFees2
{
	public static void main(String[] args)
	{
		//Step 1
		//=======
		//Declare and initialize the following two parallel arrays
		String[] studNumbers = {"22558877", "33441155", "88771144", 
								"11774455", "22558899", "99447766", 
								"22113366", "66554411", "11993344", 
								"44112233", "44779955", "33771199"};
		double[] outstandingFees = {125.36, 4447.99, 1005.25,
									11336.55, 500.87, 3874.25,
									805.25, 987.66, 1796.54,
									15998.25, 4789.10, 258.36};
		
		//Step 2
		//=========
		//Invoke/call the details() method and display the details of all the students 
		//with their outstanding amounts.
		String toDisplay = details(studNumbers, outstandingFees);
		System.out.println("Student Number	Amount" + "\n=========================");
		System.out.println(toDisplay);
		
		
		//Step 3
		//========
		//Invoke/call the highestFee() method and display the details of the student 
		//with the highest outstanding amount.
		String highest = highestFee(studNumbers, outstandingFees);
		System.out.println("\nThe student with the highest outstanding fee is " + highest);
		
		
		//Step 4
		//========
		//Invoke/call the totalFees() method and display the total outstanding amount.
		double theTotal = totalFees(outstandingFees);
		System.out.println("The total outstanding fees = R" + theTotal);
		
		//Steps 5, 6, and 7 (To update an account)
		Scanner scan = new Scanner(System.in);
		
		System.out.print("\nEnter the student number: ");
		String theNumber = scan.nextLine();
		
		System.out.print("\nEnter the amount you whish to pay :R");
		double theAmount = Double.parseDouble(scan.nextLine());
		
		double updatedFee = updateAccount(studNumbers, outstandingFees, theNumber, theAmount);
		System.out.println("The account balance of student " + theNumber + " after the payment = R" + updatedFee);
		
		//THE END
	}
	
	/*
	The method will receive the two parallel arrays as parameter.
	It will create and return a concatenated String with the student numbers as the outstanding fees. 
	A single line must contain only one students details.
	+ details(String[], double[]): String
	*/
	public static String details(String[] pStudNumbers, double[] pFees)
	{
		String theDetails = "";
		
		for(int x = 0; x < pStudNumbers.length; x++)
		{
			theDetails += "\n" + pStudNumbers[x] + "\tR" + pFees[x];
		}
		
		return theDetails;
	}
	
	/*
	The method will receive the two parallel arrays as parameters.
	It will then determine the student with the highest outstanding fee 
	and return a String containing the student number and its outstanding amount.
	Example: 11223344 (R100000.50)
	where "11223344" is the student number and R100000.50 is the outstanding amount of this student.
	+ highestFee(String[], double[]): String
	*/
	public static String highestFee(String[] pStudNumbers, double[] pFees)
	{
		String highestDetails = "";
		
		double tempFee = 0.0;
		String tempStudNum = "";
		
		for(int x = 0; x < pFees.length - 1; x++)
		{
			for(int y = 0; y < pFees.length - 1; y++)
			{
				if(pFees[y] < pFees[y + 1])
				{
					//swop the fees amount
					tempFee = pFees[y];
					pFees[y] = pFees[y + 1];
					pFees[y + 1] = tempFee;
					
					//swop the student numbers
					tempStudNum = pStudNumbers[y];
					pStudNumbers[y] = pStudNumbers[y + 1];
					pStudNumbers[y + 1] = tempStudNum;
				}
			}
		}
		
		highestDetails = pStudNumbers[0] + "(R" + pFees[0] + ")";
		
		return highestDetails;
	}
	
	/*
	The method will receive the two parallel arrays as parameters, as well as the student number 
	and the amount the student wants to pay of the outstanding fees.
	The method must update the outstanding amount of the student and return the updated 
	outstanding amount, if any.
	Take note that the student account cannot go into the negatives.
	+ updateAccount(String[], double[], String, double): double
	*/
	public static double updateAccount(String[] pStudNumbers, double[] pFees, String pStudNum, double pPayment)
	{
		double newFee = 0.0;
		
		for(int x = 0; x < pStudNumbers.length; x++)
		{
			if(pStudNum.equals(pStudNumbers[x]))
			{
				//this is the correct student, now update the fee of the account
				//to update correctly, you cannot pay more than what you own
				if(pPayment <= pFees[x])
				{
					newFee = pFees[x] - pPayment;
					pFees[x] = newFee;
				}
				else
				{
					pFees[x] = 0.0;
				}
				
				break;
			}
		}
		
		return newFee;
	}
	
	/*
	The method will calculate and return the total outstanding fees of all the students.
	+ totalFees(double[]): double
	*/
	public static double totalFees(double[] pFees)
	{
		double total = 0.0;
		
		for(int x = 0; x < pFees.length; x++)
		{
			total += pFees[x];
		}
		
		return total;
	}
}