package ru.itis.inf501.lab2_8.booking;

import java.util.List;

public class BookingData {
    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    private List<Booking> bookings;
}
