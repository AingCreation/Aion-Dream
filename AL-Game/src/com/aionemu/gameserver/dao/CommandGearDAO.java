package com.aionemu.gameserver.dao;

import java.util.Set;

import com.aionemu.commons.database.dao.DAO;
import com.aionemu.gameserver.model.gameobjects.Item;
import com.aionemu.gameserver.model.gameobjects.player.Player;
import com.aionemu.gameserver.model.gear.Gears;

public abstract class CommandGearDAO implements DAO {
	
	@Override
	public final String getClassName() {
		return CommandGearDAO.class.getName();
	}
	
	public abstract Set<Gears> getGear();
	
	public abstract void saveGear(Gears gears);
	
	public abstract void loadGear(Player playerId, Item itemId, String name);
	
	public abstract boolean deleteGear(Player playerId, Item itemId);
}
