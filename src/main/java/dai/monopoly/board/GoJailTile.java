package dai.monopoly.board;

import dai.monopoly.Player;

public class GoJailTile extends Tile {

	public GoJailTile(String name ,int position) {
		super(name, position);
	}

	@Override
	public void landingActions(Player rechiverOfActions) {
		//TODO Tell board to move them to Jail, and change status to prisoned
		throw new UnsupportedOperationException("Feature under development");
	}

	
	
}