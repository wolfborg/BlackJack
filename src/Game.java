import java.util.Scanner;

public class Game
{
	static Scanner keyboard = new Scanner(System.in);
	private Deck deck;
	private Player dealer;
	
	public static void main(String[] args)
	{
		
		System.out.print("Enter name: ");
		String playerName = keyboard.next();
		System.out.println();
		
		new Game(new Player(playerName));
	}
	
	
	public Game(Player player)
	{
		deck = new Deck();
		dealer = new Player("Dealer");
		
		draw(player,false);
		draw(dealer,true);
		draw(player,false);
		draw(dealer,false);
		
		if(((player.getHand().getCard(1).equals("JACK of SPADES"))&&
		    (player.getHand().getCard(2).equals("ACE of SPADES")))||
		   ((player.getHand().getCard(1).equals("ACE of SPADES"))&&
			(player.getHand().getCard(2).equals("JACK of SPADES")))){
			System.out.println("BLACKJACK");
			System.out.println("YOU WIN");
			System.out.println("GAME OVER");
			System.exit(0);
		}
		
		player.setTurn(true);
		
		while(player.isTurn()){
			System.out.println("Dealer's Hand:");
			dealer.getHand().display();
			printHand(player);
			System.out.println();
			command(player);
		}
		
		if((dealer.getHand().getTotal())>player.getHand().getTotal()){
			printHand(dealer);
			System.out.println("YOU LOSE");
			System.out.println("GAME OVER");
			System.exit(0);
		}else{
			while((dealer.getHand().getTotal())<(player.getHand().getTotal())){
				hit(dealer);
			}
			
			System.out.println("DEALER HAND WINS");
			System.out.println("YOU LOSE");
			System.out.println("GAME OVER");
			System.exit(0);
		}
		
		
	}
	
	public int calculate(Player player)
	{
		int playerHandValue = player.getHand().getTotal();
		Card playerCard = player.getHand().getCard(player.getHand().getNumberOfCards());
		
		if(playerCard.getFace()){
			playerHandValue += 10;
		}else{
			if(playerCard.getRankValue()==1){
				if((player.getHand().getTotal()+11)<=21){
					playerHandValue += 11;
				}else{
					playerHandValue += 1;
				}
			}else{
				playerHandValue += playerCard.getRankValue();
			}
		}
		
		player.getHand().setTotal(playerHandValue);
		return player.getHand().getTotal();
	}
	
	public boolean isBust(Player player)
	{
		if((player.getHand().getTotal())>21){
			return true;
		}
		
		return false;
	}
	
	public void draw(Player player, boolean hidden)
	{
		Card card = deck.getTopCard();
		
		player.getHand().add(card);
		deck.remove(1);
		
		if(hidden==false){
			player.getHand().getCard(player.getHand().getNumberOfCards()).setHidden(false);;
		}
		
		System.out.println(player.getName()+" draws ... "+card+"\n");
		
		calculate(player);
	}
	
	public void hit(Player player)
	{
		draw(player,false);
		
		if(!player.equals(dealer)){
			printHand(dealer);
			printHand(player);
			
			if(isBust(player)){
				System.out.println("YOU BUST");
				System.out.println("YOU LOSE");
				System.out.println("GAME OVER");
				System.exit(0);
			}
		}else{
			printHand(player);
			
			if(isBust(dealer)){
				System.out.println("DEALER BUST");
				System.out.println("YOU WIN");
				System.out.println("GAME OVER");
				System.exit(0);
			}
		}
	}
	
	public void stand(Player player)
	{
		System.out.println(player.getName()+" stands.\n");
		System.out.println(player.getName()+"'s hand value: "+player.getHand().getTotal());
		player.setTurn(false);
		System.out.println();
	}
	
	public void fold(Player player)
	{
		System.out.println(player.getName()+" folds.\n");
		player.getHand().clear();
		player.setTurn(false);
	}
	
	public void command(Player player)
	{
		System.out.println("Available commands: 'hit','stand','fold','quit'");
		System.out.print("Enter command: ");
		String command = keyboard.next();
		System.out.println();
		
		if(command.equals("hit")){
			hit(player);
		}else if(command.equals("stand")){
			stand(player);
		}else if(command.equals("fold")){
			fold(player);
		}else if(command.equals("quit")){
			System.exit(0);
		}else{
			System.out.println("Invalid command.\n");
			command(player);
		}
	}
	
	public void printHand(Player player)
	{
		System.out.println(player.getName()+"'s Hand:");
		player.getHand().display();
		System.out.println("Hand Value: "+player.getHand().getTotal()+"\n");
	}
	
	public Deck getDeck()
	{
		return deck;
	}
	
	public Player getDealer()
	{
		return dealer;
	}
}
