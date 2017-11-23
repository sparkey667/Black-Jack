package application;

import java.util.ArrayList;
import java.util.Collections;

public class Table {
	private ArrayList<Card> deck = new ArrayList<Card>();
	private Player player = new Player();
	private Player dealer = new Player();
	private double pot;
	
	Table() {
		this.pot = 0;
		newGame();
		shuffle();
	}
	

	
	public void shuffle() {
		Collections.shuffle(this.deck);
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	public Player getDealer() {
		return this.dealer;
	}
	
	public ArrayList<Card> getDeck() {
		return this.deck;
	}
	
	public void newGame() {
		this.deck.clear();
		String[] suits = {"hearts", "diamonds", "clubs", "spades"};
		for (int i=0; i<4; i++) {
			for (int value=1; value<14; value++) {
				this.deck.add(new Card(suits[i], value));
			}
		}
		this.shuffle();
		player.getHand().clear();
		dealer.getHand().clear();
	}
	
	public Card getCard() {
		Card card = this.deck.get(this.deck.size() - 1);
		this.deck.remove(card);
		return card;
	}
	
	public double getPot() {
		return this.pot;
	}
	
	public void setPot(double pot) {
		this.pot = pot;
	}
	
	public void addPot(double bet) {
		this.pot = this.pot + bet;
	}
}
