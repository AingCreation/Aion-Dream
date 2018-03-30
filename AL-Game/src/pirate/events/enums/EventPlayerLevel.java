package pirate.events.enums;

/**
 *
 * @author flashman
 */
public enum EventPlayerLevel {

    L_DEFAULT(false, 20, 60),
    L20_30(true, 20, 30),	
	L30_40(true, 31, 40),	
	L40_50(true, 41, 50),	
	L50_55(true, 51, 55),	
	L55_60(true, 56, 60),	
	L60_66(true, 60, 66),	
	L66_76(true, 66, 76);
    private boolean regular;
    private int min;
    private int max;

    private EventPlayerLevel(boolean regular, int min, int max) {
        this.regular = regular;
        this.min = min;
        this.max = max;
    }

    public boolean isRegularLevelGroup() {
        return this.regular;
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }

    /**
     * Returns eventa level for the current level of the player.
     *
     * @param lvl
     * @return If the player is not suitable for participation in eventah, then
     * back L_DEFAULT
     */
    public static EventPlayerLevel getEventLevelByPlayerLevel(byte lvl) {
        for (EventPlayerLevel epl : values()) {
            if (lvl >= epl.getMin() && lvl <= epl.getMax() && epl.isRegularLevelGroup()) {
                return epl;
            }
        }
        return EventPlayerLevel.L_DEFAULT;
    }
}
