import java.io.Serializable;

public class Complaint implements Serializable {

    private int complaintId;
    private int studentId;
    private String category;
    private String description;
    private String status;

    public Complaint(int complaintId, int studentId,
                     String category, String description) {

        this.complaintId = complaintId;
        this.studentId = studentId;
        this.category = category;
        this.description = description;

        status = "Pending";
    }

    public int getComplaintId() {
        return complaintId;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    // Update complaint status

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {

        return "\n----------------------------------" +
                "\nComplaint ID : " + complaintId +
                "\nStudent ID   : " + studentId +
                "\nCategory     : " + category +
                "\nDescription  : " + description +
                "\nStatus       : " + status +
                "\n----------------------------------";
    }
}