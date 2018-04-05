package admincommands;

import java.util.Set;

import javolution.util.FastList;

import com.aionemu.gameserver.model.gameobjects.Item;
import com.aionemu.gameserver.model.gameobjects.player.Player;
import com.aionemu.gameserver.model.gear.GearList;
import com.aionemu.gameserver.model.gear.Gears;
import com.aionemu.gameserver.utils.PacketSendUtility;
import com.aionemu.gameserver.utils.chathandlers.AdminCommand;

public class Gear extends AdminCommand {
	
	private GearList gearList;

	public Gear() {
		super("gear");
		gearList = GearList.getInstance();
	}

	@Override
	public void execute(Player admin, String... params) {
		// TODO Auto-generated method stub
		if(params[0].equals("list")) {
			Set<Gears> gear = gearList.getGear();
			PacketSendUtility.sendMessage(admin, "-------------------------------------------------------------------");
			for (Gears gears : gear) {
				PacketSendUtility.sendMessage(admin, "- " + gears.getName());
			}
		} else if (params[0].equals("save")) {
			if ((params.length < 5)) {
				onFail(admin, null);
				return;
			}
			
			String name = "";
			
			FastList<Item> item = admin.getEquipment().getEquippedAllItemsWithoutStigma();
			
			Gears gears = new Gears(admin, item, name);
			
			gearList.saveGear(gears);
		}
	}

}
