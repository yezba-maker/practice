
package com.mycompany.rmiclient;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

public class RMIclient {
    public static void main(String[] args) {
        try {
            String serverIP = "172.16.74.107"; 

            Registry registry = LocateRegistry.getRegistry(serverIP, 1099);
            FitnessService service = (FitnessService) registry.lookup("FitnessService");

            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("\n=== Fitness Tracker ===");
                System.out.println("1. Add Record");
                System.out.println("2. View Records");
                System.out.println("3. Average Steps");
                System.out.println("4. Latest Weight");
                System.out.println("5. Exit");
                System.out.print("Choose: ");

                int choice = sc.nextInt();
                sc.nextLine();

                if (choice == 1) {
                    System.out.print("User: ");
                    String user = sc.nextLine();
                    System.out.print("Date (YYYY-MM-DD): ");
                    String date = sc.nextLine();

                    System.out.print("Steps: ");
                    int steps = sc.nextInt();

                    System.out.print("Weight: ");
                    double weight = sc.nextDouble();

                    service.addRecord(user, date, steps, weight);
                    System.out.println("✅ Record added!");

                } else if (choice == 2) {
                    System.out.print("User: ");
                    String user = sc.nextLine();

                    List<String> records = service.getRecords(user);
                    System.out.println("📊 Records:");
                    for (String r : records) {
                        System.out.println(r);
                    }

                } else if (choice == 3) {
                    System.out.print("User: ");
                    String user = sc.nextLine();

                    System.out.println("Average Steps: " + service.getAverageSteps(user));

                } else if (choice == 4) {
                    System.out.print("User: ");
                    String user = sc.nextLine();

                    System.out.println("Latest Weight: " + service.getLatestWeight(user));

                } else {
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

