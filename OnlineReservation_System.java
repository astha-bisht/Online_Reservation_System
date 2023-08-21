package OasisInfoByteProject;

import java.util.Scanner;

public class OnlineReservation_System {

	private static boolean[] seats = new boolean[10]; //10 seat array 

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            // display menu
            System.out.println("\nPlease select an option:");
            System.out.println("1. View Availaible Seat ");
            System.out.println("2. Reserve Seat");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Exit");

            // get user input
            System.out.println("---------------------------------------------------------------------------------------------------------------------");
            System.out.println("ENTER YOUR CHOICE: ");
            int option = scanner.nextInt();

            switch (option) {

                case 1:
                    viewSeat();
                    break;

                case 2:
                    reserveSeat();
                    break;

                case 3:
                    cancelReservation();
                    break;

                case 4:
                    System.exit(0); // exit the program

                default:
                    System.out.println("INVALID CHOICE! ");
            }
        }
    }

    private static void viewSeat() {
        System.out.println("\nAVAILAIBLE SEATS: ");
        for (int i = 0; i < seats.length; i++) {
            if (seats[i]) {
                System.out.print("X "); // RESERVED SEAT PRINTED WITH X
            } else {
                System.out.print((i + 1) + " "); // EMPTY SEATS
            }
        }
        System.out.println();
    }

    private static void reserveSeat() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter seat number (1-10): ");
        int seatNumber = scanner.nextInt();
        if (seatNumber < 1 || seatNumber > 10) {
            System.out.println("Invalid seat number!");
        } else if (seats[seatNumber - 1]) {
            System.out.println("Seat already reserved!");
        } else {
            seats[seatNumber - 1] = true; // reserve the seat
            System.out.println("Seat reserved!");
        }
    }

    private static void cancelReservation() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter seat number (1-10): ");
        int seatNumber = scanner.nextInt();
        if (seatNumber < 1 || seatNumber > 10) {
            System.out.println("Invalid seat number!");
        } else if (!seats[seatNumber - 1]) {
            System.out.println("Seat not reserved!");
        } else {
            seats[seatNumber - 1] = false; // unreserve the seat
            System.out.println("Reservation canceled!");
        }
    }
}
