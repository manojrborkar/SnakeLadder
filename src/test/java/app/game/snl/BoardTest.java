package app.game.snl;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import app.game.snl.exception.SnakeLadderException;

public class BoardTest implements SnakeLadder {

	/**
	 * If the ladder array is null or Length is less than 2 then it should throw
	 * exception
	 * */
	@Test(expected = SnakeLadderException.class)
	public void testCreateLaddersOnBoardForElementsSizeException() {
		int[][] ladders = { {} };
		new Board(120, ladders, SNAKES);
	}

	/**
	 * If the ladder array contains array as starting point is greater than end
	 * point then, expected throw an Exception
	 * */
	@Test(expected = SnakeLadderException.class)
	public void testCreateLaddersOnBoardException() {
		int[][] ladders = { { 20, 10 } };
		new Board(120, ladders, SNAKES);
	}

	/**
	 * If the ladder array is null or Length is less than 2 then it should throw
	 * exception
	 * */
	@Test(expected = SnakeLadderException.class)
	public void testCreateSnakesOnBoardForElementsSizeException() {
		int[][] snake = { {} };
		new Board(120, LADDERS, snake);
	}

	/**
	 * If the snake array contains array as starting point(head) is less than
	 * end point(tail) then, expected throw an Exception
	 * */
	@Test(expected = SnakeLadderException.class)
	public void testCreateSnakesOnBoardException() {
		int[][] snake = { { 10, 20 } };
		new Board(120, LADDERS, snake);
	}

	@Test
	public void testGetFirstSquare() {
		Board board = new Board(120, LADDERS, SNAKES);
		assertTrue(board.getFirstSquare() == board.getSquare(0));
	}

	@Test
	public void testGetLastSquare() {
		Board board = new Board(120, LADDERS, SNAKES);
		assertTrue(board.getLastSquare() == board.getSquare(board.getSquares()
				.size() - 1));
	}

}
