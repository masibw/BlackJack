package model;

import java.util.ArrayList;

public class Dealer {
	private int cardSum=0;
	private int cardCount;
	private ArrayList<Card> possessCard = new ArrayList<Card>();

	public int getCardSum() {
		int	tempCardSum=0;
		for(int i=0;i<this.possessCard.size();i++){
		tempCardSum+=this.possessCard.get(i).getNumber();
		}
			this.setCardSum(tempCardSum);
			return this.cardSum;
		}
	public int getCardCount() {
		return this.cardCount;
	}
	public ArrayList<Card> getPossessCard(){
		return this.possessCard;
	}
	public void setCardSum(int cardSum) {
		this.cardSum=cardSum;
	}
	public void setCardCount(int cardCount) {
		this.cardCount=cardCount;
	}
	public void addCard(Card card) {
		this.possessCard.add(card);
	}

}
