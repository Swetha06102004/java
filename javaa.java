import java.util.ArrayList;
import java.util.Scanner;

class Patient {
    private String name;
    private int age;
    private String visitReason;

    // Constructor
    public Patient(String name, int age, String visitReason) {
        this.name = name;
        this.age = age;
        this.visitReason = visitReason;
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getVisitReason() {
        return visitReason;
    }

    public void setVisitReason(String visitReason) {
        this.visitReason = visitReason;
    }

    // Method to display patient details
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Visit Reason: " + visitReason);
    }
}

public class PatientVisitManagement {

    private static ArrayList<Patient> patients = new ArrayList<>();

    // Method to add a patient
    public static void addPatient(String name, int age, String visitReason) {
        Patient newPatient = new Patient(name, age, visitReason);
        patients.add(newPatient);
        System.out.println("Patient added successfully.");
    }

    // Method to display all patients
    public static void displayAllPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients to display.");
        } else {
            for (Patient patient : patients) {
                patient.displayDetails();
                System.out.println("---------------------------");
            }
        }
    }

    // Method to search for a patient by name
    public static void searchPatient(String name) {
        for (Patient patient : patients) {
            if (patient.getName().equalsIgnoreCase(name)) {
                System.out.println("Patient found:");
                patient.displayDetails();
                return;
            }
        }
        System.out.println("No patient found with the name: " + name);
    }

    // Method to delete a patient by name
    public static void deletePatient(String name) {
        for (Patient patient : patients) {
            if (patient.getName().equalsIgnoreCase(name)) {
                patients.remove(patient);
                System.out.println("Patient deleted successfully.");
                return;
            }
        }
        System.out.println("No patient found with the name: " + name);
    }

    // Method to edit a patient's details
    public static void editPatient(String name) {
        for (Patient patient : patients) {
            if (patient.getName().equalsIgnoreCase(name)) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Editing details for patient: " + name);

                System.out.print("Enter new name (or press Enter to keep unchanged): ");
                String newName = scanner.nextLine();
                if (!newName.trim().isEmpty()) {
                    patient.setName(newName);
                }

                System.out.print("Enter new age (or -1 to keep unchanged): ");
                int newAge = scanner.nextInt();
                if (newAge != -1) {
                    patient.setAge(newAge);
                }
                scanner.nextLine(); // Consume newline

                System.out.print("Enter new visit reason (or press Enter to keep unchanged): ");
                String newReason = scanner.nextLine();
                if (!newReason.trim().isEmpty()) {
                    patient.setVisitReason(newReason);
                }

                System.out.println("Patient details updated successfully.");
                return;
            }
        }
        System.out.println("No patient found with the name: " + name);
    }

    // Method to display the total number of patients
    public static void displayPatientCount() {
        System.out.println("Total number of patients: " + patients.size());
    }

    // Main method to run the system
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("Patient Visit Management System");
            System.out.println("1. Add Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Search Patient");
            System.out.println("4. Delete Patient");
            System.out.println("5. Edit Patient");
            System.out.println("6. Display Patient Count");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    System.out.print("Enter patient's name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter patient's age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter reason for visit: ");
                    String visitReason = scanner.nextLine();
                    addPatient(name, age, visitReason);
                    break;
                case 2:
                    displayAllPatients();
                    break;
                case 3:
                    System.out.print("Enter patient's name to search: ");
                    String searchName = scanner.nextLine();
                    searchPatient(searchName);
                    break;
                case 4:
                    System.out.print("Enter patient's name to delete: ");
                    String deleteName = scanner.nextLine();
                    deletePatient(deleteName);
                    break;
                case 5:
                    System.out.print("Enter patient's name to edit: ");
                    String editName = scanner.nextLine();
                    editPatient(editName);
                    break;
                case 6:
                    displayPatientCount();
                    break;
                case 7:
                    System.out.println("Exiting the system.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
