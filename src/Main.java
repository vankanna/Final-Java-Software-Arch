import java.util.*;


public class Main {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream.



	    // write your code here
        Room dinningRoom = new Room("Dinning Room", "A normal dinning room, nothing suspicious.");
        Room kitchen = new Room("Kitchen", "A large kitchen with many utensils and drawer.");
        Room livingRoom = new Room("Living Room", "A very strange room, only one chair sitting in the middle.");
        Room wineCellar = new Room("Wine Cellar", "A musty Wine Cellar, all the wine is 5 dollar bottles from Wallmart");
        Room pantry = new Room("Pantry", "A typical Pantry full of food.");
        Room attic = new Room("Attic", "A dry Attic full of cobwebs and cardboard boxes.");
        Room masterBedroom = new Room("Master Bedroom", "A master bedroom with typical furniture");
        Room greenhouse = new Room("Green House", "A greenhouse full of plants and possibly mysterious creatures.");
        Room laundryRoom = new Room("Laundry Room", "Dirty close and a washer and dryer");
        Room library = new Room("Library", "A room filled with shelves and shelves of books.");
        Room entrance = new Room("Entrance", "A place to enter or exit the house.");

        // MAP                          N
        //                         [entrance]
        //                         [livingroom]
        //  W             [library][dinningroom][kitchen][pantry][wine celler]  E
        //             [greenhouse][master bedroom][laundry]
        //                         [attic]
        //                             S
        Door entrance_livingRoom = new Door(true, entrance, livingRoom);
        entrance.southDoor = entrance_livingRoom;
        livingRoom.northDoor = entrance_livingRoom;
        Door livingRoom_dinningRoom = new Door(true, livingRoom, dinningRoom);
        livingRoom.southDoor = livingRoom_dinningRoom;
        dinningRoom.northDoor = livingRoom_dinningRoom;
        Door dinningRoom_library = new Door(true, dinningRoom, library);
        dinningRoom.westDoor = dinningRoom_library;
        library.eastDoor = dinningRoom_library;
        Door dinningRoom_kitchen = new Door(false, dinningRoom, kitchen);
        dinningRoom.eastDoor = dinningRoom_kitchen;
        kitchen.westDoor = dinningRoom_kitchen;
        Door dinningRoom_masterBedroom = new Door(true, dinningRoom, masterBedroom);
        dinningRoom.southDoor = dinningRoom_masterBedroom;
        masterBedroom.northDoor = dinningRoom_masterBedroom;
        Door kitchen_pantry = new Door(false, kitchen, pantry);
        kitchen.eastDoor = kitchen_pantry;
        pantry.westDoor = kitchen_pantry;
        Door kitchen_laundry = new Door(false, kitchen, laundryRoom);
        kitchen.southDoor = kitchen_laundry;
        laundryRoom.northDoor = kitchen_laundry;
        Door pantry_wineCellar = new Door(true, pantry, wineCellar);
        pantry.eastDoor = pantry_wineCellar;
        wineCellar.westDoor = pantry_wineCellar;
        Door masterBedroom_greenhouse = new Door(false, masterBedroom, greenhouse);
        masterBedroom.westDoor = masterBedroom_greenhouse;
        greenhouse.eastDoor = masterBedroom_greenhouse;
        Door masterBedroom_laundry = new Door(false, masterBedroom, laundryRoom);
        masterBedroom.eastDoor = masterBedroom_laundry;
        laundryRoom.westDoor = masterBedroom_laundry;
        Door masterBedroom_attic = new Door(true, masterBedroom, attic);
        masterBedroom.southDoor = masterBedroom_attic;
        attic.northDoor = masterBedroom_attic;

        // items

        Key atticKey = (Key) ItemFactory.getItem("key");
        Key masterBedroomKey = (Key) ItemFactory.getItem("key");
        Key kitchenKey = (Key) ItemFactory.getItem("key");
        Key libraryKey = (Key) ItemFactory.getItem("key");
        Key pantryKey = (Key) ItemFactory.getItem("key");

        Food kitchenFood = (Food) ItemFactory.getItem("food");
        Food pantryFood = (Food) ItemFactory.getItem("food");


        attic.addItem(atticKey);
        kitchen.addItem(kitchenFood);
        kitchen.addItem(kitchenKey);
        masterBedroom.addItem(masterBedroomKey);
        library.addItem(libraryKey);
        pantry.addItem(pantryKey);
        pantry.addItem(pantryFood);



        // State
        Player player = Player.getInstance();
        State state = new State(player, attic);
        state.setEscapeRoom(entrance);
        GameManager gameManager = GameManager.getInstance();
        gameManager.run(state);
    }
}
