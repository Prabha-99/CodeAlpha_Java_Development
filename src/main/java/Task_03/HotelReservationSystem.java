package Task_03;

import java.util.ArrayList;
import java.util.Scanner;

class Room {
    private String roomNumber;
    private String category;
    private boolean available;
    private double price;

    public Room(String roomNumber, String category, double price) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.price = price;
        this.available = true;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getCategory() {
        return category;
    }

    public boolean isAvailable() {
        return available;
    }

    public void book() {
        available = false;
    }

    public double getPrice() {
        return price;
    }
}

class Reservation {
    private Room room;
    private String guestName;
    private int duration;
    private double totalPrice;

    public Reservation(Room room, String guestName, int duration) {
        this.room = room;
        this.guestName = guestName;
        this.duration = duration;
        this.totalPrice = room.getPrice() * duration;
        room.book();
    }

    public Room getRoom() {
        return room;
    }

    public String getGuestName() {
        return guestName;
    }

    public int getDuration() {
        return duration;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}

class Hotel {
    private ArrayList<Room> rooms;
    private ArrayList<Reservation> reservations;

    public Hotel() {
        rooms = new ArrayList<>();
        reservations = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void displayAvailableRooms() {
        System.out.println();
        System.out.println("Available Rooms:");
        for (Room room : rooms) {
            if (room.isAvailable()) {
                System.out.println("------------------------------------------------------");
                System.out.println(" Room Number: " + room.getRoomNumber() + " - Category: " + room.getCategory() + " - Price: $" + room.getPrice());
                System.out.println("------------------------------------------------------");
            }
        }
    }

    public void makeReservation(Room room, String guestName, int duration) {
        Reservation reservation = new Reservation(room, guestName, duration);
        reservations.add(reservation);
        System.out.println("-------------------------------------------------");
        System.out.println("| Reservation made successfully!");
        System.out.println("| Guest Name: " + guestName);
        System.out.println("| Room Number: " + room.getRoomNumber());
        System.out.println("| Duration: " + duration + " nights");
        System.out.println("| Total Price: $" + reservation.getTotalPrice());
        System.out.println("-------------------------------------------------");
    }

    public void displayBookingDetails() {
        System.out.println("--------------------------------------------");
        System.out.println("| Booking Details:");
        for (Reservation reservation : reservations) {
            System.out.println("| Guest Name: " + reservation.getGuestName());
            System.out.println("| Room Number: " + reservation.getRoom().getRoomNumber());
            System.out.println("| Duration: " + reservation.getDuration() + " nights");
            System.out.println("| Total Price: $" + reservation.getTotalPrice());
            System.out.println("--------------------------------------------");
        }
    }
}

public class HotelReservationSystem {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();

        // Manually adding some rooms since we are not using a separate Database for this project.
        hotel.addRoom(new Room("101", "Standard", 100));
        hotel.addRoom(new Room("102", "Standard", 100));
        hotel.addRoom(new Room("201", "Deluxe", 200));
        hotel.addRoom(new Room("202", "Deluxe", 200));
        hotel.addRoom(new Room("301", "Suite", 300));

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println();
            System.out.println("-------------------------------------------");
            System.out.println("|   Welcome to Hotel Reservation System   |");
            System.out.println("-------------------------------------------");
            System.out.println("|    1. Search for available rooms        |");
            System.out.println("|    2. Make a reservation                |");
            System.out.println("|    3. View booking details              |");
            System.out.println("|    4. Exit                              |");
            System.out.println("-------------------------------------------");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    hotel.displayAvailableRooms();
                    break;
                case 2:
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter guest name: ");
                    String guestName = scanner.nextLine();
                    System.out.print("Enter room number: ");
                    String roomNumber = scanner.nextLine();
                    System.out.print("Enter duration of stay (in nights): ");
                    int duration = scanner.nextInt();
                    Room selectedRoom = null;
                    for (Room room : hotel.getRooms()) {
                        if (room.getRoomNumber().equals(roomNumber)) {
                            selectedRoom = room;
                            break;
                        }
                    }
                    if (selectedRoom != null && selectedRoom.isAvailable()) {
                        hotel.makeReservation(selectedRoom, guestName, duration);
                    } else {
                        System.out.println("Room not available or does not exist.");
                    }
                    break;
                case 3:
                    hotel.displayBookingDetails();
                    break;
                case 4:
                    System.out.println("*******************************************************");
                    System.out.println("| Thank you for using CodeAlpha Hotel Reservation System.  |\n" +
                            "| See You Again !!!                                   |");
                    System.out.println("*******************************************************");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
