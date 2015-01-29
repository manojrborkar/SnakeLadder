package app.game.snl;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.Test;

import app.game.snl.exception.SnakeLadderException;

public class SnakeLadderGameTest implements SnakeLadder{

	@Test(expected = SnakeLadderException.class)
	public void testCreatePlayerListInsufficientPlayers() {
		new SnakeLadderGame(10, 12, LADDERS,
				SNAKES, new String[]{});
	}
	
	@Test
	public void testPlay() {
		SnakeLadderGame game=  new SnakeLadderGame(10, 12, LADDERS,
				SNAKES, new String[]{"Sachin","Yuvraj"});
		game.play();
		Player player =(Player)getInstanceField(game,"winner");
		assertNotNull(player);
	}
	
	private Object getInstanceField(Object object, String fieldName){
		Field declaredField =null;
		
		try {
			declaredField = object.getClass().getDeclaredField(fieldName);
			declaredField.setAccessible(true);
			return declaredField.get(object);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
		return null;
	}

}
