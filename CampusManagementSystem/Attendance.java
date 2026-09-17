import java.io.Serializable;

public class Attendance implements Serializable {

    private int totalClasses;
    private int attendedClasses;
    private boolean entered;

    public Attendance() {
        totalClasses = 0;
        attendedClasses = 0;
        entered = false;
    }

    // Set or update attendance

    public boolean setAttendance(int totalClasses, int attendedClasses) {

        if (totalClasses <= 0) {
            return false;
        }

        if (attendedClasses < 0 || attendedClasses > totalClasses) {
            return false;
        }

        this.totalClasses = totalClasses;
        this.attendedClasses = attendedClasses;
        this.entered = true;

        return true;
    }

    public boolean isEntered() {
        return entered;
    }

    // Calculate attendance percentage

    public double getPercentage() {

        if (totalClasses == 0) {
            return 0;
        }

        return (attendedClasses * 100.0) / totalClasses;
    }

    // Attendance status

    public String getStatus() {

        if (!entered) {
            return "Not Entered";
        }

        if (getPercentage() < 75) {
            return "Low Attendance";
        }

        return "Good";
    }

    @Override
    public String toString() {

        if (!entered) {
            return "Attendance: Not Entered";
        }

        return "Total Classes   : " + totalClasses +
                "\nAttended Classes: " + attendedClasses +
                "\nAttendance      : " + String.format("%.2f", getPercentage()) + "%" +
                "\nStatus          : " + getStatus();
    }
}