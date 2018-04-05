package com.aionemu.gameserver.model.gear;

import java.util.Set;

import com.aionemu.commons.database.dao.DAOManager;
import com.aionemu.gameserver.dao.CommandGearDAO;
import com.aionemu.gameserver.model.gameobjects.Item;
import com.aionemu.gameserver.model.gameobjects.player.Player;

public class GearList {
	
	public static GearList getInstance() {
		return SingletonHolder.instance;
	}
	
	public void saveGear(Gears gears) {
		getDAO().saveGear(gears);;
	}

	public boolean deleteGear(Player playerId, Item itemId) {
		return getDAO().deleteGear(playerId, itemId);
	}
	
	public void loadGear(Player playerId, Item itemId, String name) {
		getDAO().loadGear(playerId, itemId, name);
	}
	
	public Set<Gears> getGear() {
		return getDAO().getGear();
	}
	
	private CommandGearDAO getDAO() {
		return DAOManager.getDAO(CommandGearDAO.class);
	}
	
	@SuppressWarnings("synthetic-access")
	private static class SingletonHolder {

		protected static final GearList instance = new GearList();
	}

}
