package com.hotel;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BookingTest {
    @Test
    void testSuccessfulBooking() {
        BookingManager bm = new BookingManager(5);
        assertTrue(bm.bookRoom(1));
    }

    @Test
    void testDoubleBookingPrevented() {
        BookingManager bm = new BookingManager(5);
        bm.bookRoom(1);
        assertFalse(bm.bookRoom(1)); // Second attempt must fail
    }
}
