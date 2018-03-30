package pirate.events.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author flashman
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rItem")
public class EventRewardItem {

    @XmlAttribute(name = "item_id", required = true)
    private int itemId;
    @XmlAttribute(name = "count")
    private long count = 1;

    public long getCount() {
        return count;
    }

    public int getItemId() {
        return itemId;
    }
}
