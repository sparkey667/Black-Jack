package application;

import java.util.ArrayList;

public class Player  {
	private String name;
	private ArrayList<Card> hand = new ArrayList<Card>();
	double money = 500;
	double bet;
	static int playernum = 0;
	
	Player(String name, double money) {
		playernum++;
		this.name = name;
		this.money = money;
	}
	
	Player(String name) {
		playernum++;
		this.name = name;
		
	}
	
	Player() {
		playernum++;
		this.name = "Player " + playernum;
		
	}
	
	public void addHand(Card card) {
		hand.add(card);
	}
	
	public ArrayList<Card> getHand() {
		return this.hand;
	}
	
	public void removeHand(String suit, int value) {
		for (int i=hand.size()-1; i>=0; i--) {
			Card card = hand.get(i);
			if (card.getSuit() == suit && card.getValue() == value) {
				hand.remove(card);
			}
		}
	}
	
	public void reset(){
		hand.clear();
	}
	
	public double getMoney() {
		return this.money;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getBet() {
		return this.bet;
	}
	
	public void setMoney(double cash) {
		this.money = cash;
	}
	
	public void setBet(double bet) {
		this.bet = bet;
	}
	
	public int getHandValue() {
		int sum = 0;
		int cardValue;
		for (int i=0; i<hand.size(); i++) {
			cardValue = hand.get(i).getValue();
			if (cardValue < 11) {
				sum += cardValue;
			} else {
				sum += 10;
			}
		}
		return sum;
	}
}