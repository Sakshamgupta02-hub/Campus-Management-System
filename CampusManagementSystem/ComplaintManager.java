import java.util.ArrayList;

public class ComplaintManager {

    private ArrayList<Complaint> complaints;

    public ComplaintManager() {
        complaints = FileManager.loadComplaints();
    }

    // Generate next complaint ID

    public int getNextId() {

        int maxId = 0;

        for (Complaint complaint : complaints) {

            if (complaint.getComplaintId() > maxId) {
                maxId = complaint.getComplaintId();
            }
        }

        return maxId + 1;
    }

    // Add complaint

    public void addComplaint(int studentId,
                             String category,
                             String description) {

        int id = getNextId();

        Complaint complaint = new Complaint(
                id,
                studentId,
                category,
                description
        );

        complaints.add(complaint);

        save();

        System.out.println("\nComplaint submitted successfully.");
        System.out.println("Complaint ID: " + id);
    }

    // View all complaints

    public void viewAllComplaints() {

        if (complaints.isEmpty()) {
            System.out.println("\nNo complaints found.");
            return;
        }

        System.out.println("\n========== ALL COMPLAINTS ==========");

        for (Complaint complaint : complaints) {
            System.out.println(complaint);
        }
    }

    // View complaints of a particular student

    public void viewStudentComplaints(int studentId) {

        boolean found = false;

        System.out.println("\n========== YOUR COMPLAINTS ==========");

        for (Complaint complaint : complaints) {

            if (complaint.getStudentId() == studentId) {

                System.out.println(complaint);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No complaints found for this student.");
        }
    }

    // Update complaint status

    public boolean updateStatus(int complaintId, String newStatus) {

        for (Complaint complaint : complaints) {

            if (complaint.getComplaintId() == complaintId) {

                complaint.setStatus(newStatus);
                save();

                return true;
            }
        }

        return false;
    }

    // Save complaints

    public void save() {
        FileManager.saveComplaints(complaints);
    }
}