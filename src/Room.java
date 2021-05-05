import java.awt.*;

public class Room {

    Door northDoor;
    Door southDoor;
    Door westDoor;
    Door eastDoor;

    Room() {

    }

    public Door getNorthDoor() {
        return northDoor;
    }

    public void setNorthDoor(Door northDoor) {
        this.northDoor = northDoor;
    }

    public Door getSouthDoor() {
        return southDoor;
    }

    public void setSouthDoor(Door southDoor) {
        this.southDoor = southDoor;
    }

    public Door getWestDoor() {
        return westDoor;
    }

    public void setWestDoor(Door westDoor) {
        this.westDoor = westDoor;
    }

    public Door getEastDoor() {
        return eastDoor;
    }

    public void setEastDoor(Door eastDoor) {
        this.eastDoor = eastDoor;
    }

    public String listDoors() {
        String doors = "";
        if (this.northDoor != null) {
            doors += "- North Door\n";
        }
        if (this.southDoor != null) {
            doors += "- South Door\n";
        }
        if (this.westDoor != null) {
            doors += "- West Door\n";
        }
        if (this.eastDoor != null) {
            doors += "- East Door\n";
        }
        if (doors.equals("")) {
            doors += "There are no doors????";
        }
        return doors;
    }

    public Room useDoor(Room room, String direction) {
        if(direction.contains("north")) {
            if (this.northDoor != null) {
                return this.northDoor.changeRoom(room);
            }
        } else if (direction.contains("south")) {
            if (this.southDoor != null) {
                return this.southDoor.changeRoom(room);
            }
        } else if (direction.contains("west")) {
            if (this.westDoor != null) {
                return this.westDoor.changeRoom(room);
            }
        } else if (direction.contains("east")) {
            if (this.eastDoor != null) {
                return this.eastDoor.changeRoom(room);
            }
        }
        return room;
    }
}
