package pirate.events.xml;

import com.aionemu.commons.utils.Rnd;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javolution.util.FastList;

/**
 *
 * @author f14shm4n
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rItemGroup")
public class EventRewardItemGroup {

    // If true - that of the entire group of objects is selected specified number of items
    @XmlAttribute(name = "random")
    public boolean isRandom = false;
    @XmlAttribute(name = "random_count")
    public int randomCount = 1;
    @XmlElement(name = "item")
    public List<EventRewardItem> items;

    public boolean isRandom() {
        return isRandom;
    }

    public int getRandomCount() {
        return randomCount;
    }

    public List<EventRewardItem> getItems() {
        if (this.items == null) {
            this.items = new ArrayList<EventRewardItem>();
        }
        if (this.isRandom) {
            List<EventRewardItem> result = new FastList<EventRewardItem>(items);
            while (result.size() > this.randomCount) {
                result.remove(Rnd.get(0, result.size() - 1));
            }
            return result;
        }
        return items;
    }
}
