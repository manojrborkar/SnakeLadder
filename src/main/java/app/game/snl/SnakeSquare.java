package app.game.snl;

public class SnakeSquare extends RegularSquare {

	private int toMove;

	public SnakeSquare(Square square, int toMove) {
		super(square);
		this.toMove = toMove;
	}

	@Override
	public Square moveUpOrDown() {
		Square nextSquare = getNextSquare();
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer
				.append("-----------------------------------------------------------------------------------------\n");
		stringBuffer
				.append(" Shhhhhhhh!!!!!! It's Snake, you will go down from square position ")
				.append(square.getCurrentPosition() + 1).append(" to ")
				.append(nextSquare.getCurrentPosition() + 1).append("\n");
		stringBuffer
				.append("------------------------------------------------------------------------------------------\n");
		System.out.println(stringBuffer);
		return nextSquare.landHereOrGoHome();
	}

	private Square getNextSquare() {
		return square.getRelativeSquare(toMove);
	}

}
