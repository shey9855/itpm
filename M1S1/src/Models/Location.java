package Models;

public class Location {

    private int id;
    private String building;
    private String room;
    private String room_type;
    private int capacity;

    public Location() {
    }

    public Location(int id) {
        this.id = id;
    }

    public Location(int id, String building, String room, String room_type, int capacity) {
        this.id = id;
        this.building = building;
        this.room = room;
        this.room_type = room_type;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

}
