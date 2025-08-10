/**
* Class to define a savings account
* @author Sarah Gu
* @version 1.0
*/

public class SavingsAccount {
  // Fields
  private static double annualInterestRate = 0.01;
  private double balance;

  // Constructors
  public SavingsAccount() { // Default no-args constructor
    balance = 0;
  }

  public SavingsAccount(double amount) { // Args constructor
    balance = amount;
  }

  // Methods
  public double getBalance() {return balance;} // Accessor method

  public void addAmount(double amount) {balance += amount;} // Modifier method (kind of)

  public static double getAnnualInterestRate() {return annualInterestRate;} // Accessor method

  public static void setInterestRate(double rate) {annualInterestRate = rate;} // Modifier method

  public double calculateMonthlyInterest() {
    // Get the monthly interest
    double monthyInterest = (balance * annualInterestRate) / 12;
    // Add the monthly interest to the balance
    balance += monthyInterest;
    // Return only the monthy interesst
    return monthyInterest;
  }
}
