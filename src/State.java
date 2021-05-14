/**
 * The type State.
 */
public class State {

    /**
     * The Room.
     */
    Room room;
    /**
     * The Player.
     */
    Player player;
    /**
     * The Choice.
     */
    String choice;


    /**
     * The Escape room.
     */
    Room escapeRoom;

    /**
     * Gets escape room.
     *
     * @return the escape room
     */
    public Room getEscapeRoom() {
        return escapeRoom;
    }

    /**
     * Sets escape room.
     *
     * @param escapeRoom the escape room
     */
    public void setEscapeRoom(Room escapeRoom) {
        this.escapeRoom = escapeRoom;
    }


    /**
     * Instantiates a new State.
     *
     * @param player the player
     * @param room   the room
     */
    public State(Player player, Room room) {
        this.player = player;
        this.room = room;
    }

    /**
     * Gets room.
     *
     * @return the room
     */
    public Room getRoom() {
        return room;
    }

    /**
     * Sets room.
     *
     * @param room the room
     */
    public void setRoom(Room room) {
        this.room = room;
    }

    /**
     * Gets player.
     *
     * @return the player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Sets player.
     *
     * @param player the player
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * Gets choice.
     *
     * @return the choice
     */
    public String getChoice() {
        return choice;
    }

    /**
     * Sets choice.
     *
     * @param choice the choice
     */
    public void setChoice(String choice) {
        this.choice = choice;
    }
}
