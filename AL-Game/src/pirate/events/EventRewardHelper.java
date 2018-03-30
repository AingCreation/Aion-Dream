package pirate.events;

import com.aionemu.gameserver.model.gameobjects.player.Player;
import com.aionemu.gameserver.model.ingameshop.InGameShopEn;
import com.aionemu.gameserver.services.abyss.AbyssPointsService;
import com.aionemu.gameserver.services.item.ItemService;
import pirate.events.enums.EventType;
import pirate.events.xml.EventRankTemplate;
import pirate.events.xml.EventRewardItem;
import pirate.events.xml.EventRewardItemGroup;
import pirate.events.xml.EventRewardTemplate;

/**
 *
 * @author f14shm4n
 */
public class EventRewardHelper {

    public static void GiveRewardFor(Player player, EventType etype, EventScore score, int rank) {
        EventRewardTemplate rt = etype.getEventTemplate().getRewardInfo();
        if (rt == null) {
            return;
        }
        EventRankTemplate rw = rt.getRewardByRank(rank);
        if (rw == null) {
            // no rewatd in template for this rank
            return;
        }
        if (rw.getAp() > 0) { // abyss point reward
            AbyssPointsService.addAp(player, rw.getAp());
        }
        if (rw.getGamePoint() > 0) { // toll point reward
            InGameShopEn.getInstance().addToll(player, rw.getGamePoint());
        }
        for (EventRewardItemGroup gr : rw.getRewards()) { // items reward
            for (EventRewardItem item : gr.getItems()) {
                ItemService.addItem(player, item.getItemId(), item.getCount());
            }
        }
    }
}
