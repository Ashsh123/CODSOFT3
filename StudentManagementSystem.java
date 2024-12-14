import java.util.*;

public class StudentManagementSystem {
    private List<Student> students;
    private Scanner sc;

    public StudentManagementSystem() {
        students = new ArrayList<>();
        sc = new Scanner(System.in);
    }

    public void addStudent() {
        System.out.print("Enter student ID: ");
        int id = sc.nextInt();
        sc.nextLine();  // Consume newline
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        System.out.print("Enter student age: ");
        int age = sc.nextInt();

        students.add(new Student(id, name, age));
        System.out.println("Student added successfully!");
    }

    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        
        System.out.println("List of Students:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        int id = sc.nextInt();
        
        boolean found = false;
        for (Student student : students) {
            if (student.getId() == id) {
                students.remove(student);
                found = true;
                System.out.println("Student deleted successfully!");
                break;
            }
        }
        
        if (!found) {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    public void displayMenu() {
        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        sms.displayMenu();
    }
}