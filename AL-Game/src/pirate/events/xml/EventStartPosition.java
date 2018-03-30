package pirate.events.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author f14shm4n
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EventStartPosition")
public class EventStartPosition {

    @XmlAttribute(name = "x")
    protected int x;
    @XmlAttribute(name = "y")
    protected int y;
    @XmlAttribute(name = "z")
    protected int z;
    @XmlAttribute(name = "h")
    protected byte h;
    @XmlAttribute(name = "group")
    protected int group = 0;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public byte getH() {
        return h;
    }

    public int getGroup() {
        return group;
    }
}
