package com.hotel;

import java.util.concurrent.ConcurrentHashMap;

public class BookingManager {
    // ConcurrentHashMap ensures thread safety for the collection
    private final ConcurrentHashMap<Integer, Room> rooms = new ConcurrentHashMap<>();

    public BookingManager(int totalRooms) {
        for (int i = 1; i <= totalRooms; i++) {
            rooms.put(i, new Room(i));
        }
    }

    // synchronized ensures no two threads can modify availability at the same time
    public synchronized boolean bookRoom(int roomId) {
        Room room = rooms.get(roomId);
        if (room != null && room.isAvailable()) {
            room.setAvailable(false);
            return true;
        }
        return false;
    }

    public synchronized boolean cancelBooking(int roomId) {
        Room room = rooms.get(roomId);
        if (room != null && !room.isAvailable()) {
            room.setAvailable(true);
            return true;
        }
        return false;
    }
    
    public boolean checkAvailability(int roomId) {
        Room room = rooms.get(roomId);
        return room != null && room.isAvailable();
    }
}
