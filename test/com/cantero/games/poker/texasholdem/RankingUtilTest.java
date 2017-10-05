package com.cantero.games.poker.texasholdem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class RankingUtilTest {

	private Player player;

	@Before
	public void createPlayer() {
		player = new Player();
	}

	@Test
	public void highCard() {
		// arrange

		Card[] cards = new Card[] { new Card(CardSuitEnum.HEARTS, CardRankEnum.ACE),
				new Card(CardSuitEnum.HEARTS, CardRankEnum.KING) };
		player.setCards(cards);

		List<Card> tableCards = Arrays.asList(new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_2),
				new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_3), new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_7),
				new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_8), new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_9));

		// act
		RankingUtil.checkRanking(player, tableCards);

		org.junit.Assert.assertEquals(RankingEnum.HIGH_CARD, player.getRankingEnum());
	}

	@Test
	public void pairTest() {
		// arrange

		Card[] cards = new Card[] { new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_3),
				new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_3) };
		player.setCards(cards);

		List<Card> tableCards = Arrays.asList(new Card(CardSuitEnum.SPADES, CardRankEnum.ACE),
				new Card(CardSuitEnum.CLUBS, CardRankEnum.JACK), new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_10),
				new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_7),
				new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_5));
		// act
		RankingUtil.checkRanking(player, tableCards);

		// assert
		org.junit.Assert.assertEquals(RankingEnum.ONE_PAIR, player.getRankingEnum());
	}

	@Test
	public void pocketTablePairTest() {
		// arrange

		Card[] cards = new Card[] { new Card(CardSuitEnum.SPADES, CardRankEnum.ACE),
				new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_3) };
		player.setCards(cards);

		List<Card> tableCards = Arrays.asList(new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_3),
				new Card(CardSuitEnum.CLUBS, CardRankEnum.JACK), new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_10),
				new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_7),
				new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_5));
		// act
		RankingUtil.checkRanking(player, tableCards);

		// assert
		org.junit.Assert.assertEquals(RankingEnum.ONE_PAIR, player.getRankingEnum());
	}

	@Test
	public void tablePairTest() {
		// arrange

		Card[] cards = new Card[] { new Card(CardSuitEnum.SPADES, CardRankEnum.ACE),
				new Card(CardSuitEnum.CLUBS, CardRankEnum.JACK) };
		player.setCards(cards);

		List<Card> tableCards = Arrays.asList(new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_3),
				new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_3), new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_10),
				new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_7),
				new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_5));
		// act
		RankingUtil.checkRanking(player, tableCards);

		// assert
		org.junit.Assert.assertEquals(RankingEnum.ONE_PAIR, player.getRankingEnum());
	}
	@Test
	public void missingPocketCardTest() {
		// arrange
		
		Card[] cards = new Card[] { new Card(CardSuitEnum.SPADES, CardRankEnum.ACE),
			null	 };
		player.setCards(cards);
		
		List<Card> tableCards = Arrays.asList(new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_3),
				new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_3), new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_10),
				new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_7),
				new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_5));
		// act
		RankingUtil.checkRanking(player, tableCards);
		
		// assert
		org.junit.Assert.assertEquals(RankingEnum.ONE_PAIR, player.getRankingEnum());
	}

}
