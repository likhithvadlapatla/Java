/*
Task: Bus Reservation

Parameters :

Source, Destination, Date of Journey, Bus Service No, Bus Type (Semi Sleeper / Sleeper), Total No of seats in a bus, Seat avail at current time, Ticker cost per person, No of Passengers, Gender, Source start time, Destination Reach Time

1. Create a bus  ( Source, Destination, Bus Type, No of Seats, Source start time, Destination Reach Time, Schedule (M,T,W,TH,F,S,SU) - It should create a bus with Bus Service Number ( 5 digit number)  ( Sleeper : 2 + 1 format ) - (Semi Sleeper - 2+2 Format) - Cost of the seat
2. Customer is coming and trying to book a ticket
3. Enter (Source, Destination, journey date, bus type (semi sleeper / Sleeper / Both) )
4. As per above filter criteria, we have to display the bus schedules
5. How many passengers, Gender, Passenger Name, Passenger Email ID, Mobile Number, Age
6. We have to show the seats booking info with seat numbers

              Seat No : Status ( 1 : (Booked / Not Booked  / Only for Female)

7. If the seat is in Not Booked status then only we have to allow for seat booking and check seat booking status for female)
8. We have to display the cost the seat
9. Go for the seat booking and we have to display the total cost of booking
10. Tax : 5%
11. Total Pay Cost
12. If pay is success, go for the ticket confirmation
13. Then, display the ticket details with ticket number ( Ticket number, Passenger details, Source and destination details, Date and Timings for Source and destination, Service No, Seat Number)
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;



class Bus {
    private static int busServiceNumberCounter = 10000;
    private final int busServiceNumber;
    private final String source;
    private final String destination;
    private final String busType;
    private final int totalSeats;
    private final String startTime;
    private final String reachTime;
    private final String schedule;
    private final double seatCost;
    private final List<Seat> seats;
    private final double taxRate;

    public Bus(String source, String destination, String busType, int totalSeats,
               String startTime, String reachTime, String schedule, double seatCost, double taxRate) {
        this.busServiceNumber = generateBusServiceNumber();
        this.source = source;
        this.destination = destination;
        this.busType = busType;
        this.totalSeats = totalSeats;
        this.startTime = startTime;
        this.reachTime = reachTime;
        this.schedule = schedule;
        this.seatCost = seatCost;
        this.seats = new ArrayList<>();
        this.taxRate = taxRate;
        initializeSeats();
    }

    public static int getBusServiceNumberCounter() {
        return busServiceNumberCounter;
    }

    public static void setBusServiceNumberCounter(final int busServiceNumberCounter) {
        Bus.busServiceNumberCounter = busServiceNumberCounter;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public String getBusType() {
        return busType;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getReachTime() {
        return reachTime;
    }

    public String getSchedule() {
        return schedule;
    }

    public double getSeatCost() {
        return seatCost;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    private int generateBusServiceNumber() {
        return busServiceNumberCounter++;
    }

    public double getTaxRate() {
        return taxRate;
    }

    private void initializeSeats() {
        for (int i = 1; i <= totalSeats; i++) {
            boolean femaleOnly = (i % 3 == 0);
            seats.add(new Seat(i, femaleOnly));
        }
    }

    public int getBusServiceNumber() {
        return busServiceNumber;
    }

    public void displayBusDetails() {
        System.out.println("\nBus Service Number: " + busServiceNumber);
        System.out.println("Source: " + source);
        System.out.println("Destination: " + destination);
        System.out.println("Bus Type: " + busType);
        System.out.println("Total Seats: " + totalSeats);
        System.out.println("Start Time: " + startTime);
        System.out.println("Reach Time: " + reachTime);
        System.out.println("Schedule: " + schedule);
        System.out.println("Seat Cost: " + seatCost);
        System.out.println("Tax Rate: " + taxRate + "%");
        System.out.println("Available Seats: ");
        for (Seat seat : seats) {
            String seatStatus;
            if (seat.isBooked()) {
                seatStatus = "Booked";
            } else {
                if (seat.isFemaleOnly()) {
                    seatStatus = "Female Seat";
                } else {
                    seatStatus = "Available";
                }
            }
            System.out.println("Seat " + seat.getSeatNumber() + ": " + seatStatus);
        }
    }

    public List<Seat> getAvailableSeats() {
        return seats;
    }
}

class Seat {
    private final int seatNumber;
    private boolean booked;
    private final boolean femaleOnly;

    public Seat(int seatNumber, boolean femaleOnly) {
        this.seatNumber = seatNumber;
        this.booked = false;
        this.femaleOnly = femaleOnly;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public boolean isBooked() {
        return booked;
    }

    public boolean isFemaleOnly() {
        return femaleOnly;
    }

    public void bookSeat() {
        booked = true;
    }
}

class Passenger {
    private final String name;
    private final String email;
    private final String mobileNumber;
    private final int age;
    private final String gender;

    public Passenger(String name, String email, String mobileNumber, int age, String gender) {
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
}

class TicketDetails {
    private static int ticketNumberCounter = 500;
    private final int ticketNumber;
    private final Bus bus;
    private final Passenger passenger;
    private final Seat seat;
    private final double totalCost;

    public TicketDetails(Bus bus, Passenger passenger, Seat seat, double totalCost) {
        this.ticketNumber = generateTicketNumber();
        this.bus = bus;
        this.passenger = passenger;
        this.seat = seat;
        this.totalCost = totalCost;
    }

    private int generateTicketNumber() {
        return ++ticketNumberCounter;
    }

    public void displayTicketDetails() {
        System.out.println("\nTicket Details:");
        System.out.println("Ticket Number: " + ticketNumber);
        System.out.println("Bus Service Number: " + bus.getBusServiceNumber());
        System.out.println("Source: " + bus.getSource());
        System.out.println("Destination: " + bus.getDestination());
        System.out.println("Passenger Name: " + passenger.getName());
        System.out.println("Passenger Email: " + passenger.getEmail());
        System.out.println("Seat Number: " + seat.getSeatNumber());
        System.out.println("Total Cost: " + totalCost);
    }
}

public class BusReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create multiple buses
        System.out.println("Enter the number of buses to create:");
        int numberOfBuses = scanner.nextInt();
        List<Bus> buses = createBuses(scanner, numberOfBuses);

        // Display details of all created buses
        for (Bus bus : buses) {
            bus.displayBusDetails();
        }

        // Allow user to book tickets for each bus
        for (Bus bus : buses) {
            bookTickets(bus, scanner);
        }

        // Close the scanner
        scanner.close();
    }

    private static List<Bus> createBuses(Scanner scanner, int numberOfBuses) {
        List<Bus> buses = new ArrayList<>();
        for (int i = 1; i <= numberOfBuses; i++) {
            System.out.println("\nEnter details to create Bus #" + i + ":");
            buses.add(createBus(scanner));
        }
        return buses;
    }

    private static Bus createBus(Scanner scanner) {
        System.out.println("Enter Source:");
        String source = scanner.next();

        System.out.println("Enter Destination:");
        String destination = scanner.next();

        System.out.println("Enter Bus Type (Sleeper/Semi-Sleeper):");
        String busType = scanner.next();

        System.out.println("Enter Total Seats:");
        int totalSeats = scanner.nextInt();

        System.out.println("Enter Start Time:");
        String startTime = scanner.next();

        System.out.println("Enter Reach Time:");
        String reachTime = scanner.next();

        System.out.println("Enter Schedule (e.g., Monday or Wednesday or Friday):");
        String schedule = scanner.next();

        System.out.println("Enter Seat Cost:");
        double seatCost = scanner.nextDouble();

        System.out.println("Enter Tax Rate (%):");
        double taxRate = scanner.nextDouble();

        return new Bus(source, destination, busType, totalSeats, startTime, reachTime, schedule, seatCost, taxRate);
    }

    private static void bookTickets(Bus bus, Scanner scanner) {
        System.out.println("\nEnter details to book tickets:");

        System.out.println("Enter Source:");
        String source = scanner.next();

        System.out.println("Enter Destination:");
        String destination = scanner.next();

        System.out.println("Enter Journey Date:");
        String journeyDate = scanner.next();

        System.out.println("Enter Bus Type (Sleeper/SemiSleeper/Both):");
        String busType = scanner.next();

        List<Seat> availableSeats = getAvailableSeats(bus, busType);
        if (availableSeats.isEmpty()) {
            System.out.println("No available seats matching the criteria.");
            return;
        }

        System.out.println("How many passengers?");
        int numPassengers = scanner.nextInt();

        List<TicketDetails> bookedTickets = new ArrayList<>();

        for (int i = 1; i <= numPassengers; i++) {
            System.out.println("\nEnter details for Passenger " + i + ":");

            System.out.println("Enter Passenger Name:");
            String name = scanner.next();

            System.out.println("Enter Passenger Email:");
            String email = scanner.next();

            System.out.println("Enter Passenger Mobile Number:");
            String mobileNumber = scanner.next();

            System.out.println("Enter Passenger Age:");
            int age = scanner.nextInt();

            System.out.println("Enter Passenger Gender:");
            String gender = scanner.next();

            Passenger passenger = new Passenger(name, email, mobileNumber, age, gender);

            Seat selectedSeat = selectSeat(availableSeats, scanner);

            if (selectedSeat == null) {
                System.out.println("Seat selection canceled. Exiting ticket booking.");
                return;
            }

            double totalCost = calculateTotalCost(selectedSeat, bus);
            System.out.println("Total Cost for Passenger " + i + ": " + totalCost);

            // Handle payment and confirmation (not implemented here)
            // ...

            // Book the seat
            selectedSeat.bookSeat();

            // Create a ticket
            TicketDetails ticket = new TicketDetails(bus, passenger, selectedSeat, totalCost);
            bookedTickets.add(ticket);

            System.out.println("\nTicket booked successfully for Passenger " + i + "!");
            ticket.displayTicketDetails();
        }
    }

    private static List<Seat> getAvailableSeats(Bus bus, String busType) {
        List<Seat> availableSeats = new ArrayList<>();
        for (Seat seat : bus.getAvailableSeats()) {
            if (busType.equalsIgnoreCase("both") || busType.equalsIgnoreCase(bus.getBusType())) {
                availableSeats.add(seat);
            }
        }
        return availableSeats;
    }

    private static Seat selectSeat(List<Seat> availableSeats, Scanner scanner) {
        System.out.println("\nAvailable Seats:");
        for (Seat seat : availableSeats) {
            System.out.println("Seat " + seat.getSeatNumber() +
                    " (" + (seat.isBooked() ? "Booked" : "Available") + ")");
        }

        System.out.println("Enter Seat Number to book (or 0 to cancel):");
        int seatNumber = scanner.nextInt();

        if (seatNumber == 0) {
            return null; // User canceled seat selection
        }

        for (Seat seat : availableSeats) {
            if (seat.getSeatNumber() == seatNumber) {
                return seat;
            }
        }

        System.out.println("Invalid seat number. Seat selection canceled.");
        return null;
    }

    private static double calculateTotalCost(Seat seat, Bus bus) {
        double baseCost = bus.getSeatCost();
        double taxRate = 0.05; // 5%
        return baseCost + (baseCost * taxRate);
    }
}