import java.util.ArrayList;
import java.util.Scanner;

// Course class: stores details of one course
class Course {
    private int id;
    private String name;
    private String instructor;
    private int credits;

    public Course(int id, String name, String instructor, int credits) {
        this.id = id;
        this.name = name;
        this.instructor = instructor;
        this.credits = credits;
    }

    public int getId() { return id; }
    public int getCredits() { return credits; }

    public void display() {
        System.out.println(id + ". " + name + " | Instructor: " + instructor + " | Credits: " + credits);
    }
}

// Student class: keeps the courses a student has selected
class Student {
    private String name;
    private ArrayList<Course> registeredCourses = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public String getName() { 
        return name; }

    public void registerCourse(Course course) {
        if (registeredCourses.contains(course)) {
            System.out.println("You have already registered for this course.");
        } else {
            registeredCourses.add(course);
            System.out.println("Course registered successfully!");
        }
    }

    public void showRegisteredCourses() {
        if (registeredCourses.isEmpty()) {
            System.out.println("No courses registered yet.");
            return;
        }
        int totalCredits = 0;
        for (Course c : registeredCourses) {
            c.display();
            totalCredits += c.getCredits();
        }
        System.out.println("Total Credits: " + totalCredits);
    }
}

// Main class: runs the menu
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Available courses
        ArrayList<Course> courses = new ArrayList<>();
        courses.add(new Course(1, "Object Oriented Programming (OOPs)", "Dr Gulsher laghari", 3));
        courses.add(new Course(2, "Digital Logic Design(DLD)", "Dr Abdul Rehman Nangraj", 3));
        courses.add(new Course(3, "Internet of Things(IoT)", "Dr Asadullah Buledhi", 3));
        courses.add(new Course(4, "Expository Writing", "Madiha Khemtio", 3));
        courses.add(new Course(5, "Islamic Studies(IS)", "Dr Hamedullah Buledhi ", 2));

        System.out.print("Enter your name: ");
        Student student = new Student(sc.nextLine());
        System.out.println("Welcome, " + student.getName() + "!");

        int choice;
        do {
            System.out.println("\n--- Course Registration Menu ---");
            System.out.println("1. View available courses");
            System.out.println("2. Register for a course");
            System.out.println("3. View my registered courses");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            if (choice == 1) {
                for (Course c : courses) c.display();
            } else if (choice == 2) {
                System.out.print("Enter course number: ");
                int id = sc.nextInt();
                if (id >= 1 && id <= courses.size()) {
                    student.registerCourse(courses.get(id - 1));
                } else {
                    System.out.println("Invalid course number.");
                }
            } else if (choice == 3) {
                student.showRegisteredCourses();
            } else if (choice != 4) {
                System.out.println("Invalid choice.");
            }
        } while (choice != 4);

        System.out.println("Thank you for using the system. Goodbye!");
        sc.close();
    }
}