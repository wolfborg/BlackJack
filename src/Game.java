import java.util.Scanner;

public class Game
{
	static Scanner keyboard = new Scanner(System.in);
	private Deck deck;
	private Player player, dealer;
	
	public static void main(String[] args)
	{
		System.out.print("Enter name: ");
		String playerName = keyboard.next();
		System.out.println();
		
		new Game(new Player(playerName));
	}
	
	
	public Game(Player gamePlayer)
	{
		deck = new Deck();
		player = gamePlayer;
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
			System.out.println(player.getName()+" WINS");
			System.exit(0);
		}
		
		player.setTurn(true);
		
		while(player.isTurn()){
			System.out.println("Dealer's Hand:");
			dealer.getHand().display();
			System.out.println();
			printHand(player);
			System.out.println();
			command(player);
		}
		
		for(int i=1;i<=dealer.getHand().getNumberOfCards();i++){
			dealer.getHand().getCard(i).setHidden(false);
		}
		
		printHand(dealer);
		
		if((dealer.getHand().getTotal())>(player.getHand().getTotal())){
			System.out.println("DEALER'S HAND WINS");
			lose(player);
		}else if((dealer.getHand().getTotal())<(player.getHand().getTotal())){
			while((dealer.getHand().getTotal())<(player.getHand().getTotal())){
				hit(dealer);
			}
			
			System.out.println("DEALER'S HAND WINS");
			lose(player);
		}else{
			System.out.println("TIE");
			System.out.println();
			playAgain();
		}
	}
	
	public void playAgain()
	{
		System.out.print("Play Again?(y/n): ");
		String answer = keyboard.next();
		answer = answer.toLowerCase();
		
		if(answer.equals("y")||answer.equals("yes")){
			player.getHand().clear();
			dealer.getHand().clear();
			deck.clear();
			System.out.println();
			new Game(player);
		}else if(answer.equals("n")||answer.equals("no")){
			System.exit(0);
		}else{
			System.out.println("Invalid Response");
			System.out.println();
			playAgain();
		}
	}
	
	public void lose(Player player)
	{
		System.out.println("YOU LOSE");
		System.out.println();
		playAgain();
	}
	
	public int calculate(Player player)
	{
		int playerHandValue = player.getHand().getTotal();
		Card playerCard = player.getHand().getCard(player.getHand().getNumberOfCards());
		
		if(playerCard.getFace()){
			playerHandValue += 10;
		}else{
			playerHandValue += playerCard.getRankValue();
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
		
		if(card.getRankValue()==1){
			card.setRankValue(11);
		}
		
		if(hidden==false){
			player.getHand().getCard(player.getHand().getNumberOfCards()).setHidden(false);;
		}
		
		System.out.println(player.getName()+" draws ... "+card+"\n");
		
		calculate(player);
	}
	
	public void hit(Player player)
	{
		draw(player,false);
		
		for(int i=1;i<=player.getHand().getNumberOfCards();i++){
			if(isBust(player)){
				System.out.println(player.getHand().getCard(i).getRankValue());
				if((player.getHand().getCard(i).getRankValue())==11){
					player.getHand().getCard(i).setRankValue(1);
					player.getHand().setTotal(player.getHand().getTotal()-10);
				}
			}else{
				break;
			}
		}
		
		if(!player.equals(dealer)){	
			if(isBust(player)){
				printHand(player);
				System.out.println("YOU BUST");
				lose(player);
			}
		}else{
			printHand(player);
			
			if(isBust(dealer)){
				System.out.println("DEALER BUST");
				System.out.println("YOU WIN");
				System.out.println();
				playAgain();
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
