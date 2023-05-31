import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        TravelAgency travelAgency = new TravelAgency();

        travelAgency.createFlight("BelAvia", 2023, 7, 27);
        travelAgency.createFlight("BelAir", 2024, 1, 12);

        travelAgency.flights.forEach(System.out::println);

        List<Flight> foundFlights = travelAgency.searchFlights("e");

        foundFlights.forEach(flight -> System.out.printf("Flight #%d called %s goes %s \n", flight.getId(), flight.getName(), flight.getDate()));

        travelAgency.bookFlightById(0);
        travelAgency.bookFlightById(1);

        travelAgency.removeFlightById(0);

        travelAgency.reservedFlights.forEach(flight -> System.out.println(flight.getName()));
    }
}

interface BookingObject {
    String getName();
    int getId();
    LocalDate getDate();
}

class TravelAgency {
    public ArrayList<Flight> flights = new ArrayList<>();
    public ArrayList<Flight> reservedFlights = new ArrayList<>();
    public ArrayList<Hotel> hotels = new ArrayList<>();
    public ArrayList<Hotel> reservedHotels = new ArrayList<>();

    private <T extends BookingObject> T findById(List<T> array, int id) {
        return array.stream().filter(item -> item.getId() == id).findFirst().get();
    }

    private <T extends BookingObject> List<T> search(List<T> array, String keyWord) {
        return array.stream().
                filter(item -> item.getName().toLowerCase().contains(keyWord.toLowerCase())).
                toList();
    }

    public void createFlight(
            String flightName,
            int flightYear,
            int flightMonth,
            int flightDay
    ) {
        LocalDate date = LocalDate.of(flightYear, flightMonth, flightDay);

        flights.add(new Flight(flightName, date));
    }

    public List<Flight> searchFlights(String keyWord) {
        return this.search(this.flights, keyWord);
    }

    public Flight findFlightById(int id) {
        return findById(this.flights, id);
    }

    public void bookFlightById(int id) {
        Flight targetFlight = this.findFlightById(id);

        if (!this.reservedFlights.contains(targetFlight)) {
            this.reservedFlights.add(targetFlight);
        }
    }

    public void removeFlightById(int id) {
        Flight targetFlight = this.findFlightById(id);

        this.reservedFlights.removeIf(flights -> flights.getName().equals(targetFlight.getName()));
    }

    public List<Hotel> searchHotels(String keyWord) {
        return this.search(this.hotels, keyWord);
    }

    public Hotel findHotelById(int id) {
        return this.findById(this.hotels, id);
    }

    public void bookHotelById(int id) {
        Hotel targetHotel = this.findById(this.hotels, id);

        if (!this.reservedHotels.contains(targetHotel)) {
            this.reservedHotels.add(targetHotel);
        }
    }

    public void removeHotelById(int id) {
        Hotel targetHotel = this.findById(this.hotels, id);

        this.reservedHotels.removeIf(hotel -> hotel.getName().equals(targetHotel.getName()));
    }
}

class Flight implements BookingObject {
    private final String name;
    private final int id;
    private final static AtomicInteger nextId = new AtomicInteger(0);
    private final LocalDate bookingDate;

    public Flight(
            String name,
            LocalDate bookingDate
    ) {
        this.id = Flight.nextId.getAndIncrement();
        this.name = name;
        this.bookingDate = bookingDate;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public LocalDate getDate() {
        return this.bookingDate;
    }
}

class Hotel implements BookingObject {
    private final String name;
    private final int id;
    private final static AtomicInteger nextId = new AtomicInteger(0);
    private final LocalDate bookingDate;

    public Hotel(
            String name,
            LocalDate bookingDate
    ) {
        this.id = Hotel.nextId.getAndIncrement();
        this.name = name;
        this.bookingDate = bookingDate;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public LocalDate getDate() {
        return this.bookingDate;
    }
}