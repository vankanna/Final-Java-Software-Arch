public class Key implements Item {

    Boolean pickupAble = true;
    private String name;
    private final String description;

    public Key(String name, String description) {
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
        System.out.println("Which Door would you like to unlock?");
        String door = GameManager.getInput();
        if (door.equals("north")) {
            state.getRoom().northDoor.unlockDoor(this);
        } else if (door.equals("south")) {
            state.getRoom().northDoor.unlockDoor(this);
        } else if (door.equals("west")) {
            state.getRoom().northDoor.unlockDoor(this);
        } else if (door.equals("east")) {
            state.getRoom().northDoor.unlockDoor(this);

        }

    }
}
