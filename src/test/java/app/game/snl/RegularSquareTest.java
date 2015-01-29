package app.game.snl;

import static org.junit.Assert.*;

import org.junit.Test;

public class RegularSquareTest implements SnakeLadder{

	
	@Test
	public void testisFirstSquare(){
		RegularSquare regularSquare = new RegularSquare(getSquare(10));
		assertFalse(regularSquare.isFirstSquare());
	}
	
	@Test
	public void testIsOccupiedFalse(){
		RegularSquare regularSquare = new RegularSquare(getSquare(10));
		assertFalse(regularSquare.isOccupied());
	}
	
	@Test
	public void testIsOccupied(){
		RegularSquare regularSquare = new RegularSquare(getSquare(10));
		Player player = new Player("Test");
		regularSquare.addPlayer(player);
		assertTrue(regularSquare.isOccupied());
	}
	
	@Test
	public void testMoveAndLand(){
		Square squareParamerter = getSquare(118);
		RegularSquare regularSquare = new RegularSquare(squareParamerter);
		Square square = regularSquare.moveAndLand(6);
		assertEquals(squareParamerter, square);
	}
	
	
	@Test
	public void testMoveUpOrDown(){
		RegularSquare regularSquare = new RegularSquare(getSquare(10));
		Player player = new Player("Test");
		regularSquare.addPlayer(player);
		Square square = regularSquare.moveUpOrDown();
		assertEquals(square, square.getFirstSquare());
		
	}
	private Square getSquare(int position){
		Board board = new Board(NUMBER_OF_SQUARES,LADDERS,SNAKES);
		return board.getSquare(position-1);
	}

}
