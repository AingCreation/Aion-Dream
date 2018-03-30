package pirate.events.enums;

import com.aionemu.gameserver.dataholders.DataManager;
import pirate.events.xml.EventTemplate;
import pirate.events.xml.EventsData;

/**
 *
 * @author f14shm4n
 */
public enum EventType {

    E_DEFAULT(false),
    E_1x1(true),
    E_2x2(true),
    E_3x3(true),
    E_4x4(true),
    E_6x6(true),
    E_LHE(true),
    E_TVT(false),
    E_FFA(true);
    //-----------------------------//
    private boolean isDone;

    private EventType(boolean isDone) {
        this.isDone = isDone;
    }

    public boolean IsDone() {
        return isDone;
    }

    public EventTemplate getEventTemplate() {
        return DataManager.F14_EVENTS_DATA.getEventTemplate(this);
    }
}
