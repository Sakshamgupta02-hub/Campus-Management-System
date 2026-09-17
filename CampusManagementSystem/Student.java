import java.io.Serializable;

public class Student implements Serializable {

    private int id;
    private String name;
    private String department;
    private String email;

    private Attendance attendance;
    private Marks marks;

    public Student(int id, String name, String department, String email) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.email = email;

        this.attendance = new Attendance();
        this.marks = new Marks();
    }

    // Getters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }

    public Attendance getAttendance() {
        return attendance;
    }

    public Marks getMarks() {
        return marks;
    }

    // Display basic student information

    public void display() {
        System.out.println("----------------------------------");
        System.out.println("Student ID   : " + id);
        System.out.println("Name         : " + name);
        System.out.println("Department   : " + department);
        System.out.println("Email        : " + email);
        System.out.println("----------------------------------");
    }

    // Display complete student report

    public void displayFullReport() {

        System.out.println("\n==================================");
        System.out.println("        STUDENT REPORT");
        System.out.println("==================================");

        System.out.println("Student ID   : " + id);
        System.out.println("Name         : " + name);
        System.out.println("Department   : " + department);
        System.out.println("Email        : " + email);

        System.out.println("\n--- Attendance ---");
        System.out.println(attendance);

        System.out.println("\n--- Marks ---");
        System.out.println(marks);

        System.out.println("==================================");
    }
}