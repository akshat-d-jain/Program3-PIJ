import java.util.Scanner;
import java.util.ArrayList;

class Student {
    private int prn;
    private String name;
    private String dob;
    private double marks;

    public Student(int prn, String name, String dob, double marks) {
        this.prn = prn;
        this.name = name;
        this.dob = dob;
        this.marks = marks;
    }

    public int getPrn() {
        return prn;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public double getMarks() {
        return marks;
    }

    public void display() {
        System.out.println("PRN: " + prn);
        System.out.println("Name: " + name);
        System.out.println("Date of Birth: " + dob);
        System.out.println("Marks: " + marks);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by PRN");
            System.out.println("4. Search Student by Name");
            System.out.println("5. Update Student Details");
            System.out.println("6. Delete Student");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter PRN: ");
                    int prn = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Date of Birth: ");
                    String dob = scanner.nextLine();
                    System.out.print("Enter Marks: ");
                    double marks = scanner.nextDouble();
                    students.add(new Student(prn, name, dob, marks));
                    System.out.println("Student added successfully!");
                    break;
                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No students found!");
                    } else {
                        for (Student student : students) {
                            student.display();
                            System.out.println();
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter PRN to search: ");
                    int searchPrn = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    boolean foundByPrn = false;
                    for (Student student : students) {
                        if (student.getPrn() == searchPrn) {
                            student.display();
                            foundByPrn = true;
                            break;
                        }
                    }
                    if (!foundByPrn) {
                        System.out.println("Student not found with PRN: " + searchPrn);
                    }
                    break;
                case 4:
                    System.out.print("Enter Name to search: ");
                    String searchName = scanner.nextLine();
                    boolean foundByName = false;
                    for (Student student : students) {
                        if (student.getName().equalsIgnoreCase(searchName)) {
                            student.display();
                            foundByName = true;
                        }
                    }
                    if (!foundByName) {
                        System.out.println("Student not found with Name: " + searchName);
                    }
                    break;
                case 5:
                    System.out.print("Enter PRN of student to update details: ");
                    int updatePrn = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    boolean foundForUpdate = false;
                    for (Student student : students) {
                        if (student.getPrn() == updatePrn) {
                            System.out.print("Enter new Name: ");
                            String newName = scanner.nextLine();
                            System.out.print("Enter new Date of Birth: ");
                            String newDob = scanner.nextLine();
                            System.out.print("Enter new Marks: ");
                            double newMarks = scanner.nextDouble();
                            student = new Student(updatePrn, newName, newDob, newMarks);
                            System.out.println("Student details updated successfully!");
                            foundForUpdate = true;
                            break;
                        }
                    }
                    if (!foundForUpdate) {
                        System.out.println("Student not found with PRN: " + updatePrn);
                    }
                    break;
                case 6:
                    System.out.print("Enter PRN of student to delete: ");
                    int deletePrn = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    boolean foundForDelete = false;
                    for (Student student : students) {
                        if (student.getPrn() == deletePrn) {
                            students.remove(student);
                            System.out.println("Student deleted successfully!");
                            foundForDelete = true;
                            break;
                        }
                    }
                    if (!foundForDelete) {
                        System.out.println("Student not found with PRN: " + deletePrn);
                    }
                    break;
                case 7:
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 7.");
            }
        }
    }
}