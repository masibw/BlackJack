package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Card;
import model.Dealer;
import model.Player;

public class Main {
	static void startMessage() {
		System.out.println("Let's Start Black Jack Game !!!");
	}

	static void distributeCardAtStart(Player player, Dealer dealer, List<Card> deck) {
		for (int i = 0; i < 2; i++) {
			Card card = getCardFromDeck(deck);
			player.addCard(card);
			Card card2 = getCardFromDeck(deck);
			dealer.addCard(card2);
		}

	}

	static void showPlayerCards(Player player) {
		ArrayList<Card> possessCard = player.getPossessCard();
		if (possessCard == null)
			System.out.println("カードを持っていません");
		else {
			System.out.println("------------------------------------------------------------------");
			System.out.println("あなたの所持カード");
			for (int i = 0; i < possessCard.size(); i++) {
				System.out.println(possessCard.get(i).getKind() + ":" + possessCard.get(i).getNumber());
			}
			System.out.println("現在の合計");
			System.out.println(player.getCardSum());
			System.out.println("------------------------------------------------------------------");
		}
	}

	static void showDealerCards(Dealer dealer) {
		ArrayList<Card> possessCard = dealer.getPossessCard();
		if (possessCard == null)
			System.out.println("カードを持っていません");
		else {

			System.out.println("ディーラーのカード");
			System.out.println(possessCard.get(0).getKind() + ":" + possessCard.get(0).getNumber());
			System.out.println("+１枚");
			System.out.println("------------------------------------------------------------------");

		}
	}

	static List<Card> initializeDeck() {
		List<Card> deck = new ArrayList<>();
		int count = 0;
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 13; j++) {
				if (j > 10) {
					Card tempCard = new Card(i, 10, count);
					deck.add(tempCard);
					count++;
				} else {
					Card tempCard = new Card(i, j, count);
					deck.add(tempCard);
					count++;
				}
			}
		}
		return deck;
	}

	static void showDealerCardsAll(Dealer dealer) {
		ArrayList<Card> possessCard = dealer.getPossessCard();
		if (possessCard == null)
			System.out.println("カードを持っていません");
		else {

			System.out.println("ディーラーのカード");
			for(int i=0;i<possessCard.size();i++){
			System.out.println(possessCard.get(i).getKind() + ":" + possessCard.get(i).getNumber());
			}
			System.out.println("------------------------------------------------------------------");

		}
	}

	static Card getCardFromDeck(List<Card> deck) {
		int i = (int) Math.floor(Math.random() * deck.size());
		Card card = deck.get(i);
		deck.remove(i);
		return card;
	}

	static void gameEnd(Player player, Dealer dealer) {
		showPlayerCards(player);
		showDealerCardsAll(dealer);
		if (player.getCardSum() == dealer.getCardSum()) {
			System.out.println("引き分け！");
		} else if (21 - player.getCardSum() < 21 - dealer.getCardSum()) {
			System.out.println("あなたの点数:" + player.getCardSum());
			System.out.println("ディーラーの点数:" + dealer.getCardSum());
			System.out.println("You Win!");
		} else {
			System.out.println("あなたの点数:" + player.getCardSum());
			System.out.println("ディーラーの点数:" + dealer.getCardSum());
			System.out.println("You Lose!");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Player player = new Player();
		Dealer dealer = new Dealer();
		startMessage();
		List<Card> deck = initializeDeck();
		distributeCardAtStart(player, dealer, deck);
		showPlayerCards(player);
		showDealerCards(dealer);
		while (player.getCardSum() < 21) {
			System.out.println("もう一枚引きますか？(Yes/No)");
			if (sc.next().equals("Yes")) {
				Card tempCard = getCardFromDeck(deck);
				player.addCard(tempCard);
				showPlayerCards(player);
				if (player.getCardSum() > 21) {
					System.out.println("Over 21 , You Lose!");
					sc.close();
					return;
				}
			} else {
				sc.close();
				break;
			}
		}
		while (dealer.getCardSum() < 18) {
			Card tempCard = getCardFromDeck(deck);
			dealer.addCard(tempCard);
			if (dealer.getCardSum() > 21) {
				System.out.println("dealer over 21, You Win!");
				return;
			}
		}
		gameEnd(player, dealer);
		return;
	}
}
