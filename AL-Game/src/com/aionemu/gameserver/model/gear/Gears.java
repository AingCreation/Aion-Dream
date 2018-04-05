package com.aionemu.gameserver.model.gear;

import javolution.util.FastList;

import com.aionemu.gameserver.model.gameobjects.Item;
import com.aionemu.gameserver.model.gameobjects.player.Player;

public class Gears {
	
	private int Id;
	private Player playerId;
	private FastList<Item> itemId;
	private String name;
	
	public Gears(String name) {
		this.name = name;
	}
	
	public Gears(int Id, String name) {
		this.Id = Id;
		this.name = name;
	}
	
	public Gears(Player player, FastList<Item> itemId, String name) {
		playerId = player;
		this.itemId = itemId;
		this.name = name;
	}
	
	public Gears(int Id, Player playerId, FastList<Item> itemId, String name) {
		this.Id = Id;
		this.playerId = playerId;
		this.itemId = itemId;
		this.name = name;
	}
	
	public int getId() {
		if (Id != 0) {
			return Id;
		} else {
			return -1;
		}
	}
	
	public String getName() {
		return name;
	}
	
	public Player getPlayerId() {
		return playerId;
	}
	
	public FastList<Item> getItemId() {
		return itemId;
	}
	
}
