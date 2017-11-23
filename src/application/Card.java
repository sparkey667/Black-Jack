package application;

import java.util.HashMap;

import javafx.scene.image.Image;

public class Card {
	private static HashMap<String, Image> images = new HashMap<String, Image>();
	static {
		String[] suits = {"hearts", "diamonds", "clubs", "spades"};
		for (int v=1; v<14; v++) {
			for (int s=0; s<4; s++) {
				String cardString = "/application/assets/" + v + "_of_" + suits[s] + ".png";
				Image cardImage = new Image(cardString);
				images.put(cardString, cardImage);
			}
		}
	}
	private String suit;
	private int value;
	private Image image;
	
	Card(String suit, int value) {

		this.suit = suit;
		this.value = value;
		this.image = images.get("/application/assets/" + this.value + "_of_" + this.suit + ".png");
	}
	
	public String getSuit() {
		return this.suit;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public Image getImage() {
		return this.image;
	}
	
}
