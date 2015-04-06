
public class Deck extends Pile
{
	Pile deck;
	
	Deck()
	{
		deck = new Pile(52);
		
		for(int i=1;i<=4;i++){
			for(int j=1;j<=13;j++){
				deck.add(new Card(j,i));
			}
		}
	
		deck.shuffle();
	}
}