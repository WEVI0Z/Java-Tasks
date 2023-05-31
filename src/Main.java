import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        TravelAgency travelAgency = new TravelAgency();

        travelAgency.createFlight("BelAvia", 2023, Calendar.JULY, 27);
        travelAgency.createFlight("BelAir", 2024, Calendar.JANUARY, 12);

        travelAgency.flights.forEach(System.out::println);

        List<Flight> foundFlights = travelAgency.searchFlights("e");

        foundFlights.forEach(flight -> System.out.printf("Flight #%d called %s goes %s \n", flight.id, flight.name, flight.flightDate.getTime()));

        travelAgency.bookFlightById(0);
        travelAgency.bookFlightById(1);

        travelAgency.removeFlightById(0);

        travelAgency.reservedFlights.forEach(flight -> System.out.println(flight.name));
    }
}

interface BookingObject {
    String getName();
}

class TravelAgency {
    ArrayList<Flight> flights = new ArrayList<Flight>();
    ArrayList<Flight> reservedFlights = new ArrayList<Flight>();
    ArrayList<Hotel> hotels = new ArrayList<Hotel>();
    ArrayList<Hotel> reservedHotels = new ArrayList<Hotel>();

    <T> T findById(ArrayList<T> array, int id) {
        return array.get(id);
    }

    <T extends BookingObject> List<T> search(ArrayList<T> array, String keyWord) {
        return array.stream().
                filter(item -> item.getName().toLowerCase().contains(keyWord.toLowerCase())).
                toList();
    }

    void createFlight(
            String flightName,
            int flightYear,
            int flightMonth,
            int flightDay
    ) {
        Calendar date = new GregorianCalendar(flightYear, flightMonth, flightDay);

        flights.add(new Flight(flightName, date));
    }

    List<Flight> searchFlights(String keyWord) {
        return this.search(this.flights, keyWord);
    }

    Flight findFlightById(int id) {
        return findById(this.flights, id);
    }

    void bookFlightById(int id) {
        Flight targetFlight = this.findFlightById(id);

        if (!this.reservedFlights.contains(targetFlight)) {
            this.reservedFlights.add(targetFlight);
        }
    }

    void removeFlightById(int id) {
        Flight targetFlight = this.findFlightById(id);

        this.reservedFlights.removeIf(flights -> flights.name.equals(targetFlight.name));
    }

    List<Hotel> searchHotels(String keyWord) {
        return this.search(this.hotels, keyWord);
    }

    Hotel findHotelById(int id) {
        return this.findById(this.hotels, id);
    }

    void bookHotelById(int id) {
        Hotel targetHotel = this.findById(this.hotels, id);

        if (!this.reservedHotels.contains(targetHotel)) {
            this.reservedHotels.add(targetHotel);
        }
    }

    void removeHotelById(int id) {
        Hotel targetHotel = this.findById(this.hotels, id);

        this.reservedHotels.removeIf(hotel -> hotel.name.equals(targetHotel.name));
    }
}

class Flight implements BookingObject {
    String name;
    int id;
    static int nextId = 0;
    Calendar flightDate;

    public String getName() {
        return this.name;
    }

    Flight(
            String name,
            Calendar flightDate
    ) {
        this.name = name;
        this.id = Flight.nextId++;
        this.flightDate = flightDate;
    }
}

class Hotel implements BookingObject {
    String name;
    int id;
    static int nextId = 0;
    Calendar bookingDate;

    public String getName() {
        return name;
    }

    Hotel(
            String name,
            Calendar bookingDate
    ) {
        this.id = Hotel.nextId++;
        this.name = name;
        this.bookingDate = bookingDate;
    }
}