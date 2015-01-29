package app.game.snl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class LadderSquareTest implements SnakeLadder{

private Board board;
	
	@Before
	public void setUp(){
		board = new Board(NUMBER_OF_SQUARES, LADDERS, SNAKES);
	}
	
	/** 
	 * If player reached at the start of ladder then it's current condition should be update the top point of the ladder
	 * Below Test case used ladder start point 4-1=3 and end point 14-1=13(start of sqaure is from 0th position).
	 * So updated current position of player should be 13. 
	 * */
	@Test
	public void testMoveUpOrDown(){
		Square square = board.getSquare(LADDERS[0][0]-1).getRegularSquare().moveUpOrDown();
		assertEquals(13, square.getCurrentPosition());
	}

}
