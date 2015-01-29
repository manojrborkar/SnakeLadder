package app.game.snl;

public class Square {
	private Player player;
	private Board board;
	private RegularSquare regularSquare;
	private int currentPosition;

	public Square(Board board, int currentPosition) {
		this.board = board;
		this.currentPosition = currentPosition;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public RegularSquare getRegularSquare() {
		return regularSquare;
	}

	public void setRegularSquare(RegularSquare regularSquare) {
		this.regularSquare = regularSquare;
	}

	public Board getBoard() {
		return board;
	}

	public int getCurrentPosition() {
		return currentPosition;
	}

	public void addPalyer(Player p) {
		regularSquare.addPlayer(p);
	}

	public void removePlayer(Player player) {
		regularSquare.removePlayer(player);

	}

	public Square setPlayerToPosition(int toMoves) {
		return regularSquare.moveAndLand(toMoves);
	}

	public Square getLastSquare() {
		return board.getLastSquare();
	}

	public Square getFirstSquare() {
		return board.getFirstSquare();
	}

	public Square getRelativeSquare(int moves) {
		return board.getSquare(currentPosition + moves);
	}

	public Square landHereOrGoHome() {
		return regularSquare.moveUpOrDown();

	}

	public boolean isOccupied() {
		return regularSquare.isOccupied();
	}
}
