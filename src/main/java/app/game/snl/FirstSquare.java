package app.game.snl;

import java.util.ArrayList;

public class FirstSquare extends RegularSquare {

	private ArrayList<Player> players = new ArrayList<Player>();

	public FirstSquare(Square s) {
		super(s);
	}

	@Override
	public boolean isFirstSquare() {
		return true;
	}

	@Override
	public void addPlayer(Player player) {
		players.add(player);
		player.setSquare(square);
	}

	@Override
	public void removePlayer(Player player) {
		players.remove(player);
	}

	@Override
	public boolean isOccupied() {
		return !players.isEmpty();
	}
}
