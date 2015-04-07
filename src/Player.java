/**
 * @author chaplind
 */

public class Player
{
	private String name;
	private Hand hand;
	private boolean turn;
	
	public Player(String playerName)
	{
		name = playerName;
		hand = new Hand();
	}
	
	public String getName()
	{
		return name;
	}
	
	public Hand getHand()
	{
		return hand;
	}
	
	public boolean isTurn()
	{
		return turn;
	}
	
	public void setTurn(boolean newTurn)
	{
		turn = newTurn;
	}
}
