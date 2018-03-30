package pirate.events.holders;

import com.aionemu.gameserver.model.Race;
import com.aionemu.gameserver.model.gameobjects.player.Player;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import java.util.Collection;
import java.util.List;
import javolution.util.FastList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pirate.events.enums.EventPlayerLevel;
import pirate.events.enums.EventType;

/**
 *
 * @author flashman
 */
public abstract class SinglePlayerHolder extends BaseEventHolder {

    protected static final Logger log = LoggerFactory.getLogger(SinglePlayerHolder.class);
    protected List<Player> allPlayers = new FastList<Player>();

    public SinglePlayerHolder(int index, EventType etype, EventPlayerLevel epl) {
        super(index, etype, epl);
    }

    @Override
    public final boolean contains(Player p) {
        for (Player plr : this.allPlayers) {
            if (plr != null && plr.getObjectId() == p.getObjectId()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deletePlayer(Player player) {
        for (int i = 0; i < this.allPlayers.size(); i++) {
            Player p = this.allPlayers.get(i);
            if (p == null || !p.isOnline()) {
                this.allPlayers.remove(i);
                i--;
                continue;
            }
            if (p.getObjectId() == player.getObjectId()) {
                this.allPlayers.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return this.allPlayers.isEmpty();
    }

    public final List<Player> getAllPlayers() {
        return allPlayers;
    }

    public final Collection<Player> getPlayresByRace(final Race race) {
        return Collections2.filter(this.allPlayers, new Predicate<Player>() {
            @Override
            public boolean apply(Player t) {
                return t.getRace() == race;
            }
        });
    }

    public final int getPlayersCountByRace(Race race) {
        int count = 0;
        for (Player p : this.allPlayers) {
            if (p.getRace() == race) {
                count += 1;
            }
        }
        return count;
    }
}
