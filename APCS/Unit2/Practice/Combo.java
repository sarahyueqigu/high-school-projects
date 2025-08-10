public class Combo
{
private double comboPrice;
public Combo(MenuItem item)
{
comboPrice = item.getPrice() + 1.5;
}
public double getComboPrice()
{
return comboPrice;
}
}
