
public class Player
{
	private String name;
	private Deck deck;
	private Hand hand;
	
	public Player(String playerName, Deck gameDeck)
	{
		name = playerName;
		deck = gameDeck;
		hand = new Hand();
	}
	
	public void draw(boolean show)
	{
		Card card = deck.getTopCard();
		
		hand.add(card);
		deck.remove(1);
		
		
		
		if(show){
			System.out.println(name+" draws ... "+card+"\n");
		}else{
			System.out.println(name+" draws ... HIDDEN\n");
		}
	}
	
	public void hit()
	{
		draw(true);
	}
	
	public void stand()
	{
		
	}
	
	public void fold()
	{
		
	}
	
	public String getName()
	{
		return name;
	}
	
	public Deck getDeck()
	{
		return deck;
	}
	
	public Hand getHand()
	{
		return hand;
	}
	
	public static void main(String[] args)
	{
		Deck deck = new Deck();
		Player player = new Player("Derek",deck);
		Player dealer = new Player("Dealer",deck);
		player.draw(true);
		dealer.draw(false);
		player.draw(true);
		dealer.draw(true);
		player.getHand().display();
		player.hit();
	}
}
