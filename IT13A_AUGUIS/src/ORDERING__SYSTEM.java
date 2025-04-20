package MIDTERM;

import java.io.*;
import java.util.Scanner;

public class ORDERING__SYSTEM {
    static final String FILE_NAME = "C:\\MIDTERMDATA\\For Midterm Project.txt";
    static final int SHIFT = 3;

    static String[] cigaretteBrands = {
        "Marlboro Red",
        "Marlboro Gold",
        "Fortune",
        "Philip Morris",
        "Winston",
        "Hope",
        "Camel"
    };

    static float[] pricePerStick = {
        8.00f, 8.00f, 6.00f, 7.00f, 7.00f, 6.50f, 7.50f
    };

    static int[][] quantities = new int[cigaretteBrands.length][3]; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Welcome to WINSPOT ===");

        while (true) {
            System.out.println("\n[1] Create Account\n[2] Login\n[3] Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // dari nimo i input base sa 1 para sa create 2 para sa login and 3 para sa exit

            if (choice == 1) {
                createAccount(scanner);
            } else if (choice == 2) {
                if (login(scanner)) {
                    orderCigarettes(scanner);
                }
            } else if (choice == 3) {
                System.out.println("Paalam, ingat sa pagyosi!");
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }

    // kani ang code para sa pag create og account
    static void createAccount(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        String encrypted = encrypt(password);

        try (FileWriter fw = new FileWriter(FILE_NAME, true)) {
            fw.write(username + "," + encrypted + "\n");
            System.out.println("Account created successfully!");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    // kani ang code para sa loggin
    static boolean login(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].equals(username)) {
                    String decrypted = decrypt(parts[1]);
                    if (decrypted.equals(password)) {
                        System.out.println("Login successful!");
                        return true;
                    } else {
                        System.out.println("Incorrect password.");
                        return false;
                    }
                }
            }
            System.out.println("User not found.");
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
        return false;
    }

    // kani and code para sa sigarilyo ordor system
    static void orderCigarettes(Scanner scanner) {
        int choice;
        do {
            System.out.println("\n--- CIGARETTE MENU ---");
            for (int i = 0; i < cigaretteBrands.length; i++) {
                System.out.printf("[%d] %s - Php%.2f per stick\n", i + 1, cigaretteBrands[i], pricePerStick[i]);
            }
            System.out.println("[0] Exit and Show Summary");

            System.out.print("Choose a cigarette: ");
            choice = scanner.nextInt();

            if (choice >= 1 && choice <= cigaretteBrands.length) {
                int index = choice - 1;

                System.out.println("Choose unit:");
                System.out.println("[1] Per Stick");
                System.out.println("[2] Per Box (20 sticks)");
                System.out.println("[3] Per Bundle (10 boxes = 200 sticks)");
                System.out.print("Enter unit type: ");
                int unit = scanner.nextInt();

                if (unit >= 1 && unit <= 3) {
                    System.out.print("Enter quantity: ");
                    int qty = scanner.nextInt();
                    quantities[index][unit - 1] += qty;
                } else {
                    System.out.println("Invalid unit type.");
                }
            } else if (choice != 0) {
                System.out.println("Invalid choice.");
            }
        } while (choice != 0);

        showSummary();
    }

    // dani gina summary and mga order
    static void showSummary() {
        float total = 0;
        System.out.println("\n=== Order Summary ===");
        for (int i = 0; i < cigaretteBrands.length; i++) {
            int sticks = quantities[i][0];
            int boxes = quantities[i][1];
            int bundles = quantities[i][2];

            if (sticks > 0 || boxes > 0 || bundles > 0) {
                System.out.println(cigaretteBrands[i] + ":");
                if (sticks > 0) {
                    float amount = sticks * pricePerStick[i];
                    total += amount;
                    System.out.printf("  - %d stick(s) = Php%.2f\n", sticks, amount);
                }
                if (boxes > 0) {
                    float amount = boxes * 20 * pricePerStick[i];
                    total += amount;
                    System.out.printf("  - %d box(es) = Php%.2f\n", boxes, amount);
                }
                if (bundles > 0) {
                    float amount = bundles * 200 * pricePerStick[i];
                    total += amount;
                    System.out.printf("  - %d bundle(s) = Php%.2f\n", bundles, amount);
                }
            }
        }
        System.out.printf("TOTAL BILL: Php%.2f\n", total);
        System.out.println("=======================");
    }

    // kani and code para sa Caesar Cipher Encryption
    static String encrypt(String text) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            sb.append((char)(c + SHIFT));
        }
        return sb.toString();
    }

    static String decrypt(String text) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            sb.append((char)(c - SHIFT));
        }
        return sb.toString();
    }
}
