package app.game.snl;

import java.util.Random;

public class Dice {

	private static Random random;

	public static int getDiceNumber() {
		return (getRandomInstance().nextInt(6) + 1);
	}

	private static Random getRandomInstance() {
		if (random == null)
			random = new Random();
		return random;
	}
}
