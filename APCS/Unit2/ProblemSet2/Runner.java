/**
* Class to run all of the class files from Problem Set 2
* @author Sarah Gu
* @version 1.0
*/

import java.util.ArrayList;

public class Runner {
  /**
  * Main method in the class
  * @param args The command line arguments
  */
  public static void main(String[] args) {
    // 1. Complex
    Complex x = new Complex(1, 2);
    Complex y = new Complex();
    Complex z = new Complex(-0.001, 0);
    Complex x1 = new Complex(-1, -5);
    Complex y1 = new Complex(1.5, -2.99);
    Complex z1 = new Complex(-1.3, 2.66);

    Complex[] complexArr = {x, y, z, x1, y1, z1};

    for (int i = 0; i < complexArr.length; i++) {
      Complex complexNum = complexArr[i];
      System.out.println(complexNum);
      System.out.println(complexNum.modulus());
      System.out.println(complexNum.angle());
      System.out.println();
    }

    // 2. Qubit
    Qubit qDefault = new Qubit();
    Qubit q1 = new Qubit(new Complex(0.8, 0), new Complex(0, 0.6));
    Qubit q2 = new Qubit(z, x1);
    Qubit q3 = new Qubit(x1, y1);
    Qubit q4 = new Qubit(new Complex(), new Complex(0, 0));

    Qubit[] qubitArr = {qDefault, q1, q2, q3, q4};

    for (int i = 0; i < qubitArr.length; i++) {
      System.out.println(qubitArr[i]);
      for (int j = 0; j < 10; j++) { // Measure each Qubit 10 times
        System.out.println(qubitArr[i].measure());
      }
    }
    System.out.println();

    // 3. Date
    Date date = new Date(2006, 6, 6);
    Date date1 = new Date(9999, 12, 31);
    Date date2 = new Date(1, 12, 31);
    Date date3 = new Date(0, 12, 31); // Invalid date
    Date date4 = new Date(1000, 2, 29); // Invalid date
    Date date5 = new Date(100, 0, 32); // Invalid date
    Date date6 = new Date(-5000, 12, 31); // Invalid date
    Date date7 = new Date(400, 13, 32); // Invalid date, leap year
    Date date8 = new Date(-400, 6, 30); // Invalid date
    Date date9 = new Date(2020, 12, 32); // Invalid date, leap year
    Date date10 = new Date(8, 12, 0); // Invalid date, leap year
    Date date11 = new Date(2000, 2, 29); // Leap year
    Date date12 = new Date(10000, 2, 29); // Leap year

    Date[] dateArr = {date, date1, date2, date3, date4, date5, date6, date7, date8, date9, date10, date11, date12};

    for (int i = 0; i < dateArr.length; i++) {
      System.out.println(dateArr[i].getDayOfWeek() + " " + dateArr[i].getMonth() + " " + dateArr[i].getDay() + " " + dateArr[i].getYear());
      if (Date.isValidDate(dateArr[i].getYear(), dateArr[i].getMonth(), dateArr[i].getDay())) {
        System.out.println(dateArr[i]);
        System.out.println(dateArr[i].nextDay());
      }
      System.out.println();
    }

    // Put in separate for loops so that the boolean variables are easier to look at
    for (int i = 0; i < dateArr.length; i++) {
      System.out.println(Date.isLeapYear(dateArr[i].getYear()));
    }
    System.out.println();

    // 4. Poem
    Haiku haiku = new Haiku();
    System.out.println(haiku.printRhythm());
    Poem limerick = new Limerick();
    System.out.println(limerick.printRhythm());

    // 5. SavingsAccount
    SavingsAccount s = new SavingsAccount();
    SavingsAccount s1 = new SavingsAccount(500);
    SavingsAccount s2 = new SavingsAccount(-10);
    SavingsAccount[] savingsArr = {s, s1, s2};

    System.out.println(SavingsAccount.getAnnualInterestRate());
    SavingsAccount.setInterestRate(0.05);
    System.out.println(SavingsAccount.getAnnualInterestRate());

    for (int i = 0; i < savingsArr.length; i++) {
      System.out.println(savingsArr[i].getBalance());
      savingsArr[i].addAmount(10);
      System.out.println(savingsArr[i].getBalance());
      System.out.println(savingsArr[i].calculateMonthlyInterest());
      System.out.println(savingsArr[i].getBalance());
      System.out.println();

    }

    // 6. Transport classes
    System.out.println("6. Safety Classes");
    ArrayList<Transport> transportOperations = new ArrayList<Transport>();
    // 25 tickets sold, $5 per ticket, and has a fire extinguisher on board
    transportOperations.add(new Bus(25, 5, true));
    // 200 tickets sold, $25 per ticket, and has no fire extinguisher
    transportOperations.add(new Train(200, 25, false));
    // 100 tickets sold, $375 per ticket, and has a fire extinguisher on board,
    // 150 lifejackets, 30 lifeboats which can carry 5 people per lifeboat
    transportOperations.add(new Plane(100, 375, true, 150, 30, 5));
    // 105 tickets sold, $370 per ticket, and has no fire extinguisher on board,
    // 50 lifejackets, 1 lifeboat which can carry 5 people per lifeboat
    transportOperations.add(new Plane(105, 370, false, 50, 1, 5));
    // 15 tickets sold, $500 per ticket, and has a fire extinguisher on board
    // 10 lifejackets, no lifeboat
    transportOperations.add(new Helicopter(15, 500, true, 10, 0, 0));
    // 90 tickets sold, $150 per ticket, and has a fire extinguisher on board
    // 100 lifejackets, 10 lifeboat which can carry 10 people per lifeboat
    transportOperations.add(new Ship(90, 150, true, 100, 10, 10));
    // 25 tickets sold, $450 per ticket, and has a fire extinguisher on board,
    // 25 lifejackets, 5 lifeboats which can carry 5 people per lifeboat
    transportOperations.add(new Helicopter(25, 450, true, 25, 5, 5));
    // 5 tickets sold, $500 per ticket, no fire extinguisher on board,
    // 25 lifejackets, 5 lifeboats which can carry 4 people per lifeboat
    transportOperations.add(new Boat(5, 500, false, 25, 5, 4));
    // 12 tickets sold, $250 per ticket, no fire extinguisher on board,
    // 25 lifejackets, 5 lifeboats which can carry 4 people per lifeboat
    transportOperations.add(new Boat(12, 250, false, 25, 5, 4));

    Operations current = new Operations(transportOperations);
    // Find out how many transport operations pass the safety test
    System.out.println("Safe operations: " + current.getSafeOperations());
    // Find out the total revenue for all operations that pass the safety test
    System.out.println("Total revenue: " + current.totalRevenue());
    // Find out the total Land transport operation revenue for all Land
    // transport operations that pass the safety test
    System.out.println("Land revenue: " + current.totalLandRevenue());
    // Find out the total Air transport operation revenue for all Air
    // transport operations that pass the safety test
    System.out.println("Air revenue: " + current.totalAirRevenue());
    // Find out the total Sea transport operation revenue for all Sea
    // transport operations that pass the safety test
    System.out.println("Sea revenue: " + current.totalSeaRevenue());
    System.out.println();

    // 7. Vending Machine classes
    // Money class
    Money nickel = new Money(5);
    System.out.println(nickel.getValue());
    System.out.println(nickel.getName());
    System.out.println();

    Money invalidCoin = new Money(6);
    System.out.println(invalidCoin.getValue());
    System.out.println(invalidCoin.getName());
    System.out.println();

    Money penny = new Money(1);
    System.out.println(penny.getValue());
    System.out.println(penny.getName());
    System.out.println();

    ArrayList<Money> a = Money.makeCoins(0);
    ArrayList<Money> b = Money.makeCoins(200);
    ArrayList<Money> c = Money.makeCoins(499);
    ArrayList<Money> d = Money.makeCoins(10);
    ArrayList<Money> e = Money.makeCoins(25);
    ArrayList<Money> f = Money.makeCoins(11);
    ArrayList<Money> g = Money.makeCoins(56);
    System.out.println(a + " " + Money.totalAmount(a));
    System.out.println(b + " " + Money.totalAmount(b));
    System.out.println(c + " " + Money.totalAmount(c));
    System.out.println(d + " " + Money.totalAmount(d));
    System.out.println(e + " " + Money.totalAmount(e));
    System.out.println(f + " " + Money.totalAmount(f));
    System.out.println(g + " " + Money.totalAmount(g));

    System.out.println();

    // Shopper class
    Shopper Laura = new Shopper("Laura");
    System.out.println(Laura);
    // Laura gets money
    Laura.addFunds(b);
    System.out.println(Laura.getFunds());
    System.out.println(Laura.getSnacks());
    System.out.println(Laura.getTotalValue());
    System.out.println();

    Shopper Keira = new Shopper("Keira");
    Keira.addFunds(c);
    System.out.println(Keira.getTotalValue());
    System.out.println(Keira);
    System.out.println();

    Shopper Annabelle = new Shopper("Annabelle");
    Annabelle.addFunds(a); // Sorry Annabelle :(
    System.out.println(Annabelle.getTotalValue());
    System.out.println(Annabelle);
    System.out.println();

    Shopper Kelly = new Shopper("Kelly");
    Kelly.addFunds(f);
    System.out.println(Kelly.getTotalValue());
    System.out.println(Kelly);
    System.out.println();

    Shopper Katelyn = new Shopper("Katelyn");
    Katelyn.addFunds(g);
    System.out.println(Katelyn.getTotalValue());
    System.out.println(Katelyn);
    System.out.println();

    // Vending Machine + Snack class
    Snack ticTacBox = new Snack("TicTacs", 150);
    System.out.println(ticTacBox.getName() + " " + ticTacBox.getPrice());

    // Test Case #1 (running out of money)
    VendingMachine ticTacs = new VendingMachine(ticTacBox, 3);
    ticTacs.addMoney(Laura.prepareCoins(ticTacBox));
    Laura.buySnack(ticTacs.makeSale());
    System.out.println(Laura);
    System.out.println();
    ticTacs.addMoney(Laura.prepareCoins(ticTacBox));
    Laura.buySnack(ticTacs.makeSale());
    System.out.println(Laura);
    System.out.println("Total revenue: " + VendingMachine.getTotalSales());
    System.out.println(ticTacs.getChange());
    Laura.addFunds(ticTacs.getChange());
    System.out.println(Laura);
    System.out.println();

    // Test Case #2 (running out of stock)
    for (int i = 0; i < 3; i++) {
      ticTacs.addMoney(Keira.prepareCoins(ticTacBox));
      Keira.buySnack(ticTacs.makeSale());
      Keira.addFunds(ticTacs.getChange());
      System.out.println(Keira);
    }
    System.out.println("Total revenue: " + VendingMachine.getTotalSales());
    System.out.println();

    // Test Case #3 (not having any money)
    Snack guoDanPiBag = new Snack("Guo Dan Pi", 1);
    VendingMachine guoDanPi = new VendingMachine(guoDanPiBag, 3);
    guoDanPi.addMoney(Annabelle.prepareCoins(guoDanPiBag));
    Annabelle.buySnack(guoDanPi.makeSale());
    Annabelle.addFunds(guoDanPi.getChange());
    System.out.println(Annabelle);
    System.out.println("Total revenue: " + VendingMachine.getTotalSales());
    Annabelle.addFunds(nickel);
    guoDanPi.addStock(10);
    System.out.println();

    // Test Case #4 (having enough stock and money)
    for (int i = 0; i < 6; i++) {
      guoDanPi.addMoney(Annabelle.prepareCoins(guoDanPiBag));
      Annabelle.buySnack(guoDanPi.makeSale());
      Annabelle.addFunds(guoDanPi.getChange());
    }
    System.out.println(Annabelle);
    System.out.println("Total revenue: " + VendingMachine.getTotalSales());
    System.out.println();

    // Test Case #5 (having enough money but lacking stock)
    for (int i = 0; i < 100; i++) {
      Annabelle.addFunds(nickel);
    }
    System.out.println(ticTacs.getStock());
    ticTacs.addMoney(Annabelle.prepareCoins(ticTacBox));
    System.out.println(ticTacs);
    Annabelle.buySnack(ticTacs.makeSale());
    Annabelle.addFunds(ticTacs.getChange());
    System.out.println(ticTacs);
    System.out.println(ticTacs.getStock());
    System.out.println(Annabelle);
    System.out.println();

    // Test Case #6
    ticTacs.addStock(1);
    ticTacs.addMoney(Annabelle.prepareCoins(ticTacBox));
    System.out.println(ticTacs);
    Annabelle.buySnack(ticTacs.makeSale());
    Annabelle.addFunds(ticTacs.getChange());
    System.out.println(ticTacs);
    System.out.println(ticTacs.getStock());
    System.out.println(Annabelle);

  }
} // class
