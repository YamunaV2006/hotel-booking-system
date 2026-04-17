package com.hotel;

public class Room {
    private int id;
    private boolean isAvailable;

    public Room(int id) {
        this.id = id;
        this.isAvailable = true; // Rooms are available by default
    }

    public int getId() {
        return id;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
