public class MenuItem
{
  private double price;
  private double test;
  public MenuItem(double p)
  {
    price = p;
    test = 4.0;
  }
  public double getPrice()
  {
    double price = 0;
    return price;
  }

  public void makeItAMeal()
  {
    System.out.println(price);
    Combo meal = new Combo(this);
    price = meal.getComboPrice();
  }
}
