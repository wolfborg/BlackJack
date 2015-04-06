
public class Hand extends Pile
{
	Pile hand;
	int total;
	
	public Hand()
	{
		this.setCapacity(21);
		total = 0;
	}
	
	public int getTotal()
	{
		return total;
	}
	
	public void setTotal(int newTotal)
	{
		total = newTotal;
	}
}