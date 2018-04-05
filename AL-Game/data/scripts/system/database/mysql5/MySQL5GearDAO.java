package mysql5;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.aionemu.commons.database.DB;
import com.aionemu.commons.database.IUStH;
import com.aionemu.commons.database.ReadStH;
import com.aionemu.gameserver.dao.CommandGearDAO;
import com.aionemu.gameserver.model.gameobjects.Item;
import com.aionemu.gameserver.model.gameobjects.player.Player;
import com.aionemu.gameserver.model.gear.Gears;

public class MySQL5GearDAO extends CommandGearDAO {

	@Override
	public boolean supports(String arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Gears> getGear() {
		final Set<Gears> result = new HashSet<Gears>();
		DB.select("SELECT * FROM commandgears ORDER BY id", new ReadStH() {

			@Override
			public void handleRead(ResultSet resultSet) throws SQLException {
				
				while (resultSet.next()) {
					result.add(new Gears(resultSet.getInt("id"), resultSet.getString("name")));
				}
				
			} 
			
		});
		return null;
	}

	@Override
	public void saveGear(final Gears gears) {
		// TODO Auto-generated method stub
		DB.insertUpdate("INSERT INTO commandgears (player_id, item_id, name) VALUES (?, ?, ?)", new IUStH() {

			@Override
			public void handleInsertUpdate(PreparedStatement preparedStatement) throws SQLException {
				// TODO Auto-generated method stub
				
			}
			
		});
	}

	@Override
	public void loadGear(Player playerId, Item itemId, String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean deleteGear(Player playerId, Item itemId) {
		// TODO Auto-generated method stub
		return false;
	}

}
