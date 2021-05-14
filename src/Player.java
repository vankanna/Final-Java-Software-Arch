import java.util.ArrayList;
import java.util.List;
// This is a Singleton pattern
/**
 * The type Player.
 */
public class Player {
    private static final Player player = new Player();

    private List<Item> items;

    private Player() {
        this.items = new ArrayList<Item>();
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static Player getInstance() {
        return player;
    }

    /**
     * Add item to inventory.
     *
     * @param item the item
     */
    public void addItemToInventory(Item item) {
        items.add(item);
    }

    /**
     * List inventory.
     */
    public void listInventory(){
        System.out.println("Player Inventory");
        if(this.items.size() == 0) {
            System.out.println("You have no items.");
        } else {
            for (Item item : this.items) {
                System.out.println(item.getName());
                System.out.println(" - " + item.getDescription());
            }
        }
    }

    /**
     * Use item item.
     *
     * @param itemName the item name
     * @return the item
     */
    public Item useItem(String itemName) {
        int counter = 0;
        for(Item item : this.items) {

            if(item.getName().equals(itemName)) {
                this.items.remove(counter);
                return item;
            }
            counter += 1;
        }
        System.out.println("You don't have that item: " + itemName);
        return null;
    }

    /**
     * Gets item from inventory.
     *
     * @param name the name
     * @return the item from inventory
     */
    public Item getItemFromInventory(String name) {
        // loop through items find a match.
        return new Key("Key", "key");
    }
}
