package app.game.snl;

import java.util.ArrayList;
import java.util.List;

import app.game.snl.exception.SnakeLadderException;

public class Board {
	private List<Square> squares;

	public Board(int numberOfSquares, int[][] ladders, int snakes[][])
			throws SnakeLadderException {
		createSquaresOfBoard(numberOfSquares);
		createLaddersOnBoard(ladders);
		createSnakesOnBoard(snakes);
	}

	private void createLaddersOnBoard(int[][] ladders)
			throws SnakeLadderException {
		for (int[] ladder : ladders) {
			if (ladder.length < 2) {
				throw new SnakeLadderException(
						"Ladder should have start position and end Position!!!");
			}

			final int ladderStartPosition = ladder[0] - 1;
			final int ladderEndPosition = ladder[1] - 1;

			if (ladderStartPosition > ladderEndPosition) {
				throw new SnakeLadderException(
						"Ladder start position should less than end position!!!");
			}

			final int toMove = ladderEndPosition - ladderStartPosition;
			final Square square = getSquares().get(ladderStartPosition);
			square.setRegularSquare(new LadderSquare(square, toMove));

		}
	}

	private void createSnakesOnBoard(int[][] snakes)
			throws SnakeLadderException {
		for (int[] snake : snakes) {
			if (snake.length < 2) {
				throw new SnakeLadderException(
						"Snake should have start position and end position!!!");
			}

			final int snakeHeadPosition = snake[0] - 1;
			final int snakeTailPosition = snake[1] - 1;

			if (snakeHeadPosition < snakeTailPosition) {
				throw new SnakeLadderException(
						"Snake start position(Head) should greater than end(Tail) position!!!");
			}

			final int toMove = snakeTailPosition - snakeHeadPosition;
			final Square square = getSquares().get(snakeHeadPosition);
			square.setRegularSquare(new SnakeSquare(square, toMove));
		}
	}

	private void createSquaresOfBoard(int numberOfSquares) {
		for (int squarePosition = 0; squarePosition < numberOfSquares; squarePosition++) {
			Square square = new Square(this, squarePosition);
			square.setRegularSquare(new RegularSquare(square));
			getSquares().add(square);
		}
		getFirstSquare().setRegularSquare(new FirstSquare(getFirstSquare()));
	}

	public List<Square> getSquares() {
		if (squares == null)
			squares = new ArrayList<Square>();
		return squares;
	}

	public Square getFirstSquare() {
		return getSquares().get(0);
	}

	public Square getLastSquare() {
		return getSquares().get(squares.size() - 1);
	}

	public Square getSquare(int position) {
		return getSquares().get(position);
	}

}
