package app.game.snl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class FirstSquareTest implements SnakeLadder{

	private Board board;
	
	@Before
	public void setUp(){
		board = new Board(NUMBER_OF_SQUARES, LADDERS, SNAKES);
	}
	
	@Test
	public void testIsFirstSquare() {
		assertTrue(board.getFirstSquare().getRegularSquare().isFirstSquare());
	}
	
	@Test
	public void testAddPlayer(){
		FirstSquare  firstSquare = new FirstSquare(board.getFirstSquare());
		firstSquare.addPlayer(new Player("Test"));
		assertTrue(firstSquare.isOccupied());
	}
	
	@Test
	public void testRemovePlayer(){
		FirstSquare  firstSquare = new FirstSquare(board.getFirstSquare());
		Player player = new  Player("Test");
		firstSquare.addPlayer(player);
		assertTrue(firstSquare.isOccupied());
		firstSquare.removePlayer(player);
		assertFalse(firstSquare.isOccupied());
	}

}
