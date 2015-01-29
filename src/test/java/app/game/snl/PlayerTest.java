package app.game.snl;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest implements SnakeLadder {

	@Test
	public void testGetName() {
		String name = "Test";
		Player player = new Player(name);
		assertEquals(name, player.getName());
	}

	@Test
	public void testGetSquare() {
		Player player = new Player("Test");
		int squarPosition = 25;
		Square square = getSquare(squarPosition);
		player.setSquare(square);
		assertEquals(square, player.getSquare());
	}

	
	@Test
	public void testGetPosition() {
		Player player = new Player("Test");
		int squarPosition = 25;
		Square square = getSquare(squarPosition);
		player.setSquare(square);
		assertEquals(squarPosition, player.getPosition());
	}
	
	
	@Test
	public void testNextMove() {
		Player player = new Player("Test");
		int squarePosition = 25;
		Square square = getSquare(squarePosition);
		player.setSquare(square);
		player.nextMove(3);
		assertEquals(squarePosition+3, player.getPosition());
	}
	
	
	@Test
	public void testIsInLastPosition() {
		Player player = new Player("Test");
		int squarPosition = NUMBER_OF_SQUARES-1;
		Square square = getSquare(squarPosition);
		player.setSquare(square);
		square.setPlayer(player);
		assertTrue(player.isInLastPosition());
		
	}
	
	
	@Test
	public void testIsInLastPositionFalse() {
		Player player = new Player("Test");
		int squarPosition = NUMBER_OF_SQUARES-2;
		Square square = getSquare(squarPosition);
		player.setSquare(square);
		square.setPlayer(player);
		assertFalse(player.isInLastPosition());
		
	}
	public void testToString(){
		Player player = new Player("Test");
		assertEquals(player.getName(), player.toString());
	}
	private Square getSquare(int squarPosition) {
		Board board = new Board(NUMBER_OF_SQUARES, LADDERS, SNAKES);
		return board.getSquare(squarPosition);
	}

	
}
