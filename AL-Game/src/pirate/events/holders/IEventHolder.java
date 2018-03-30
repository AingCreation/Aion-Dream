package pirate.events.holders;

import com.aionemu.gameserver.model.gameobjects.player.Player;
import com.aionemu.gameserver.model.team2.group.PlayerGroup;
import pirate.events.enums.EventPlayerLevel;
import pirate.events.enums.EventRergisterState;
import pirate.events.enums.EventType;

/**
 *
 * @author f14shm4n
 */
public interface IEventHolder {

    public boolean canAddGroup(PlayerGroup group);
    
    public boolean canAddPlayer(Player player);

    public EventRergisterState addPlayer(Player player);
    
    public EventRergisterState addPlayerGroup(PlayerGroup group);

    public boolean deletePlayer(Player player);
    
    public boolean deletePlayerGroup(PlayerGroup group);

    public boolean isReadyToGo();

    public boolean contains(Player p);
    
    public boolean contains(PlayerGroup group);

    public EventPlayerLevel getHolderLevel();

    public EventType getEventType();

    public int Index();

    public boolean isEmpty();
}
