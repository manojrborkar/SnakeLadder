package app.game.snl;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class DiceTest {

	/**
	 * Test the dice throw the number 1-6.
	 * */
	@Test
	public void testGetDiceNumber() {
		int diceNumber = Dice.getDiceNumber();
		assertTrue(diceNumber>0 && diceNumber<7);
	}
	
	@Test
	public void testGetDiceNumberForLineCoverage() {
		int diceNumber = Dice.getDiceNumber();
		assertTrue(diceNumber>0 && diceNumber<7);
	}

}
