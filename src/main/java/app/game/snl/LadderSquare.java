package app.game.snl;

public class LadderSquare extends RegularSquare {

	private int toMove;

	public LadderSquare(Square square, int toMove) {
		super(square);
		this.toMove = toMove;
	}

	@Override
	public Square moveUpOrDown() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(
				"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")
				.append("\n");
		stringBuffer.append("Hurrey it's LADDDEEERRRRR !!!!!!").append("\n");
		stringBuffer.append(" Moving  from Square[")
				.append(square.getCurrentPosition() + 1)
				.append("] to Square [")
				.append(destination().getCurrentPosition() + 1).append("]")
				.append("\n");
		stringBuffer
				.append("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(stringBuffer);
		return destination().landHereOrGoHome();
	}

	private Square destination() {
		return square.getRelativeSquare(toMove);
	}

}
