package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller {
	Image back = new Image("application/back.jpg");
	Table table = new Table();
	Player player = table.getPlayer();
	Player dealer = table.getDealer();
	
	
	int playerTotal = 0;
	int pot = 0;
	int cash = 500;
	
	@FXML
	Label lblWin,lblPot,lblMoney;
	
	
	@FXML
	Button btnStay, btnDouble, btnHit, btnDeal;
	
	@FXML
	ImageView imgDlrC1, imgDlrC2, imgDlrC3, imgDlrC4, imgDlrC5;
	
	@FXML
	ImageView imgPlyrC1, imgPlyrC2, imgPlyrC3, imgPlyrC4, imgPlyrC5;
	
	int count = 0;
	public void clickHit()
	{
		player.addHand(table.getCard());
		if (count == 2)
		{
			imgPlyrC3.setImage(player.getHand().get(count).getImage());
			count++;
		}
		else if(count == 3)
		{
			imgPlyrC4.setImage(player.getHand().get(count).getImage());
			count++;
		}
		else if(count == 4)
		{
			imgPlyrC5.setImage(player.getHand().get(count).getImage());
			count++;
		}
		else 
		{
			imgPlyrC5.setImage(player.getHand().get(count).getImage());
			count++;
		}
			playerTotal = player.getHandValue();

		System.out.println("hit");
		if(playerTotal > 21)
		{
			btnStay.disableProperty().set(true);
			btnDouble.disableProperty().set(true);
			btnHit.disableProperty().set(true);
			btnDeal.disableProperty().set(false);
			pot = 0;
			lblWin.setText("You busted! You Lose!");
			player.reset();
			dealer.reset();
			count = 0;
			
		}
		count = 0;

		lblPot.setText("Current Pot: $" + pot);
	}
	
	public void clickDouble()
	{
		player.setMoney(player.getMoney() - 10);
		pot = pot + 10;
		cash = cash - 10;
		lblMoney.setText("Current Cash: $" + player.getMoney());
		lblPot.setText("Current Pot: $" + pot );
		
		player.addHand(table.getCard());
		if (count == 2)
		{
			imgPlyrC3.setImage(player.getHand().get(count).getImage());
			count++;
		}
		else if(count == 3)
		{
			imgPlyrC4.setImage(player.getHand().get(count).getImage());
			count++;
		}
		else if(count == 4)
		{
			imgPlyrC5.setImage(player.getHand().get(count).getImage());
			count++;
		}
		else 
		{
			imgPlyrC5.setImage(player.getHand().get(count).getImage());
			count++;
		}
			playerTotal = player.getHandValue();

		System.out.println("dub");
		if(playerTotal > 21)
		{
			btnStay.disableProperty().set(true);
			btnDouble.disableProperty().set(true);
			btnHit.disableProperty().set(true);
			btnDeal.disableProperty().set(false);
			pot = 0;
			lblWin.setText("You busted! You Lose!");
			player.reset();
			dealer.reset();
			count = 0;
		}
		else{
		btnStay.disableProperty().set(false);
		btnDouble.disableProperty().set(true);
		btnHit.disableProperty().set(true);
		btnDeal.disableProperty().set(true);
		
		lblPot.setText("Current Pot: $" + pot);
		lblMoney.setText("Current Cash: $ " + player.getMoney());
		}
	}
	
	public void clickStay()
	{
		int dCount = 2;
		System.out.println("stay");
		System.out.println("Player has " + player.getHand().size() + " cards");
		System.out.println("Dealer has " + dealer.getHand().size() + " cards");
		
		player.addHand(table.getCard());
		dealer.addHand(table.getCard());
		
		imgDlrC1.setImage(dealer.getHand().get(0).getImage());
		imgDlrC2.setImage(dealer.getHand().get(1).getImage());
		
		while(dealer.getHandValue() < 17)
		{
			
			dealer.addHand(table.getCard());
			
			if (dCount == 2)
			{
				imgDlrC3.setImage(dealer.getHand().get(count).getImage());
				dCount++;
				count++;
			}
			else if(dCount == 3)
			{
				imgDlrC4.setImage(dealer.getHand().get(count).getImage());
				dCount++;
				count++;
			}
			else if(dCount == 4)
			{
				imgDlrC5.setImage(dealer.getHand().get(count).getImage());
				dCount++;
				count++;

			}
			else 
			{
				imgDlrC5.setImage(dealer.getHand().get(count).getImage());
				dCount++;
				count++;

			}
		}
		
		if((table.getDealer().getHandValue() > 21) || table.getDealer().getHandValue() < player.getHandValue())
		{
			player.setMoney(player.getMoney()+ pot*2);
			pot = 0;
			count = 0;
			lblWin.setText("You win!");
		}
		else
		{
			pot = 0;
			count = 0;
			lblWin.setText("You lose!");
		}
		
		
		btnStay.disableProperty().set(true);
		btnDouble.disableProperty().set(true);
		btnHit.disableProperty().set(true);
		btnDeal.disableProperty().set(false);
		
		lblPot.setText("Current Pot: $" + pot);
		lblMoney.setText("Current Cash: $ " + cash);
		
		player.reset();
		dealer.reset();
		count = 0;

	}
	
	public void clickDeal()
	{
		table.newGame();
		imgPlyrC3.setImage(back);
		imgPlyrC4.setImage(back);
		imgPlyrC5.setImage(back);
		imgDlrC1.setImage(back);
		imgDlrC2.setImage(back);
		imgDlrC3.setImage(back);
		imgDlrC4.setImage(back);
		imgDlrC5.setImage(back);
		
		
		player.addHand(table.getCard());
		player.addHand(table.getCard());
		dealer.addHand(table.getCard());
		dealer.addHand(table.getCard());
		player.setMoney(player.getMoney() - 10);
		playerTotal = player.getHandValue();
		lblMoney.setText("Current Cash: $" + player.getMoney());
		pot +=10;
		lblPot.setText("Current Pot: $" + pot );
		
		imgPlyrC1.setImage(player.getHand().get(count).getImage());
		count++;
		imgPlyrC2.setImage(player.getHand().get(count).getImage());
		count++;
		System.out.println(playerTotal);
		//add two cards to player. Add card value to player card total.Subtract 10 from player
		//money. add 10 to pot
		System.out.println("deal");
		
		btnStay.disableProperty().set(false);
		btnDouble.disableProperty().set(false);
		btnHit.disableProperty().set(false);
		btnDeal.disableProperty().set(true);

	}
}
