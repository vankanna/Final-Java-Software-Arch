import java.util.*;


public class Main {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream.




	// write your code here
        Room westRoom = new Room();
        Room middleRoom = new Room();
        Room eastRoom = new Room();
        Door westToMiddle = new Door(false, false, westRoom, middleRoom);
        Door eastToMiddle = new Door(false, false, eastRoom, middleRoom);
        westRoom.eastDoor = westToMiddle;
        middleRoom.westDoor = westToMiddle;
        eastRoom.westDoor = eastToMiddle;
        middleRoom.eastDoor = eastToMiddle;
        //[westRoom]|[middleroom]|[eastRoom]

        // State
        Room _currentRoom = middleRoom;

        while (true) {
            System.out.println("What Would you Like To Do");
            String answer = sc.nextLine();

            if (answer.equals("list doors")) {
                System.out.println(_currentRoom.listDoors());
            }

            if (answer.equals(("use door"))) {

                _currentRoom.listDoors();
                System.out.println("Choose a door to use.");
                _currentRoom = _currentRoom.useDoor(_currentRoom, sc.nextLine());
            }

        }

    }
}
