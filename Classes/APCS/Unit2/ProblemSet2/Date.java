/**
* Class to define a date
* @author Sarah Gu
* @version 1.0
*/

public class Date {
  // Fields
  private int year;
  private int month;
  private int day;

  private static String[] strMonths = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
  private static String[] strDays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
  private static int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

  // Constructor
  public Date(int year, int month, int day) {
    this.year = year;
    this.month = month;
    this.day = day;
  }

  public int getYear() {return year;}

  public int getMonth() {return month;}

  public int getDay() {return day;}

  public Date nextDay() { // Get the next day, assuming that the current date is valid
    // Assume that the date isn't a special case, and then adjust accordingly in the if/else structure
    int nextDateMonth = month;
    int nextDateDay = day + 1;
    int nextDateYear = year;

    // Check if today is the end of the month
    if (daysInMonth[month - 1] == day) {
      nextDateDay = 1; // Reset the day to 1

      // Check if today is also the end of the month
      if (month == 12) {
        nextDateMonth = 1; // Reset the month to January
        nextDateYear ++; // Indicate that it is the new year
      }
      else {
        nextDateMonth ++; // Go to next month
      }
    }
    return new Date(nextDateYear, nextDateMonth, nextDateDay);
  }

  public String getDayOfWeek() { // Get the day of the week for a given date
    // The year is the year - 1 if the month is January or February
    int Y = year;
    if (month == 1 || month == 2)
      Y--;
    // Last two digits of the year
    int y = Y % 100;
    // Century
    int c = Y / 100;
    // Shifted month (March = 1, ..., February = 12)
    int m = month - 2;
    if (m <= 0)
      m += 12;
    // Calculate the day of the week
    int w = (day + (int)(2.6*m - 0.2) + y + y/4 + c/4 - 2*c);
    while (w < 0)
      w += 7;
    w %= 7;
    return strDays[w];
  }

  public static boolean isLeapYear(int yearInQuestion) {
    // Check if the year is divisible by 4
    if ((yearInQuestion % 4) == 0) {
      // Check that the year is not divisible by 100 or is 400 (these are the exceptions to leap years)
      if ((yearInQuestion % 100) != 0 || (yearInQuestion % 400) == 0)  {
        return true;
      }
    }
    return false;
  }

  public static boolean isValidDate(int year, int month, int day) {
    // Check that the year is within the range of 1 to 9999
    if (year >= 1 && year <= 9999) {
      //Check that the month is between January and December
      if (month >= 1 && month <= 12) {
        int lastDay = daysInMonth[month - 1]; // Find out the total number of days in am onth
        // Alter the number of days in a month accordingly if it is a leap year and the month is February
        if (isLeapYear(year) && month == 2) {
          lastDay++;
        }
        // Check if the day is within the range 1 and the last day of the month
        if (day >= 1 && day <= lastDay) {
          return true;
        }
      }
    }
    return false;
  }

  public String toString() { // Under the assumption that the month is a valid month
    return this.getDayOfWeek() + " " + day + " " + strMonths[month - 1] + " " + year; // e.g. Tuesday 27 Feb 2018
  }

} // class
