import java.util.Scanner;

// This is a Singleton pattern
/**
 * The type Game manager.
 */
public class GameManager {

    private static final GameManager gameManager = new GameManager();

    private GameManager() {
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    /* Static 'instance' method */
    public static GameManager getInstance() {
        return gameManager;
    }

    /**
     *
     * @param input to be validated
     * @return Boolean
     */
    private Boolean validateInput(String input) {
        if (input.equals("")) {
            return false;
        }
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            return true;
        }
        return false;
    }

    /**
     * Gets input.
     *
     * @return the input
     */
    public static String getInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private void doChoice(State state) {
        String choice = state.getChoice();
        if (choice.contains("list doors")) {
            state.getRoom().listDoors();

        } else if (choice.contains("use") && choice.contains("door")) {
            state.getRoom().useDoor(state);

        } else if (choice.contains("search room")) {
            state.getRoom().listItems();

        } else if (choice.contains("pickup")) {
            String[] item = choice.split(" ");
            state.player.addItemToInventory(state.getRoom().removeItem(item[1]));

        } else if (choice.contains("list inventory")) {
            state.player.listInventory();
        } else if (choice.contains("use") && !choice.contains("door")) {
            String[] item = choice.split(" ");
            Item toBeUsed = state.player.useItem(item[1]);
            toBeUsed.use(state);
        } else {
            System.out.println("----- Help Menu -----");
            System.out.println("List of commands");
            System.out.println(" - 'list doors' ( lists doors in current room )");
            System.out.println(" - 'use [door direction] door' ( uses a door to go to a new room )");
            System.out.println(" - 'search room' ( checks room for items )");
            System.out.println(" - 'pickup [item name]' ( picks up the item you named )");
            System.out.println(" - 'list inventory' ( lists items you have in your inventory )");
            System.out.println(" - 'use [item name]' ( uses an item in your inventory )");
        }



    }

    /**
     * Run.
     *
     * @param state the state
     */
    public void run(State state) {
        state.setChoice("help");
        doChoice(state);
        System.out.println("----------------------------------------\n");
        System.out.println("Current Room: " + state.room.getName());
        System.out.println(" - " + state.room.getDescription());
        System.out.println("\n----------------------------------------\n");

        boolean playing = true;
        while (playing) {
            System.out.println("What will you do?");
            String choice = getInput();
            if (!validateInput(choice)) {
                System.out.println("Please Enter A Valid Choice.\n");
            } else if (choice.equals("quit")) {
                System.out.println("Quitting...");
                playing = false;
            } else {
                state.setChoice(choice);
                doChoice(state);
            }

            if(state.getRoom() == state.getEscapeRoom()) {
                System.out.println("You Won!");
                playing = false;
            }
        }
    }
}
