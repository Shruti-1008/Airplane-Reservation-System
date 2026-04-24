import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Flight {
    int id;
    String route;
    int seats;
    int price;

    Flight(int id, String route, int seats, int price) {
        this.id = id;
        this.route = route;
        this.seats = seats;
        this.price = price;
    }
}

class Passenger {
    String name;
    int score;
    int trips;
    int cancellations;
    String preferredRoute;

    Passenger(String name, int score, int trips, int cancellations, String route) {
        this.name = name;
        this.score = score;
        this.trips = trips;
        this.cancellations = cancellations;
        this.preferredRoute = route;
    }
}

public class AirlineReservation {

    static List<Flight> flights = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Sample flights
        flights.add(new Flight(1, "Chennai-Delhi", 3, 5000));
        flights.add(new Flight(2, "Chennai-Mumbai", 2, 4500));
        flights.add(new Flight(3, "Chennai-Bangalore", 5, 2000));

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        Passenger user = loadUser(name);

        while (true) {
            System.out.println("\n--- Airline System ---");
            System.out.println("1. View Flights");
            System.out.println("2. Book Ticket");
            System.out.println("3. Cancel Ticket");
            System.out.println("4. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    viewFlights();
                    break;
                case 2:
                    bookTicket(user);
                    break;
                case 3:
                    cancelTicket(user);
                    break;
                case 4:
                    saveUser(user);
                    System.out.println("Thank you!");
                    return;
            }
        }
    }

    // ---------------- LOAD USER ----------------
    static Passenger loadUser(String name) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("users.txt"));
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equalsIgnoreCase(name)) {
                    br.close();
                    return new Passenger(
                        data[0],
                        Integer.parseInt(data[1]),
                        Integer.parseInt(data[2]),
                        Integer.parseInt(data[3]),
                        data[4]
                    );
                }
            }
            br.close();
        } catch (Exception e) {}

        return new Passenger(name, 0, 0, 0, "None");
    }

    // ---------------- SAVE USER ----------------
    static void saveUser(Passenger user) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("users.txt", true));
            bw.write(user.name + "," + user.score + "," + user.trips + "," + user.cancellations + "," + user.preferredRoute);
            bw.newLine();
            bw.close();
        } catch (Exception e) {}
    }

    // ---------------- VIEW FLIGHTS ----------------
    static void viewFlights() {
        for (Flight f : flights) {
            System.out.println(f.id + ". " + f.route + " | Seats: " + f.seats + " | Price: ₹" + f.price);
        }
    }

    // ---------------- BOOK TICKET ----------------
    static void bookTicket(Passenger user) {

        // Behavior Score
        user.score = (user.trips * 10) - (user.cancellations * 15);

        if (user.score < 0) {
            System.out.println("⚠ Risky passenger! Limited access.");
        }

        viewFlights();
        System.out.print("Select Flight ID: ");
        int id = sc.nextInt();

        Flight selected = null;
        for (Flight f : flights) {
            if (f.id == id) {
                selected = f;
                break;
            }
        }

        if (selected == null || selected.seats == 0) {
            System.out.println("Invalid or full flight!");
            return;
        }

        // Trip Purpose
        System.out.println("Purpose: 1.Vacation 2.Business 3.Emergency");
        int purpose = sc.nextInt();

        int finalPrice = selected.price;

        if (purpose == 1) finalPrice += 500;
        else if (purpose == 3) finalPrice -= 1000;

        // Risk Mode
        System.out.println("Booking Type: 1.Safe 2.Risk");
        int type = sc.nextInt();

        if (type == 2) {
            Random r = new Random();
            if (r.nextInt(2) == 0)
                System.out.println("😎 Upgrade success!");
            else
                System.out.println("😬 Last seat assigned!");
        }

        selected.seats--;
        user.trips++;
        user.preferredRoute = selected.route;

        int seatNo = (10 - selected.seats);

        System.out.println("✅ Ticket Booked!");
        System.out.println("Route: " + selected.route);
        System.out.println("Seat No: " + seatNo);
        System.out.println("Price: ₹" + finalPrice);
    }

    // ---------------- CANCEL ----------------
    static void cancelTicket(Passenger user) {
        user.cancellations++;
        System.out.println("❌ Ticket Cancelled");
    }
}