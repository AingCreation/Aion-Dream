package pirate.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**

 @author flashman
 */
public class TimeUtil {

    /**
     Converts a time in seconds, in the format <tt>Hour, minute, second</tt>

     @param time time in seconds
     @return <tt>int[hours,minutes,seconds]</tt>
     */
    public static int[] getHMS(int time) {
        int[] hms = new int[3];

        int s = getClearValue(time);
        int m = getClearValue((int) Math.floor(time / 60));
        int h = (int) Math.floor((time / 60) / 60);

        hms[0] = h;
        hms[1] = m;
        hms[2] = s;

        return hms;
    }

    /**
     Converts an array containing h m s a string representation.

     @param hms array h m s
     @return line of the form - <tt>0 h. 0 m. 0 s.</tt>
     */
    public static String convertToString(int[] hms) {
        if (hms[0] > 0) {
            return String.format("%s h. %s m. %s s.", hms[0], hms[1], hms[2]);
        }
        if (hms[1] > 0) {
            return String.format("%s m. %s s.", hms[1], hms[2]);
        }
        return String.format("%s s.", hms[2]);
    }

    /**
     Converts a time in seconds to a string representation.

     @param time time in seconds
     @return line of the form - <tt>0 h. 0 m. 0 s.</tt>
     */
    public static String convertToString(int time) {
        try {
            return convertToString(getHMS(time));
        } catch (Exception ex) {
            LoggerFactory.getLogger(TimeUtil.class).error("Error while converting time: ", ex);
            return null;
        }
    }

    private static int getClearValue(int time) {
        int v1 = (int) Math.floor(time / 60);
        int v2 = time - v1 * 60;
        return v2;
    }
}
