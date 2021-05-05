import java.util.*;

public class Door implements Asset {

    Boolean needsKey;
    Boolean locked;
    Room roomOne;
    Room roomTwo;

    Door(Boolean needsKey, Boolean locked, Room roomOne, Room roomTwo) {
        this.needsKey = needsKey;
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

    public Room changeRoom(Room currentRoom) {
        if (currentRoom == roomOne) {
            return roomTwo;
        } else {
            return roomOne;
        }
    }
}
