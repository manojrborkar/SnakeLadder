package app.game.snl;

public class Player {
	private String name;
	private Square square;

	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Square getSquare() {
		return square;
	}

	public void setSquare(Square square) {
		this.square = square;
	}

	public int getPosition() {
		return square.getCurrentPosition();
	}

	public void nextMove(int toMove) {
		square.removePlayer(this);
		square = square.setPlayerToPosition(toMove);
		square.addPalyer(this);
	}

	public boolean isInLastPosition() {
		return square.getCurrentPosition() == square.getBoard().getSquares()
				.size() - 1;
	}

	@Override
	public String toString() {
		return name;
	}
}
