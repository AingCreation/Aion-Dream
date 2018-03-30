package pirate.events.xml;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author flashman
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EventReward")
public class EventRewardTemplate {

    @XmlElement(name = "rank")
    private List<EventRankTemplate> rankRewards;

    public List<EventRankTemplate> getRankRewards() {
        return rankRewards;
    }

    public EventRankTemplate getRewardByRank(int rank) {
        for (EventRankTemplate rt : this.rankRewards) {
            if (rt.getRankId() == rank) {
                return rt;
            }
        }
        return null;
    }
}
