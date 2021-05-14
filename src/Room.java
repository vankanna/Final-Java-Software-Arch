import java.util.*;

/**
 * The type Room.
 */
public class Room implements Asset {

    /**
     * The North door.
     */
    Door northDoor;
    /**
     * The South door.
     */
    Door southDoor;
    /**
     * The West door.
     */
    Door westDoor;
    /**
     * The East door.
     */
    Door eastDoor;

    private final String name;
    private final String description;

    private List<Item> items;

    /**
     * Instantiates a new Room.
     *
     * @param name        the name
     * @param description the description
     */
    Room(String name, String description) {
        this.name = name;
        this.description = description;
         this.items = new ArrayList<Item>();
    }

    /**
     * Gets north door.
     *
     * @return the north door
     */
    public Door getNorthDoor() {
        return northDoor;
    }

    /**
     * Sets north door.
     *
     * @param northDoor the north door
     */
    public void setNorthDoor(Door northDoor) {
        this.northDoor = northDoor;
    }

    /**
     * Gets south door.
     *
     * @return the south door
     */
    public Door getSouthDoor() {
        return southDoor;
    }

    /**
     * Sets south door.
     *
     * @param southDoor the south door
     */
    public void setSouthDoor(Door southDoor) {
        this.southDoor = southDoor;
    }

    /**
     * Gets west door.
     *
     * @return the west door
     */
    public Door getWestDoor() {
        return westDoor;
    }

    /**
     * Sets west door.
     *
     * @param westDoor the west door
     */
    public void setWestDoor(Door westDoor) {
        this.westDoor = westDoor;
    }

    /**
     * Gets east door.
     *
     * @return the east door
     */
    public Door getEastDoor() {
        return eastDoor;
    }

    /**
     * Sets east door.
     *
     * @param eastDoor the east door
     */
    public void setEastDoor(Door eastDoor) {
        this.eastDoor = eastDoor;
    }

    /**
     * Add item.
     *
     * @param item the item
     */
    public void addItem(Item item) {
        this.items.add(item);
    }

    /**
     * Remove item item.
     *
     * @param itemName the item name
     * @return the item
     */
    public Item removeItem(String itemName) {
        int counter = 0;
        for(Item item : this.items) {

            if(item.getName().equals(itemName)) {
                this.items.remove(counter);
                return item;
            }
            counter += 1;
        }
        return null;
    }

    /**
     * List items.
     */
    public void listItems() {
        if(items.size() == 0 ) {
            System.out.println("There is nothing here.");
        } else {
            for (Item item : this.items) {
                System.out.println(item.getName());
                System.out.println(" - " + item.getDescription());
            }
        }
    }

    /**
     * List doors.
     */
    public void listDoors() {
        String doors = "";
        if (this.northDoor != null) {
            doors += "- North Door\n";
            doors += (" - " + this.northDoor.getDescription() + "\n");
        }
        if (this.southDoor != null) {
            doors += "- South Door\n";
            doors += (" - " + this.southDoor.getDescription() + "\n");
        }
        if (this.westDoor != null) {
            doors += "- West Door\n";
            doors += (" - " + this.westDoor.getDescription() + "\n");
        }
        if (this.eastDoor != null) {
            doors += "- East Door\n";
            doors += (" - " + this.eastDoor.getDescription() + "\n");
        }
        if (doors.equals("")) {
            doors += "There are no doors????";
        }
        System.out.println(doors);
    }

    /**
     * Use door.
     *
     * @param state the state
     */
    public void useDoor(State state) {
        String direction = state.getChoice();
        if(direction.contains("north")) {
            if (this.northDoor != null) {
                this.northDoor.useDoor(state);
            }
        } else if (direction.contains("south")) {
            if (this.southDoor != null) {
                this.southDoor.useDoor(state);
            }
        } else if (direction.contains("west")) {
            if (this.westDoor != null) {
                this.westDoor.useDoor(state);
            }
        } else if (direction.contains("east")) {
            if (this.eastDoor != null) {
                this.eastDoor.useDoor(state);
            }
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}
