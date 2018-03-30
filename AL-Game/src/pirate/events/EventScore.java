package pirate.events;

/**
 *
 * @author f14shm4n
 */
public class EventScore implements Comparable<EventScore> {

    public final int PlayerObjectId;
    public boolean isWinner;
    private int points;
    private int kills;
    private int death;
    private int wins;
    private int loses;
    private int killStreak;
    private int endKillStreak;

    public EventScore(int id) {
        this.PlayerObjectId = id;
        this.isWinner = false;
    }

    public void incKills() {
        this.kills += 1;
        this.killStreak += 1;
    }

    public void incDeath() {
        this.death += 1;
        this.endKillStreak = killStreak;
        this.killStreak = 0;
    }

    public void incWin() {
        this.wins += 1;
    }

    public void incLose() {
        this.loses += 1;
    }

    public void incPoints(int points) {
        this.points += points;
        if (this.points < 0) {
            this.points = 0;
        }
    }

    public int getEndStreak() {
        return this.endKillStreak;
    }

    public int getStreak() {
        return this.killStreak;
    }

    public void setStreak(int streak) {
        this.killStreak = streak;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getDeath() {
        return death;
    }

    public void setDeath(int death) {
        this.death = death;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLoses() {
        return loses;
    }

    public void setLoses(int loses) {
        this.loses = loses;
    }

    @Override
    public int compareTo(EventScore o) {
        Integer p1 = points;
        Integer p2 = o.points;
        return p2.compareTo(p1);
    }
}
