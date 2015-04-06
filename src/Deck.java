
public class Deck extends Pile
{
	Deck()
	{
		Pile deck = new Pile(52);
		
		for(int i=1;i<=4;i++){
			for(int j=1;j<=13;j++){
				deck.add(new Card(j,i));
			}
		}
	
		shuffle();
	}
}
