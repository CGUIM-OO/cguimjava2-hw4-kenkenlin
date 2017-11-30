import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Scanner;
public class HW4 {
	public static void main(String[] args) {
		int nDeck=4;
		Deck deck=new Deck(nDeck);
		deck.shuffle();
		//TODO: please check your output, make sure that 
		Player player1=new Player("Player 1",100);
		Player player2=new Player("Player 2",300);
		player1.sayHello();
		player2.sayHello();
		int p1Bet=player1.makeBet();
		int p2Bet=player2.makeBet();
		ArrayList<Card> player1Card=new ArrayList<Card>();
		player1Card.add(deck.getOneCard(false));
		player1Card.add(deck.getOneCard(true));
		player1.setOneRoundCard(player1Card);
		
		ArrayList<Card> player2Card=new ArrayList<Card>();
		player2Card.add(deck.getOneCard(false));
		player2Card.add(deck.getOneCard(true));
		player2.setOneRoundCard(player2Card);
		boolean hit=false;
		do{
			hit=player1.hitMe(); //this
			if(hit){
				player1Card.add(deck.getOneCard(true));
				player1.setOneRoundCard(player1Card);
				System.out.print("Hit! ");
				System.out.println(player1.getName()+"'s Cards now:");
				for(Card c : player1Card){
					c.printCard(c.getSuit(),c.getRank());
				}
			}
			else{
				System.out.println(player1.getName()+", Pass hit!");
				System.out.println(player1.getName()+", Final Card:");
				for(Card c : player1Card){
					c.printCard(c.getSuit(),c.getRank());
				}
			}
		}while(hit);
		
		hit=false;
		do{
			hit=player2.hitMe(); //this
			if(hit){
				player2Card.add(deck.getOneCard(true));
				player2.setOneRoundCard(player2Card);
				System.out.print("Hit! ");
				System.out.println(player2.getName()+"'s Cards now:");
				for(Card c : player2Card){
					c.printCard(c.getSuit(),c.getRank());
				}
			}
			else{
				System.out.println(player2.getName()+", Pass hit!");
				System.out.println(player2.getName()+", Final Card:");
				for(Card c : player2Card){
					c.printCard(c.getSuit(),c.getRank());
				}
			}
		}while(hit);
		if(player1.getTotalValue()>21 && player2.getTotalValue()>21){
			System.out.println("Need another game");
		}else if(player1.getTotalValue()<=21&&player2.getTotalValue()>21){
			System.out.println(player1.getName()+" wins the game");
			player1.increaseChips(p1Bet);
			player2.increaseChips(-p2Bet);
		}else if(player1.getTotalValue()>21&&player2.getTotalValue()<=21){
			System.out.println(player2.getName()+" wins the game");
			player1.increaseChips(-p1Bet);
			player2.increaseChips(p2Bet);
		}else if(player1.getTotalValue()>player2.getTotalValue()&&player1.getTotalValue()<=21){
			System.out.println(player1.getName()+" wins the game");
			player1.increaseChips(p1Bet);
			player2.increaseChips(-p2Bet);
		}else if(player1.getTotalValue()<player2.getTotalValue()&&player2.getTotalValue()<=21){
			System.out.println(player2.getName()+" wins the game");
			player1.increaseChips(-p1Bet);
			player2.increaseChips(p2Bet);
		}else{
			System.out.println("Need another game");
		}
		System.out.println(player1.getName()+" has "+player1.getCurrentChips()+" chips");
		System.out.println(player2.getName()+" has "+player2.getCurrentChips()+" chips");

	}
	

}
