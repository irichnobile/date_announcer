//******************************************************************************
//	DateAnnouncer.java		Author: Ian Nobile
//
//	Utilising ArrayLists and conditional expressions, this program allows the 
//	user to enter a date using digits and slashes and receive output that 
//	displays the date with the month shown as a word, the date’s ordinal 
//	position within the year and whether or not it falls within a leap year. 
//	Should the user to enter an invalid date, it badgers them until they enter 
//	a valid one.
//	
//******************************************************************************

import java.util.ArrayList;
import java.util.Scanner; 

public class DateAnnouncer
{
	public static void main(String[] args)
	{	
		Scanner scan = new Scanner(System.in);
		//	Must use both the / and \n characters as delimiters or application 
		//	hangs at iUserYear:
		scan.useDelimiter("/|\\n");
		int iUserMonth = 00;
		int iUserDay = 00;
		int iUserYear = 0000;
		int iUserOrdinal = 00;
		
		//	This is an ArrayList that links month name to month number
		ArrayList<String> ALMonths = new ArrayList<String>();
		ALMonths.add(0, "");
		ALMonths.add(1, "January");
		ALMonths.add(2, "February");
		ALMonths.add(3, "March");
		ALMonths.add(4, "April");
		ALMonths.add(5, "May");
		ALMonths.add(6, "June");
		ALMonths.add(7, "July");
		ALMonths.add(8, "August");
		ALMonths.add(9, "September");
		ALMonths.add(10, "October");
		ALMonths.add(11, "November");
		ALMonths.add(12, "December");
		
		//	This is an ArrayList that links number of days to month number
		ArrayList<Integer> ALDays = new ArrayList<Integer>();
		ALDays.add(0, 00);
		ALDays.add(1, 31);
		ALDays.add(2, 29);
		ALDays.add(3, 31);
		ALDays.add(4, 30);
		ALDays.add(5, 31);
		ALDays.add(6, 30);
		ALDays.add(7, 31);
		ALDays.add(8, 31);
		ALDays.add(9, 30);
		ALDays.add(10, 31);
		ALDays.add(11, 30);
		ALDays.add(12, 31);
		
		System.out.print("Good day. Please enter your date using digits and "
				+ "slashes: ");
		iUserMonth = scan.nextInt();
		iUserDay = scan.nextInt();
		iUserYear = scan.nextInt();
		
		//	Prevents invalid dates:
		while ((iUserMonth < 1 || iUserMonth > 12) || 
        (iUserDay < 1 || iUserDay > ALDays.get(iUserMonth)) ||
        ((iUserMonth == 02 && iUserDay == 29) && 
        ((iUserYear % 400 != 0) || (iUserYear % 100 = 0) || (iUserYear % 4 != 0))))
		{
		 	System.out.println("I'm sorry, but the date you have entered is "
		 			+ "invalid. Please enter a proper date using digits and "
		 			+ "slashes: ");
		 	iUserMonth = scan.nextInt();
			iUserDay = scan.nextInt();
			iUserYear = scan.nextInt();
		}
		
		//	Day number calculated by month/day, minus one for non-leap years:
		for(int i = 0; i<iUserMonth; i++){iUserOrdinal+=ALDays.get(i);}
		iUserOrdinal+=iUserDay;
		if(((iUserYear%4!=0)&&(iUserYear%400!=0))&&(iUserMonth>02)){iUserOrdinal-=1;}
		
		System.out.print("The date you entered was " + iUserDay + " " + 
		ALMonths.get(iUserMonth) + " " + iUserYear + ", which was day " 
				+ iUserOrdinal + " of that year. ");
		if ((iUserYear%4==0&&iUserYear%100!=0)||(iUserYear%400==0))
		{System.out.println("It was a leap year.");}
		else{System.out.print("It was not a leap year.");}
		scan.close();

	}
}

