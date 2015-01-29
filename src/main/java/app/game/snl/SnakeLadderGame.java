package app.game.snl;

import java.util.LinkedList;

import app.game.snl.exception.SnakeLadderException;

public class SnakeLadderGame {

	private LinkedList<Player> playersList;
	private Board board;
	private Player winner;

	public SnakeLadderGame(int hSquareNumbers, int vSquareNumbers,
			int[][] ladders, int[][] snakes, String... players)
			throws SnakeLadderException {

		final int totalNumbersOfSquares = hSquareNumbers * vSquareNumbers;
		board = new Board(totalNumbersOfSquares, ladders, snakes);
		createPlayerList(players);
	}

	public void play() {
		gameStartupSetup();
		while (isContinue()) {
			Player player = getPlayersList().remove();
			final int diceNumber = Dice.getDiceNumber();
			System.out.println("Player " + player.getName()
					+ " current position " + (player.getPosition() + 1)
					+ ",  Dice throw number " + diceNumber);
			player.nextMove(diceNumber);
			getPlayersList().add(player);
			if (player.isInLastPosition()) {
				winner = player;
			}
		}

		System.out.println(winner + " is Won");

	}

	private void gameStartupSetup() {
		for (Player player : getPlayersList()) {
			board.getFirstSquare().addPalyer(player);
		}

	}

	private LinkedList<Player> getPlayersList() {
		if (playersList == null)
			playersList = new LinkedList<Player>();
		return playersList;
	}

	private boolean isContinue() {
		return winner == null;
	}

	private void createPlayerList(String... players)
			throws SnakeLadderException {

		if (players != null && players.length < 2) {
			throw new SnakeLadderException(
					"At least two players requires for playing Snake and Ladders!!!!!!!!");
		}
		for (String playerName : players) {
			getPlayersList().add(new Player(playerName));
		}
	}

}
