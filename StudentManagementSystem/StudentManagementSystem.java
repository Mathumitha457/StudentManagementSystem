import java.util.ArrayList;
import java.util.Scanner;


class Student {
    int rollNo;
    String name;
    String course;
    int marks;

    Student(int rollNo, String name, String course, int marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.course = course;
        this.marks = marks;
    }
}

public class StudentManagementSystem {

    static ArrayList<Student> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. View All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice : ");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1: addStudent(); break;
                case 2: updateStudent(); break;
                case 3: deleteStudent(); break;
                case 4: viewStudents(); break;
                case 5: 
                    System.out.println("Exiting... Thank you!");
                    return;
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    // -------------------------------
    // ADD STUDENT
    // -------------------------------
    static void addStudent() {
        System.out.println("\n--- Add Student ---");

        System.out.print("Enter Roll No: ");
        int roll = sc.nextInt(); sc.nextLine();

        // Check duplicate Roll No
        for (Student s : list) {
            if (s.rollNo == roll) {
                System.out.println("❌ Roll No already exists!");
                return;
            }
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        System.out.print("Enter Marks (0–100): ");
        int marks = sc.nextInt();
        sc.nextLine();

        if (marks < 0 || marks > 100) {
            System.out.println("❌ Marks must be between 0–100");
            return;
        }

        list.add(new Student(roll, name, course, marks));
        System.out.println("✅ Student Added Successfully!");
    }

    // -------------------------------
    // UPDATE STUDENT
    // -------------------------------
    static void updateStudent() {
        System.out.println("\n--- Update Student ---");

        System.out.print("Enter Roll No: ");
        int roll = sc.nextInt(); 
        sc.nextLine();

        for (Student s : list) {
            if (s.rollNo == roll) {
                System.out.print("Enter New Name: ");
                s.name = sc.nextLine();

                System.out.print("Enter New Course: ");
                s.course = sc.nextLine();

                System.out.print("Enter New Marks: ");
                s.marks = sc.nextInt();
                sc.nextLine();

                System.out.println("✅ Updated Successfully!");
                return;
            }
        }
        System.out.println("❌ Student Not Found!");
    }

    // -------------------------------
    // DELETE STUDENT
    // -------------------------------
    static void deleteStudent() {
        System.out.println("\n--- Delete Student ---");

        System.out.print("Enter Roll No: ");
        int roll = sc.nextInt();
        sc.nextLine();

        for (Student s : list) {
            if (s.rollNo == roll) {
                list.remove(s);
                System.out.println("🗑️ Deleted Successfully!");
                return;
            }
        }
        System.out.println("❌ Student Not Found!");
    }

    // -------------------------------
    // VIEW ALL STUDENTS
    // -------------------------------
    static void viewStudents() {
        System.out.println("\n--- All Students ---");

        if (list.isEmpty()) {
            System.out.println("No records found.");
            return;
        }

        System.out.printf("%-10s %-20s %-20s %-10s\n",
                "Roll No", "Name", "Course", "Marks");
        System.out.println("----------------------------------------------------------");

        for (Student s : list) {
            System.out.printf("%-10d %-20s %-20s %-10d\n",
                    s.rollNo, s.name, s.course, s.marks);
        }
    }
}
