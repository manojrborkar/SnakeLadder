package app.game.snl;

public class RegularSquare {
	protected Square square = null;

	public RegularSquare(Square square) {
		this.square = square;
	}

	public boolean isFirstSquare() {
		return false;
	}

	public boolean isOccupied() {
		return square.getPlayer() != null;
	}

	public void addPlayer(Player player) {
		square.setPlayer(player);
		player.setSquare(square);
	}

	public void removePlayer(Player player) {
		square.setPlayer(null);

	}

	public Square moveAndLand(int moves) {
		int lastPosition = square.getLastSquare().getCurrentPosition();
		int presentPosition = square.getCurrentPosition();
		if (presentPosition + moves > lastPosition) {
			StringBuffer stringMessage = new StringBuffer();
			stringMessage.append("Should go to ")
					.append(presentPosition + moves + 1)
					.append(" beyond last square ").append(lastPosition + 1)
					.append(" so don't move ");
			System.out.println(stringMessage);
			return square;
		} else {
			StringBuffer stringMessage = new StringBuffer();
			stringMessage
					.append("Moving from  Square[")
					.append(square.getCurrentPosition() + 1)
					.append(" to ")
					.append(square.getRelativeSquare(moves)
							.getCurrentPosition() + 1);
			System.out.println(stringMessage);
			return square.getRelativeSquare(moves).landHereOrGoHome();
		}
	}

	public Square moveUpOrDown() {
		if (square.isOccupied()) {
			StringBuffer stringMessage = new StringBuffer();
			stringMessage.append("Ohh no!!! Square [")
					.append(square.getCurrentPosition() + 1)
					.append("] has already Occupied");
			return square.getFirstSquare();
		}
		return square;
	}

}
