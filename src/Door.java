import java.util.*;

/**
 * The type Door.
 */
public class Door implements Asset {

    /**
     * The Locked.
     */
    Boolean locked;
    /**
     * The Room one.
     */
    Room roomOne;
    /**
     * The Room two.
     */
    Room roomTwo;

    /**
     * Instantiates a new Door.
     *
     * @param locked  the locked
     * @param roomOne the room one
     * @param roomTwo the room two
     */
    Door( Boolean locked, Room roomOne, Room roomTwo ) {
        this.locked = locked;
        this.roomOne = roomOne;
        this.roomTwo = roomTwo;
    }

    @Override
    public String getName() {
        return "Door";
    }

    @Override
    public String getDescription() {
        if (locked) {
            return "This is a locked door";
        } else {
            return "This is an unlocked door";
        }
    }

    /**
     * Unlock door.
     *
     * @param key the key
     */
    public void unlockDoor(Item key) {
        if (key != null) {
            this.locked = false;
        }
    }

    /**
     * Use door.
     *
     * @param state the state
     */
    public void useDoor(State state ) {
        if (this.locked) {
            System.out.println("Door locked");
        } else {
            if (state.getRoom() == this.roomOne) {
                state.setRoom(this.roomTwo);
            } else {
                state.setRoom(roomOne);
            }
            System.out.println("----------------------------------------\n");
            System.out.println("Current Room: " + state.room.getName());
            System.out.println(" - " + state.room.getDescription());
            System.out.println("\n----------------------------------------\n");
        }

    }
}
