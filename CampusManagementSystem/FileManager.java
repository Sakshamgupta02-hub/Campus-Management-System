import java.io.*;
import java.util.ArrayList;

public class FileManager {

    private static final String DATA_FOLDER = "data";
    private static final String STUDENT_FILE =
            DATA_FOLDER + "/students.dat";
    private static final String COMPLAINT_FILE =
            DATA_FOLDER + "/complaints.dat";

    // Create data folder

    private static void createFolder() {

        File folder = new File(DATA_FOLDER);

        if (!folder.exists()) {
            folder.mkdir();
        }
    }

    // Save students

    public static void saveStudents(ArrayList<Student> students) {

        createFolder();

        try {

            ObjectOutputStream output =
                    new ObjectOutputStream(
                            new FileOutputStream(STUDENT_FILE)
                    );

            output.writeObject(students);
            output.close();

        } catch (IOException e) {

            System.out.println("Error saving student data.");
        }
    }

    // Load students

    @SuppressWarnings("unchecked")
    public static ArrayList<Student> loadStudents() {

        createFolder();

        File file = new File(STUDENT_FILE);

        if (!file.exists()) {
            return new ArrayList<>();
        }

        try {

            ObjectInputStream input =
                    new ObjectInputStream(
                            new FileInputStream(STUDENT_FILE)
                    );

            ArrayList<Student> students =
                    (ArrayList<Student>) input.readObject();

            input.close();

            return students;

        } catch (IOException | ClassNotFoundException e) {

            System.out.println("Error loading student data.");

            return new ArrayList<>();
        }
    }

    // Save complaints

    public static void saveComplaints(
            ArrayList<Complaint> complaints) {

        createFolder();

        try {

            ObjectOutputStream output =
                    new ObjectOutputStream(
                            new FileOutputStream(COMPLAINT_FILE)
                    );

            output.writeObject(complaints);
            output.close();

        } catch (IOException e) {

            System.out.println("Error saving complaint data.");
        }
    }

    // Load complaints

    @SuppressWarnings("unchecked")
    public static ArrayList<Complaint> loadComplaints() {

        createFolder();

        File file = new File(COMPLAINT_FILE);

        if (!file.exists()) {
            return new ArrayList<>();
        }

        try {

            ObjectInputStream input =
                    new ObjectInputStream(
                            new FileInputStream(COMPLAINT_FILE)
                    );

            ArrayList<Complaint> complaints =
                    (ArrayList<Complaint>) input.readObject();

            input.close();

            return complaints;

        } catch (IOException | ClassNotFoundException e) {

            System.out.println("Error loading complaint data.");

            return new ArrayList<>();
        }
    }
}