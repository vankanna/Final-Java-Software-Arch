// this is the Factory Pattern
/**
 * The type Item factory.
 */
public class ItemFactory {

    /**
     * Get item item.
     *
     * @param itemType the item type
     * @return the item
     */
    public static Item getItem(String itemType){
        if(itemType == null){
            return null;
        }
        if(itemType.equalsIgnoreCase("key")) {
            return new Key("key", "Used for unlocking doors.");
        } else if(itemType.equalsIgnoreCase("food")){
            return new Food ("food", "you can eat this!");
        }

        return null;
    }
}
