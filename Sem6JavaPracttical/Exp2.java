import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exp2{
    public static class VideoRentalStore {
        private Map<String, Integer> inventory;
        public VideoRentalStore() {
            this.inventory = new HashMap<>();
        }
        public void addMovie(String title, int quantity) {
            inventory.put(title, quantity);
            System.out.println("Added " + quantity + " copies of " + title + " to the inventory.");
        }
        public void rentMovie(String title, int quantity) {
            if (inventory.containsKey(title)) {
                int availableCopies = inventory.get(title);
                if (availableCopies >= quantity) {
                    inventory.put(title, availableCopies - quantity);
                    System.out.println("Rented " + quantity + " copies of " + title + ".");
                } else {
                    System.out.println("Sorry, not enough copies of " + title + " available.");
                }
            } else {
                System.out.println("Movie not found in the inventory.");
            }
        }
        public void displayInventory() {
            System.out.println("Current Inventory:");
            for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " copies");
            }
        }
    }
    public static void main(String[] args) {
        VideoRentalStore rentalStore = new VideoRentalStore();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenu:\n1. Add Movie\n2. Rent Movie\n3. Display Inventory\n4. Exit");
                    System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            switch (choice) {
                case 1:
                    System.out.print("Enter movie title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    rentalStore.addMovie(title, quantity);
                    break;
                case 2:
                    System.out.print("Enter movie title: ");
                    title = scanner.nextLine();
                    System.out.print("Enter quantity to rent: ");
                    quantity = scanner.nextInt();
                    rentalStore.rentMovie(title, quantity);
                    break;
                case 3:
                    rentalStore.displayInventory();
                    break;
                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
            }
