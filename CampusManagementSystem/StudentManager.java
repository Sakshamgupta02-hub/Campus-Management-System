import java.util.ArrayList;

public class StudentManager {

    private ArrayList<Student> students;

    public StudentManager() {
        students = FileManager.loadStudents();
    }

    // Add student

    public boolean addStudent(Student student) {

        if (findStudent(student.getId()) != null) {
            return false;
        }

        students.add(student);
        save();

        return true;
    }

    // Display all students

    public void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("\nNo students found.");
            return;
        }

        System.out.println("\n========== STUDENT LIST ==========");

        for (Student student : students) {
            student.display();
        }
    }

    // Search student

    public Student findStudent(int id) {

        for (Student student : students) {

            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }

    // Search and display student

    public void searchStudent(int id) {

        Student student = findStudent(id);

        if (student == null) {
            System.out.println("\nStudent not found.");
        } else {
            student.display();
        }
    }

    // Delete student

    public boolean deleteStudent(int id) {

        Student student = findStudent(id);

        if (student == null) {
            return false;
        }

        students.remove(student);
        save();

        return true;
    }

    // Add or update attendance

    public boolean updateAttendance(int id, int total, int attended) {

        Student student = findStudent(id);

        if (student == null) {
            return false;
        }

        boolean result = student.getAttendance()
                .setAttendance(total, attended);

        if (result) {
            save();
        }

        return result;
    }

    // Add or update marks

    public boolean updateMarks(int id,
                               double subject1,
                               double subject2,
                               double subject3) {

        Student student = findStudent(id);

        if (student == null) {
            return false;
        }

        boolean result = student.getMarks()
                .setMarks(subject1, subject2, subject3);

        if (result) {
            save();
        }

        return result;
    }

    // Display attendance

    public void viewAttendance(int id) {

        Student student = findStudent(id);

        if (student == null) {
            System.out.println("\nStudent not found.");
            return;
        }

        System.out.println("\nStudent: " + student.getName());
        System.out.println(student.getAttendance());
    }

    // Display marks

    public void viewMarks(int id) {

        Student student = findStudent(id);

        if (student == null) {
            System.out.println("\nStudent not found.");
            return;
        }

        System.out.println("\nStudent: " + student.getName());
        System.out.println(student.getMarks());
    }

    // Display complete report

    public void viewReport(int id) {

        Student student = findStudent(id);

        if (student == null) {
            System.out.println("\nStudent not found.");
            return;
        }

        student.displayFullReport();
    }

    // Save students

    public void save() {
        FileManager.saveStudents(students);
    }
}