package rymko.bookingdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;


@SpringBootTest
class BookingControllerTest {

    @Autowired
    private BookingController bookingController;

    @Test
    void getAll() {
        List<HotelBooking> allHotelBookings = bookingController.getAll();
        Assertions.assertEquals(3, allHotelBookings.size());
    }

    @Test
    void getAffordable() {
        List<HotelBooking> affordableHotelBookings = bookingController.getAffordable(100);
        Assertions.assertEquals(1, affordableHotelBookings.size());
    }

    @Test
    void create() {
        HotelBooking hotelBooking = new HotelBooking("Grodno Hotel", 500, 7);
        bookingController.create(hotelBooking);
        Assertions.assertEquals(4, bookingController.getAll().size());
    }

    @Test
    void remove() {
        bookingController.remove(1);
        Optional<HotelBooking> hotelBooking1 = bookingController.getAll().stream()
                .filter(hotelBooking -> hotelBooking.getId() == 1)
                .findFirst();
        Assertions.assertTrue(hotelBooking1.isEmpty());
        Assertions.assertEquals(2,bookingController.getAll().size());
    }
}