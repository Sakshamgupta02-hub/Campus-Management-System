import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static StudentManager studentManager =
            new StudentManager();

    static ComplaintManager complaintManager =
            new ComplaintManager();

    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("       WELCOME TO Campus Management System");
        System.out.println("==========================================");

        while (true) {

            showMainMenu();

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    studentMenu();
                    break;

                case 2:
                    attendanceMenu();
                    break;

                case 3:
                    marksMenu();
                    break;

                case 4:
                    complaintMenu();
                    break;

                case 5:
                    reportMenu();
                    break;

                case 6:
                    System.out.println(
                            "\nThank you for using Campus Management System!"
                    );
                    scanner.close();
                    return;

                default:
                    System.out.println(
                            "\nInvalid choice. Please try again."
                    );
            }
        }
    }

    // ==========================================
    // MAIN MENU
    // ==========================================

    public static void showMainMenu() {

        System.out.println("\n");
        System.out.println("========== MAIN MENU ==========");
        System.out.println("1. Student Management");
        System.out.println("2. Attendance Management");
        System.out.println("3. Marks Management");
        System.out.println("4. Complaint Management");
        System.out.println("5. Student Report");
        System.out.println("6. Exit");
        System.out.println("===============================");
    }

    // ==========================================
    // STUDENT MENU
    // ==========================================

    public static void studentMenu() {

        while (true) {

            System.out.println("\n====== STUDENT MANAGEMENT ======");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Back");

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    studentManager.viewStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    deleteStudent();
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // Add student

    public static void addStudent() {

        System.out.println("\n------ ADD STUDENT ------");

        int id = readInt("Enter Student ID: ");

        String name = readString("Enter Name: ");

        String department =
                readString("Enter Department: ");

        String email =
                readString("Enter Email: ");

        Student student =
                new Student(id, name, department, email);

        if (studentManager.addStudent(student)) {

            System.out.println(
                    "\nStudent added successfully."
            );

        } else {

            System.out.println(
                    "\nStudent ID already exists."
            );
        }
    }

    // Search student

    public static void searchStudent() {

        int id = readInt("Enter Student ID: ");

        studentManager.searchStudent(id);
    }

    // Delete student

    public static void deleteStudent() {

        int id = readInt("Enter Student ID to delete: ");

        if (studentManager.deleteStudent(id)) {

            System.out.println(
                    "\nStudent deleted successfully."
            );

        } else {

            System.out.println(
                    "\nStudent not found."
            );
        }
    }

    // ==========================================
    // ATTENDANCE MENU
    // ==========================================

    public static void attendanceMenu() {

        while (true) {

            System.out.println("\n====== ATTENDANCE MANAGEMENT ======");
            System.out.println("1. Add / Update Attendance");
            System.out.println("2. View Attendance");
            System.out.println("3. Back");

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    updateAttendance();
                    break;

                case 2:
                    viewAttendance();
                    break;

                case 3:
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // Update attendance

    public static void updateAttendance() {

        int id = readInt("Enter Student ID: ");

        if (studentManager.findStudent(id) == null) {

            System.out.println("Student not found.");
            return;
        }

        int total =
                readInt("Enter total classes: ");

        int attended =
                readInt("Enter attended classes: ");

        if (studentManager.updateAttendance(
                id, total, attended)) {

            System.out.println(
                    "\nAttendance updated successfully."
            );

        } else {

            System.out.println(
                    "\nInvalid attendance data."
            );

            System.out.println(
                    "Attended classes cannot be greater than total classes."
            );
        }
    }

    // View attendance

    public static void viewAttendance() {

        int id = readInt("Enter Student ID: ");

        studentManager.viewAttendance(id);
    }

    // ==========================================
    // MARKS MENU
    // ==========================================

    public static void marksMenu() {

        while (true) {

            System.out.println("\n====== MARKS MANAGEMENT ======");
            System.out.println("1. Add / Update Marks");
            System.out.println("2. View Marks");
            System.out.println("3. Back");

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    updateMarks();
                    break;

                case 2:
                    viewMarks();
                    break;

                case 3:
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // Update marks

    public static void updateMarks() {

        int id = readInt("Enter Student ID: ");

        if (studentManager.findStudent(id) == null) {

            System.out.println("Student not found.");
            return;
        }

        double subject1 =
                readDouble("Enter Subject 1 marks: ");

        double subject2 =
                readDouble("Enter Subject 2 marks: ");

        double subject3 =
                readDouble("Enter Subject 3 marks: ");

        if (studentManager.updateMarks(
                id, subject1, subject2, subject3)) {

            System.out.println(
                    "\nMarks updated successfully."
            );

        } else {

            System.out.println(
                    "\nInvalid marks."
            );

            System.out.println(
                    "Marks must be between 0 and 100."
            );
        }
    }

    // View marks

    public static void viewMarks() {

        int id = readInt("Enter Student ID: ");

        studentManager.viewMarks(id);
    }

    // ==========================================
    // COMPLAINT MENU
    // ==========================================

    public static void complaintMenu() {

        while (true) {

            System.out.println("\n====== COMPLAINT MANAGEMENT ======");
            System.out.println("1. Submit Complaint");
            System.out.println("2. View All Complaints");
            System.out.println("3. View Student Complaints");
            System.out.println("4. Update Complaint Status");
            System.out.println("5. Back");

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    submitComplaint();
                    break;

                case 2:
                    complaintManager.viewAllComplaints();
                    break;

                case 3:
                    viewStudentComplaints();
                    break;

                case 4:
                    updateComplaintStatus();
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // Submit complaint

    public static void submitComplaint() {

        int studentId =
                readInt("Enter Student ID: ");

        if (studentManager.findStudent(studentId) == null) {

            System.out.println(
                    "Student not found. Complaint cannot be submitted."
            );

            return;
        }

        String category =
                readString("Enter complaint category: ");

        String description =
                readString("Enter complaint description: ");

        complaintManager.addComplaint(
                studentId,
                category,
                description
        );
    }

    // View student's complaints

    public static void viewStudentComplaints() {

        int studentId =
                readInt("Enter Student ID: ");

        if (studentManager.findStudent(studentId) == null) {

            System.out.println("Student not found.");
            return;
        }

        complaintManager.viewStudentComplaints(studentId);
    }

    // Update complaint status

    public static void updateComplaintStatus() {

        int complaintId =
                readInt("Enter Complaint ID: ");

        System.out.println("\nAvailable statuses:");
        System.out.println("1. Pending");
        System.out.println("2. In Progress");
        System.out.println("3. Resolved");

        int choice =
                readInt("Choose status: ");

        String status;

        switch (choice) {

            case 1:
                status = "Pending";
                break;

            case 2:
                status = "In Progress";
                break;

            case 3:
                status = "Resolved";
                break;

            default:
                System.out.println("Invalid status.");
                return;
        }

        if (complaintManager.updateStatus(
                complaintId, status)) {

            System.out.println(
                    "\nComplaint status updated successfully."
            );

        } else {

            System.out.println(
                    "\nComplaint not found."
            );
        }
    }

    // ==========================================
    // REPORT MENU
    // ==========================================

    public static void reportMenu() {

        System.out.println("\n====== STUDENT REPORT ======");

        int id = readInt("Enter Student ID: ");

        studentManager.viewReport(id);
    }

    // ==========================================
    // INPUT METHODS
    // ==========================================

    public static int readInt(String message) {

        while (true) {

            try {

                System.out.print(message);

                int value =
                        Integer.parseInt(scanner.nextLine());

                return value;

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid number."
                );
            }
        }
    }

    public static double readDouble(String message) {

        while (true) {

            try {

                System.out.print(message);

                double value =
                        Double.parseDouble(scanner.nextLine());

                return value;

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid number."
                );
            }
        }
    }

    public static String readString(String message) {

        while (true) {

            System.out.print(message);

            String value = scanner.nextLine().trim();

            if (!value.isEmpty()) {
                return value;
            }

            System.out.println(
                    "Input cannot be empty."
            );
        }
    }
}