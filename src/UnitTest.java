import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UnitTest {

    private final Room roomOne = new Room("roomOne", "This is room one");
    private final Room roomTwo = new Room("roomTwo", "This is room two");
    private final Door door = new Door(true, roomOne, roomTwo );
    private final Item key = new Key("Key", "This is a key");
    private final Player player = Player.getInstance();
    private final State state = new State(player, roomOne);


    @BeforeEach
    public void setUp() throws Exception {
        roomOne.southDoor = door;
        roomTwo.northDoor = door;
    }
    @Test
    void testDoorFunctionality() {
        assertEquals("Door", door.getName());
        assertEquals("This is a locked door", door.getDescription());
        // unlock door
        door.unlockDoor(key);
        //check if door is unlocked
        assertEquals("This is an unlocked door", door.getDescription());
        //test use door scenario
        state.setChoice("use south door");
        assertEquals(roomOne, state.getRoom());
        roomOne.useDoor(state);
        assertEquals(roomTwo, state.getRoom());
    }

    @Test
    void testStateFunctionality() {
        State state = new State(player, roomOne);
        assertEquals(state.getPlayer(), player);
        assertEquals(state.getRoom(), roomOne);
        state.setEscapeRoom(roomTwo);
        assertEquals(state.getEscapeRoom(), roomTwo);
        state.setChoice("test");
        assertEquals(state.getChoice(), "test");
    }

}