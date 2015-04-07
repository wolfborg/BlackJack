/**
 * @author chaplind
 */

public class Deck extends Pile
{
	public Deck()
	{
		this.setCapacity(52);
		
		for(int i=1;i<=4;i++){
			for(int j=1;j<=13;j++){
				add(new Card(j,i));
			}
		}
	
		shuffle();
	}
}