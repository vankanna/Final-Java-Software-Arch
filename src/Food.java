/**
 * The type Food.
 */
public class Food implements Item {

    /**
     * The Pickup able.
     */
    Boolean pickupAble = true;
    private final String name;
    private final String description;

    /**
     * Instantiates a new Food.
     *
     * @param name        the name
     * @param description the description
     */
    public Food(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public void use(State state) {
        System.out.println("You ate the food, why would you eat the food in a strange house?");
    }
}
